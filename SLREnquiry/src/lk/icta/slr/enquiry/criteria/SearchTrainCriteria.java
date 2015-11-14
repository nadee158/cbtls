/*    */ package lk.icta.slr.enquiry.criteria;
/*    */ 
/*    */ import lk.icta.slr.enquiry.vo.BaseVO;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SearchTrainCriteria
/*    */   extends BaseVO
/*    */ {
/*    */   private static final long serialVersionUID = 737360812419513490L;
/*    */   private String startStationID;
/*    */   private String endStationID;
/*    */   private String searchDate;
/*    */   private String startTime;
/*    */   private String endTime;
/* 16 */   private String lang = "en";
/*    */   
/*    */   public String getStartStationID() {
/* 19 */     return this.startStationID;
/*    */   }
/*    */   
/* 22 */   public void setStartStationID(String startStationID) { this.startStationID = startStationID; }
/*    */   
/*    */   public String getEndStationID() {
/* 25 */     return this.endStationID;
/*    */   }
/*    */   
/* 28 */   public void setEndStationID(String endStationID) { this.endStationID = endStationID; }
/*    */   
/*    */   public String getSearchDate() {
/* 31 */     return this.searchDate;
/*    */   }
/*    */   
/* 34 */   public void setSearchDate(String searchDate) { this.searchDate = searchDate; }
/*    */   
/*    */   public String getStartTime() {
/* 37 */     return this.startTime;
/*    */   }
/*    */   
/* 40 */   public void setStartTime(String startTime) { this.startTime = startTime; }
/*    */   
/*    */   public String getEndTime() {
/* 43 */     return this.endTime;
/*    */   }
/*    */   
/* 46 */   public void setEndTime(String endTime) { this.endTime = endTime; }
/*    */   
/*    */ 
/* 49 */   public String getLang() { return this.lang; }
/*    */   
/*    */   public void setLang(String lang) {
/* 52 */     if ((!"en".equals(lang)) && (!"si".equals(lang)) && (!"ta".equals(lang)))
/*    */     {
/*    */ 
/* 55 */       throw new IllegalArgumentException("Language not supported: " + lang);
/*    */     }
/*    */     
/* 58 */     this.lang = lang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\criteria\SearchTrainCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */