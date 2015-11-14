/*    */ package lk.icta.slr.enquiry.criteria;
/*    */ 
/*    */ import lk.icta.slr.enquiry.vo.BaseVO;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetAllStationCriteria
/*    */   extends BaseVO
/*    */ {
/*    */   private static final long serialVersionUID = -4303749205181825441L;
/* 11 */   private String lang = "en";
/*    */   
/*    */   public void setLang(String lang) {
/* 14 */     if ((!"en".equals(lang)) && (!"si".equals(lang)) && (!"ta".equals(lang)))
/*    */     {
/*    */ 
/* 17 */       throw new IllegalArgumentException("Language not supported: " + lang);
/*    */     }
/* 19 */     this.lang = lang;
/*    */   }
/*    */   
/*    */   public String getLang() {
/* 23 */     return this.lang;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\criteria\GetAllStationCriteria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */