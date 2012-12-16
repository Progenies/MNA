package com.progenies.mna.controllers.admin;

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
        binder.setValidator(new User.UserValidator());
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
		model.addObject("userList", usersDAO.findAllUsers());
		
		model.setViewName("admin-user-list");
		return model;
	}
	
	//formulario de alta
	@RequestMapping("Users/add")
	public ModelAndView add(ModelAndView model)
	{
		model.setViewName("admin-user-add");
		return model;
	}
	
	
	//formulario de guardadp
	@RequestMapping("Users/save")
	public ModelAndView save(@ModelAttribute("userData") @Validated User user, BindingResult result, ModelAndView model)
	{
		if(result.hasErrors())
		{
			model.setViewName("admin-user-add");
		}
		else
			model.setViewName("redirect:list");
		return model;
	}
	
}
