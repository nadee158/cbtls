 package lk.icta.slr.enquiry.ws.output;

import lk.icta.slr.enquiry.vo.ConnectingTrainInfoVO;
import lk.icta.slr.enquiry.vo.ConnectingTrainRecordHeader;
import lk.icta.slr.enquiry.vo.DirectTrainInfoVO;

 import lk.icta.slr.enquiry.vo.QueryVO;




 public class SearchTrainOutput {

	public class ConnectingTrainHeaderAndRouteEnvelop {
		private ConnectingTrainRecordHeader[] recordHeader;
		private ConnectingTrainInfoVO[] connectedTrains;

		public ConnectingTrainHeaderAndRouteEnvelop(SearchTrainOutput paramSearchTrainOutput) {
		}

		public void setRecordHeader(ConnectingTrainRecordHeader[] recordHeader) {
			/* 116 */ this.recordHeader = recordHeader;
		}

		public ConnectingTrainRecordHeader[] getRecordHeader() {
			/* 120 */ return this.recordHeader;
		}

		public void setConnectedTrains(ConnectingTrainInfoVO[] connectedTrains) {
			/* 124 */ this.connectedTrains = connectedTrains;
		}

		public ConnectingTrainInfoVO[] getConnectedTrains() {
			/* 128 */ return this.connectedTrains;
		}
	}

	public class ConnectingTrain {
		private SearchTrainOutput.ConnectingTrainHeaderAndRouteEnvelop[] trainsList;

		public ConnectingTrain(SearchTrainOutput paramSearchTrainOutput) {
		}

		public void setTrainsList(SearchTrainOutput.ConnectingTrainHeaderAndRouteEnvelop[] trainsList) {
			/* 103 */ this.trainsList = trainsList;
		}

		public SearchTrainOutput.ConnectingTrainHeaderAndRouteEnvelop[] getTrainsList() {
			/* 107 */ return this.trainsList;
		}
	}

	public class DirectTrain {
		private DirectTrainInfoVO[] trainsList;

		public DirectTrain(SearchTrainOutput paramSearchTrainOutput) {
		}

		public void setTrainsList(DirectTrainInfoVO[] trainsList) {
			/* 91 */ this.trainsList = trainsList;
		}

		public DirectTrainInfoVO[] getTrainsList() {
			/* 95 */ return this.trainsList;
		}
	}

	public class Result {
		private SearchTrainOutput.DirectTrain directTrains;

		private SearchTrainOutput.ConnectingTrain connectingTrains;

		public Result(SearchTrainOutput paramSearchTrainOutput) {
		}

		public void setDirectTrains(SearchTrainOutput.DirectTrain directTrains) {
			/* 71 */ this.directTrains = directTrains;
		}

		public SearchTrainOutput.DirectTrain getDirectTrains() {
			/* 75 */ return this.directTrains;
		}

		public void setConnectingTrains(SearchTrainOutput.ConnectingTrain connectingTrains) {
			/* 79 */ this.connectingTrains = connectingTrains;
		}

		public SearchTrainOutput.ConnectingTrain getConnectingTrains() {
			/* 83 */ return this.connectingTrains;
		}
	}

	 private String SUCCESS;
	 private String MESSAGE;
	 private QueryVO QUERY;
	 private String NOFRESULTS;
	 private SearchTrainOutput.Result RESULTS;
	 private String STATUSCODE;

	
	 public String getSUCCESS()
	 {
		/* 18 */ return this.SUCCESS;
		 }

	
	 public void setSUCCESS(String sUCCESS) {
		/* 22 */ this.SUCCESS = sUCCESS;
		 }

	
	 public String getMESSAGE() {
		/* 26 */ return this.MESSAGE;
		 }

	
	 public void setMESSAGE(String mESSAGE) {
		/* 30 */ this.MESSAGE = mESSAGE;
		 }

	
	 public String getNOFRESULTS() {
		/* 34 */ return this.NOFRESULTS;
		 }

	
	 public void setNOFRESULTS(String nOFRESULTS) {
		/* 38 */ this.NOFRESULTS = nOFRESULTS;
		 }

	
	 public SearchTrainOutput.Result getRESULTS() {
		/* 42 */ return this.RESULTS;
		 }

	
	 public void setRESULTS(SearchTrainOutput.Result rESULTS) {
		/* 46 */ this.RESULTS = rESULTS;
		 }

	
	 public void setQUERY(QueryVO qUERY) {
		/* 50 */ this.QUERY = qUERY;
		 }

	
	 public QueryVO getQUERY() {
		/* 54 */ return this.QUERY;
		 }

	
	 public void setSTATUSCODE(String sTATUSCODE) {
		/* 58 */ this.STATUSCODE = sTATUSCODE;
		 }

	
	 public String getSTATUSCODE() {
		/* 62 */ return this.STATUSCODE;
		 }
	 }

/*
 * Location:
 * C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\
 * enquiry\ws\output\SearchTrainOutput.class Java compiler version: 6 (50.0)
 * JD-Core Version: 0.7.1
 */