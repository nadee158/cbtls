package com.nadee.cbtls.validator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nadee.cbtls.model.GeoLocation;

@Component("gPSValidator")
public class GPSValidator {
	
	//within 500m
	private static final double standarRadius=0.5;

	boolean isInRectangle(double centerX, double centerY, double radius, double x, double y) {
		return x >= centerX - radius && x <= centerX + radius && y >= centerY - radius && y <= centerY + radius;
	}

	// test if coordinate (x, y) is within a radius from coordinate (center_x,
	// center_y)
	public boolean checkIfPointInCircle(double centerCoordX, double centerCoordY, double radius, double coordX, double coordY) {
		if (isInRectangle(centerCoordX, centerCoordY, radius, coordX, coordY)) {
			double doubleXCoord = centerCoordX - coordX;
			double doubleYCoord = centerCoordY - coordY;
			doubleXCoord *= doubleXCoord;
			doubleYCoord *= doubleYCoord;
			double distanceSquared = doubleXCoord + doubleYCoord;
			double radiusSquared = radius * radius;
			return distanceSquared <= radiusSquared;
		}
		return false;
	}
	
	public boolean checkIfValidLocationInput(GeoLocation inputLocation, List<GeoLocation> geoLocations){
		boolean isValid=false;
		for (GeoLocation centerLocation : geoLocations) {
			if((checkIfPointInCircle(centerLocation.getLatitude(), centerLocation.getLongitude(), 
					standarRadius, inputLocation.getLatitude(), inputLocation.getLongitude()))){
				isValid=true;
			}
		}
		return isValid;
	}

}
