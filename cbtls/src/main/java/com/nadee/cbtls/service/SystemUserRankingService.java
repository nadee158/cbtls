package com.nadee.cbtls.service;

import java.util.List;

import com.nadee.cbtls.dto.SystemUserRankingsDTO;

public interface SystemUserRankingService {


	public String saveRanking(SystemUserRankingsDTO systemUserRankingsDTO);
	
	public String deleteRanking(long id);

	public float getAverageSystemUserRanking(long userId);   
	
	public List<SystemUserRankingsDTO> getAllSystemUserRankings(long userId);
	
}
