/*    */ package lk.icta.slr.enquiry.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BusinessException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = -9046588951532319094L;
/*    */   
/*    */ 
/*    */   private transient String errorKey;
/*    */   
/*    */   private transient int errorCode;
/*    */   
/*    */ 
/*    */   public String getErrorKey()
/*    */   {
/* 18 */     return this.errorKey;
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 22 */     return this.errorCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BusinessException(String errorKey, Throwable cause)
/*    */   {
/* 34 */     super(errorKey, cause);
/* 35 */     this.errorKey = errorKey;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BusinessException(String errorKey)
/*    */   {
/* 45 */     super(errorKey);
/* 46 */     this.errorKey = errorKey;
/*    */   }
/*    */   
/*    */   public BusinessException(int errorCode) {
/* 50 */     this.errorCode = errorCode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BusinessException(Throwable cause)
/*    */   {
/* 60 */     super(cause);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\exception\BusinessException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */