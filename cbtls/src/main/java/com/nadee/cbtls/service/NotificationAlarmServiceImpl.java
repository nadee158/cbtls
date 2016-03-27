package com.nadee.cbtls.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.AlarmType;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dto.NotificationAlarmDTO;
import com.nadee.cbtls.model.SystemUserAlarm;
import com.nadee.cbtls.model.SystemUserMobileDevice;
import com.nadee.cbtls.model.TrainStation;

@Service("notificationAlarmService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NotificationAlarmServiceImpl implements NotificationAlarmService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private SystemUserService systemUserService;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	@Override
	public Map<String,Object> setNotificationAlarm(NotificationAlarmDTO notificationAlarmDTO) throws Exception {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		SystemUserAlarm alarm=new SystemUserAlarm();
		alarm.setActiveStatus(YesNoStatus.YES);
		AlarmType alarmType=AlarmType.fromCode(notificationAlarmDTO.getAlarmType());
		alarm.setAlarmType(alarmType);
		
		switch (alarmType) {
			case AT_STATION:
				
				break;
			case BEFORE_STATION:
				
				break;
			case DISTANCE:
				
				break;
			default:
				break;
		}
		long stationId=notificationAlarmDTO.getDestinationStation();
		if(!(stationId==0)){
			TrainStation destinationStation=commonDAO.getEntityById(TrainStation.class, stationId);
			alarm.setDestinationStation(destinationStation);
		}
		alarm.setDistanceToStation(notificationAlarmDTO.getDistanceToStation());
		SystemUserMobileDevice systemUserMobileDevice=null;
		systemUserMobileDevice=systemUserService.getSystemUserMobileDeviceByUniqueId(notificationAlarmDTO.getSystemUserMobileDevice());
		
		if(systemUserMobileDevice==null){
			systemUserMobileDevice=systemUserService.createMobileUser(notificationAlarmDTO.getSystemUserMobileDevice());
		}
		
		alarm.setSystemUserMobileDevice(systemUserMobileDevice);
		long id=commonDAO.createEntity(alarm);
		if(id>0){
			resultMap.put(ApplicationConstants.RESULT, ApplicationConstants.SUCCESS);
		}else{
			resultMap.put(ApplicationConstants.RESULT, ApplicationConstants.ERROR);
		}
		resultMap.put(ApplicationConstants.USER_TYPE,ApplicationConstants.MOBILE_USER);
		resultMap.put(ApplicationConstants.USER_ID,systemUserMobileDevice.getMobileDevice().getUniqueMobileDeviceNumber());
		return resultMap;
	}
	
	

}