package com.nadee.cbtls.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nadee.cbtls.service.SystemUserRankingService;

@RestController(value="systemUserRankingController")
public class SystemUserRankingController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SystemUserRankingService rankingService;

}
