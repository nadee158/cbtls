package com.nadee.cbtls.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="compartmentDetailDAO")
public class CompartmentDetailDAOImpl implements CompartmentDetailDAO{
	
	@Autowired
	private SessionFactory sessionFactory;


}
