package com.nadee.cbtls.service;

import java.util.Map;

import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.PassiveTrainLocationUpdateDTO;

public interface TrainLocationUpdateService {

	Map<String,Object> activeUpdateTrainLocation(ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO)throws Exception;

	Map<String,Object> passiveUpdateTrainLocation(PassiveTrainLocationUpdateDTO passiveTrainLocationUpdateDTO)throws Exception;

}
