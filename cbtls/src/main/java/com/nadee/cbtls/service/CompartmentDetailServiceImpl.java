package com.nadee.cbtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadee.cbtls.dao.CommonDAO;
import com.nadee.cbtls.dao.CompartmentDetailDAO;
import com.nadee.cbtls.dto.CompartmentDetailUpdateDTO;

@Service("compartmentDetailService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CompartmentDetailServiceImpl implements CompartmentDetailService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private CompartmentDetailDAO compartmentDetailDAO;

	@Override
	public String updateCompartmentDetails(CompartmentDetailUpdateDTO compartmentDetailUpdateDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
