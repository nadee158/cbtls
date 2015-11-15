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

}
