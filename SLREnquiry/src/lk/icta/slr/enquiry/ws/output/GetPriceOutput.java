package lk.icta.slr.enquiry.ws.output;

import java.util.ArrayList;
import java.util.List;

import lk.icta.slr.enquiry.vo.PriceVO;

public class GetPriceOutput {
	public class Result {
		public Result(GetPriceOutput paramGetPriceOutput) {
		}

		/* 50 */ private List<PriceVO> priceList = new ArrayList();

		public void setPriceList(List<PriceVO> priceList) {
			/* 53 */ this.priceList = priceList;
		}

		public List<PriceVO> getPriceList() {
			/* 57 */ return this.priceList;
		}
	}

	private String SUCCESS;

	private String MESSAGE;

	private String NOFRESULTS;

	private GetPriceOutput.Result RESULTS;

	public String getSUCCESS() {
		/* 17 */ return this.SUCCESS;
	}

	public void setSUCCESS(String sUCCESS) {
		/* 21 */ this.SUCCESS = sUCCESS;
	}

	public String getMESSAGE() {
		/* 25 */ return this.MESSAGE;
	}

	public void setMESSAGE(String mESSAGE) {
		/* 29 */ this.MESSAGE = mESSAGE;
	}

	public String getNOFRESULTS() {
		/* 33 */ return this.NOFRESULTS;
	}

	public void setNOFRESULTS(String nOFRESULTS) {
		/* 37 */ this.NOFRESULTS = nOFRESULTS;
	}

	public void setRESULTS(GetPriceOutput.Result rESULTS) {
		/* 41 */ this.RESULTS = rESULTS;
	}

	public GetPriceOutput.Result getRESULTS() {
		/* 45 */ return this.RESULTS;
	}
}

/*
 * Location:
 * C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\
 * enquiry\ws\output\GetPriceOutput.class Java compiler version: 6 (50.0)
 * JD-Core Version: 0.7.1
 */