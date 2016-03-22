package com.nadee.cbtls.dto;

import java.io.Serializable;

public class GeoLocationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private long geoLocationId;

	private double latitude;

	private double longitude;

	public GeoLocationDTO() {
		super();
	}

	public GeoLocationDTO(long geoLocationId, double latitude, double longitude) {
		super();
		this.geoLocationId = geoLocationId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getGeoLocationId() {
		return geoLocationId;
	}

	public void setGeoLocationId(long geoLocationId) {
		this.geoLocationId = geoLocationId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
