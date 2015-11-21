package com.nadee.cbtls.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.nadee.cbtls.constant.GeneralEnumConstants.TicketType;


@Entity(name = "ticketPrice")
@Table(name = "ticket_price", uniqueConstraints = {@UniqueConstraint(columnNames = {"ticket_price_id"})})
public class TicketPrice implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_price_id", nullable = false)
	private long ticketPriceId;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_schedule_id",nullable=false)
	private TrainSchedule trainSchedule;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role_type")
	private TicketType ticketType;
	
	@Column(name = "ticket_price")
	private float ticketPrice;
	
	@Version
	@Column(name = "version_id")
	private int versionId;
	
	public TicketPrice() {
	}
	

	public Map<String,Object> toBasicMap(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("ticketPriceId", ticketPriceId);
		map.put("ticketType", ticketType);
		map.put("ticketPrice", ticketPrice);
		map.put("versionId", versionId);
		return map;
	}
	
	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}


	public long getTicketPriceId() {
		return ticketPriceId;
	}


	public void setTicketPriceId(long ticketPriceId) {
		this.ticketPriceId = ticketPriceId;
	}


	public TicketType getTicketType() {
		return ticketType;
	}


	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}


	public int getVersionId() {
		return versionId;
	}


	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}


	public float getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public TrainSchedule getTrainSchedule() {
		return trainSchedule;
	}


	public void setTrainSchedule(TrainSchedule trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	

}
