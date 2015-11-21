package com.nadee.cbtls.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nadeeshani Senevirathna
 *
 */
public class GeneralEnumConstants {
	
	public enum YesNoStatus{
		YES(1),
		NO(0);
		
		private int code;
		
		private YesNoStatus(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, YesNoStatus> LOOKUP = new HashMap<Integer, YesNoStatus>();

		static {
			for (YesNoStatus yesNoStatus : EnumSet.allOf(YesNoStatus.class)) {
				LOOKUP.put(yesNoStatus.getCode(), yesNoStatus);
			}
		}
		
		public static YesNoStatus fromCode(int code) {
			return LOOKUP.get(code);
		}
	}
	
	
	public enum UserRoleType {
		ROLE_USER,
		ROLE_ADMIN,
		ROLE_GUEST,
		ROLE_PASSENGER,
	}
	
	
	public enum TrainFrequency{
		DAILY(1),
		MONDAY_TO_FRIDAY(2),
		SATURDAY_SUNDAY(3);
		
		private int code;
		
		private TrainFrequency(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, TrainFrequency> LOOKUP = new HashMap<Integer, TrainFrequency>();

		static {
			for (TrainFrequency trainFrequency : EnumSet.allOf(TrainFrequency.class)) {
				LOOKUP.put(trainFrequency.getCode(), trainFrequency);
			}
		}
		
		public static TrainFrequency fromCode(int code) {
			return LOOKUP.get(code);
		}
	}
	
	public enum PassengerType{
		DAILY(1),
		WEEKLY(2),
		OCCASIONAL(3);
		
		private int code;
		
		private PassengerType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, PassengerType> LOOKUP = new HashMap<Integer, PassengerType>();

		static {
			for (PassengerType passengerType : EnumSet.allOf(PassengerType.class)) {
				LOOKUP.put(passengerType.getCode(), passengerType);
			}
		}
		
		public static PassengerType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}
	
	
	public enum CrowdDensity{
		LOW(1),
		MEDIUM(2),
		HIGH(3),
		VERY_HIGH(4);
		
		private int code;
		
		private CrowdDensity(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, CrowdDensity> LOOKUP = new HashMap<Integer, CrowdDensity>();

		static {
			for (CrowdDensity  crowdDensity : EnumSet.allOf(CrowdDensity.class)) {
				LOOKUP.put(crowdDensity.getCode(), crowdDensity);
			}
		}
		
		public static CrowdDensity fromCode(int code) {
			return LOOKUP.get(code);
		}
	}
	
	
	public enum AlarmType{
		DISTANCE(1),
		BEFORE_STATION(2),
		AT_STATION(3);
		
		private int code;
		
		private AlarmType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, AlarmType> LOOKUP = new HashMap<Integer, AlarmType>();

		static {
			for (AlarmType  alarmType : EnumSet.allOf(AlarmType.class)) {
				LOOKUP.put(alarmType.getCode(), alarmType);
			}
		}
		
		public static AlarmType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}
	
	public enum LocatedType{
		IN_THE_STATION(1),
		ON_THE_MOVE(2),
		STOPPED(3);
		
		private int code;
		
		private LocatedType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, LocatedType> LOOKUP = new HashMap<Integer, LocatedType>();

		static {
			for (LocatedType  locatedType : EnumSet.allOf(LocatedType.class)) {
				LOOKUP.put(locatedType.getCode(), locatedType);
			}
		}
		
		public static LocatedType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}
	
	
	
	public enum TicketType{
		FIRST_CLASS(1),
		SECOND_CLASS(2),
		THIRD_CLASS(3);
		
		private int code;
		
		private TicketType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
		
		private static final Map<Integer, TicketType> LOOKUP = new HashMap<Integer, TicketType>();

		static {
			for (TicketType  ticketType : EnumSet.allOf(TicketType.class)) {
				LOOKUP.put(ticketType.getCode(), ticketType);
			}
		}
		
		public static TicketType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

}
