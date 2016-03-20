package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.model.TrainStationSchedule;

public class TrainStationScheduleDTO implements Serializable {
	
	private long trainStationScheduleId;
	
	private TrainScheduleDTO trainSchedule;
	
	private TrainStationDTO fromTrainStation;
	
	private TrainStationDTO toTrainStation;
	
	private Date arrivalTime;	
	
	private Date departureTime;
	
	private Date arrivalAtDestinationTime;
	
	private List<TicketPriceDTO> ticketPrices;
	
	private String duration;

	public TrainStationScheduleDTO() {
		super();
	}
	
	public TrainStationScheduleDTO(TrainStationSchedule trainStationSchedule) {
		this.trainStationScheduleId = trainStationSchedule.getTrainStationScheduleId();
		this.trainSchedule = new TrainScheduleDTO(trainStationSchedule.getTrainSchedule());
		this.fromTrainStation = new TrainStationDTO(trainStationSchedule.getFromTrainStation());
		this.toTrainStation = new TrainStationDTO(trainStationSchedule.getToTrainStation());
		this.arrivalTime = trainStationSchedule.getArrivalTime();
		this.departureTime = trainStationSchedule.getDepartureTime();
		this.arrivalAtDestinationTime = trainStationSchedule.getArrivalAtDestinationTime();
		this.duration=calculateDuration();
	}
	

	private String calculateDuration() {
		long duration=Math.abs(arrivalAtDestinationTime.getTime() - departureTime.getTime());
		return String.format("%02d min, %02d sec", 
			    TimeUnit.MILLISECONDS.toMinutes(duration),
			    TimeUnit.MILLISECONDS.toSeconds(duration) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
			);
	}

	public TrainStationScheduleDTO(long trainStationScheduleId, TrainScheduleDTO trainSchedule,
			TrainStationDTO fromTrainStation, TrainStationDTO toTrainStation, YesNoStatus activeStatus,
			Date arrivalTime, Date departureTime, Date arrivalAtDestinationTime, List<TicketPriceDTO> ticketPrices) {
		super();
		this.trainStationScheduleId = trainStationScheduleId;
		this.trainSchedule = trainSchedule;
		this.fromTrainStation = fromTrainStation;
		this.toTrainStation = toTrainStation;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.arrivalAtDestinationTime = arrivalAtDestinationTime;
		this.ticketPrices = ticketPrices;
	}



	private static final long serialVersionUID = 1L;

	public long getTrainStationScheduleId() {
		return trainStationScheduleId;
	}

	public void setTrainStationScheduleId(long trainStationScheduleId) {
		this.trainStationScheduleId = trainStationScheduleId;
	}

	public TrainScheduleDTO getTrainSchedule() {
		return trainSchedule;
	}

	public void setTrainSchedule(TrainScheduleDTO trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	public TrainStationDTO getFromTrainStation() {
		return fromTrainStation;
	}

	public void setFromTrainStation(TrainStationDTO fromTrainStation) {
		this.fromTrainStation = fromTrainStation;
	}

	public TrainStationDTO getToTrainStation() {
		return toTrainStation;
	}

	public void setToTrainStation(TrainStationDTO toTrainStation) {
		this.toTrainStation = toTrainStation;
	}


	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalAtDestinationTime() {
		return arrivalAtDestinationTime;
	}

	public void setArrivalAtDestinationTime(Date arrivalAtDestinationTime) {
		this.arrivalAtDestinationTime = arrivalAtDestinationTime;
	}

	public List<TicketPriceDTO> getTicketPrices() {
		return ticketPrices;
	}

	public void setTicketPrices(List<TicketPriceDTO> ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	

}
