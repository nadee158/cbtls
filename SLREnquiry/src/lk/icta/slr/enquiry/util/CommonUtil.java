/*    */ package lk.icta.slr.enquiry.util;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.MessageFormat;
/*    */ import java.util.Enumeration;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.MissingResourceException;
/*    */ import java.util.Properties;
/*    */ import java.util.ResourceBundle;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CommonUtil
/*    */ {
/* 22 */   private static final Logger LOGGER = Logger.getLogger(CommonUtil.class);
/* 23 */   private static Map<String, Properties> fileNamePropertiesMapping = new HashMap();
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
/*    */   public static boolean checkBlank(String strValue)
/*    */   {
/* 37 */     return (strValue == null) || (strValue.trim().isEmpty());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Properties getPropertiesFromFile(String filePath)
/*    */   {
/* 47 */     Properties properties = new Properties();
/*    */     
/* 49 */     if (fileNamePropertiesMapping.containsKey(filePath)) {
/* 50 */       properties = (Properties)fileNamePropertiesMapping.get(filePath);
/*    */     } else {
/*    */       try {
/* 53 */         ResourceBundle resourceBundle = ResourceBundle.getBundle(filePath);
/* 54 */         LOGGER.debug("loaded local Resource Bundle File:" + filePath);
/* 55 */         String key = null;
/* 56 */         if (resourceBundle != null) {
/* 57 */           Enumeration<String> localenum = resourceBundle.getKeys();
/* 58 */           while (localenum.hasMoreElements()) {
/* 59 */             key = (String)localenum.nextElement();
/* 60 */             properties.put(key, resourceBundle.getString(key));
/*    */           }
/*    */         }
/*    */         
/* 64 */         fileNamePropertiesMapping.put(filePath, properties);
/*    */       }
/*    */       catch (MissingResourceException ex) {
/* 67 */         LOGGER.fatal("could not find file:" + ex);
/*    */       }
/*    */     }
/*    */     
/* 71 */     return properties;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getValueFromFile(String filePath, String key, Object... params)
/*    */   {
/* 81 */     String valueFromFile = "";
/*    */     try {
/* 83 */       if (params == null) {
/* 84 */         valueFromFile = getPropertiesFromFile(filePath).getProperty(key);
/*    */       } else {
/* 86 */         valueFromFile = MessageFormat.format(getPropertiesFromFile(filePath).getProperty(key), params);
/*    */       }
/*    */     } catch (Exception e) {
/* 89 */       LOGGER.error("getValueFromFile failed", e);
/*    */     }
/* 91 */     return valueFromFile;
/*    */   }
/*    */   
/*    */   public static String convertDoubleToCurrency(double input) {
/* 95 */     DecimalFormat twoDecimal = new DecimalFormat("0.00");
/* 96 */     twoDecimal.setGroupingUsed(false);
/* 97 */     return twoDecimal.format(input);
/*    */   }
/*    */ }


