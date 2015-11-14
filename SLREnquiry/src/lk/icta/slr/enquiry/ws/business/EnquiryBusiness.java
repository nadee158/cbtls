/*     */ package lk.icta.slr.enquiry.ws.business;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;

/*     */ import org.apache.log4j.Logger;

/*     */ 
/*     */ import com.google.gson.Gson;

/*     */ import lk.icta.slr.enquiry.criteria.GetAllStationCriteria;
/*     */ import lk.icta.slr.enquiry.criteria.GetPriceCriteria;
/*     */ import lk.icta.slr.enquiry.criteria.SearchTrainCriteria;
/*     */ import lk.icta.slr.enquiry.exception.BusinessException;
/*     */ import lk.icta.slr.enquiry.util.CommonUtil;
/*     */ import lk.icta.slr.enquiry.vo.ConnectingTrainEnvelop;
/*     */ import lk.icta.slr.enquiry.vo.ConnectingTrainRecordHeader;
/*     */ import lk.icta.slr.enquiry.vo.PriceVO;
/*     */ import lk.icta.slr.enquiry.vo.SearchResultVO;
/*     */ import lk.icta.slr.enquiry.vo.StationVO;
/*     */ import lk.icta.slr.enquiry.ws.client.RestWSClient;
/*     */ import lk.icta.slr.enquiry.ws.output.GetAllStationOutput;
/*     */ import lk.icta.slr.enquiry.ws.output.GetPriceOutput;
/*     */ import lk.icta.slr.enquiry.ws.output.SearchTrainOutput;
/*     */ 
/*     */ public class EnquiryBusiness
/*     */ {
/*  31 */   private static final Logger LOGGER = Logger.getLogger(EnquiryBusiness.class);
/*  32 */   private static EnquiryBusiness instance = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized EnquiryBusiness getInstance()
/*     */   {
/*  46 */     if (instance == null) {
/*  47 */       instance = new EnquiryBusiness();
/*     */     }
/*  49 */     return instance;
/*     */   }
/*     */   
/*     */   public List<StationVO> getAllStation(GetAllStationCriteria criteria) throws BusinessException
/*     */   {
/*  54 */     if (LOGGER.isDebugEnabled()) {
/*  55 */       LOGGER.debug("ENTRY getAllStation with criteria: " + criteria);
/*     */     }
/*     */     
/*  58 */     if ((criteria == null) || (CommonUtil.checkBlank(criteria.getLang()))) {
/*  59 */       throw new IllegalArgumentException("Invalid criteria: " + criteria);
/*     */     }
/*     */     
/*  62 */     List<StationVO> allStationList = new ArrayList();
/*     */     
/*  64 */     String endPointURL = CommonUtil.getValueFromFile("ws", "rest.ws.endPointURL.getAllStation", new Object[] { criteria.getLang() });
/*  65 */     if (CommonUtil.checkBlank(endPointURL)) {
/*  66 */       throw new IllegalArgumentException("Invalid URL: " + endPointURL);
/*     */     }
/*     */     
/*  69 */     String jsonOutput = RestWSClient.getInstance().getJSONStringFromRestWebService(endPointURL);
/*  70 */     Gson gson = new Gson();
/*  71 */     GetAllStationOutput result = (GetAllStationOutput)gson.fromJson(jsonOutput, GetAllStationOutput.class);
/*  72 */     if ("true".equals(result.getSUCCESS())) {
/*  73 */       if (LOGGER.isDebugEnabled()) {
/*  74 */         LOGGER.debug("getAllStation successful with result size: " + result.getNOFRESULTS());
/*     */       }
/*  76 */       allStationList = result.getRESULTS().getStationList();
/*     */     } else {
/*  78 */       LOGGER.error("getAllStation failed with message: " + result.getMESSAGE());
/*  79 */       throw new BusinessException(result.getMESSAGE());
/*     */     }
/*     */     
/*  82 */     if (LOGGER.isDebugEnabled()) {
/*  83 */       LOGGER.debug("EXIT getAllStation with result size: " + allStationList.size());
/*     */     }
/*     */     
/*  86 */     return allStationList;
/*     */   }
/*     */   
/*     */   public List<PriceVO> getPrice(GetPriceCriteria criteria) throws BusinessException
/*     */   {
/*  91 */     if (LOGGER.isDebugEnabled()) {
/*  92 */       LOGGER.debug("ENTRY getPrice with criteria: " + criteria);
/*     */     }
/*     */     
/*  95 */     if ((criteria == null) || (CommonUtil.checkBlank(criteria.getStartStationID())) || (CommonUtil.checkBlank(criteria.getEndStationID())) || (CommonUtil.checkBlank(criteria.getLang())))
/*     */     {
/*     */ 
/*     */ 
/*  99 */       throw new IllegalArgumentException("Invalid criteria: " + criteria);
/*     */     }
/*     */     
/* 102 */     List<PriceVO> priceList = new ArrayList();
/*     */     
/* 104 */     Object[] inputParam = new Object[3];
/* 105 */     inputParam[0] = criteria.getStartStationID();
/* 106 */     inputParam[1] = criteria.getEndStationID();
/* 107 */     inputParam[2] = criteria.getLang();
/*     */     
/* 109 */     String endPointURL = CommonUtil.getValueFromFile("ws", "rest.ws.endPointURL.getPrice", inputParam);
/* 110 */     if (CommonUtil.checkBlank(endPointURL)) {
/* 111 */       throw new IllegalArgumentException("Invalid URL: " + endPointURL);
/*     */     }
/*     */     
/* 114 */     String jsonOutput = RestWSClient.getInstance().getJSONStringFromRestWebService(endPointURL);
/* 115 */     Gson gson = new Gson();
/* 116 */     GetPriceOutput result = (GetPriceOutput)gson.fromJson(jsonOutput, GetPriceOutput.class);
/* 117 */     if ("true".equals(result.getSUCCESS())) {
/* 118 */       if (LOGGER.isDebugEnabled()) {
/* 119 */         LOGGER.debug("getPrice successful with result size: " + result.getNOFRESULTS());
/*     */       }
/* 121 */       priceList = result.getRESULTS().getPriceList();
/*     */     } else {
/* 123 */       LOGGER.error("getPrice failed with message: " + result.getMESSAGE());
/* 124 */       throw new BusinessException(result.getMESSAGE());
/*     */     }
/*     */     
/* 127 */     if (LOGGER.isDebugEnabled()) {
/* 128 */       LOGGER.debug("EXIT getPrice with result: " + priceList);
/*     */     }
/*     */     
/* 131 */     return priceList;
/*     */   }
/*     */   
/*     */   public SearchResultVO searchTrain(SearchTrainCriteria criteria) throws BusinessException
/*     */   {
/* 136 */     if (LOGGER.isDebugEnabled()) {
/* 137 */       LOGGER.debug("ENTRY searchTrain with criteria: " + criteria);
/*     */     }
/*     */     
/* 140 */     if ((criteria == null) || (CommonUtil.checkBlank(criteria.getStartStationID())) || (CommonUtil.checkBlank(criteria.getEndStationID())) || (CommonUtil.checkBlank(criteria.getSearchDate())) || (CommonUtil.checkBlank(criteria.getStartTime())) || (CommonUtil.checkBlank(criteria.getEndTime())) || (CommonUtil.checkBlank(criteria.getLang())))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 147 */       throw new IllegalArgumentException("Invalid criteria: " + criteria);
/*     */     }
/*     */     
/*     */ 
/* 151 */     Object[] inputParam = new Object[6];
/* 152 */     inputParam[0] = criteria.getStartStationID();
/* 153 */     inputParam[1] = criteria.getEndStationID();
/* 154 */     inputParam[2] = criteria.getSearchDate();
/* 155 */     inputParam[3] = criteria.getStartTime();
/* 156 */     inputParam[4] = criteria.getEndTime();
/* 157 */     inputParam[5] = criteria.getLang();
/*     */     
/* 159 */     String endPointURL = CommonUtil.getValueFromFile("ws", "rest.ws.endPointURL.searchTrain", inputParam);
/* 160 */     if (CommonUtil.checkBlank(endPointURL)) {
/* 161 */       throw new IllegalArgumentException("Invalid URL: " + endPointURL);
/*     */     }
/*     */     
/* 164 */     String jsonOutput = RestWSClient.getInstance().getJSONStringFromRestWebService(endPointURL);
/* 165 */     Gson gson = new Gson();
/* 166 */     SearchTrainOutput searchTrainOutput = (SearchTrainOutput)gson.fromJson(jsonOutput, SearchTrainOutput.class);
/* 167 */     SearchResultVO result = new SearchResultVO();
/* 168 */     if ("true".equals(searchTrainOutput.getSUCCESS())) {
/* 169 */       if (LOGGER.isDebugEnabled()) {
/* 170 */         LOGGER.debug("searchTrain successful with result size: " + searchTrainOutput.getNOFRESULTS());
/*     */       }
/* 172 */       populateSearchResult(result, searchTrainOutput);
/*     */     } else {
/* 174 */       LOGGER.error("searchTrain failed with message: " + searchTrainOutput.getMESSAGE());
/* 175 */       throw new BusinessException(searchTrainOutput.getMESSAGE());
/*     */     }
/*     */     
/* 178 */     if (LOGGER.isDebugEnabled()) {
/* 179 */       LOGGER.debug("EXIT searchTrain with result: " + result);
/*     */     }
/*     */     
/* 182 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private void populateSearchResult(SearchResultVO result, SearchTrainOutput searchTrainOutput)
/*     */   {
/* 188 */     result.setQuery(searchTrainOutput.getQUERY());
/* 189 */     result.setNoOfResult(searchTrainOutput.getNOFRESULTS());
/* 190 */     result.setMessage(searchTrainOutput.getMESSAGE());
/* 191 */     result.setStatusCode(searchTrainOutput.getSTATUSCODE());
/*     */     
/* 193 */     if ((searchTrainOutput.getRESULTS() != null) && (searchTrainOutput.getRESULTS().getDirectTrains() != null) && (searchTrainOutput.getRESULTS().getDirectTrains().getTrainsList() != null) && (searchTrainOutput.getRESULTS().getDirectTrains().getTrainsList().length > 0))
/*     */     {
/*     */ 
/*     */ 
/* 197 */       result.setDirectTrainList(Arrays.asList(searchTrainOutput.getRESULTS().getDirectTrains().getTrainsList()));
/*     */     }
/*     */     
/* 200 */     if ((searchTrainOutput.getRESULTS() != null) && (searchTrainOutput.getRESULTS().getConnectingTrains() != null) && (searchTrainOutput.getRESULTS().getConnectingTrains().getTrainsList() != null) && (searchTrainOutput.getRESULTS().getConnectingTrains().getTrainsList().length > 0))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 205 */       List<ConnectingTrainEnvelop> connectingTrainEnvelopList = new ArrayList();
/*     */       
/* 207 */       for (SearchTrainOutput.ConnectingTrainHeaderAndRouteEnvelop entry : searchTrainOutput.getRESULTS().getConnectingTrains().getTrainsList()) {
/* 208 */         ConnectingTrainRecordHeader header = entry.getRecordHeader()[0];
/* 209 */         List<lk.icta.slr.enquiry.vo.ConnectingTrainInfoVO> connectingRouteList = Arrays.asList(entry.getConnectedTrains());
/*     */         
/* 211 */         ConnectingTrainEnvelop envelop = new ConnectingTrainEnvelop();
/* 212 */         envelop.setHeader(header);
/* 213 */         envelop.setConnectingRouteList(connectingRouteList);
/* 214 */         connectingTrainEnvelopList.add(envelop);
/*     */       }
/*     */       
/* 217 */       result.setConnectingTrainEnvelopList(connectingTrainEnvelopList);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws BusinessException
/*     */   {
/* 234 */     SearchTrainCriteria searchCriteria = new SearchTrainCriteria();
/* 235 */     searchCriteria.setStartStationID("168");
/* 236 */     searchCriteria.setEndStationID("12");
/* 237 */     searchCriteria.setSearchDate("2013-08-21");
/* 238 */     searchCriteria.setStartTime("00:00:00");
/* 239 */     searchCriteria.setEndTime("23:59:59");
/* 240 */     getInstance().searchTrain(searchCriteria);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\ws\business\EnquiryBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */