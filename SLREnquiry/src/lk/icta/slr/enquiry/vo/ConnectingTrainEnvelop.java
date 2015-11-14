/*    */ package lk.icta.slr.enquiry.vo;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ConnectingTrainEnvelop
/*    */   extends BaseVO
/*    */ {
/*    */   private static final long serialVersionUID = 1084173976647748691L;
/*    */   ConnectingTrainRecordHeader header;
/* 11 */   List<ConnectingTrainInfoVO> connectingRouteList = new ArrayList();
/*    */   
/*    */   public ConnectingTrainRecordHeader getHeader() {
/* 14 */     return this.header;
/*    */   }
/*    */   
/*    */   public void setHeader(ConnectingTrainRecordHeader header) {
/* 18 */     this.header = header;
/*    */   }
/*    */   
/*    */   public List<ConnectingTrainInfoVO> getConnectingRouteList() {
/* 22 */     return this.connectingRouteList;
/*    */   }
/*    */   
/*    */   public void setConnectingRouteList(List<ConnectingTrainInfoVO> connectingRouteList)
/*    */   {
/* 27 */     this.connectingRouteList = connectingRouteList;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\vo\ConnectingTrainEnvelop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */