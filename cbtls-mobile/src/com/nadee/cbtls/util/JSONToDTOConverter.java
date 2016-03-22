package com.nadee.cbtls.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.nadee.cbtls.dto.GeoLocationDTO;
import com.nadee.cbtls.dto.TicketPriceDTO;
import com.nadee.cbtls.dto.TrainLineDTO;
import com.nadee.cbtls.dto.TrainLineStationDTO;
import com.nadee.cbtls.dto.TrainScheduleDTO;
import com.nadee.cbtls.dto.TrainStationDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;

public class JSONToDTOConverter {

	public static TrainStationScheduleDTO convertToTrainStationScheduleDTO(
			JSONObject jsonObject) throws JSONException {
		TrainStationScheduleDTO trainStationScheduleDTO = new TrainStationScheduleDTO();

		long arrivalAtDestinationTime = jsonObject
				.getLong("arrivalAtDestinationTime");
		trainStationScheduleDTO.setArrivalAtDestinationTime(new Date(
				arrivalAtDestinationTime));

		long arrivalTime = jsonObject.getLong("arrivalTime");
		trainStationScheduleDTO.setArrivalTime(new Date(arrivalTime));

		long departureTime = jsonObject.getLong("departureTime");
		trainStationScheduleDTO.setDepartureTime(new Date(departureTime));

		trainStationScheduleDTO.setDistance(jsonObject.getDouble("distance"));
		trainStationScheduleDTO.setDuration(jsonObject.getString("duration"));
		trainStationScheduleDTO.setTrainStationScheduleId(jsonObject
				.getLong("trainStationScheduleId"));

		TrainLineDTO trainLineDTO = convertToTrainLineDTO(jsonObject
				.getJSONObject("trainLineDTO"));
		trainStationScheduleDTO.setTrainLineDTO(trainLineDTO);

		TrainScheduleDTO trainSchedule = convertToTrainScheduleDTO(jsonObject
				.getJSONObject("trainSchedule"));

		TrainStationDTO fromTrainStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("fromTrainStation"));

