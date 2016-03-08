package com.nadee.cbtls.initbinder;

import java.beans.PropertyEditorSupport;

import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainStationService;

public class TrainStationEditor extends PropertyEditorSupport {
	
	private final TrainStationService trainStationService;

	public TrainStationEditor(TrainStationService trainStationService) {
		this.trainStationService = trainStationService;
	}


	@Override
	public void setAsText(String trainStationId) throws IllegalArgumentException {
		TrainStation trainStation = null;
		try {
			trainStation = trainStationService.getTrainStationById(Long.parseLong(trainStationId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setValue(trainStation);
	}

}
