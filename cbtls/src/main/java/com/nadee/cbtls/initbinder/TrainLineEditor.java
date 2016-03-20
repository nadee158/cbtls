package com.nadee.cbtls.initbinder;

import java.beans.PropertyEditorSupport;

import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.service.TrainLineService;

public class TrainLineEditor extends PropertyEditorSupport {
	
	private final TrainLineService trainLineService;

	public TrainLineEditor(TrainLineService trainLineService) {
		this.trainLineService = trainLineService;
	}


	@Override
	public void setAsText(String trainLineId) throws IllegalArgumentException {
		TrainLine trainLine = null;
		try {
			trainLine = trainLineService.getTrainLineById(Long.parseLong(trainLineId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setValue(trainLine);
	}

}
