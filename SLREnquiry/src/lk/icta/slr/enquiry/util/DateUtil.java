/*    */ package lk.icta.slr.enquiry.util;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public final class DateUtil
/*    */ {
/* 10 */   private static final DateFormat DF_WEBSERVICE = new SimpleDateFormat("yyyy-MM-dd");
/* 11 */   private static final DateFormat DF_CALENDAR = new SimpleDateFormat("dd/MM/yyyy");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getWebServiceDateString(Date date)
/*    */   {
/* 26 */     return DF_WEBSERVICE.format(date);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Date convertWebServiceDateStrToDateObj(String dateStr)
/*    */     throws ParseException
/*    */   {
/* 36 */     return DF_WEBSERVICE.parse(dateStr);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Date convertCalendarDateStrToDateObj(String dateStr)
/*    */     throws ParseException
/*    */   {
/* 47 */     return DF_CALENDAR.parse(dateStr);
/*    */   }
/*    */   
/*    */   public static String getCalendarDateString(Date date) {
/* 51 */     return DF_CALENDAR.format(date);
/*    */   }
/*    */ }


