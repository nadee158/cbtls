package com.nadee.cbtls.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.model.GeoLocation;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainStation;

@Service("trainLineStationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainLineStationServiceImpl implements TrainLineStationService {

  @Autowired
  private CommonDAO commonDAO;

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
  public String saveTrainLineStations(List<TrainLineStation> trainLineStations) {
    String status = ApplicationConstants.SUCCESS;
    for (TrainLineStation trainLineStation : trainLineStations) {
      trainLineStation.setActiveStatus(YesNoStatus.YES);
      long id = commonDAO.createEntity(trainLineStation);
      if ((id <= 0)) {
        status = ApplicationConstants.ERROR;
        break;
      }
    }
    return status;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
  public String updateTrainLineStations(List<TrainLineStation> trainLineStations) {
    String status = ApplicationConstants.SUCCESS;
    for (TrainLineStation trainLineStation : trainLineStations) {
      TrainLineStation trainLineStationFromDb =
          commonDAO.getEntityById(TrainLineStation.class, trainLineStation.getTrainLineStationId());
      trainLineStationFromDb.setActiveStatus(YesNoStatus.YES);
      trainLineStationFromDb.updateFromTrainLineStation(trainLineStation);
      status = commonDAO.updateEntity(trainLineStationFromDb);
      if (StringUtils.equals(status, ApplicationConstants.ERROR)) {
        break;
      }
    }
    return status;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
  public String deleteTrainLineStation(long trainLineStationId) {
    TrainLineStation trainLineStation = new TrainLineStation();
    trainLineStation.setTrainLineStationId(trainLineStationId);
    commonDAO.deleteEntity(trainLineStation);
    return ApplicationConstants.SUCCESS;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
  public String uploadMasterdataFromFile(String fileName) {
    String result = ApplicationConstants.SUCCESS;
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    try {
      br = new BufferedReader(new FileReader(fileName));
      while ((line = br.readLine()) != null) {
        // use comma as separator
        String[] properties = line.split(cvsSplitBy);

        // TrainStation
        long trainStationId = Long.parseLong(properties[0]);// station_id
        String trainStationName = properties[1];// Station
        long geoLocationId = Long.parseLong(properties[9]);// geo_location_id
        double latitude = Double.parseDouble(properties[10]);// latitude
        double longitude = Double.parseDouble(properties[11]);// longitude
        String trainStationContactNumber = properties[4];// Telephone No.

        TrainStation trainStation = commonDAO.getEntityById(TrainStation.class, trainStationId);
        trainStation.setTrainStationName(trainStationName);
        GeoLocation geoLocation = trainStation.getGeoLocation();
        System.out.println("geoLocation.getGeoLocationId() :" + geoLocation.getGeoLocationId());
        System.out.println("geoLocationId :" + geoLocationId);
        geoLocation.setLatitude(latitude);
        geoLocation.setLongitude(longitude);
        trainStation.setTrainStationContactNumber(trainStationContactNumber);
        commonDAO.updateEntity(trainStation);

        long trainLineStationId = Long.parseLong(properties[12]);// train_line_station_id
        double distanceFromStartStation = Double.parseDouble(properties[2]);// distance_from_start_station
        double distanceFromEndStation = Double.parseDouble(properties[3]);// distance_from_end_station
        long nextStationId = Long.parseLong(properties[5]);// next_station_id
        long previousStationId = Long.parseLong(properties[6]);// previous_station_id
        double distanceToNextStation = Double.parseDouble(properties[7]);// distance_to_next_station
        double distanceToPreviousStation = Double.parseDouble(properties[8]);// distance_to_previous_station

        TrainLineStation lineStation =
            commonDAO.getEntityById(TrainLineStation.class, trainLineStationId);
        lineStation.setDistanceFromEndStation(distanceFromEndStation);
        lineStation.setDistanceFromStartStation(distanceFromStartStation);
        lineStation.setDistanceToNextStation(distanceToNextStation);
        lineStation.setDistanceToPreviousStation(distanceToPreviousStation);

        TrainStation nextStation = commonDAO.getEntityById(TrainStation.class, nextStationId);
        lineStation.setNextStation(nextStation);

        TrainStation previousStation =
            commonDAO.getEntityById(TrainStation.class, previousStationId);
        lineStation.setPreviousStation(previousStation);
        commonDAO.updateEntity(lineStation);


      }
    } catch (FileNotFoundException e) {
      result = ApplicationConstants.ERROR;
      e.printStackTrace();
    } catch (IOException e) {
      result = ApplicationConstants.ERROR;
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          result = ApplicationConstants.ERROR;
          e.printStackTrace();
        }
      }
    }
    System.out.println("Done");
    return result;
  }

}
