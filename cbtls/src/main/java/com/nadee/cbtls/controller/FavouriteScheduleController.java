package com.nadee.cbtls.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.FavouriteScheduleDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.service.FavouriteScheduleService;

@Controller
public class FavouriteScheduleController {
	
	@Autowired
	private FavouriteScheduleService favouriteScheduleService;
	
	@RequestMapping(value = "/getFavourites", method = RequestMethod.POST)
	public ModelAndView getFavourites(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		return new ModelAndView("favouriteList", modelMap);
	}
	
	@RequestMapping(value = "/addToFavourite", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> addToFavourite(
			@RequestBody FavouriteScheduleDTO favouriteScheduleDTO ){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
			return favouriteScheduleService.addToFavourites(favouriteScheduleDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
		return map;
	}
	
	
	@RequestMapping(value = "/listFavourites", method = RequestMethod.POST)
	public @ResponseBody List<TrainStationScheduleDTO> listFavourites(
			@RequestBody FavouriteScheduleDTO favouriteScheduleDTO ){
		List<TrainStationScheduleDTO> list=new ArrayList<TrainStationScheduleDTO>();
		try {
			System.out.println("favouriteScheduleDTO :" + favouriteScheduleDTO);
			list=favouriteScheduleService.listFavourites(favouriteScheduleDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
