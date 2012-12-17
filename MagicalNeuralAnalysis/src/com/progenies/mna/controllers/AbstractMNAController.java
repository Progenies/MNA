package com.progenies.mna.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.progenies.mna.menu.Menu;

public abstract class AbstractMNAController implements ApplicationContextAware
{
	
	@Autowired
	protected ApplicationContext context;
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
	{
		
	}

	@ModelAttribute("menu")
	public Menu insertMenu(HttpServletRequest request)
	{
		Menu menu=context.getBean(Menu.class);
		return menu;
	}
	
	@ModelAttribute("locale")
	public String getLocale()
	{
		//de momento, manualmente castellano
		return "es";
	}
	
	@ModelAttribute("userProfile")
	public Principal insertUserPrincipal(Principal userProfile)
	{
		return userProfile;
	}
}
