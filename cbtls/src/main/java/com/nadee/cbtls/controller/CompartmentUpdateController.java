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
import com.nadee.cbtls.dto.CompartmentDetailResponseDTO;
import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;
import com.nadee.cbtls.dto.ViewCompartmentDetailRequestDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.CompartmentDetailService;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class CompartmentUpdateController {

	@Autowired
	private CompartmentDetailService compartmentDetailService;
	
	@Autowired
	private SystemUserService systemUserService;


	@RequestMapping(value = "/getUpdateCompartmentDetails", method = RequestMethod.POST)
	public ModelAndView getUpdateCompartmentDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long tssid=SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
		modelMap.put("tssid", tssid);
		modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
		return new ModelAndView("updateCompartmentDetails", modelMap);
	}

	@RequestMapping(value = "/updateCompartmentDetails", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateCompartmentDetails(HttpServletResponse response, HttpServletRequest request, 
			@RequestBody CompartmentDetailUpdateDTO compartmentDetailUpdateDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println("compartmentDetailUpdateDTO :" + compartmentDetailUpdateDTO);
			SystemUser systemUser=SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
			boolean isUserNull=false;
			if(StringUtils.isEmpty(compartmentDetailUpdateDTO.getSystemUserMobileDevice())){
				if(!(systemUser==null)){
					compartmentDetailUpdateDTO.setUpdatedUser(systemUser.getUserId());
				}else{
					long systemUserId=SessionUtil.getUserIdFromCookie(request);
					if(systemUserId==0){
						isUserNull=true;
					}else{
						SystemUser user=systemUserService.getSystemUserById(systemUserId);
						SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
						compartmentDetailUpdateDTO.setUpdatedUser(systemUserId);
					}					
				}
			}
			map= compartmentDetailService.updateCompartmentDetails(compartmentDetailUpdateDTO);
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

	@RequestMapping(value = "/getViewCompartmentDetails", method = RequestMethod.POST)
	public ModelAndView getViewCompartmentDetails(HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		long tssid=SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL_ID");
		modelMap.put("tssid", tssid);
		modelMap.put("trainStationScheduleDTO", SessionUtil.getFromSession("SEARCHED_SCHEDULE_DETAIL"));
		return new ModelAndView("viewCompartmentDetails", modelMap);
	}
	
	@RequestMapping(value = "/viewCompartmentDetails", method = RequestMethod.POST)
	public @ResponseBody CompartmentDetailResponseDTO viewCompartmentDetails(
			@RequestBody ViewCompartmentDetailRequestDTO viewCompartmentDetailRequestDTO) {
		try {
			System.out.println("viewCompartmentDetailRequestDTO :" + viewCompartmentDetailRequestDTO);
			return compartmentDetailService.viewCompartmentDetails(viewCompartmentDetailRequestDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CompartmentDetailResponseDTO(ApplicationConstants.NO_RESULTS);
	}

}
