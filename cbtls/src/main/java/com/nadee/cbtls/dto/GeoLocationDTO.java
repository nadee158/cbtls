package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nadee.cbtls.model.GeoLocation;

public class GeoLocationDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private long geoLocationId;

  private double latitude;

  private double longitude;



  public GeoLocationDTO() {
    super();
  }



  public GeoLocationDTO(double latitude, double longitude) {
    super();
    this.latitude = latitude;
    this.longitude = longitude;
  }



  public GeoLocationDTO(long geoLocationId, double latitude, double longitude) {
    super();
    this.geoLocationId = geoLocationId;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoLocationDTO(GeoLocation geoLocation) {
    super();
    this.geoLocationId = geoLocation.getGeoLocationId();
    this.latitude = geoLocation.getLatitude();
    this.longitude = geoLocation.getLongitude();
  }

  public static List<GeoLocationDTO> constructGeoLocationDTOList(
      List<GeoLocation> geoLocationList) {
    List<GeoLocationDTO> geoLocationDTOs = new ArrayList<GeoLocationDTO>();
    for (GeoLocation location : geoLocationList) {
      geoLocationDTOs.add(new GeoLocationDTO(location));
    }
    return geoLocationDTOs;
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
