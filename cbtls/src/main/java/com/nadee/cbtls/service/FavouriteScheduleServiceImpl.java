package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dto.FavouriteScheduleDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.SystemUserFavouriteSchedules;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.TrainStationSchedule;
@Service("favouriteScheduleService")
public class FavouriteScheduleServiceImpl implements FavouriteScheduleService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private SystemUserService systemUserService;

	@Override
	public Map<String, Object> addToFavourites(FavouriteScheduleDTO dto) throws Exception {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		SystemUserFavouriteSchedules systemUserFavouriteSchedules=new SystemUserFavouriteSchedules();
		systemUserFavouriteSchedules.setActiveStatus(YesNoStatus.YES);
		
		SystemUser systemUser=null;
		
		if(StringUtils.isNotEmpty(dto.getSystemUserMobileDevice())){
			SystemUserMobileDevice systemUserMobileDevice=systemUserService.getSystemUserMobileDeviceByUniqueId(dto.getSystemUserMobileDevice());
			if(systemUserMobileDevice==null){
				systemUserMobileDevice=systemUserService.createMobileUser(dto.getSystemUserMobileDevice());
			}
			systemUser=systemUserMobileDevice.getSystemUser();
			resultMap.put(ApplicationConstants.USER_TYPE,ApplicationConstants.MOBILE_USER);
			resultMap.put(ApplicationConstants.USER_ID,systemUserMobileDevice.getMobileDevice().getUniqueMobileDeviceNumber());
		}else{
			if(!(dto.getUpdatedUser()==0)){
				systemUser=commonDAO.getEntityById(SystemUser.class, dto.getUpdatedUser());
			}
			if(systemUser==null){
				systemUser=systemUserService.createWebUser();
			}
			resultMap.put(ApplicationConstants.USER_TYPE,ApplicationConstants.WEB_USER);
			resultMap.put(ApplicationConstants.USER_ID,systemUser.getUserId());
		}
		
		systemUserFavouriteSchedules.setSystemUser(systemUser);
		TrainStationSchedule trainStationSchedule=commonDAO.getEntityById(TrainStationSchedule.class, dto.getTrainStationScheduleId());
		systemUserFavouriteSchedules.setTrainStationSchedule(trainStationSchedule);
		
		String result=commonDAO.saveOrUpdateEntity(systemUserFavouriteSchedules);
		resultMap.put(ApplicationConstants.RESULT, result);
		return resultMap;
	}
	
	@Override
	public List<TrainStationScheduleDTO> listFavourites(FavouriteScheduleDTO dto) throws Exception {
		SystemUser systemUser=null;
		if(StringUtils.isNotEmpty(dto.getSystemUserMobileDevice())){
			SystemUserMobileDevice systemUserMobileDevice=systemUserService.getSystemUserMobileDeviceByUniqueId(dto.getSystemUserMobileDevice());
			if(systemUserMobileDevice==null){
				systemUserMobileDevice=systemUserService.createMobileUser(dto.getSystemUserMobileDevice());
			}
			systemUser=systemUserMobileDevice.getSystemUser();
		}else{
			if(!(dto.getUpdatedUser()==0)){
				systemUser=commonDAO.getEntityById(SystemUser.class, dto.getUpdatedUser());
			}
			if(systemUser==null){
				systemUser=systemUserService.createWebUser();
			}
		}
		List<SystemUserFavouriteSchedules> favouriteSchedules=systemUserService.listFavouriteSchedules(systemUser.getUserId());
		List<TrainStationScheduleDTO> dtos=new ArrayList<TrainStationScheduleDTO>();
		
		for (SystemUserFavouriteSchedules schedules : favouriteSchedules) {
			TrainStationSchedule trainStationSchedule=schedules.getTrainStationSchedule();
			dtos.add(new TrainStationScheduleDTO(trainStationSchedule, null, null, null));
		}
		return dtos;
	}

}
