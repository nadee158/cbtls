package com.nadee.cbtls.dto;

import java.io.Serializable;

public class TicketPriceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String priceLabel;
	private float ticketPrice;

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
