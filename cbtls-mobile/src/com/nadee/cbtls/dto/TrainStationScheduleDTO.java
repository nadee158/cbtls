package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TrainStationScheduleDTO implements Serializable {

	private long trainStationScheduleId;

	private TrainLineDTO trainLineDTO;

	private TrainScheduleDTO trainSchedule;

	private TrainStationDTO fromTrainStation;

	private TrainStationDTO toTrainStation;

	private TrainLineStationDTO fromTrainLineStation;

	private TrainLineStationDTO toTrainLineStation;

	private Date arrivalTime;

	private Date departureTime;

	private Date arrivalAtDestinationTime;

	private List<TicketPriceDTO> ticketPrices;

	private String duration;

	private double distance;

	public TrainStationScheduleDTO() {
		super();
	}

	private double calculateDistance() {
		return this.toTrainLineStation.getDistanceFromStartStation()
				- this.fromTrainLineStation.getDistanceFromStartStation();
	}

	private String calculateDuration() {
		long duration = Math.abs(arrivalAtDestinationTime.getTime()
				- departureTime.getTime());
		return String.format(
				"%02d h, %02d min",
				TimeUnit.MILLISECONDS.toHours(duration),

				TimeUnit.MILLISECONDS.toMinutes(duration)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
								.toHours(duration))

		);
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

	public TrainLineDTO getTrainLineDTO() {
		return trainLineDTO;
	}

	public void setTrainLineDTO(TrainLineDTO trainLineDTO) {
		this.trainLineDTO = trainLineDTO;
	}

	public TrainLineStationDTO getFromTrainLineStation() {
		return fromTrainLineStation;
	}

	public void setFromTrainLineStation(TrainLineStationDTO fromTrainLineStation) {
		this.fromTrainLineStation = fromTrainLineStation;
	}

	public TrainLineStationDTO getToTrainLineStation() {
		return toTrainLineStation;
	}

	public void setToTrainLineStation(TrainLineStationDTO toTrainLineStation) {
		this.toTrainLineStation = toTrainLineStation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
