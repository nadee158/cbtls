package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.CrowdDensity;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.CompartmentDetailDAO;
import com.nadee.cbtls.dao.TrainLocationUpdateDAO;
import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;
import com.nadee.cbtls.model.SystemUser;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainScheduleTurn;
import com.nadee.cbtls.model.TrainScheduleTurnCompartmentUpdate;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainStationScheduleTurn;

@Service("compartmentDetailService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompartmentDetailServiceImpl implements CompartmentDetailService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private CompartmentDetailDAO compartmentDetailDAO;
	
	@Autowired
	private TrainLocationUpdateDAO trainLocationUpdateDAO;

	@Override
	public String updateCompartmentDetails(CompartmentDetailUpdateDTO dto) throws Exception {
		TrainScheduleTurnCompartmentUpdate update=new TrainScheduleTurnCompartmentUpdate();
		
		update.setCompartmentDensity(CrowdDensity.fromCode(dto.getCompartmentDensity()));
		update.setCompartmentNumber(dto.getCompartmentNumber());
		update.setOverallDensity(CrowdDensity.fromCode(dto.getOverallDensity()));
		update.setTotalCompartments(dto.getTotalCompartments());
		
		TrainScheduleTurn trainScheduleTurn=trainLocationUpdateDAO.fetchTrainScheduleTurn(dto.getTrainScheduleId(), Calendar.getInstance().getTime());
		System.out.println("trainScheduleTurn :"  + trainScheduleTurn);
		
		boolean isNewRecord=false;
		
		
		if(trainScheduleTurn==null){
			isNewRecord=true;
			trainScheduleTurn=new TrainScheduleTurn();
			trainScheduleTurn.setActiveStatus(YesNoStatus.YES);
			TrainSchedule trainSchedule=commonDAO.getEntityById(TrainSchedule.class, dto.getTrainScheduleId());
			trainScheduleTurn.setTrainSchedule(trainSchedule);
			trainScheduleTurn.setTrainScheduleTurnDate(Calendar.getInstance().getTime());
		}
		
		if(trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates()==null){
			trainScheduleTurn.setTrainScheduleTurnCompartmentUpdates(new ArrayList<TrainScheduleTurnCompartmentUpdate>());
		}
		
		update.setTrainScheduleTurn(trainScheduleTurn);
		update.setUpdatedTime(Calendar.getInstance().getTime());
		SystemUser systemUser=null;
		if(!(dto.getUpdatedUser()==0)){
			systemUser=commonDAO.getEntityById(SystemUser.class, dto.getUpdatedUser());
		}
		update.setUpdatedUser(systemUser);
		
		trainScheduleTurn.getTrainScheduleTurnCompartmentUpdates().add(update);
		
		TrainStationScheduleTurn trainStationScheduleTurn=null;
		if(!(isNewRecord)){
			trainStationScheduleTurn=trainLocationUpdateDAO.fetchTrainStationScheduleTurn(trainScheduleTurn.getTrainScheduleTurnId(),dto.getTrainStationScheduleId());
		}
		Date arrivalTime=Calendar.getInstance().getTime();
		Date departureTime=Calendar.getInstance().getTime();
		
		
		if(trainStationScheduleTurn==null){
			if(trainScheduleTurn.getTrainStationScheduleTurn()==null){
				trainScheduleTurn.setTrainStationScheduleTurn(new ArrayList<TrainStationScheduleTurn>());
			}
			trainStationScheduleTurn=new TrainStationScheduleTurn();
			trainStationScheduleTurn.setActiveStatus(YesNoStatus.YES);
			trainStationScheduleTurn.setArrivalTime(arrivalTime);
			trainStationScheduleTurn.setDepartureTime(departureTime);
			TrainStationSchedule trainStationSchedule=commonDAO.getEntityById(TrainStationSchedule.class, dto.getTrainStationScheduleId());
			trainStationScheduleTurn.setTrainStationSchedule(trainStationSchedule);
			trainStationScheduleTurn.setTrainTurn(trainScheduleTurn);
			trainScheduleTurn.getTrainStationScheduleTurn().add(trainStationScheduleTurn);
			
		}
		
		return commonDAO.saveOrUpdateEntity(trainScheduleTurn);
	}

}
