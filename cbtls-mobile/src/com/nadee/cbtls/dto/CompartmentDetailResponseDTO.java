package com.nadee.cbtls.dto;

import java.io.Serializable;
import java.util.List;

public class CompartmentDetailResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String resultsAvailableStatus;
	
	private int totalCompartments;
	
	private int overallCrowdDensity;
	
	private int noOfFeedBacks;
	
	private List<CompartmentDetailItemDTO> detailItems;
	
	public CompartmentDetailResponseDTO(String resultsAvailableStatus) {
		this.resultsAvailableStatus=resultsAvailableStatus;
	}

	public String getResultsAvailableStatus() {
		return resultsAvailableStatus;
	}

	public void setResultsAvailableStatus(String resultsAvailableStatus) {
		this.resultsAvailableStatus = resultsAvailableStatus;
	}

	public int getTotalCompartments() {
		return totalCompartments;
	}

	public void setTotalCompartments(int totalCompartments) {
		this.totalCompartments = totalCompartments;
	}

	public int getOverallCrowdDensity() {
		return overallCrowdDensity;
	}

	public void setOverallCrowdDensity(int overallCrowdDensity) {
		this.overallCrowdDensity = overallCrowdDensity;
	}

	public int getNoOfFeedBacks() {
		return noOfFeedBacks;
	}

	public void setNoOfFeedBacks(int noOfFeedBacks) {
		this.noOfFeedBacks = noOfFeedBacks;
	}

	public List<CompartmentDetailItemDTO> getDetailItems() {
		return detailItems;
	}

	public void setDetailItems(List<CompartmentDetailItemDTO> detailItems) {
		this.detailItems = detailItems;
	}

	@Override
	public String toString() {
		return "CompartmentDetailResponseDTO [resultsAvailableStatus=" + resultsAvailableStatus + ", totalCompartments="
				+ totalCompartments + ", overallCrowdDensity=" + overallCrowdDensity + ", noOfFeedBacks="
				+ noOfFeedBacks + ", detailItems=" + detailItems + "]";
	}
	
	

}
