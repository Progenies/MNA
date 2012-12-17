package com.progenies.mna.forms.internal;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.progenies.mna.model.internal.User;
import com.progenies.mna.utils.FormUtils;

public class UserForm extends User
{
	
	public UserForm()
	{		
	}
	
	public UserForm(User user)
	{
		FormUtils.copyFields(user, this);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String repeatPassword;
	
	public User convertToUser()
	{
		User user=new User();
		FormUtils.copyFields(this, user);
		return user;
	}
	
	

	public static class UserValidator implements org.springframework.validation.Validator {

		@Override
		public boolean supports(Class<?> clazz)
		{
			return UserForm.class.equals(clazz);
		}

		@Override
		public void validate(Object target, Errors errors)
		{		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty");

			UserForm usr=(UserForm) target;
			if(usr.getIdUser()==null || usr.getIdUser()==0)
			{
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
			
				if(usr!=null && usr.getPassword()!=null && !usr.getPassword().equals(usr.getRepeatPassword()))
					errors.rejectValue("repeatPassword", "password.not_match");
			}
		}


	
	}
   
	
	

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
