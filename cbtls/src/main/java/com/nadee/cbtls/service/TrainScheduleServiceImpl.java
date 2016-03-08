package com.nadee.cbtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.TrainScheduleDAO;
import com.nadee.cbtls.model.TrainSchedule;

@Service("trainScheduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainScheduleServiceImpl implements TrainScheduleService{
	
	@Autowired
	private TrainScheduleDAO trainScheduleDAO;

	@Override
	public long countActiveTrainSchedules() throws Exception {
		return trainScheduleDAO.countActiveTrainSchedules();
	}

	@Override
	public List<TrainSchedule> listAllTrainSchedules(YesNoStatus yesNoStatus) throws Exception {
		return trainScheduleDAO.listAllTrainSchedules(yesNoStatus);
	}

	@Override
	public String saveTrainSchedule(TrainSchedule trainSchedule) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTrainSchedule(long trainScheduleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
