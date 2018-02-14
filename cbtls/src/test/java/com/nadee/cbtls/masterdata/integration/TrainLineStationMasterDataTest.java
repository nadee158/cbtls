package com.nadee.cbtls.masterdata.integration;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.masterdata.domain.TrainLines;
import com.nadee.cbtls.masterdata.domain.TrainStations;
import com.nadee.cbtls.masterdata.service.RailwayWebServiceV2;
import com.nadee.cbtls.model.TrainLine;
import com.nadee.cbtls.model.TrainLineStation;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.service.TrainLineService;
import com.nadee.cbtls.service.TrainStationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-config.xml" })
public class TrainLineStationMasterDataTest {

//	@Autowired
//	private TrainLineService trainLineService;
//
//	@Autowired
//	private TrainStationService trainStationService;
//
//	@Test
//	public void testSaveTrainlineStations() {
//
//		try {
//			TrainLines lines = RailwayWebServiceV2.getLines();
//			for (int i = 0; i < lines.getCount(); i++) {
//				String trainLineName = lines.getNames()[i];
//				int trainLineId = lines.getIds()[i];
//
//				if(!(trainLineId==0)){
//					TrainLine trainLine = trainLineService.getTrainLineByTrainLineIntegrationId(trainLineId);
//					if (trainLine == null) {
//						trainLine = new TrainLine(trainLineId, trainLineName);
//						System.out.println("trainLine :" + trainLine);
//						trainLineService.saveTrainLine(trainLine);
//						trainLine = trainLineService.getTrainLineByTrainLineIntegrationId(trainLineId);
//					}
//
//					if (trainLine.getTrainLineStations() == null) {
//						trainLine.setTrainLineStations(new ArrayList<TrainLineStation>());
//					}
//
//					TrainStations stations = RailwayWebServiceV2.getTrainStations(trainLineId);
//					for (int j = 0; j < stations.getCount(); j++) {
//						String stationsName = stations.getNames()[j];
//						String statsionCode = stations.getCodes()[j];
//						System.out.println("statsionCode :" + statsionCode + " stationsName" + stationsName);
//						if (!(StringUtils.equals("Anytype{}", stationsName))) {
//							if (statsionCode.length() <= 3) {
//								TrainStation trainStation = trainStationService.getTrainStationByCode(statsionCode);
//								if (trainStation == null) {
//									trainStation = new TrainStation(stationsName, statsionCode);
//									System.out.println("trainStation :" + trainStation);
//									trainStationService.saveTrainStation(trainStation);
//									trainStation = trainStationService.getTrainStationByCode(statsionCode);
//								}
//
//								TrainLineStation trainLineStation = new TrainLineStation();
//								trainLineStation.setActiveStatus(YesNoStatus.YES);
//								trainLineStation.setTrainLine(trainLine);
//								trainLineStation.setTrainStation(trainStation);
//
//								trainLine.getTrainLineStations().add(trainLineStation);
//							}
//						}
//					}
//					
//					TrainStation startStation=null;
//					TrainStation endStation=null;
//					
//
//					switch (trainLineId) {
//					case 1:
//						// '1', 'YES', '1', 'Colombo - Badulla', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("BAD");
//						break;
//					case 2:
//						// '2', 'YES', '2', 'Colombo - Matale', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("MTL");
//						break;
//					case 3:
//						// '3', 'YES', '3', 'Colombo - Puttlam', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("PTM");
//						break;
//					case 4:
//						// '4', 'YES', '4', 'Colombo - Thandikulam', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("TDK");
//						break;
//					case 5:
//						// '5', 'YES', '5', 'Colombo - Talaimannar', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("MNR");
//						break;
//					case 6:
//						// '6', 'YES', '6', 'Colombo - Batticaloa', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("BCO");
//						break;
//					case 7:
//						// '7', 'YES', '7', 'Colombo - Trincomalee', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("TCO");
//						break;
//					case 8:
//						// '8', 'YES', '8', 'Colombo - Matara', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("MDA");
//						endStation=trainStationService.getTrainStationByCode("MTR");
//						break;
//					case 9:
//						// '9', 'YES', '9', 'Colombo - Avissawella', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("AVS");
//						break;
//					case 10:
//						// '10', 'YES', '10', 'Colombo - Mihintale', '0', NULL, NULL
//						startStation=trainStationService.getTrainStationByCode("FOT");
//						endStation=trainStationService.getTrainStationByCode("MHN");
//						break;
//					
//					default:
//						break;
//					}
//					trainLine.setStartStation(startStation);
//					trainLine.setEndStation(endStation);
//					trainLineService.saveTrainLine(trainLine);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
