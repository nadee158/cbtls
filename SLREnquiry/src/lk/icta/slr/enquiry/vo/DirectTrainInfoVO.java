/*     */ package lk.icta.slr.enquiry.vo;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DirectTrainInfoVO
/*     */   extends BaseVO
/*     */ {
/*     */   private static final long serialVersionUID = 847590774807232290L;
/*     */   private String trainID;
/*     */   private String trainName;
/*     */   private String trainNo;
/*     */   private String trainType;
/*     */   private String trainFrequncy;
/*     */   private String startStationName;
/*     */   private String arrivalTime;
/*     */   private String depatureTime;
/*     */   private String endStationName;
/*     */   private String arrivalTimeEndStation;
/*     */   private String finalStationName;
/*     */   private String arrivalTimeFinalStation;
/*  26 */   private List<ClassVO> classList = new ArrayList();
/*     */   
/*     */   public String getTrainID() {
/*  29 */     return this.trainID;
/*     */   }
/*     */   
/*     */   public void setTrainID(String trainID) {
/*  33 */     this.trainID = trainID;
/*     */   }
/*     */   
/*     */   public String getTrainName() {
/*  37 */     return this.trainName;
/*     */   }
/*     */   
/*     */   public void setTrainName(String trainName) {
/*  41 */     this.trainName = trainName;
/*     */   }
/*     */   
/*     */   public String getTrainNo() {
/*  45 */     return this.trainNo;
/*     */   }
/*     */   
/*     */   public void setTrainNo(String trainNo) {
/*  49 */     this.trainNo = trainNo;
/*     */   }
/*     */   
/*     */   public String getTrainType() {
/*  53 */     return this.trainType;
/*     */   }
/*     */   
/*     */   public void setTrainType(String trainType) {
/*  57 */     this.trainType = trainType;
/*     */   }
/*     */   
/*     */   public String getTrainFrequncy() {
/*  61 */     return this.trainFrequncy;
/*     */   }
/*     */   
/*     */   public void setTrainFrequncy(String trainFrequncy) {
/*  65 */     this.trainFrequncy = trainFrequncy;
/*     */   }
/*     */   
/*     */   public String getStartStationName() {
/*  69 */     return this.startStationName;
/*     */   }
/*     */   
/*     */   public void setStartStationName(String startStationName) {
/*  73 */     this.startStationName = startStationName;
/*     */   }
/*     */   
/*     */   public String getArrivalTime() {
/*  77 */     return this.arrivalTime;
/*     */   }
/*     */   
/*     */   public void setArrivalTime(String arrivalTime) {
/*  81 */     this.arrivalTime = arrivalTime;
/*     */   }
/*     */   
/*     */   public String getDepatureTime() {
/*  85 */     return this.depatureTime;
/*     */   }
/*     */   
/*     */   public void setDepatureTime(String depatureTime) {
/*  89 */     this.depatureTime = depatureTime;
/*     */   }
/*     */   
/*     */   public String getEndStationName() {
/*  93 */     return this.endStationName;
/*     */   }
/*     */   
/*     */   public void setEndStationName(String endStationName) {
/*  97 */     this.endStationName = endStationName;
/*     */   }
/*     */   
/*     */   public String getArrivalTimeEndStation() {
/* 101 */     return this.arrivalTimeEndStation;
/*     */   }
/*     */   
/*     */   public void setArrivalTimeEndStation(String arrivalTimeEndStation) {
/* 105 */     this.arrivalTimeEndStation = arrivalTimeEndStation;
/*     */   }
/*     */   
/*     */   public String getFinalStationName() {
/* 109 */     return this.finalStationName;
/*     */   }
/*     */   
/*     */   public void setFinalStationName(String finalStationName) {
/* 113 */     this.finalStationName = finalStationName;
/*     */   }
/*     */   
/*     */   public String getArrivalTimeFinalStation() {
/* 117 */     return this.arrivalTimeFinalStation;
/*     */   }
/*     */   
/*     */   public void setArrivalTimeFinalStation(String arrivalTimeFinalStation) {
/* 121 */     this.arrivalTimeFinalStation = arrivalTimeFinalStation;
/*     */   }
/*     */   
/*     */   public List<ClassVO> getClassList() {
/* 125 */     return this.classList;
/*     */   }
/*     */   
/*     */   public void setClassList(List<ClassVO> classList) {
/* 129 */     this.classList = classList;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\vo\DirectTrainInfoVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */