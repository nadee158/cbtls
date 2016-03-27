package com.nadee.cbtls.service;

import java.util.Map;

import com.nadee.cbtls.dto.NotificationAlarmDTO;

public interface NotificationAlarmService {

	 Map<String,Object> setNotificationAlarm(NotificationAlarmDTO notificationAlarmDTO)throws Exception;

}
