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

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.NotificationAlarmDTO;
import com.nadee.cbtls.service.NotificationAlarmService;

@Controller
public class NotificationAlarmController {
	
	@Autowired
	private NotificationAlarmService notificationAlarmService;

	@RequestMapping(value = "/getNotificationAlarm", method = RequestMethod.POST)
	public ModelAndView setNotificationAlarm(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		return new ModelAndView("setNotificationAlarm", modelMap);
	}
	
	@RequestMapping(value = "/setNotificationAlarm", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> setNotificationAlarm(
			@RequestBody NotificationAlarmDTO notificationAlarmDTO ){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			System.out.println("notificationAlarmDTO :" + notificationAlarmDTO);
			return notificationAlarmService.setNotificationAlarm(notificationAlarmDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
		return map;
	}

}
