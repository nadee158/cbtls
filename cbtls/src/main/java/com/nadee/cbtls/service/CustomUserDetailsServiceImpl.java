package com.nadee.cbtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nadee.cbtls.dao.SystemUserDAO;

@Service(value = "customUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private SystemUserDAO systemUserDAO; 
	
	public CustomUserDetailsServiceImpl(){}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		try {
			return systemUserDAO.getSystemUserByUserName(userName);
		} catch (Exception e) {
			throw new UsernameNotFoundException(userName);
		}
	}

}
