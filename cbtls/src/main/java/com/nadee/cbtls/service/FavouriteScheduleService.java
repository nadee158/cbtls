package com.nadee.cbtls.service;

import java.util.Map;

import com.nadee.cbtls.dto.FavouriteScheduleDTO;

public interface FavouriteScheduleService {

	Map<String, Object> addToFavourites(FavouriteScheduleDTO favouriteScheduleDTO);

}
