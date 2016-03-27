package com.nadee.cbtls.service;

import java.util.List;
import java.util.Map;

import com.nadee.cbtls.dto.FavouriteScheduleDTO;
import com.nadee.cbtls.dto.TrainStationScheduleDTO;

public interface FavouriteScheduleService {

	Map<String, Object> addToFavourites(FavouriteScheduleDTO favouriteScheduleDTO)throws Exception;

	List<TrainStationScheduleDTO> listFavourites(FavouriteScheduleDTO favouriteScheduleDTO)throws Exception;

}
