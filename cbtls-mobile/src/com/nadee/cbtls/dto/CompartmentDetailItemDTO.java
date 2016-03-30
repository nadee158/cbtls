package com.nadee.cbtls.dto;

import java.io.Serializable;

public class CompartmentDetailItemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int comaprtmentNumber;
	
	private int crowdDensity;
	
	private int noOfFeedBacks;

	public int getComaprtmentNumber() {
		return comaprtmentNumber;
	}

	public void setComaprtmentNumber(int comaprtmentNumber) {
		this.comaprtmentNumber = comaprtmentNumber;
	}

	public int getCrowdDensity() {
		return crowdDensity;
	}

	public void setCrowdDensity(int crowdDensity) {
		this.crowdDensity = crowdDensity;
	}

	public int getNoOfFeedBacks() {
		return noOfFeedBacks;
	}

	public void setNoOfFeedBacks(int noOfFeedBacks) {
		this.noOfFeedBacks = noOfFeedBacks;
	}

	@Override
	public String toString() {
		return "CompartmentDetailItemDTO [comaprtmentNumber=" + comaprtmentNumber + ", crowdDensity=" + crowdDensity
				+ ", noOfFeedBacks=" + noOfFeedBacks + "]";
	}
	
	

}
