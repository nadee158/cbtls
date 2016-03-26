package com.nadee.cbtls.service;

import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.PassiveTrainLocationUpdateDTO;

public interface TrainLocationUpdateService {

	String activeUpdateTrainLocation(ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO)throws Exception;

	String passiveUpdateTrainLocation(PassiveTrainLocationUpdateDTO passiveTrainLocationUpdateDTO)throws Exception;

}
