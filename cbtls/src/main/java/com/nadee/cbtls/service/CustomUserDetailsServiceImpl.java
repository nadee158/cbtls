package com.nadee.cbtls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nadee.cbtls.dao.SystemUserDAO;
import com.nadee.cbtls.model.SystemUser;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private SystemUserDAO systemUserDAO; 
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("CAME HERE CustomUserDetailsServiceImpl");
		try {
			System.out.println("CAME HERE CustomUserDetailsServiceImpl");
			SystemUser systemUser= systemUserDAO.getSystemUserByUserName(userName);
			System.out.println("systemUser :l " + systemUser);
			return systemUser;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			throw new UsernameNotFoundException(userName);
		}
	}

}
