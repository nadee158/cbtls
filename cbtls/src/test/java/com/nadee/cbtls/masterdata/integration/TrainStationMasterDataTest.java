package com.nadee.cbtls.masterdata.integration;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nadee.cbtls.masterdata.domain.TrainStations;
import com.nadee.cbtls.masterdata.service.RailwayWebServiceV2;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainStationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/application-config.xml"})
public class TrainStationMasterDataTest {
	
	@Autowired
	private TrainStationService trainStationService;
	
	
	@Test
	public void testSaveTrainStatsions() {
		try {
			TrainStations stations=RailwayWebServiceV2.getTrainStations(0);
			for (int i = 0; i < stations.getCount(); i++) {
				String stationsName=stations.getNames()[i];
				String statsionCode=stations.getCodes()[i];
				//System.out.println("statsionCode :"  +statsionCode  + " stationsName" + stationsName);
				if(!(StringUtils.equals("Anytype{}", stationsName))){
					if(statsionCode.length()<=3){
						TrainStation trainStation=new TrainStation(stationsName,statsionCode);
						System.out.println("trainStation :" + trainStation);
						trainStationService.saveTrainStation(trainStation);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
