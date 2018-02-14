package com.nadee.cbtls.masterdata.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadee.cbtls.constant.GeneralEnumConstants.TicketType;
import com.nadee.cbtls.constant.GeneralEnumConstants.TrainFrequency;
import com.nadee.cbtls.constant.GeneralEnumConstants.YesNoStatus;
import com.nadee.cbtls.masterdata.domain.Rates;
import com.nadee.cbtls.masterdata.domain.TrainSchedules;
import com.nadee.cbtls.masterdata.domain.TrainStations;
import com.nadee.cbtls.model.TicketPrice;
import com.nadee.cbtls.model.TrainSchedule;
import com.nadee.cbtls.model.TrainStation;
import com.nadee.cbtls.model.TrainStationSchedule;
import com.nadee.cbtls.model.TrainType;
import com.nadee.cbtls.service.TrainScheduleService;
import com.nadee.cbtls.service.TrainStationScheduleService;
import com.nadee.cbtls.service.TrainStationService;
import com.nadee.cbtls.service.TrainTypeService;

@Service("trainScheduleMasterDataService")
public class TrainScheduleMasterDataService {
	
//	public static final String MONDAY_TO_FRIDAY="MONDAY TO FRIDAY";	
//	public static final String SUNDAYS_AND_HOLIDAYS="SUNDAYS AND HOLIDAYS";	
//	public static final String SATURDAY_AND_SUNDAY="SATURDAY AND SUNDAY";	
//	public static final String DAILY="DAILY";	
//	
//	
//	@Autowired
//	private TrainScheduleService trainScheduleService;
//	
//	@Autowired
//	private TrainStationService trainStationService;
//	
//	@Autowired
//	private TrainTypeService trainTypeService;
//	
//	@Autowired
//	private TrainStationScheduleService trainStationScheduleService;
//	
//	private List<TrainType> trainTypes;
//	
//	
//	public void saveSchedules(int trainLine) {
//		try {
//			
//			trainTypes=trainTypeService.listAllTrainTypes(YesNoStatus.YES);
//			
//			TrainStations stations=RailwayWebServiceV2.getTrainStations(trainLine);
//			
//			String startStationCode="FOT";
//			String endStationCode="JLA";
//			
//			String startStationName="Colombo Fort";
//			String endStationName="Ja-Ela";
//			
//			TrainStation startStation=null;
//			TrainStation endStation=null;
//			
//			
//			outer_for:for (int i = 0; i < stations.getCount(); i++) {
//				
//				startStationCode=stations.getCodes()[i];
//				startStationName=stations.getNames()[i];
//				
//				
//				
//				String [] addedStartStations={"AWP","AVD","AKT","BOA","BLT","BSA","CHL","FOT","DAG","EDM","EPN",
//						"IPZ","HRP","HUN","JLA","KYA","KAN","KAW","KAT","CAK","KTK","KLA","KCH","KWW","KUD",
//						"KUR","LGM","LWL","MDP","MKI","MGE","MDA","MNL"};
//				
//				if(!(StringUtils.equals("Anytype{}", startStationName) || startStationCode.length()>3)){
//					
//					boolean doAdd=true;
//					
//					for (String addedStartStationCode : addedStartStations) {
//						if(StringUtils.equals(startStationCode, addedStartStationCode)){
//							doAdd=false;
//						}
//					}
//					
//					if(doAdd){
//						startStation =trainStationService.getTrainStationByCode(startStationCode);
//						inner_for:for (int j = 0; j < stations.getCount(); j++) {
//							endStationCode=stations.getCodes()[j];
//							endStationName=stations.getNames()[j];
//							if(!(StringUtils.equals("Anytype{}", endStationName)|| endStationCode.length()>3)){
//								if(!(StringUtils.equals(startStationCode, endStationCode))){
//									endStation=trainStationService.getTrainStationByCode(endStationCode);
//									System.out.println("startStation :" + startStation.getTrainStationName());
//									System.out.println("endStation :" + endStation.getTrainStationName());
//									try {
//										addTrainStationScheduleList(startStation, endStation);
//									} catch (Exception e) {
//										System.err.println("FAILED.........!");
//										System.err.println("startStation :" + startStation.getTrainStationName());
//										System.err.println("endStation :" + endStation.getTrainStationName());
//										e.printStackTrace();
//									}
//								}
//							}
//						}
//					}
//					
//					
//				}
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void addTrainStationScheduleList(TrainStation fromStation,TrainStation toStation) throws Exception{
//		
//		Calendar now = Calendar.getInstance();
//		String todayDate = String.format("%1$tY-%1$tm-%1$td", now);
//		String todayTime = String.format("%1$tH:%1$tM:%1$tS", now);
//		
//		TrainSchedules schedules= RailwayWebServiceV2.getSchedule(fromStation.getTrainStationCode(),toStation.getTrainStationCode() , "00:00:00", "23:59:59", todayDate, todayTime);
//		
//		SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
//		
//		for (int i = 0; i < schedules.getCount(); i++) {
//			String trainName=schedules.getTrainNames()[i];
//			System.out.println("trainName :" + trainName);
//			String arrivalTimes=schedules.getArrivalTimes()[i];
//			System.out.println("arrivalTimes :" + arrivalTimes);
//			String depatureTimes=schedules.getDepatureTimes()[i];
//			System.out.println("depatureTimes :" + depatureTimes);
//			String arrivalAtDestinationTimes=schedules.getArrivalAtDestinationTimes()[i];
//			System.out.println("arrivalAtDestinationTimes :" + arrivalAtDestinationTimes);
//			String delayTimes=schedules.getDelayTimes()[i];
//			System.out.println("delayTimes :" + delayTimes);
//			String comments=schedules.getComments()[i];
//			System.out.println("comments :" + comments);
//			String fdDescriptions=schedules.getFdDescriptions()[i];
//			System.out.println("fdDescriptions :" + fdDescriptions);
//			String tyDescriptions=schedules.getTyDescriptions()[i];
//			System.out.println("tyDescriptions :" + tyDescriptions);
//			String startStationName=schedules.getStartStationName()[i];
//			System.out.println("startStationName :" + startStationName);
//			String endStationName=schedules.getEndStationName()[i];
//			System.out.println("endStationName :" + endStationName);
//			
//		
//			Date arrivalTime=timeFormat.parse(arrivalTimes);
//			Date depatureTime=timeFormat.parse(depatureTimes);
//			Date arrivalAtDestinationTime=timeFormat.parse(arrivalAtDestinationTimes);
//			
//			TrainType trainType=getTrainTypeByName(tyDescriptions);
//			
//			TrainFrequency trainFrequency=TrainFrequency.DAILY;			
//			if(StringUtils.equals(fdDescriptions, MONDAY_TO_FRIDAY)){
//				trainFrequency=TrainFrequency.MONDAY_TO_FRIDAY;
//			}else if(StringUtils.equals(fdDescriptions, SUNDAYS_AND_HOLIDAYS)){
//				trainFrequency=TrainFrequency.SUNDAYS_AND_HOLIDAYS;
//			}else if(StringUtils.equals(fdDescriptions, SATURDAY_AND_SUNDAY)){
//				trainFrequency=TrainFrequency.SATURDAY_AND_SUNDAY;
//			}else if(StringUtils.equals(fdDescriptions, DAILY)){
//				trainFrequency=TrainFrequency.DAILY;
//			}
//			
//			TrainStation startStation=trainStationService.getTrainStationByName(startStationName);
//			TrainStation endStation=trainStationService.getTrainStationByName(endStationName);
//			boolean hasTrainScheduleCreated=false;
//			TrainSchedule trainSchedule=trainScheduleService.fetchTrainSchedule(trainName, 
//					trainFrequency,startStationName, endStationName, trainType.getTrainTypeName());
//			if(trainSchedule==null){
//				hasTrainScheduleCreated=true;
//				trainSchedule=new TrainSchedule();
//				trainSchedule.setActiveStatus(YesNoStatus.YES);
//				trainSchedule.setStartStation(startStation);
//				trainSchedule.setEndStation(endStation);
//				trainSchedule.setTrainFrequency(trainFrequency);
//				trainSchedule.setTrainName(trainName);
//				trainSchedule.setTrainNumber(trainName);
//				trainSchedule.setTrainType(trainType);
//			}
//			
//			
//			
//			TrainStationSchedule trainStationSchedule=trainStationScheduleService
//					.fetchTrainStationSchedule(trainSchedule.getTrainScheduleId(), fromStation.getTrainStationId(),
//							toStation.getTrainStationId(), arrivalTime, depatureTime);
//			
//			if(trainStationSchedule==null){
//				
//				trainStationSchedule=new TrainStationSchedule();
//				
//				trainStationSchedule.setActiveStatus(YesNoStatus.YES);
//				trainStationSchedule.setArrivalTime(arrivalTime);
//				trainStationSchedule.setDepartureTime(depatureTime);
//				trainStationSchedule.setTrainSchedule(trainSchedule);
//				
//				Rates rates = RailwayWebServiceV2.getRates(fromStation.getTrainStationCode(),toStation.getTrainStationCode());
//				
//				List<TicketPrice> ticketPrices=new ArrayList<TicketPrice>();
//				
//				int itr = 0;
//	            for(float price: rates.getPrices()){
//	            	TicketType ticketType=TicketType.FIRST_CLASS;
//	            	if(itr==0){
//	            		ticketType=TicketType.FIRST_CLASS;
//	            	}else if(itr==1){
//	            		ticketType=TicketType.SECOND_CLASS;
//	            	}else{
//	            		ticketType=TicketType.THIRD_CLASS;
//	            	}
//	            	++itr;
//	            	ticketPrices.add(new TicketPrice(trainStationSchedule, ticketType, price));
//	            }
//				trainStationSchedule.setTicketPrice(ticketPrices);
//				trainStationSchedule.setFromTrainStation(fromStation);
//				trainStationSchedule.setToTrainStation(toStation);
//				trainStationSchedule.setArrivalAtDestinationTime(arrivalAtDestinationTime);
//				
//				if(hasTrainScheduleCreated){
//					if((trainSchedule.getTrainStationSchedules()==null)){
//						trainSchedule.setTrainStationSchedules(new ArrayList<TrainStationSchedule>());
//					}
//					trainSchedule.getTrainStationSchedules().add(trainStationSchedule);
//					trainScheduleService.saveTrainSchedule(trainSchedule);
//				}else{
//					trainStationScheduleService.saveTrainStationSchedule(trainStationSchedule);
//				}
//				
//				
//				
//				
//			}
//			
//			
//			
//		}
//		
//	}
//
//	private TrainType getTrainTypeByName(String tyDescriptions) throws Exception {
//		TrainType trainType=null;
//		for (TrainType trainTypeItr : trainTypes) {
//			if(StringUtils.equalsIgnoreCase(tyDescriptions, trainTypeItr.getTrainTypeName())){
//				trainType=trainTypeItr;
//			}
//		}
//		if(trainType==null){
//			trainType=trainTypeService.getTrainTypeByName(tyDescriptions);
//			if(trainType==null){
//				trainType=new TrainType(tyDescriptions);
//				trainTypeService.saveTrainType(trainType);
//				trainTypes=trainTypeService.listAllTrainTypes(YesNoStatus.YES);
//			}
//		}
//		return trainType;
//	}

}
