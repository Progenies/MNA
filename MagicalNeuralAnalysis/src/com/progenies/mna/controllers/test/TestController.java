package com.progenies.mna.controllers.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("MNA")
public class TestController
{
	@RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name, Model model) {
            model.addAttribute("name", name);
            return "hello";
    }
}
