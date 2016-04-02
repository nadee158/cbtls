package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatagenerationObjectMaster implements Serializable {

  private static final long serialVersionUID = 1L;

  private long trainStationId;

  private long trainLineStationId;

  private String trainStationName;

  private long duration;

  private GeoLocationDTO geoLocation;

  private List<GeoLocationDTO> geoLocations;

  public static Map<Long, DatagenerationObjectMaster> generateDefaultList() {
    Map<Long, DatagenerationObjectMaster> map =
        new LinkedHashMap<Long, DatagenerationObjectMaster>();

    List<GeoLocationDTO> geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(6.93328519, 79.85253609));
    geoLocations.add(new GeoLocationDTO(6.93247576, 79.85588349));
    geoLocations.add(new GeoLocationDTO(6.93021787, 79.85850132));
    geoLocations.add(new GeoLocationDTO(6.92813037, 79.86137665));
    geoLocations.add(new GeoLocationDTO(6.92885461, 79.86429489));
    geoLocations.add(new GeoLocationDTO(6.92917412, 79.86491717));
    map.put(46l, new DatagenerationObjectMaster(46, 0, "Colombo Fort", 0,
        new GeoLocationDTO(6.933492, 79.850506), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(6.93017527, 79.86774958));
    geoLocations.add(new GeoLocationDTO(6.93162372, 79.87118281));
    geoLocations.add(new GeoLocationDTO(6.9337538, 79.87465895));
    geoLocations.add(new GeoLocationDTO(6.9366933, 79.87815655));
    geoLocations.add(new GeoLocationDTO(6.9369702, 79.87822092));
    geoLocations.add(new GeoLocationDTO(6.93733231, 79.87873591));
    map.put(178l, new DatagenerationObjectMaster(178, 0, "Maradana", 4,
        new GeoLocationDTO(6.929466, 79.865105), geoLocations));



    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(6.93910026, 79.88068856));
    geoLocations.add(new GeoLocationDTO(6.9411451, 79.88287724));
    geoLocations.add(new GeoLocationDTO(6.94391415, 79.88459385));
    geoLocations.add(new GeoLocationDTO(6.94785468, 79.88704003));
    geoLocations.add(new GeoLocationDTO(6.95471326, 79.88950766));
    geoLocations.add(new GeoLocationDTO(6.9590158, 79.89195383));
    geoLocations.add(new GeoLocationDTO(6.96086886, 79.89407814));
    map.put(51l, new DatagenerationObjectMaster(51, 0, "Dematagoda", 9,
        new GeoLocationDTO(6.937432, 79.879112), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(6.96297751, 79.89637411));
    geoLocations.add(new GeoLocationDTO(6.96572513, 79.89740408));
    geoLocations.add(new GeoLocationDTO(6.97007016, 79.89826239));
    geoLocations.add(new GeoLocationDTO(6.97315852, 79.89882029));
    geoLocations.add(new GeoLocationDTO(6.97447905, 79.89909924));
    map.put(136l, new DatagenerationObjectMaster(136, 0, "Kelaniya", 14,
        new GeoLocationDTO(6.961136, 79.894558), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(6.97660894, 79.89935673));
    geoLocations.add(new GeoLocationDTO(6.97918608, 79.89985026));
    geoLocations.add(new GeoLocationDTO(6.98169932, 79.89976443));
    geoLocations.add(new GeoLocationDTO(6.98459592, 79.89950693));
    geoLocations.add(new GeoLocationDTO(6.98719432, 79.90004338));
    map.put(311l, new DatagenerationObjectMaster(311, 0, "Wanawasala", 17,
        new GeoLocationDTO(6.975663, 79.899209), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(6.98928155, 79.90158833));
    geoLocations.add(new GeoLocationDTO(6.9910493, 79.90321911));
    geoLocations.add(new GeoLocationDTO(6.99285964, 79.90493573));
    geoLocations.add(new GeoLocationDTO(6.99518112, 79.90680254));
    geoLocations.add(new GeoLocationDTO(6.9984184, 79.90699566));
    geoLocations.add(new GeoLocationDTO(6.99995183, 79.90665234));
    map.put(100l, new DatagenerationObjectMaster(100, 0, "Hunupitiya", 20,
        new GeoLocationDTO(6.988833, 79.896391), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.00240107, 79.90678109));
    geoLocations.add(new GeoLocationDTO(7.00450953, 79.90796126));
    geoLocations.add(new GeoLocationDTO(7.00593646, 79.91057909));
    geoLocations.add(new GeoLocationDTO(7.00802361, 79.91377629));
    geoLocations.add(new GeoLocationDTO(7.0104728, 79.91532124));
    geoLocations.add(new GeoLocationDTO(7.01409331, 79.91703785));
    map.put(59l, new DatagenerationObjectMaster(59, 0, "Enderamulla", 23,
        new GeoLocationDTO(7.000415, 79.906833), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.0170749, 79.9184326));
    geoLocations.add(new GeoLocationDTO(7.01971571, 79.91965569));
    geoLocations.add(new GeoLocationDTO(7.02278244, 79.92100752));
    geoLocations.add(new GeoLocationDTO(7.02589231, 79.9215889));
    geoLocations.add(new GeoLocationDTO(7.02863955, 79.92146015));
    map.put(98l, new DatagenerationObjectMaster(98, 0, "Horape", 27,
        new GeoLocationDTO(7.016193, 79.917969), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.03136549, 79.92115974));
    geoLocations.add(new GeoLocationDTO(7.03274974, 79.91993666));
    geoLocations.add(new GeoLocationDTO(7.03281363, 79.91734028));
    geoLocations.add(new GeoLocationDTO(7.03389974, 79.91560221));
    geoLocations.add(new GeoLocationDTO(7.03600805, 79.91457224));
    geoLocations.add(new GeoLocationDTO(7.03756267, 79.91326332));
    map.put(256l, new DatagenerationObjectMaster(256, 0, "Ragama", 30,
        new GeoLocationDTO(7.030012, 79.921426), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.03879783, 79.91096735));
    geoLocations.add(new GeoLocationDTO(7.0405441, 79.90916491));
    geoLocations.add(new GeoLocationDTO(7.04254591, 79.90712643));
    geoLocations.add(new GeoLocationDTO(7.04429216, 79.90493774));
    geoLocations.add(new GeoLocationDTO(7.04691152, 79.90317822));
    geoLocations.add(new GeoLocationDTO(7.04852998, 79.90214825));
    map.put(237l, new DatagenerationObjectMaster(237, 0, "Peralanda", 34,
        new GeoLocationDTO(7.038021, 79.912362), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.05025492, 79.90103245));
    geoLocations.add(new GeoLocationDTO(7.05187336, 79.90023851));
    geoLocations.add(new GeoLocationDTO(7.05427973, 79.89998102));
    geoLocations.add(new GeoLocationDTO(7.05570651, 79.89972353));
    geoLocations.add(new GeoLocationDTO(7.05779344, 79.89835024));
    geoLocations.add(new GeoLocationDTO(7.0622015, 79.8962903));
    map.put(120l, new DatagenerationObjectMaster(120, 0, "Kandana", 38,
        new GeoLocationDTO(7.049297, 79.90158), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.06475687, 79.89560366));
    geoLocations.add(new GeoLocationDTO(7.06739742, 79.89491701));
    geoLocations.add(new GeoLocationDTO(7.07035736, 79.89403725));
    geoLocations.add(new GeoLocationDTO(7.0732747, 79.89332914));
    geoLocations.add(new GeoLocationDTO(7.07621331, 79.89259958));
    geoLocations.add(new GeoLocationDTO(7.07734191, 79.89221334));
    map.put(124l, new DatagenerationObjectMaster(124, 0, "Kapuwatte", 41,
        new GeoLocationDTO(7.062915, 79.896071), geoLocations));


    geoLocations = new ArrayList<GeoLocationDTO>();
    geoLocations.add(new GeoLocationDTO(7.077768, 79.891988));
    map.put(107l, new DatagenerationObjectMaster(107, 0, " Ja-Ela", 44,
        new GeoLocationDTO(7.077768, 79.891988), geoLocations));

    return map;
  }



  public DatagenerationObjectMaster(long trainStationId, long trainLineStationId,
      String trainStationName, long duration, GeoLocationDTO geoLocation,
      List<GeoLocationDTO> geoLocations) {
    super();
    this.trainStationId = trainStationId;
    this.trainLineStationId = trainLineStationId;
    this.trainStationName = trainStationName;
    this.duration = duration;
    this.geoLocation = geoLocation;
    this.geoLocations = geoLocations;
  }



  public DatagenerationObjectMaster() {
    super();
  }



  public long getTrainStationId() {
    return trainStationId;
  }

  public void setTrainStationId(long trainStationId) {
    this.trainStationId = trainStationId;
  }

  public long getTrainLineStationId() {
    return trainLineStationId;
  }

  public void setTrainLineStationId(long trainLineStationId) {
    this.trainLineStationId = trainLineStationId;
  }

  public String getTrainStationName() {
    return trainStationName;
  }

  public void setTrainStationName(String trainStationName) {
    this.trainStationName = trainStationName;
  }

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }

  public GeoLocationDTO getGeoLocation() {
    return geoLocation;
  }

  public void setGeoLocation(GeoLocationDTO geoLocation) {
    this.geoLocation = geoLocation;
  }



  public List<GeoLocationDTO> getGeoLocations() {
    return geoLocations;
  }



  public void setGeoLocations(List<GeoLocationDTO> geoLocations) {
    this.geoLocations = geoLocations;
  }



}
