package com.progenies.mna.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.progenies.mna.controllers.AbstractMNAController;
import com.progenies.mna.dao.internal.UsersDAO;
import com.progenies.mna.forms.internal.UserForm;
import com.progenies.mna.model.internal.User;

@Controller
@RequestMapping("/admin")
public class UsersController extends AbstractMNAController
{
	@Autowired
	private UsersDAO usersDAO;
	
	//validaciones
    @InitBinder("userData")
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new UserForm.UserValidator());
    }
	
	@RequestMapping("Users")
	public String defaultMapping()
	{
		return "redirect:Users/list";
	}
	
	//acceso a la raiz de usuario: Listado
	@RequestMapping("Users/list")
	public ModelAndView index(ModelAndView model)
	{
		List<User> users=usersDAO.findAllUsers();
		model.addObject("userList", users);
		
		model.setViewName("admin-user-list");
		return model;
	}
	
	//formulario de alta
	@RequestMapping("Users/add")
	public ModelAndView add()
	{
		//Usuario con datos pore defecto
		UserForm defaultUser=new UserForm();
		defaultUser.setActive(Boolean.TRUE);
		
		ModelAndView result=new ModelAndView("admin-user-add");
		result.addObject("userData", defaultUser);
		result.addObject("editingUser", Boolean.FALSE);
		return result;
	}
	
	//formulario de edicion
	@RequestMapping("Users/edit")
	public ModelAndView edit(@RequestParam Long idUser)
	{
		UserForm user=new UserForm(usersDAO.getUserByID(idUser));
		ModelAndView result=new ModelAndView("admin-user-add");
		result.addObject("userData", user);
		result.addObject("editingUser", Boolean.TRUE);
		return result;
	}
	
	//eliminar
	@RequestMapping("Users/delete")
	public ModelAndView delete(@RequestParam Long idUser)
	{
		usersDAO.deleteUser(usersDAO.getUserByID(idUser));
		return new ModelAndView("redirect:list");
	}
	
	//activar/desactivar
	@RequestMapping("Users/disable")
	public ModelAndView disable(@RequestParam Long idUser, @RequestParam Boolean active)
	{
		User currentUser=usersDAO.getUserByID(idUser);
		currentUser.setActive(active);
		usersDAO.updateUser(currentUser);
		return new ModelAndView("redirect:list");
	}
	
	
	//formulario de guardadp
	@RequestMapping("Users/save")
	public ModelAndView save(@ModelAttribute("userData") @Validated UserForm userData, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("admin-user-add");
		}
		else
		{
			User user=userData.convertToUser();
			if(user.getIdUser()!=null && user.getIdUser()>0)
				usersDAO.updateUserExceptPassword(user);
			else
				usersDAO.insertUser(user);
			
			return new ModelAndView("redirect:list");
		}
	}
	
	
	
}
