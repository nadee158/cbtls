package com.nadee.cbtls.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainStationScheduleDAO;
import com.nadee.cbtls.model.TrainStationSchedule;

@Service("trainStationScheduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainStationScheduleServiceImpl implements TrainStationScheduleService {
	
	@Autowired
	private TrainStationScheduleDAO trainStationScheduleDAO;
	
	@Autowired
	private CommonDAO commonDAO;

	@Override
	public long countActiveTrainStationSchedules() throws Exception {
		return trainStationScheduleDAO.countActiveTrainStationSchedules();
	}

	@Override
	public List<TrainStationSchedule> listAllTrainStationSchedule(YesNoStatus yesNoStatus) throws Exception {
		return trainStationScheduleDAO.listAllTrainStationSchedule(yesNoStatus);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String saveTrainStationSchedule(TrainStationSchedule trainStationSchedule) throws Exception {
		return commonDAO.saveOrUpdateEntity(trainStationSchedule);
	}

	@Override
	public String deleteTrainSchedule(long trainStationScheduleId) throws Exception {
		TrainStationSchedule trainStationSchedule=new TrainStationSchedule();
		trainStationSchedule.setTrainStationScheduleId(trainStationScheduleId);
		return commonDAO.deleteEntity(trainStationSchedule);
	}

	@Override
	public TrainStationSchedule fetchTrainStationSchedule(long trainScheduleId, long fromStationId, long toStationId,
			Date arrivalTime, Date depatureTime) throws Exception {
		return trainStationScheduleDAO.fetchTrainStationSchedule(trainScheduleId, fromStationId, toStationId, arrivalTime, depatureTime);
	}

}
