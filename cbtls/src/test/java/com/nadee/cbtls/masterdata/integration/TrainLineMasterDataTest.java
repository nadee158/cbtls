package com.nadee.cbtls.masterdata.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nadee.cbtls.service.TrainLineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-config.xml"})
public class TrainLineMasterDataTest {
	
	@Autowired
	private TrainLineService trainLineService;

	@Test
	public void test() {
		try {
			long count=trainLineService.countActiveTrainLines();
			System.out.println("count :" + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
