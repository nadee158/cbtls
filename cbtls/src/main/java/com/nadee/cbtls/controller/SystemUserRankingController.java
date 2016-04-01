package com.nadee.cbtls.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.dto.SystemUserRankingsDTO;
import com.nadee.cbtls.dto.UserRankDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.service.SystemUserRankingService;
import com.nadee.cbtls.service.SystemUserService;
import com.nadee.cbtls.util.SessionUtil;

@Controller
public class SystemUserRankingController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SystemUserRankingService rankingService;
	
	@Autowired
    private SystemUserService systemUserService;

	
	@RequestMapping(value = "/rankUser", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> rankUser(HttpServletResponse response, HttpServletRequest request, 
            @RequestBody UserRankDTO dtoUi) {
	  SystemUserRankingsDTO dto=new SystemUserRankingsDTO(dtoUi);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            System.out.println("dto :" + dto);
            SystemUser systemUser=SessionUtil.getFromSession(ApplicationConstants.SYSTEM_USER);
            boolean isUserNull=false;
            if(StringUtils.isEmpty(dto.getSystemUserMobileDevice())){
                if(!(systemUser==null)){
                  dto.setUpdatedUser(systemUser.getUserId());
                }else{
                    long systemUserId=SessionUtil.getUserIdFromCookie(request);
                    if(systemUserId==0){
                        isUserNull=true;
                    }else{
                        SystemUser user=systemUserService.getSystemUserById(systemUserId);
                        SessionUtil.addToSession(ApplicationConstants.SYSTEM_USER, user);
                        dto.setUpdatedUser(systemUserId);
                    }                   
                }
            }
            map= rankingService.saveRanking(dto);
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
