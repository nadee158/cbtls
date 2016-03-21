package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.model.TrainLineStation;

public interface TrainLineStationService {

  String saveTrainLineStations(List<TrainLineStation> trainLineStations);

  String updateTrainLineStations(List<TrainLineStation> trainLineStations);

  String deleteTrainLineStation(long trainLineStationId);

  String uploadMasterdataFromFile(String fileName);

}
