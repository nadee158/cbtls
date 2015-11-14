/*    */ package lk.icta.slr.enquiry.criteria;
/*    */ 
/*    */ import lk.icta.slr.enquiry.vo.BaseVO;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetPriceCriteria
/*    */   extends BaseVO
/*    */ {
/*    */   private static final long serialVersionUID = -948099753869528122L;
/*    */   private String startStationID;
/*    */   private String endStationID;
/* 13 */   private String lang = "en";
/*    */   
/*    */   public void setStartStationID(String startStationID) {
/* 16 */     this.startStationID = startStationID;
/*    */   }
/*    */   
/*    */   public String getStartStationID() {
/* 20 */     return this.startStationID;
/*    */   }
/*    */   
/*    */   public void setEndStationID(String endStationID) {
/* 24 */     this.endStationID = endStationID;
/*    */   }
/*    */   
/*    */   public String getEndStationID() {
/* 28 */     return this.endStationID;
/*    */   }
/*    */   
/*    */   public void setLang(String lang) {
/* 32 */     if ((!"en".equals(lang)) && (!"si".equals(lang)) && (!"ta".equals(lang)))
/*    */     {
/*    */ 
/* 35 */       throw new IllegalArgumentException("Language not supported: " + lang);
/*    */     }
/* 37 */     this.lang = lang;
/*    */   }
/*    */   
/*    */   public String getLang() {
/* 41 */     return this.lang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\criteria\GetPriceCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */