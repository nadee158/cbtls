/*     */ package lk.icta.slr.enquiry.vo;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConnectingTrainInfoVO
/*     */   extends BaseVO
/*     */ {
/*     */   private static final long serialVersionUID = -813494693546216103L;
/*     */   private String trainNo;
/*     */   private String trainName;
/*     */   private String recID;
/*     */   private String selected;
/*     */   private String isTransit;
/*     */   private String startStation;
/*     */   private String startTime;
/*     */   private String endStation;
/*     */   private String endTime;
/*  22 */   private List<ClassVO> classList = new ArrayList();
/*     */   
/*     */   public String getTrainNo() {
/*  25 */     return this.trainNo;
/*     */   }
/*     */   
/*     */   public void setTrainNo(String trainNo) {
/*  29 */     this.trainNo = trainNo;
/*     */   }
/*     */   
/*     */   public String getTrainName() {
/*  33 */     return this.trainName;
/*     */   }
/*     */   
/*     */   public void setTrainName(String trainName) {
/*  37 */     this.trainName = trainName;
/*     */   }
/*     */   
/*     */   public String getRecID() {
/*  41 */     return this.recID;
/*     */   }
/*     */   
/*     */   public void setRecID(String recID) {
/*  45 */     this.recID = recID;
/*     */   }
/*     */   
/*     */   public String getSelected() {
/*  49 */     return this.selected;
/*     */   }
/*     */   
/*     */   public void setSelected(String selected) {
/*  53 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public String getIsTransit() {
/*  57 */     return this.isTransit;
/*     */   }
/*     */   
/*     */   public void setIsTransit(String isTransit) {
/*  61 */     this.isTransit = isTransit;
/*     */   }
/*     */   
/*     */   public String getStartStation() {
/*  65 */     return this.startStation;
/*     */   }
/*     */   
/*     */   public void setStartStation(String startStation) {
/*  69 */     this.startStation = startStation;
/*     */   }
/*     */   
/*     */   public String getStartTime() {
/*  73 */     return this.startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(String startTime) {
/*  77 */     this.startTime = startTime;
/*     */   }
/*     */   
/*     */   public String getEndStation() {
/*  81 */     return this.endStation;
/*     */   }
/*     */   
/*     */   public void setEndStation(String endStation) {
/*  85 */     this.endStation = endStation;
/*     */   }
/*     */   
/*     */   public String getEndTime() {
/*  89 */     return this.endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(String endTime) {
/*  93 */     this.endTime = endTime;
/*     */   }
/*     */   
/*     */   public List<ClassVO> getClassList() {
/*  97 */     return this.classList;
/*     */   }
/*     */   
/*     */   public void setClassList(List<ClassVO> classList) {
/* 101 */     this.classList = classList;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\vo\ConnectingTrainInfoVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */