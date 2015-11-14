/*    */ package lk.icta.slr.enquiry.vo;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SearchResultVO
/*    */   extends BaseVO
/*    */ {
/*    */   private static final long serialVersionUID = -2174785100926349791L;
/*    */   private QueryVO query;
/*    */   private String noOfResult;
/*    */   private String message;
/* 13 */   private List<DirectTrainInfoVO> directTrainList = new ArrayList();
/* 14 */   private List<ConnectingTrainEnvelop> connectingTrainEnvelopList = new ArrayList();
/*    */   private String statusCode;
/*    */   
/*    */   public QueryVO getQuery() {
/* 18 */     return this.query;
/*    */   }
/*    */   
/*    */   public void setQuery(QueryVO query) {
/* 22 */     this.query = query;
/*    */   }
/*    */   
/*    */   public String getNoOfResult() {
/* 26 */     return this.noOfResult;
/*    */   }
/*    */   
/*    */   public void setNoOfResult(String noOfResult) {
/* 30 */     this.noOfResult = noOfResult;
/*    */   }
/*    */   
/*    */   public List<DirectTrainInfoVO> getDirectTrainList() {
/* 34 */     return this.directTrainList;
/*    */   }
/*    */   
/*    */   public void setDirectTrainList(List<DirectTrainInfoVO> directTrainList) {
/* 38 */     this.directTrainList = directTrainList;
/*    */   }
/*    */   
/*    */   public void setConnectingTrainEnvelopList(List<ConnectingTrainEnvelop> connectingTrainEnvelopList)
/*    */   {
/* 43 */     this.connectingTrainEnvelopList = connectingTrainEnvelopList;
/*    */   }
/*    */   
/*    */   public List<ConnectingTrainEnvelop> getConnectingTrainEnvelopList() {
/* 47 */     return this.connectingTrainEnvelopList;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 51 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 55 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setStatusCode(String statusCode) {
/* 59 */     this.statusCode = statusCode;
/*    */   }
/*    */   
/*    */   public String getStatusCode() {
/* 63 */     return this.statusCode;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\vo\SearchResultVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */