package com.nadee.cbtls.dao;

import java.util.List;

import com.nadee.cbtls.model.SystemUserRankings;

public interface SystemUserRankingDAO {
	
	public List<SystemUserRankings> getSystemUserRankingsByUserId(long userId);
	

}
