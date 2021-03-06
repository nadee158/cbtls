package com.nadee.cbtls.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.TrainStationDAO;
import com.nadee.cbtls.dao.TrainStationScheduleDAO;
import com.nadee.cbtls.dto.TicketPriceDTO;
import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.dto.TrainLineStationDTO;
import com.nadee.cbtls.dto.TrainScheduleSearchDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;
import com.nadee.cbtls.model.TicketPrice;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainStationSchedule;

@Service("trainStationScheduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainStationScheduleServiceImpl implements TrainStationScheduleService {
	
	@Autowired
	private TrainStationScheduleDAO trainStationScheduleDAO;
	
	@Autowired
	private TrainStationDAO trainStationDAO;
	
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

	@Override
	public List<TrainStationScheduleDTO> serachTrainStationSchedules(TrainScheduleSearchDTO trainScheduleSearchDTO)
			throws Exception {
		List<TrainStationSchedule> stationSchedules=trainStationScheduleDAO.serachTrainStationSchedules(trainScheduleSearchDTO);
		if(!(stationSchedules==null)){
			
			TrainLine trainLine=commonDAO.getEntityById(TrainLine.class, trainScheduleSearchDTO.getTrainLineId());
			TrainLineDTO trainLineDTO=null;
			if(!(trainLine==null)){
				trainLineDTO=new TrainLineDTO(trainLine, false);
			}
			TrainLineStation fromTrainLineStation=trainStationDAO.getTrainLineStationByStationAndTrainLine(
					trainScheduleSearchDTO.getFromStationId(),trainScheduleSearchDTO.getTrainLineId());
			TrainLineStationDTO fromDTO=null;
			if(!(fromTrainLineStation==null)){
				fromDTO=new TrainLineStationDTO(fromTrainLineStation);
			}
			
			TrainLineStation toTrainLineStation=trainStationDAO.getTrainLineStationByStationAndTrainLine(
					trainScheduleSearchDTO.getToStationId(),trainScheduleSearchDTO.getTrainLineId());
			TrainLineStationDTO toDTO=null;
			if(!(toTrainLineStation==null)){
				toDTO=new TrainLineStationDTO(toTrainLineStation);
			}
			
			
			List<TrainStationScheduleDTO> list=new ArrayList<TrainStationScheduleDTO>();
			for (TrainStationSchedule trainStationSchedule : stationSchedules) {
				
				TrainStationScheduleDTO trainStationScheduleDTO=new TrainStationScheduleDTO(trainStationSchedule,fromDTO,toDTO,trainLineDTO);
				trainStationScheduleDTO.setTicketPrices(new ArrayList<TicketPriceDTO>());
				List<TicketPrice> ticketPrices=trainStationScheduleDAO.getTicketPrices(trainStationSchedule.getTrainStationScheduleId());
				for (TicketPrice ticketPrice : ticketPrices) {
					trainStationScheduleDTO.getTicketPrices().add(new TicketPriceDTO(ticketPrice));
				}
				list.add(trainStationScheduleDTO);
			}
			return list;
		}
		return null;
	}

	@Override
	public TrainStationScheduleDTO getTrainStationScheduleById(long trainStationScheduleId,TrainScheduleSearchDTO trainScheduleSearchDTO) throws Exception {
		TrainStationSchedule trainStationSchedule=commonDAO.getEntityById(TrainStationSchedule.class, trainStationScheduleId);
		
		TrainLine trainLine=commonDAO.getEntityById(TrainLine.class, trainScheduleSearchDTO.getTrainLineId());
		TrainLineDTO trainLineDTO=null;
		if(!(trainLine==null)){
			trainLineDTO=new TrainLineDTO(trainLine, false);
		}
		TrainLineStation fromTrainLineStation=trainStationDAO.getTrainLineStationByStationAndTrainLine(
				trainScheduleSearchDTO.getFromStationId(),trainScheduleSearchDTO.getTrainLineId());
		TrainLineStationDTO fromDTO=null;
		if(!(fromTrainLineStation==null)){
			fromDTO=new TrainLineStationDTO(fromTrainLineStation);
		}
		
		TrainLineStation toTrainLineStation=trainStationDAO.getTrainLineStationByStationAndTrainLine(
				trainScheduleSearchDTO.getToStationId(),trainScheduleSearchDTO.getTrainLineId());
		TrainLineStationDTO toDTO=null;
		if(!(toTrainLineStation==null)){
			toDTO=new TrainLineStationDTO(toTrainLineStation);
		}
		
		
		TrainStationScheduleDTO trainStationScheduleDTO=new TrainStationScheduleDTO(trainStationSchedule,fromDTO,toDTO,trainLineDTO);
		trainStationScheduleDTO.setTicketPrices(new ArrayList<TicketPriceDTO>());
		List<TicketPrice> ticketPrices=trainStationScheduleDAO.getTicketPrices(trainStationSchedule.getTrainStationScheduleId());
		for (TicketPrice ticketPrice : ticketPrices) {
			trainStationScheduleDTO.getTicketPrices().add(new TicketPriceDTO(ticketPrice));
		}
		return trainStationScheduleDTO;
	}
}
