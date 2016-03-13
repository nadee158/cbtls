package com.nadee.cbtls.dto;

import java.io.Serializable;

import com.nadee.cbtls.model.TicketPrice;

public class TicketPriceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String priceLabel;
	private float ticketPrice;
	
	public TicketPriceDTO(TicketPrice ticketPrice) {
		this.ticketPrice=ticketPrice.getTicketPrice();
		switch (ticketPrice.getTicketType()) {
		case FIRST_CLASS:
			this.priceLabel="Class 1";
			break;
		case SECOND_CLASS:
			this.priceLabel="Class 2";	
			break;
		case THIRD_CLASS:
			this.priceLabel="Class 3(E)";
			break;
		default:
			break;
		}
	}
	
	
	
	public TicketPriceDTO() {
		super();
	}



	public TicketPriceDTO(String priceLabel, float ticketPrice) {
		super();
		this.priceLabel = priceLabel;
		this.ticketPrice = ticketPrice;
	}



	public String getPriceLabel() {
		return priceLabel;
	}
	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	

}
