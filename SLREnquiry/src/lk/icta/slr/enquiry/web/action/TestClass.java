package lk.icta.slr.enquiry.web.action;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lk.icta.slr.enquiry.criteria.GetAllStationCriteria;
import lk.icta.slr.enquiry.criteria.GetPriceCriteria;
import lk.icta.slr.enquiry.criteria.SearchTrainCriteria;
import lk.icta.slr.enquiry.exception.BusinessException;
import lk.icta.slr.enquiry.util.DateUtil;
import lk.icta.slr.enquiry.vo.ClassVO;
import lk.icta.slr.enquiry.vo.ConnectingTrainEnvelop;
import lk.icta.slr.enquiry.vo.ConnectingTrainInfoVO;
import lk.icta.slr.enquiry.vo.DirectTrainInfoVO;
import lk.icta.slr.enquiry.vo.PriceVO;
import lk.icta.slr.enquiry.vo.SearchResultVO;
import lk.icta.slr.enquiry.vo.StationVO;
import lk.icta.slr.enquiry.ws.business.EnquiryBusiness;

public class TestClass {
	
	private static List<StationVO> allStations = new ArrayList();
	private static SearchTrainCriteria searchCriteria = new SearchTrainCriteria();
	private static SearchResultVO searchResult;
	private static final DateFormat DF_CALENDAR = new SimpleDateFormat("dd/MM/yyyy");
	private static List<PriceVO> priceList;
	private static String totalDistance;

	public static void main(String[] args) throws SQLException {
		loadStationList();
		generateCsvFile("C:/Users/Nadeeshani/Desktop/test_list_1.csv");
		//searchTrain();
		insertRecordIntoTable();

	}
	
	private static void insertRecordIntoTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO train_station "
				+ "(active_status,train_station_code,train_station_contact_number,train_station_name,train_station_reference_id,version_id) "
				+ "VALUES(1,?,?,?,0)";

		try {
			dbConnection = getDBConnection();
			
			for (StationVO stationVO : allStations) {
				preparedStatement = dbConnection.prepareStatement(insertTableSQL);
				preparedStatement.setString(1, stationVO.getStationCode());
				preparedStatement.setString(2, null);
				preparedStatement.setString(3, stationVO.getStationName());
				preparedStatement.setString(4, stationVO.getStationID());
				// execute insert SQL stetement
				preparedStatement.executeUpdate();
				System.out.println("Record is inserted into DBUSER table!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.commit();
				dbConnection.close();
			}
		}
	}
	
	private static Connection getDBConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mkyongcom","root", "root123");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}
	
