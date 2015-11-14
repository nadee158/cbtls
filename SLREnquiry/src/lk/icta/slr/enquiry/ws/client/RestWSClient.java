/*    */ package lk.icta.slr.enquiry.ws.client;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.HttpURLConnection;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.ProtocolException;
/*    */ import java.net.URL;
/*    */ import lk.icta.slr.enquiry.exception.BusinessException;
/*    */ import lk.icta.slr.enquiry.util.CommonUtil;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RestWSClient
/*    */ {
/* 18 */   private static final Logger LOGGER = Logger.getLogger(RestWSClient.class);
/* 19 */   private static RestWSClient instance = null;
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
/*    */   public static synchronized RestWSClient getInstance()
/*    */   {
/* 33 */     if (instance == null) {
/* 34 */       instance = new RestWSClient();
/*    */     }
/* 36 */     return instance;
/*    */   }
/*    */   
/*    */   public String getJSONStringFromRestWebService(String urlString) throws BusinessException
/*    */   {
/* 41 */     if (LOGGER.isDebugEnabled()) {
/* 42 */       LOGGER.debug("ENTRY getJSONStringFromRestWebService with url: " + urlString);
/*    */     }
/*    */     
/* 45 */     if (CommonUtil.checkBlank(urlString)) {
/* 46 */       throw new IllegalArgumentException("URL can not be blank");
/*    */     }
/*    */     
/* 49 */     StringBuffer resultString = new StringBuffer();
/*    */     
/*    */ 
/*    */     try
/*    */     {
/* 54 */       URL url = new URL(urlString);
/* 55 */       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
/* 56 */       conn.setRequestMethod("GET");
/* 57 */       conn.setRequestProperty("Accept", "application/json");
/*    */       
/* 59 */       if (conn.getResponseCode() != 200) {
/* 60 */         throw new RuntimeException("Failed with HTTP error code: " + conn.getResponseCode());
/*    */       }
/*    */       
/*    */ 
/* 64 */       BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
/*    */       
/*    */       String output;
/*    */       
/* 68 */       while ((output = br.readLine()) != null) {
/* 69 */         resultString.append(output);
/*    */       }
/*    */       
/* 72 */       conn.disconnect();
/*    */     } catch (MalformedURLException e) {
/* 74 */       LOGGER.error("Got MalformedURLException: ", e);
/* 75 */       throw new BusinessException(e);
/*    */     } catch (ProtocolException e) {
/* 77 */       LOGGER.error("Got ProtocolException: ", e);
/* 78 */       throw new BusinessException(e);
/*    */     } catch (IOException e) {
/* 80 */       LOGGER.error("Got IOException: ", e);
/* 81 */       throw new BusinessException(e);
/*    */     }
/*    */     
/* 84 */     if (LOGGER.isDebugEnabled()) {
/* 85 */       LOGGER.debug("EXIT getJSONStringFromRestWebService with result: " + resultString);
/*    */     }
/*    */     
/* 88 */     return resultString.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\ws\client\RestWSClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */