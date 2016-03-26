package com.nadee.cbtls.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;
import com.nadee.cbtls.service.CompartmentDetailService;

@Controller
public class CompartmentUpdateController {
	
	@Autowired
	private CompartmentDetailService compartmentDetailService;

	@RequestMapping(value = "/getUpdateCompartmentDetails", method = RequestMethod.POST)
	public ModelAndView getUpdateCompartmentDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		return new ModelAndView("updateCompartmentDetails", modelMap);
	}
	
	@RequestMapping(value = "/updateCompartmentDetails", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateCompartmentDetails(
			@RequestBody CompartmentDetailUpdateDTO compartmentDetailUpdateDTO ){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			System.out.println("compartmentDetailUpdateDTO :" + compartmentDetailUpdateDTO);
			String result=compartmentDetailService.updateCompartmentDetails(compartmentDetailUpdateDTO);
			map.put("RESULT", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
