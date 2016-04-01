package com.nadee.cbtls.service;

import java.util.Map;

import com.nadee.cbtls.dto.ActiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.PassiveTrainLocationUpdateDTO;
import com.nadee.cbtls.dto.ViewTrainlocationRequestDTO;
import com.nadee.cbtls.dto.ViewTrainlocationResponseDTO;

public interface TrainLocationUpdateService {

	Map<String,Object> activeUpdateTrainLocation(ActiveTrainLocationUpdateDTO activeTrainLocationUpdateDTO)throws Exception;

	Map<String,Object> passiveUpdateTrainLocation(PassiveTrainLocationUpdateDTO passiveTrainLocationUpdateDTO)throws Exception;

	
	ViewTrainlocationResponseDTO listTrainLocation(ViewTrainlocationRequestDTO requestDTO)throws Exception;
}
