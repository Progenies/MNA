package com.progenies.mna.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.progenies.mna.menu.Menu;

public abstract class AbstractMNAController
{

	@ModelAttribute("menu")
	public Menu insertMenu(HttpServletRequest request)
	{
		Menu menu=WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean(Menu.class);
		return menu;
	}
	
	@ModelAttribute("locale")
	public String getLocale()
	{
		//de momento, manualmente castellano
		return "es";
	}
}
