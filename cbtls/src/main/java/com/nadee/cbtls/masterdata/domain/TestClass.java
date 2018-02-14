package com.nadee.cbtls.masterdata.domain;

public class TestClass {
	private final static String NAMESPACE = "http://ws.wso2.org/dataservice";
	private final static String ENDPOINT = "http://103.11.35.13:9080/services/RailwayWebServiceV2Proxy.RailwayWebServiceV2ProxyHttpSoap12Endpoint";
		
	
//	public static void main(String[] args) {
//		try {
//			TrainLines lines=getLines();
//			for (int i = 0; i < lines.getCount(); i++) {
//				System.out.println(lines.getNames()[i]);
//				System.out.println(lines.getIds()[i]);
//			}
//			
//			TrainStations trainStations=getTrainStations(1);
//			for (int i = 0; i < trainStations.getCount(); i++) {
//				System.out.println(trainStations.getNames()[i]);
//				System.out.println(trainStations.getCodes()[i]);
//				System.out.println(trainStations.getCount());
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	
//	public static TrainLines getLines() throws Exception {
//		String methodName = "getLines";
//		String actionName = methodName;
//		SoapObject request = new SoapObject(NAMESPACE,methodName);
//		request.addProperty("lang", "en");
//		SoapObject results = callWebService(actionName, request);
//		
//		int length = results.getPropertyCount() + 1;			
//		TrainLines trainLines = new TrainLines();
//		trainLines.setCount(length);
//		trainLines.setIds(new int[length]);
//		trainLines.setNames(new String[length]);
//		
//		trainLines.getIds()[0] = 0;
//		trainLines.getNames()[0] = "All Stations";
//		
//		for(int i= 1; i < length; i++)
//		{
//			SoapObject result = (SoapObject) results.getProperty(i-1);			
//			trainLines.getIds()[i] = (Integer.parseInt(result.getProperty("id").toString()));
//			trainLines.getNames()[i] = String.valueOf(result.getProperty("LineName").toString());						
//		}		
//		
//		return trainLines;		
//	}
//	
//	
//	public static TrainStations getTrainStations(int lineId) throws Exception{		
//		String methodName;
//		if(lineId == 0){
//			methodName = "getAllStations";
//		}else{
//			methodName = "getStations";
//		}
//		String actionName = methodName;
//		SoapObject request = new SoapObject(NAMESPACE,methodName);
//		request.addProperty("line", String.valueOf(lineId));
//		request.addProperty("lang", "en");
//		
//		SoapObject results = callWebService(actionName, request);
//		
//		int length = results.getPropertyCount();				
//		TrainStations trainStations = new TrainStations();
//		trainStations.setCount(length);
//		trainStations.setCodes(new String[length]);
//		trainStations.setNames(new String[length]);
//		
//		
//		for(int i=0;  i < length; i++)
//		{
//			SoapObject result = (SoapObject) results.getProperty(i);
//			trainStations.getCodes()[i] = String.valueOf(result.getProperty("StationCode").toString());
//			trainStations.getNames()[i] = String.valueOf(result.getProperty("StationNameEng").toString());				
//		}		
//		
//		return trainStations;		
//	}
//	
//	private static SoapObject callWebService(String actionName, SoapObject request)
//			throws Exception {
//		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
//		envelope.setOutputSoapObject(request);
//		AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(ENDPOINT);
//		androidHttpTransport.call(actionName, envelope);
//		//Log.v("result", envelope.bodyOut.toString());
//		SoapObject results = (SoapObject) envelope.bodyIn;
//		return results;
//	}

}
