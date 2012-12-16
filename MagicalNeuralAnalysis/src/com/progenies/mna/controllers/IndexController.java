package com.progenies.mna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends AbstractMNAController
{
	@RequestMapping({"/","/index.html","/index.htm","/index.jsp"})
	public ModelAndView handleRequest(ModelAndView model)
	{
		model.setViewName("index");
		return model;
	}
}
