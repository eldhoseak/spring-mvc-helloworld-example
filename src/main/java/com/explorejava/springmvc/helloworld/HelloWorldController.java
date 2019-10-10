package com.explorejava.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/helloModel", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView("helloworld")
				.addObject("name", "Ramesh");
		return modelAndView;
	}
	
	@RequestMapping(value = "/hello/{userName}", method = RequestMethod.GET)
	public String sayHello(@PathVariable String userName , ModelMap model) {
		model.addAttribute("name", "Hello "+userName+" from Spring 4 MVC");
		return "helloworld";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(@RequestParam(required=false) String employeeName, ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC "+ employeeName);
		return "welcome";
	}
}
