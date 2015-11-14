 package lk.icta.slr.enquiry.web.action;
 
 import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import lk.icta.slr.enquiry.criteria.GetAllStationCriteria;
import lk.icta.slr.enquiry.criteria.GetPriceCriteria;
import lk.icta.slr.enquiry.criteria.SearchTrainCriteria;
import lk.icta.slr.enquiry.exception.BusinessException;
import lk.icta.slr.enquiry.util.CommonUtil;
import lk.icta.slr.enquiry.util.DateUtil;
import lk.icta.slr.enquiry.vo.PriceVO;
import lk.icta.slr.enquiry.vo.SearchResultVO;
import lk.icta.slr.enquiry.vo.StationVO;
import lk.icta.slr.enquiry.ws.business.EnquiryBusiness;
 
 
 
 
 public class SLREnquiryAction
   extends ActionSupport
   implements ServletRequestAware, SessionAware
 {
   private static final long serialVersionUID = 980997491590968316L;
/*  34 */   private static final Logger LOGGER = Logger.getLogger(SLREnquiryAction.class);
   
   private HttpServletRequest request;
   
   private Map<String, Object> session;
/*  39 */   private List<StationVO> allStations = new ArrayList();
/*  40 */   private static List<String> allTimePickerList = new ArrayList();
   private List<String> startTimePickerList;
   private List<String> endTimePickerList;
/*  43 */   private SearchTrainCriteria searchCriteria = new SearchTrainCriteria();
   
   private String searchDate;
   private SearchResultVO searchResult;
   private List<PriceVO> priceList;
   private String totalDistance;
/*  49 */   private String selectedLocale = "en";
/*  50 */   private Boolean isCountryPortalTheme = Boolean.valueOf(false);
   
   static {
/*  53 */     allTimePickerList.add("00:00:00");
/*  54 */     allTimePickerList.add("00:30:00");
/*  55 */     allTimePickerList.add("01:00:00");
/*  56 */     allTimePickerList.add("01:30:00");
/*  57 */     allTimePickerList.add("02:00:00");
/*  58 */     allTimePickerList.add("02:30:00");
/*  59 */     allTimePickerList.add("03:00:00");
/*  60 */     allTimePickerList.add("03:30:00");
/*  61 */     allTimePickerList.add("04:00:00");
/*  62 */     allTimePickerList.add("04:30:00");
/*  63 */     allTimePickerList.add("05:00:00");
/*  64 */     allTimePickerList.add("05:30:00");
/*  65 */     allTimePickerList.add("06:00:00");
/*  66 */     allTimePickerList.add("06:30:00");
/*  67 */     allTimePickerList.add("07:00:00");
/*  68 */     allTimePickerList.add("07:30:00");
/*  69 */     allTimePickerList.add("08:00:00");
/*  70 */     allTimePickerList.add("08:30:00");
/*  71 */     allTimePickerList.add("09:00:00");
/*  72 */     allTimePickerList.add("09:30:00");
/*  73 */     allTimePickerList.add("10:00:00");
/*  74 */     allTimePickerList.add("10:30:00");
/*  75 */     allTimePickerList.add("11:00:00");
/*  76 */     allTimePickerList.add("11:30:00");
/*  77 */     allTimePickerList.add("12:00:00");
/*  78 */     allTimePickerList.add("12:30:00");
/*  79 */     allTimePickerList.add("13:00:00");
/*  80 */     allTimePickerList.add("13:30:00");
/*  81 */     allTimePickerList.add("14:00:00");
/*  82 */     allTimePickerList.add("14:30:00");
/*  83 */     allTimePickerList.add("15:00:00");
/*  84 */     allTimePickerList.add("15:30:00");
/*  85 */     allTimePickerList.add("16:00:00");
/*  86 */     allTimePickerList.add("16:30:00");
/*  87 */     allTimePickerList.add("17:00:00");
/*  88 */     allTimePickerList.add("17:30:00");
/*  89 */     allTimePickerList.add("18:00:00");
/*  90 */     allTimePickerList.add("18:30:00");
/*  91 */     allTimePickerList.add("19:00:00");
/*  92 */     allTimePickerList.add("19:30:00");
/*  93 */     allTimePickerList.add("20:00:00");
/*  94 */     allTimePickerList.add("20:30:00");
/*  95 */     allTimePickerList.add("21:00:00");
/*  96 */     allTimePickerList.add("21:30:00");
/*  97 */     allTimePickerList.add("22:00:00");
/*  98 */     allTimePickerList.add("22:30:00");
/*  99 */     allTimePickerList.add("23:00:00");
/* 100 */     allTimePickerList.add("23:30:00");
/* 101 */     allTimePickerList.add("23:59:59");
   }
   
   public String homeAction() {
     try {
/* 106 */       populateHomePageAttributes();
				
/* 107 */       return "success";
     } catch (BusinessException e) {
/* 109 */       LOGGER.error("BusinessException occured in homeAction", e);
/* 110 */       return "error";
     } catch (Exception e) {
/* 112 */       LOGGER.error("Exception occured in homeAction", e); }
/* 113 */     return "error";
   }
   
   private void populateHomePageAttributes() throws BusinessException
   {
/* 118 */     this.selectedLocale = this.request.getParameter("lang");
/* 119 */     this.isCountryPortalTheme = checkIfCountryPortalTheme();
     
/* 121 */     String language = getLanguageFromLocale(this.selectedLocale);
/* 122 */     GetAllStationCriteria getAllStationCriteria = new GetAllStationCriteria();
/* 123 */     getAllStationCriteria.setLang(language);
/* 124 */     this.allStations = EnquiryBusiness.getInstance().getAllStation(getAllStationCriteria);
     

/* 126 */     this.startTimePickerList = new ArrayList(allTimePickerList);
/* 127 */     this.startTimePickerList.remove("23:59:59");
     
/* 129 */     this.endTimePickerList = new ArrayList(allTimePickerList);
/* 130 */     this.endTimePickerList.remove("00:00:00");
   }
   
   public String searchTrain()
   {
     try {
/* 136 */       if ((this.searchCriteria == null) || (CommonUtil.checkBlank(this.searchCriteria.getStartStationID())) || (CommonUtil.checkBlank(this.searchCriteria.getEndStationID())))
       {
 
 
/* 140 */         populateHomePageAttributes();
/* 141 */         return "input";
       }
       
/* 144 */       this.selectedLocale = this.request.getParameter("lang");
/* 145 */       this.isCountryPortalTheme = checkIfCountryPortalTheme();
       
/* 147 */       String language = getLanguageFromLocale(this.selectedLocale);
       
/* 149 */       if ((CommonUtil.checkBlank(this.searchCriteria.getStartTime())) || ("-1".equals(this.searchCriteria.getStartTime())))
       {
/* 151 */         this.searchCriteria.setStartTime("00:00:00");
       }
       
/* 154 */       if ((CommonUtil.checkBlank(this.searchCriteria.getEndTime())) || ("-1".equals(this.searchCriteria.getEndTime())))
       {
/* 156 */         this.searchCriteria.setEndTime("23:59:59");
       }
       Date date;
/* 160 */       if (CommonUtil.checkBlank(this.searchDate))
       {
/* 162 */         date = new Date();
       } else {
/* 164 */         date = DateUtil.convertCalendarDateStrToDateObj(this.searchDate);
       }
/* 166 */       this.searchCriteria.setSearchDate(DateUtil.getWebServiceDateString(date));
/* 167 */       this.searchCriteria.setLang(language);
/* 168 */       this.searchResult = EnquiryBusiness.getInstance().searchTrain(this.searchCriteria);
       
/* 170 */       if ((this.searchResult != null) && (this.searchResult.getQuery() != null) && (this.searchResult.getQuery().getSearchDate() != null))
       {
 
/* 173 */         this.searchResult.getQuery().setSearchDate(DateUtil.getCalendarDateString(DateUtil.convertWebServiceDateStrToDateObj(this.searchResult.getQuery().getSearchDate())));
         
 
 
 
/* 178 */         populateResultMessage();
       }
       
 
/* 182 */       if ((this.searchResult.getDirectTrainList().size() > 0) || (this.searchResult.getConnectingTrainEnvelopList().size() > 0))
       {
 
/* 185 */         GetPriceCriteria priceCriteria = new GetPriceCriteria();
/* 186 */         priceCriteria.setStartStationID(this.searchCriteria.getStartStationID());
/* 187 */         priceCriteria.setEndStationID(this.searchCriteria.getEndStationID());
/* 188 */         priceCriteria.setLang(this.searchCriteria.getLang());
         
/* 190 */         this.priceList = EnquiryBusiness.getInstance().getPrice(priceCriteria);
         
/* 192 */         if ((this.priceList != null) && (!this.priceList.isEmpty())) {
/* 193 */           this.totalDistance = (((PriceVO)this.priceList.get(0)).getDistanceKM() + " km");
         }
       }
       
/* 197 */       return "success";
     } catch (ParseException e) {
/* 199 */       LOGGER.error("ParseException occured in searchTrain", e);
/* 200 */       return "error";
     } catch (BusinessException e) {
/* 202 */       LOGGER.error("BusinessException occured in searchTrain", e);
/* 203 */       return "error";
     } catch (Exception e) {
/* 205 */       LOGGER.error("Exception occured in searchTrain", e); }
/* 206 */     return "error";
   }
   
   
  
   
   private void populateResultMessage()
   {
/* 211 */     if ("2000".equals(this.searchResult.getStatusCode()))
     {
/* 213 */       this.searchResult.setMessage(getText("enquiry.message.resultFound", Collections.singletonList(this.searchResult.getNoOfResult())));
     }
/* 215 */     else if ("2001".equals(this.searchResult.getStatusCode()))
     {
/* 217 */       this.searchResult.setMessage(getText("enquiry.message.noResultFound"));
     }
   }
   
   private String getLanguageFromLocale(String locale) {
/* 222 */     if (CommonUtil.checkBlank(locale)) {
/* 223 */       locale = "en";
     }
/* 225 */     return locale;
   }
   
   private Boolean checkIfCountryPortalTheme()
   {
/* 230 */     boolean isCountryPortal = false;
     
 
/* 233 */     String theme = (String)this.session.get("selectedTheme");
/* 234 */     if (CommonUtil.checkBlank(theme)) {
/* 235 */       isCountryPortal = "countryportal".equals(this.request.getParameter("selectedTheme"));
/* 236 */       this.session.put("selectedTheme", this.request.getParameter("selectedTheme"));
     }
     else {
/* 239 */       isCountryPortal = "countryportal".equals(theme);
     }
     
/* 242 */     return Boolean.valueOf(isCountryPortal);
   }
   
   public void setServletRequest(HttpServletRequest request)
   {
/* 247 */     this.request = request;
   }
   
   public void setAllStations(List<StationVO> allStations) {
/* 251 */     this.allStations = allStations;
   }
   
   public List<StationVO> getAllStations() {
/* 255 */     return this.allStations;
   }
   
   public void setSearchCriteria(SearchTrainCriteria searchCriteria) {
/* 259 */     this.searchCriteria = searchCriteria;
   }
   
   public SearchTrainCriteria getSearchCriteria() {
/* 263 */     return this.searchCriteria;
   }
   
   public void setSearchDate(String searchDate) {
/* 267 */     this.searchDate = searchDate;
   }
   
   public String getSearchDate() {
/* 271 */     return this.searchDate;
   }
   
   public void setStartTimePickerList(List<String> startTimePickerList) {
/* 275 */     this.startTimePickerList = startTimePickerList;
   }
   
   public List<String> getStartTimePickerList() {
/* 279 */     return this.startTimePickerList;
   }
   
   public void setEndTimePickerList(List<String> endTimePickerList) {
/* 283 */     this.endTimePickerList = endTimePickerList;
   }
   
   public List<String> getEndTimePickerList() {
/* 287 */     return this.endTimePickerList;
   }
   
   public void setSearchResult(SearchResultVO searchResult) {
/* 291 */     this.searchResult = searchResult;
   }
   
   public SearchResultVO getSearchResult() {
/* 295 */     return this.searchResult;
   }
   
   public void setPriceList(List<PriceVO> priceList) {
/* 299 */     this.priceList = priceList;
   }
   
   public List<PriceVO> getPriceList() {
/* 303 */     return this.priceList;
   }
   
   public void setSelectedLocale(String selectedLocale) {
/* 307 */     this.selectedLocale = selectedLocale;
   }
   
   public String getSelectedLocale() {
/* 311 */     return this.selectedLocale;
   }
   
   public void setTotalDistance(String totalDistance) {
/* 315 */     this.totalDistance = totalDistance;
   }
   
   public String getTotalDistance() {
/* 319 */     return this.totalDistance;
   }
   
 
   public void setIsCountryPortalTheme(Boolean isCountryPortalTheme)
   {
/* 325 */     this.isCountryPortalTheme = isCountryPortalTheme;
   }
   
 
   public Boolean getIsCountryPortalTheme()
   {
/* 331 */     return this.isCountryPortalTheme;
   }
   
 
 
   public void setSession(Map<String, Object> session)
   {
/* 338 */     this.session = session;
   }
 }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\web\action\SLREnquiryAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */