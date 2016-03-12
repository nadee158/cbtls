package com.nadee.cbtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainScheduleDAO;
import com.nadee.cbtls.model.TrainSchedule;

@Service("trainScheduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainScheduleServiceImpl implements TrainScheduleService{
	
	@Autowired
	private TrainScheduleDAO trainScheduleDAO;
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public long countActiveTrainSchedules() throws Exception {
		return trainScheduleDAO.countActiveTrainSchedules();
	}

	@Override
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
		return trainScheduleDAO.listAllTrainSchedules(yesNoStatus);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String saveTrainSchedule(TrainSchedule trainSchedule) throws Exception {
		return commonDAO.saveOrUpdateEntity(trainSchedule);
	}

	@Override
	public String deleteTrainSchedule(long trainScheduleId) throws Exception {
		TrainSchedule trainSchedule=new TrainSchedule();
		trainSchedule.setTrainScheduleId(trainScheduleId);
		return commonDAO.deleteEntity(trainSchedule);
	}

	@Override
	public TrainSchedule fetchTrainSchedule(String trainNumber, TrainFrequency trainFrequency,String startStationName, String endStationName,
			String trainType) throws Exception {
		return trainScheduleDAO.fetchTrainSchedule(trainNumber, trainFrequency, startStationName, endStationName, 
				trainType);
	}

}
