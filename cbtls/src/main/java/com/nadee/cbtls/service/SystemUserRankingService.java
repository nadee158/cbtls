package com.nadee.cbtls.service;

import java.util.List;
import java.util.Map;

import com.nadee.cbtls.dto.SystemUserRankingsDTO;

public interface SystemUserRankingService {


	public Map<String, Object> saveRanking(SystemUserRankingsDTO systemUserRankingsDTO) throws Exception;
	
	public String deleteRanking(long id);

	public float getAverageSystemUserRanking(long userId);   
	
	public List<SystemUserRankingsDTO> getAllSystemUserRankings(long userId);

	
}
