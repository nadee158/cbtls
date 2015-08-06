package com.nadee.cbtls.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/admin")
public class AdminHomeController {
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public ModelAndView getLoginPage(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		modelMap.put("message", "Hi");		
		
		return new ModelAndView("adminHome", modelMap);
	}

}
