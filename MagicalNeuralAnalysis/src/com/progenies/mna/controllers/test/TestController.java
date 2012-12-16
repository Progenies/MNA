package com.progenies.mna.controllers.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.progenies.mna.controllers.AbstractMNAController;

@Controller
@RequestMapping("/hello")
public class TestController extends AbstractMNAController
{
	@RequestMapping("/{name}")
    public ModelAndView hello(@PathVariable String name, ModelAndView model)
	{
		model.getModel().put("name", name);
		model.setViewName("hello");
        return model;
    }
	

}
