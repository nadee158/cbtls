package com.nadee.cbtls.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.NotificationAlarmService;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class NotificationAlarmController {
	
	@Autowired
	private NotificationAlarmService notificationAlarmService;
	
	@Autowired
	private SystemUserService systemUserService;

	@RequestMapping(value = "/getNotificationAlarm", method = RequestMethod.POST)
	public ModelAndView setNotificationAlarm(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long tssid=SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
		modelMap.put("tssid", tssid);
		modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
		return new ModelAndView("setNotificationAlarm", modelMap);
	}
	
	@RequestMapping(value = "/setNotificationAlarm", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> setNotificationAlarm(HttpServletResponse response, HttpServletRequest request,
			@RequestBody NotificationAlarmDTO notificationAlarmDTO ){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			System.out.println("notificationAlarmDTO :" + notificationAlarmDTO);
			SystemUser systemUser=SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
			boolean isUserNull=false;
			if(StringUtils.isEmpty(notificationAlarmDTO.getSystemUserMobileDevice())){
				if(!(systemUser==null)){
					notificationAlarmDTO.setUpdatedUser(systemUser.getUserId());
				}else{
					long systemUserId=SessionUtil.getUserIdFromCookie(request);
					if(systemUserId==0){
						isUserNull=true;
					}else{
						SystemUser user=systemUserService.getSystemUserById(systemUserId);
						SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
						notificationAlarmDTO.setUpdatedUser(systemUserId);
					}					
				}
			}
			map= notificationAlarmService.setNotificationAlarm(notificationAlarmDTO);
			if(isUserNull){
				SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, map.get(ApplicationConstants.SYSTEM_USER));
				SessionUtil.addUserCookie(response,(SystemUser) map.get(ApplicationConstants.SYSTEM_USER));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
		return map;
	}

}
