package com.nadee.cbtls.dto;

public class GeoLocationManager {

	// declare public constants

	/**
	 * The minimum allowed latitude
	 */
	public static double MIN_LATITUDE = Double.valueOf("-90.0000");

	/**
	 * The maximum allowed latitude
	 */
	public static double MAX_LATITUDE = Double.valueOf("90.0000");

	/**
	 * The minimum allowed longitude
	 */
	public static double MIN_LONGITUDE = Double.valueOf("-180.0000");

	/**
	 * The maximum allowed longitude
	 */
	public static double MAX_LONGITUDE = Double.valueOf("180.0000");

	/**
	 * The diameter of the Earth used in calculations
	 */
	public static double EARTH_DIAMETER = Double.valueOf("12756.274");

	/**
	 * A method to validate a latitude value
	 * 
	 * @param latitude
	 *            the latitude to check is valid
	 * 
	 * @return true if, and only if, the latitude is within the MIN and MAX
	 *         latitude
	 */
	public static boolean isValidLatitude(double latitude) {
		if (latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A method to validate a longitude value
	 * 
	 * @param longitude
	 *            the longitude to check is valid
	 * 
	 * @return true if, and only if, the longitude is between the MIN and MAX
	 *         longitude
	 */
	public static boolean isValidLongitude(double longitude) {
		if (longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A private method to calculate the latitude constant
	 * 
	 * @return a double representing the latitude constant
	 */
	public static double latitudeConstant() {
		return EARTH_DIAMETER * (Math.PI / Double.valueOf("360"));
		// return EARTH_DIAMETER * (Double.valueOf("3.14") /
		// Double.valueOf("360"));
	}

	/**
	 * A private method to caluclate the longitude constant
	 * 
	 * @param latitude
	 *            a latitude GeoLocation in decimal notation
	 * 
	 * @return a double representing the longitude constant
	 */
	public static double longitudeConstant(double latitude) {

		// return Math.abs( Math.cos(Math.abs(latitude)));
		return EARTH_DIAMETER * Math.PI
				* Math.abs(Math.cos(Math.abs(latitude)))
				/ Double.valueOf("360");

	}

	/**
	 * A method to add distance in a northerly direction to a GeoLocation
	 * 
	 * @param latitude
	 *            a latitude GeoLocation in decimal notation
	 * @param longitude
	 *            a longitude GeoLocation in decimal notation
	 * @param distance
	 *            the distance to add in metres
	 * 
	 * @return the new GeoLocation
	 */
	public static GeoLocation addDistanceNorth(double latitude,
			double longitude, int distance) {

		// check on the parameters
		if (isValidLatitude(latitude) == false
				|| isValidLongitude(longitude) == false || distance <= 0) {
			throw new IllegalArgumentException(
					"All parameters are required and must be valid");
		}

		// convert the distance from metres to kilometers
		double kilometers = distance / new Double(1000);

		// calculate the new latitude
		double newLat = latitude + (kilometers / latitudeConstant());

		return new GeoLocation(new Double(newLat).doubleValue(), longitude);

	}

	/**
	 * A method to add distance in a southerly direction to a GeoLocation
	 * 
	 * @param latitude
	 *            a latitude GeoLocation in decimal notation
	 * @param longitude
	 *            a longitude GeoLocation in decimal notation
	 * @param distance
	 *            the distance to add in metres
	 * 
	 * @return the new GeoLocation
	 */
	public static GeoLocation addDistanceSouth(double latitude,
			double longitude, int distance) {

		// check on the parameters
		if (isValidLatitude(latitude) == false
				|| isValidLongitude(longitude) == false || distance <= 0) {
			throw new IllegalArgumentException(
					"All parameters are required and must be valid");
		}

		// convert the distance from metres to kilometers
		double kilometers = distance / new Double(1000);

		// calculate the new latitude
		double newLat = latitude - (kilometers / latitudeConstant());

		return new GeoLocation(new Double(newLat).doubleValue(), longitude);

	}

	/**
	 * A method to add distance in an easterly direction to a GeoLocation
	 * 
	 * @param latitude
	 *            a latitude GeoLocation in decimal notation
	 * @param longitude
	 *            a longitude GeoLocation in decimal notation
	 * @param distance
	 *            the distance to add in metres
	 * 
	 * @return the new GeoLocation
	 */
	public static GeoLocation addDistanceEast(double latitude,
			double longitude, int distance) {

		// check on the parameters
		if (isValidLatitude(latitude) == false
				|| isValidLongitude(longitude) == false || distance <= 0) {
			throw new IllegalArgumentException(
					"All parameters are required and must be valid");
		}

		// convert the distance from metres to kilometers
		double kilometers = distance / 1000;

		// calculate the new longitude
		double newLng = longitude + (distance / longitudeConstant(latitude));

		return new GeoLocation(latitude, new Double(newLng).doubleValue());
	}

	/**
	 * A method to add distance in an westerly direction to a GeoLocation
	 * 
	 * @param latitude
	 *            a latitude GeoLocation in decimal notation
	 * @param longitude
	 *            a longitude GeoLocation in decimal notation
	 * @param distance
	 *            the distance to add in metres
	 * 
	 * @return the new GeoLocation
	 */
	public static GeoLocation addDistanceWest(double latitude,
			double longitude, int distance) {

		// check on the parameters
		if (isValidLatitude(latitude) == false
				|| isValidLongitude(longitude) == false || distance <= 0) {
			throw new IllegalArgumentException(
					"All parameters are required and must be valid");
		}

		// convert the distance from metres to kilometers
		double kilometers = distance / 1000;

		// calculate the new longitude
		double newLng = longitude - (distance / longitudeConstant(latitude));

		return new GeoLocation(latitude, new Double(newLng).doubleValue());
	}

	/**
	 * A method to build four GeoLocations representing a bounding box given a
	 * start GeoLocation and a distance
	 * 
	 * @param latitude
	 *            a latitude GeoLocation in decimal notation
	 * @param longitude
	 *            a longitude GeoLocation in decimal notation
	 * @param distance
	 *            the distance to add in metres
	 * 
	 * @return a hashMap representing the bounding box (NE,SE,SW,NW)
	 */
	public static java.util.HashMap<String, GeoLocation> getBoundingBox(
			double latitude, double longitude, int distance) {

		// check on the parameters
		if (isValidLatitude(latitude) == false
				|| isValidLongitude(longitude) == false || distance <= 0) {
			throw new IllegalArgumentException(
					"All parameters are required and must be valid");
		}

		// convert the distance from metres to kilometers
		double kilometers = distance / 1000;

		// declare helper variables
		java.util.HashMap<String, GeoLocation> boundingBox = new java.util.HashMap<String, GeoLocation>();

		// calculate the GeoLocations
		GeoLocation north = addDistanceNorth(latitude, longitude, distance);
		GeoLocation south = addDistanceSouth(latitude, longitude, distance);
		GeoLocation east = addDistanceEast(latitude, longitude, distance);
		GeoLocation west = addDistanceWest(latitude, longitude, distance);

		// build the bounding box object
		boundingBox.put("NE",
				new GeoLocation(north.getLatitude(), east.getLongitude()));
		boundingBox.put("SE",
				new GeoLocation(south.getLatitude(), east.getLongitude()));
		boundingBox.put("SW",
				new GeoLocation(south.getLatitude(), west.getLongitude()));
		boundingBox.put("NW",
				new GeoLocation(north.getLatitude(), west.getLongitude()));

		// return the bounding box object
		return boundingBox;
	}

}
