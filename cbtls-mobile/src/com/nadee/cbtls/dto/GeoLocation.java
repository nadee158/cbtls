package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class GeoLocation implements Serializable, Comparable<GeoLocation> {

	private static final long serialVersionUID = 1L;
	private long geoLocationId;

	private double latitude;

	private double longitude;

	private DecimalFormat format;

	private int versionId;

	public GeoLocation() {
		super();
		this.format = new DecimalFormat("##.######");
	}

	public GeoLocation(boolean defaultConstructor) {
		this();
		if (!(defaultConstructor)) {
			this.latitude = 00.000000;
			this.longitude = 00.000000;
		}
	}

	/**
	 * Constructor for this class
	 * 
	 * @param latitude
	 *            a latitude coordinate in decimal notation
	 * @param longitude
	 *            a longitude coordinate in decimal notation
	 */
	public GeoLocation(double latitude, double longitude) {

		if (GeoLocationManager.isValidLatitude(latitude) == true
				&& GeoLocationManager.isValidLongitude(longitude) == true) {
			this.latitude = latitude;
			this.longitude = longitude;
		} else {
			throw new IllegalArgumentException(
					"The parameters did not pass validation as defined by the CoordinateManager class");
		}

		this.format = new DecimalFormat("##.######");
	}

	public Map<String, Object> toBasicMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("geoLocationId", geoLocationId);
		map.put("latitude", latitude);
		map.put("longitude", longitude);
		map.put("versionId", versionId);
		return map;
	}

	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}

	public long getGeoLocationId() {
		return geoLocationId;
	}

	public void setGeoLocationId(long geoLocationId) {
		this.geoLocationId = geoLocationId;
	}

	public void setLatitude(double latitude) {
		if (GeoLocationManager.isValidLatitude(latitude) == true) {
			this.latitude = latitude;
		} else {
			throw new IllegalArgumentException(
					"The parameter did not pass validation as defined by the GeoLocationManager class");
		}
	}

	public void setLongitude(double longitude) {
		if (GeoLocationManager.isValidLongitude(longitude) == true) {
			this.longitude = longitude;
		} else {
			throw new IllegalArgumentException(
					"The parameter did not pass validation as defined by the CoordinateManager class");
		}
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public DecimalFormat getFormat() {
		return format;
	}

	public void setFormat(DecimalFormat format) {
		this.format = format;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getLatitudeAsString() {
		return format.format(latitude);
	}

	public String getLongitudeAsString() {
		return format.format(longitude);
	}

	/**
	 * The compareTo method compares the receiving object with the specified
	 * object and returns a negative integer, 0, or a positive integer depending
	 * on whether the receiving object is less than, equal to, or greater than
	 * the specified object.
	 * 
	 * @param c
	 *            the event to compare this one to
	 * 
	 * @return an integer indicating comparison result
	 */
	@Override
	public int compareTo(GeoLocation c) {
		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		String you = c.getLatitudeAsString() + c.getLongitudeAsString();

		Double meDbl = Double.valueOf(me);
		Double youDbl = Double.valueOf(you);

		if (meDbl == youDbl) {
			return 0;
		} else {
			Double tmp = Math.floor(meDbl - youDbl);
			return tmp.intValue();
		}
	}

	/**
	 * A method to determine if one event is the same as another
	 * 
	 * @param o
	 *            the object to compare this one to
	 * 
	 * @return true if they are equal, false if they are not
	 */
	public boolean equals(Object o) {
		// check to make sure the object is an event
		if ((o instanceof GeoLocation) == false) {
			// o is not an event object
			return false;
		}

		// compare these two events
		GeoLocation c = (GeoLocation) o;

		// build items for comparison
		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		String you = c.getLatitudeAsString() + c.getLongitudeAsString();

		return me.equals(you);

	} // end equals method

	/**
	 * Overide the default hashcode method
	 * 
	 * @return a hashcode for this object
	 */
	public int hashCode() {

		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		return 31 * me.hashCode();
	}

}
