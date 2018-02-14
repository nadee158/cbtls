package com.nadee.cbtls.masterdata.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nadee.cbtls.masterdata.domain.TrainLines;
import com.nadee.cbtls.masterdata.service.RailwayWebServiceV2;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.service.TrainLineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-config.xml"})
public class TrainLineMasterDataTest {
	
//	@Autowired
//	private TrainLineService trainLineService;
//	
//
//	@Test
//	public void testSaveTrainlines() {
//		
//		try {
//			TrainLines lines=RailwayWebServiceV2.getLines();
//			for (int i = 0; i < lines.getCount(); i++) {
//				String trainLineName=lines.getNames()[i];
//				int trainLineId=lines.getIds()[i];
//				
//				TrainLine trainLine=new TrainLine(trainLineId,trainLineName);
//				System.out.println("trainLine :" + trainLine);
//				trainLineService.saveTrainLine(trainLine);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	


}
