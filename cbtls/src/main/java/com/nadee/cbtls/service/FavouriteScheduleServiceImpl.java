package com.nadee.cbtls.service;

import java.util.Map;

import com.nadee.cbtls.dto.FavouriteScheduleDTO;
import com.nadee.cbtls.model.SystemUserFavouriteSchedules;

public class FavouriteScheduleServiceImpl implements FavouriteScheduleService {

	@Override
	public Map<String, Object> addToFavourites(FavouriteScheduleDTO favouriteScheduleDTO) {
		SystemUserFavouriteSchedules systemUserFavouriteSchedules=new SystemUserFavouriteSchedules();
		
		return null;
	}

}
