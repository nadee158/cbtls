package com.nadee.cbtls.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nadee.cbtls.service.SystemUserRankingService;

@Component("userInputValidator")
public class UserInputValidator {
	
	//threashhold user ranking
	private static final float minUserRanking=2.5f;
	
	@Autowired
	private SystemUserRankingService systemUserRankingService;
	
	/*
	 *  The formula for calculating the weighted rating of a user, Bayesian estimate:
	    weighted rating (WR) = (v ÷ (v+m)) × R + (m ÷ (v+m)) × C
	    where:
	    * R = average for the user (mean) = (Rating)
	    * v = number of votes for the user = (feedbacks)
	    * m = minimum votes required to be considered as a trusted user - eg:- 10
	    * C = the mean vote across the whole report
	    for the Top 250, only votes from regular voters are considered.
	 * */
	public boolean checkIfUserIsTrusted(long userId){
		float avergeUserRanking=systemUserRankingService.getAverageSystemUserRanking(userId);
		if(avergeUserRanking>=minUserRanking){
			return true;
		}
		return false;
	}

}
