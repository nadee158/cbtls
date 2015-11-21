package com.nadee.cbtls.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.nadee.cbtls.constant.GeneralEnumConstants.LocatedType;
import com.nadee.cbtls.util.GeoLocationManager;

@Entity(name = "trainScheduleTurnLocationUpdate")
@Table(name = "train_schedule_turn_location_update", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class TrainScheduleTurnLocationUpdate implements Serializable, Comparable<TrainScheduleTurnLocationUpdate> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "latitude", nullable = false)
	private float latitude;

	@Column(name = "longitude", nullable = false)
	private float longitude;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="train_schedule_turn_id",nullable=false)
	private TrainScheduleTurn trainScheduleTurn;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="last_station_id",nullable=false)
	private TrainStation lastStation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "located_type")
	private LocatedType locatedType;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	private SystemUser updatedUser;
	
	@Column(name="updated_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;
	
	@Transient
	private DecimalFormat format;

	@Version
	@Column(name = "version_id")
	private int versionId;

	public TrainScheduleTurnLocationUpdate() {
		 this.format = new DecimalFormat("##.######");
	}
	
	/**
	   * Constructor for this class
	   *
	   * @param latitude a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   */
	  public TrainScheduleTurnLocationUpdate(float latitude, float longitude) {
	  
	    if(GeoLocationManager.isValidLatitude(latitude) == true && GeoLocationManager.isValidLongitude(longitude) == true) {
	      this.latitude = latitude;
	      this.longitude = longitude;
	    } else {
	      throw new IllegalArgumentException("The parameters did not pass validation as defined by the CoordinateManager class");
	    }
	    
	    this.format = new DecimalFormat("##.######");
	  }

	public Map<String, Object> toBasicMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("latitude", latitude);
		map.put("longitude", longitude);
		
		map.put("trainScheduleTurn", trainScheduleTurn);
		map.put("updatedUser", updatedUser);
		map.put("updatedTime", updatedTime);
		
		map.put("versionId", versionId);
		return map;
	}

	@Override
	public String toString() {
		return this.toBasicMap().toString();
	}


	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		if (GeoLocationManager.isValidLatitude(latitude) == true) {
			this.latitude = latitude;
		} else {
			throw new IllegalArgumentException("The parameter did not pass validation as defined by the GeoLocationManager class");
		}
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		if (GeoLocationManager.isValidLongitude(longitude) == true) {
			this.longitude = longitude;
		} else {
			throw new IllegalArgumentException("The parameter did not pass validation as defined by the CoordinateManager class");
		}
	}

	public DecimalFormat getFormat() {
		return format;
	}

	public void setFormat(DecimalFormat format) {
		this.format = format;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getLatitudeAsString() {
		return format.format(latitude);
	}

	public String getLongitudeAsString() {
		return format.format(longitude);
	}
	
	

	public TrainStation getLastStation() {
		return lastStation;
	}

	public void setLastStation(TrainStation lastStation) {
		this.lastStation = lastStation;
	}

	public LocatedType getLocatedType() {
		return locatedType;
	}

	public void setLocatedType(LocatedType locatedType) {
		this.locatedType = locatedType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TrainScheduleTurn getTrainScheduleTurn() {
		return trainScheduleTurn;
	}

	public void setTrainScheduleTurn(TrainScheduleTurn trainScheduleTurn) {
		this.trainScheduleTurn = trainScheduleTurn;
	}

	public SystemUser getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(SystemUser updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * The compareTo method compares the receiving object with the specified
	 * object and returns a negative integer, 0, or a positive integer depending
	 * on whether the receiving object is less than, equal to, or greater than
	 * the specified object.
	 *
	 * @param c
	 *            the event to compare this one to
	 *
	 * @return an integer indicating comparison result
	 */
	@Override
	public int compareTo(TrainScheduleTurnLocationUpdate c) {
		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		String you = c.getLatitudeAsString() + c.getLongitudeAsString();

		Double meDbl = Double.valueOf(me);
		Double youDbl = Double.valueOf(you);

		if (meDbl == youDbl) {
			return 0;
		} else {
			Double tmp = Math.floor(meDbl - youDbl);
			return tmp.intValue();
		}
	}

	/**
	 * A method to determine if one event is the same as another
	 *
	 * @param o
	 *            the object to compare this one to
	 *
	 * @return true if they are equal, false if they are not
	 */
	public boolean equals(Object o) {
		// check to make sure the object is an event
		if ((o instanceof TrainScheduleTurnLocationUpdate) == false) {
			// o is not an event object
			return false;
		}

		// compare these two events
		TrainScheduleTurnLocationUpdate c = (TrainScheduleTurnLocationUpdate) o;

		// build items for comparison
		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		String you = c.getLatitudeAsString() + c.getLongitudeAsString();

		return me.equals(you);

	} // end equals method

	/**
	 * Overide the default hashcode method
	 * 
	 * @return a hashcode for this object
	 */
	public int hashCode() {

		String me = this.getLatitudeAsString() + this.getLongitudeAsString();
		return 31 * me.hashCode();
	}
	
	
	
}
