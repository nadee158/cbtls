package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		System.out.println("CAME IN TO CONTROLER");
		return new ModelAndView("login", modelMap);
	}

}