		TrainStationDTO toTrainStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("toTrainStation"));

		TrainLineStationDTO fromTrainLineStation = convertToTrainLineStationDTO(jsonObject
				.getJSONObject("fromTrainLineStation"));

		TrainLineStationDTO toTrainLineStation = convertToTrainLineStationDTO(jsonObject
				.getJSONObject("toTrainLineStation"));

		trainStationScheduleDTO.setFromTrainLineStation(fromTrainLineStation);
		trainStationScheduleDTO.setFromTrainStation(fromTrainStation);

		List<TicketPriceDTO> ticketPrices = convertToTicketPriceDTOList(jsonObject
				.getJSONArray("ticketPrices"));
		trainStationScheduleDTO.setTicketPrices(ticketPrices);

		trainStationScheduleDTO.setToTrainLineStation(toTrainLineStation);
		trainStationScheduleDTO.setToTrainStation(toTrainStation);
		trainStationScheduleDTO.setTrainSchedule(trainSchedule);

		return trainStationScheduleDTO;
	}

	private static List<TicketPriceDTO> convertToTicketPriceDTOList(
			JSONArray jsonArray) throws JSONException {
		List<TicketPriceDTO> list = new ArrayList<TicketPriceDTO>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			list.add(convertToTicketPriceDTO(jsonObject));
		}
		return list;
	}

	private static TicketPriceDTO convertToTicketPriceDTO(JSONObject jsonObject)
			throws JSONException {
		TicketPriceDTO ticketPriceDTO = new TicketPriceDTO();
		ticketPriceDTO.setPriceLabel(jsonObject.getString("priceLabel"));
		ticketPriceDTO.setTicketPrice(Float.parseFloat(jsonObject
				.getString("ticketPrice")));
		return ticketPriceDTO;
	}

	private static TrainLineStationDTO convertToTrainLineStationDTO(
			JSONObject jsonObject) throws JSONException {
		TrainLineStationDTO trainLineStationDTO = new TrainLineStationDTO();
		trainLineStationDTO.setDistanceFromEndStation(jsonObject
				.getDouble("distanceFromEndStation"));
		trainLineStationDTO.setDistanceFromStartStation(jsonObject
				.getDouble("distanceFromStartStation"));
		trainLineStationDTO.setDistanceToNextStation(jsonObject
				.getDouble("distanceToNextStation"));
		trainLineStationDTO.setDistanceToPreviousStation(jsonObject
				.getDouble("distanceToPreviousStation"));
		TrainStationDTO nextStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("nextStation"));
		trainLineStationDTO.setNextStation(nextStation);
		TrainStationDTO previousStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("previousStation"));
		trainLineStationDTO.setPreviousStation(previousStation);
		trainLineStationDTO.setTrainLineStationId(jsonObject
				.getLong("trainLineStationId"));
		TrainStationDTO trainStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("trainStation"));
		trainLineStationDTO.setTrainStation(trainStation);
		return trainLineStationDTO;
	}

	private static TrainScheduleDTO convertToTrainScheduleDTO(
			JSONObject jsonObject) throws JSONException {
		TrainScheduleDTO trainScheduleDTO = new TrainScheduleDTO();
		TrainStationDTO endStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("endStation"));
		trainScheduleDTO.setEndStation(endStation);
		TrainStationDTO startStation = convertToTrainStationDTO(jsonObject
				.getJSONObject("startStation"));
		trainScheduleDTO.setStartStation(startStation);
		trainScheduleDTO.setTrainFrequency(jsonObject
				.getString("trainFrequency"));
		trainScheduleDTO.setTrainName(jsonObject.getString("trainName"));
		trainScheduleDTO.setTrainNumber(jsonObject.getString("trainNumber"));
		trainScheduleDTO.setTrainScheduleId(jsonObject
				.getLong("trainScheduleId"));
		trainScheduleDTO.setTrainType(jsonObject.getString("trainType"));
		return trainScheduleDTO;
	}

	private static TrainLineDTO convertToTrainLineDTO(JSONObject jsonObject)
			throws JSONException {
		TrainLineDTO trainLineDTO = new TrainLineDTO();
		trainLineDTO.setTrainLineId(jsonObject.getLong("trainLineId"));
		trainLineDTO.setTrainLineName(jsonObject.getString("trainLineName"));
		// TrainStationDTO
		// endStation=convertToTrainStationDTO(jsonObject.getJSONObject("endStation"));
		// TrainStationDTO
		// startStation=convertToTrainStationDTO(jsonObject.getJSONObject("startStation"));
		// trainLineDTO.setEndStation(endStation);
		// trainLineDTO.setStartStation(startStation);
		return trainLineDTO;
	}

	private static TrainStationDTO convertToTrainStationDTO(
			JSONObject jsonObject) throws JSONException {
		TrainStationDTO trainStationDTO = new TrainStationDTO();
		try {
			if (jsonObject.has("geoLocation")
					&& !(jsonObject.get("geoLocation") == null)) {
				GeoLocationDTO geoLocation = convertToGeoLocationDTO(jsonObject
						.getJSONObject("geoLocation"));
				trainStationDTO.setGeoLocation(geoLocation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		trainStationDTO.setTrainStationCode(jsonObject
				.getString("trainStationCode"));
		trainStationDTO.setTrainStationContactNumber(jsonObject
				.getString("trainStationContactNumber"));
		trainStationDTO.setTrainStationId(jsonObject.getLong("trainStationId"));
		trainStationDTO.setTrainStationName(jsonObject
				.getString("trainStationName"));
		return trainStationDTO;
	}

	private static GeoLocationDTO convertToGeoLocationDTO(JSONObject jsonObject)
			throws JSONException {
		GeoLocationDTO geoLocation = new GeoLocationDTO();
		geoLocation.setGeoLocationId(jsonObject.getLong("geoLocationId"));
		geoLocation.setLatitude(jsonObject.getDouble("latitude"));
		geoLocation.setLongitude(jsonObject.getDouble("longitude"));
		return geoLocation;
	}

}
