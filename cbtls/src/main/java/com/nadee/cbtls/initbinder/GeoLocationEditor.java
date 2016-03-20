package com.nadee.cbtls.initbinder;

import java.beans.PropertyEditorSupport;

import com.nadee.cbtls.model.GeoLocation;
import com.nadee.cbtls.service.TrainStationService;

public class GeoLocationEditor extends PropertyEditorSupport {
	
	private final TrainStationService trainStationService;

	public GeoLocationEditor(TrainStationService trainStationService) {
		this.trainStationService = trainStationService;
	}


	@Override
	public void setAsText(String geoLocationIdStr) throws IllegalArgumentException {
		GeoLocation geoLocation = null;
		try {
			long geoLocationId=Long.parseLong(geoLocationIdStr);
			if(geoLocationId==0){
				geoLocation=new GeoLocation();
			}else{
				geoLocation = trainStationService.getGeoLocationById(geoLocationId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setValue(geoLocation);
	}

}