	public static void loadStationList(){
		GetAllStationCriteria getAllStationCriteria = new GetAllStationCriteria();
		getAllStationCriteria.setLang("en");
		try {
			allStations = EnquiryBusiness.getInstance().getAllStation(getAllStationCriteria);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	 private static void generateCsvFile(String sFileName){
		try	{
		    FileWriter writer = new FileWriter(sFileName);
		    int i=1;
		    for (StationVO stationVO : allStations) {
		    	writer.append(Integer.toString(i));
			    writer.append(',');
		    	writer.append(stationVO.getStationID());
			    writer.append(',');
			    writer.append(stationVO.getStationCode().toUpperCase());
			    writer.append(',');
			    writer.append(stationVO.getStationName().toUpperCase());
			    writer.append('\n');
			    i++;
			}
		    //generate whatever data you want
		    writer.flush();
		    writer.close();
		}catch(IOException e){
		     e.printStackTrace();
		} 
    }
	 
	 
	 private static void searchTrain(){
		 searchCriteria.setLang("en");
		 searchCriteria.setStartTime("00:00:00");
		 searchCriteria.setEndTime("23:59:59");
		 List<Date> datesOfWeek=getDatesOfWeek();
		 for (Date date : datesOfWeek) {
			 searchCriteria.setSearchDate(DateUtil.getWebServiceDateString(date));
			 System.out.println("date.getDay()" + date.getDay());
			 for (StationVO startStationVO : allStations) {
				 searchCriteria.setStartStationID(startStationVO.getStationID());
				 for (StationVO endStationVO : allStations) {
					 searchCriteria.setEndStationID(endStationVO.getStationID());
					 try {
						   searchResult = EnquiryBusiness.getInstance().searchTrain(searchCriteria);
						   System.out.println("searchResult.getMessage() " + searchResult.getMessage());
						   System.out.println("searchResult.getNoOfResult() " + searchResult.getNoOfResult());
						   System.out.println("searchResult.getClass() " + searchResult.getClass());
					       if ((searchResult.getDirectTrainList().size() > 0) || (searchResult.getConnectingTrainEnvelopList().size() > 0)){
					         if(searchResult.getDirectTrainList().size() > 0){
					        	 generateDirectTrainCSVFile(searchResult.getDirectTrainList(),startStationVO,endStationVO,date);
					         }
					    	  
					         if(searchResult.getConnectingTrainEnvelopList().size() > 0){
					        	 generateConnectingTrainCSVFile(searchResult.getConnectingTrainEnvelopList(),startStationVO,endStationVO,date);
					         }
					    	   
					    	 GetPriceCriteria priceCriteria = new GetPriceCriteria();
					         priceCriteria.setStartStationID(searchCriteria.getStartStationID());
					         priceCriteria.setEndStationID(searchCriteria.getEndStationID());
					         priceCriteria.setLang(searchCriteria.getLang());
					         priceList = EnquiryBusiness.getInstance().getPrice(priceCriteria);
					         if ((priceList != null) && (!priceList.isEmpty())) {
					           totalDistance = (((PriceVO)priceList.get(0)).getDistanceKM() + " km");
					           generatePriceListCsv(priceList,startStationVO,endStationVO,date);
					         }
					       }
						
					 } catch (BusinessException e) {
						e.printStackTrace();
					 } 
				 }
			 }
		}
	 }
	 

	private static void generatePriceListCsv(List<PriceVO> priceList2, StationVO startStationVO, StationVO endStationVO,
			Date date) {
		try	{
			Calendar cal=Calendar.getInstance();
			cal.setTime(date);
			FileWriter writer = new FileWriter("C:/Users/Nadeeshani/Desktop/price_list.csv",true);
		    int i=1;
		    for (PriceVO priceVO : priceList2) {
		    	writer.append(Integer.toString(i));
			    writer.append(',');
		    	writer.append(Integer.toString(cal.get(Calendar.DAY_OF_WEEK)));
		    	writer.append(',');
		    	writer.append(startStationVO.getStationID());
		    	writer.append(',');
		    	writer.append(endStationVO.getStationID());
		    	writer.append(',');
		    	writer.append(priceVO.getClassName());
		    	writer.append(',');
		    	writer.append(priceVO.getDistanceKM());
		    	writer.append(',');
		    	writer.append(priceVO.getPriceLKR());
			    writer.append('\n');
			    i++;
			}
		    //generate whatever data you want
		    writer.flush();
		    writer.close();
		}catch(IOException e){
		     e.printStackTrace();
		} 
		
	}

	private static void generateConnectingTrainCSVFile(List<ConnectingTrainEnvelop> connectingTrainEnvelopList,	StationVO startStationVO, StationVO endStationVO, Date date) {
		try	{
			Calendar cal=Calendar.getInstance();
			cal.setTime(date);
			
		    FileWriter writer = new FileWriter("C:/Users/Nadeeshani/Desktop/connected_train_list.csv",true);
		    int i=1;
		    
		    for (ConnectingTrainEnvelop connectingTrainEnvelop : connectingTrainEnvelopList) {
		    	System.out.println("connectingTrainEnvelop.getHeader() :" + connectingTrainEnvelop.getHeader());
		    	List<ConnectingTrainInfoVO> connectingRouteList=connectingTrainEnvelop.getConnectingRouteList();
		    	if(!(connectingRouteList==null || connectingRouteList.isEmpty())){
		    		for (ConnectingTrainInfoVO connectingTrainInfoVO : connectingRouteList) {
		    			writer.append(Integer.toString(i));
					    writer.append(',');
				    	writer.append(Integer.toString(cal.get(Calendar.DAY_OF_WEEK)));
				    	writer.append(',');
				    	writer.append(startStationVO.getStationID());
				    	writer.append(',');
				    	writer.append(endStationVO.getStationID());
				    	writer.append(',');
					    writer.append(connectingTrainInfoVO.getRecID());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getTrainNo());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getTrainName());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getSelected());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getIsTransit());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getStartStation());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getStartTime());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getEndStation());
					    writer.append(',');
					    writer.append(connectingTrainInfoVO.getEndTime());
					    writer.append('\n');
					    
