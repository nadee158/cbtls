package com.nadee.cbtls.service;

import java.util.Map;

import com.nadee.cbtls.dto.CompartmentDetailResponseDTO;
import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;
import com.nadee.cbtls.dto.ViewCompartmentDetailRequestDTO;

public interface CompartmentDetailService {

	 Map<String,Object> updateCompartmentDetails(CompartmentDetailUpdateDTO compartmentDetailUpdateDTO) throws Exception;

	CompartmentDetailResponseDTO viewCompartmentDetails(ViewCompartmentDetailRequestDTO viewCompartmentDetailRequestDTO)throws Exception;

}
