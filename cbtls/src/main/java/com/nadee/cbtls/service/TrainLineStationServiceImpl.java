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
import com.nadee.cbtls.model.TrainLineStation;

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

        //TrainStation
        
        long trainStationId = Long.parseLong(properties[0]);// station_id
        String stationName = properties[1];// Station
        
        =properties[2];// distance_from_start_station
        =properties[3];// distance_from_end_station
        
        String trainStationContactNumber=properties[4];// Telephone No.
        // next_station_id
        // previous_station_id
        // distance_to_next_station
        // distance_to_previous_station
        // geo_location_id
        // latitude
        // longitude
        // train_line_station_id



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