					    List<ClassVO> classList=connectingTrainInfoVO.getClassList();
					    if(!(classList==null)){
					    	generateClassListFileConnectedTrains(classList,i);
					    }
					    
					    i++;
					}
		    	}
			}
		    //generate whatever data you want
		    writer.flush();
		    writer.close();
		}catch(IOException e){
		     e.printStackTrace();
		} 
		
	}

	private static void generateClassListFileConnectedTrains(List<ClassVO> classList, int connectedTrainId) {
		try	{
			FileWriter writer = new FileWriter("C:/Users/Nadeeshani/Desktop/train_class_list.csv",true);
		    int i=1;
		    for (ClassVO classVO : classList) {
		    	writer.append(Integer.toString(i));
			    writer.append(',');
			    writer.append(Integer.toString(connectedTrainId));
			    writer.append(',');
		    	writer.append(classVO.getClassID());
			    writer.append(',');
			    writer.append(classVO.getClassName());
			    writer.append('\n');
			    i++;
			}
		    //generate whatever data you want
		    writer.flush();
		    writer.close();
		}catch(IOException e){
		     e.printStackTrace();
		} 
		
	}

	private static void generateDirectTrainCSVFile(List<DirectTrainInfoVO> directTrainList, StationVO startStationVO,
			StationVO endStationVO, Date date) {
		try	{
			Calendar cal=Calendar.getInstance();
			cal.setTime(date);
			
		    FileWriter writer = new FileWriter("C:/Users/Nadeeshani/Desktop/direct_train_list.csv",true);
		    int i=1;
		    
		    for (DirectTrainInfoVO directTrainInfoVO : directTrainList) {
		    	writer.append(Integer.toString(i));
			    writer.append(',');
		    	writer.append(Integer.toString(cal.get(Calendar.DAY_OF_WEEK)));
		    	writer.append(',');
		    	writer.append(startStationVO.getStationID());
		    	writer.append(',');
		    	writer.append(endStationVO.getStationID());
		    	writer.append(',');
			    writer.append(directTrainInfoVO.getTrainID());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getTrainNo());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getTrainName());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getTrainType());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getTrainFrequncy());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getStartStationName());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getArrivalTime());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getDepatureTime());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getEndStationName());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getArrivalTimeEndStation());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getDepatureTime());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getFinalStationName());
			    writer.append(',');
			    writer.append(directTrainInfoVO.getArrivalTimeFinalStation());
			    writer.append('\n');
			    
			    List<ClassVO> classList=directTrainInfoVO.getClassList();
			    if(!(classList==null)){
			    	generateClassListFile(classList,i);
			    }
			    
			    i++;
			}
		    //generate whatever data you want
		    writer.flush();
		    writer.close();
		}catch(IOException e){
		     e.printStackTrace();
		} 
		
	}

	private static void generateClassListFile(List<ClassVO> classList, int trainId) {
		try	{
			FileWriter writer = new FileWriter("C:/Users/Nadeeshani/Desktop/train_class_list.csv",true);
		    int i=1;
		    for (ClassVO classVO : classList) {
		    	writer.append(Integer.toString(i));
			    writer.append(',');
			    writer.append(Integer.toString(trainId));
			    writer.append(',');
		    	writer.append(classVO.getClassID());
			    writer.append(',');
			    writer.append(classVO.getClassName());
			    writer.append('\n');
			    i++;
			}
		    //generate whatever data you want
		    writer.flush();
		    writer.close();
		}catch(IOException e){
		     e.printStackTrace();
		} 
		
	}

	private static List<Date> getDatesOfWeek() {
		List<Date> dates=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for (int i = 1; i <=7; i++) {
			cal.set(Calendar.DAY_OF_WEEK, i);
			dates.add(cal.getTime());
		}
		return dates;
	}

}
