package com.nadee.cbtls.masterdata.integration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nadee.cbtls.service.TrainLineService;
import com.nadee.cbtls.service.TrainStationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-config.xml"})
public class TrainLineMasterDataTest {
	
	@Autowired
	private TrainLineService trainLineService;
	
	@Autowired
	private TrainStationService trainStationService;
	

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
	
	
//	@Test
//	public void testSaveTrainStatsions() {
//		try {
//			TrainStations stations=RailwayWebServiceV2.getTrainStations(0);
//			for (int i = 0; i < stations.getCount(); i++) {
//				String stationsName=stations.getNames()[i];
//				String statsionCode=stations.getCodes()[i];
//				//System.out.println("statsionCode :"  +statsionCode  + " stationsName" + stationsName);
//				if(!(StringUtils.equals("Anytype{}", stationsName))){
//					if(statsionCode.length()<=3){
//						TrainStation trainStation=new TrainStation(stationsName,statsionCode);
//						System.out.println("trainStation :" + trainStation);
//						trainStationService.saveTrainStation(trainStation);
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
