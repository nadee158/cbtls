package lk.icta.slr.enquiry.ws.output;

import java.util.ArrayList;
import java.util.List;

import lk.icta.slr.enquiry.vo.StationVO;

/*    */
/*    */
public class GetAllStationOutput
{
	public class Result {
		public Result(GetAllStationOutput paramGetAllStationOutput) {
		}

		/*    */
		/* 50 */ private List<StationVO> stationList = new ArrayList();

		/*    */
		public void setStationList(List<StationVO> stationList) {
			/* 53 */ this.stationList = stationList;
			}

		/*    */
		public List<StationVO> getStationList() {
			/* 57 */ return this.stationList;
			}
	}

	private String SUCCESS;
	/*    */
	private String MESSAGE;
	/*    */
	private String NOFRESULTS;
	/*    */
	private GetAllStationOutput.Result RESULTS;

	/*    */
	/*    */
	public String getSUCCESS()
	{
		/* 17 */ return this.SUCCESS;
		}

	/*    */
	public void setSUCCESS(String sUCCESS) {
		/* 21 */ this.SUCCESS = sUCCESS;
		}

	/*    */
	public String getMESSAGE() {
		/* 25 */ return this.MESSAGE;
		}

	/*    */
	public void setMESSAGE(String mESSAGE) {
		/* 29 */ this.MESSAGE = mESSAGE;
		}

	/*    */
	public String getNOFRESULTS() {
		/* 33 */ return this.NOFRESULTS;
		}

	/*    */
	public void setNOFRESULTS(String nOFRESULTS) {
		/* 37 */ this.NOFRESULTS = nOFRESULTS;
		}

	/*    */
	public void setRESULTS(GetAllStationOutput.Result rESULTS) {
		/* 41 */ this.RESULTS = rESULTS;
		}

	/*    */
	public GetAllStationOutput.Result getRESULTS() {
		/* 45 */ return this.RESULTS;
		}
	}

/*
 * Location:
 * C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\
 * enquiry\ws\output\GetAllStationOutput.class Java compiler version: 6 (50.0)
 * JD-Core Version: 0.7.1
 */