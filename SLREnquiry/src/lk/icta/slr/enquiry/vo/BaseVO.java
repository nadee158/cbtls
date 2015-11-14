/*    */ package lk.icta.slr.enquiry.vo;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Modifier;
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
/*    */ public class BaseVO
/*    */   implements Cloneable, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -5923902571502857976L;
/*    */   
/*    */   public String toString()
/*    */   {
/* 24 */     Class myClass = getClass();
/* 25 */     String strNewLineTabbed = "\n";
/* 26 */     StringBuffer strBuffer = new StringBuffer();
/* 27 */     strBuffer.append(strNewLineTabbed + myClass + " :~" + strNewLineTabbed + "{");
/*    */     
/* 29 */     Field[] myClassFields = myClass.getDeclaredFields();
/* 30 */     for (int index = 0; index < myClassFields.length; index++) {
/* 31 */       if (!Modifier.isPublic(myClassFields[index].getModifiers())) {
/* 32 */         myClassFields[index].setAccessible(true);
/*    */       }
/* 34 */       strBuffer.append(myClassFields[index].getName()).append(" = ");
/*    */       try {
/* 36 */         if (myClassFields[index].getType().isArray()) {
/* 37 */           Object[] subClassObjectArray = (Object[])myClassFields[index].get(this);
/*    */           
/* 39 */           if (subClassObjectArray == null) {
/* 40 */             strBuffer.append(" [ null array - no elements ]");
/*    */           } else {
/* 42 */             strBuffer.append(" [ ");
/* 43 */             for (int j = 0; j < subClassObjectArray.length; j++) {
/* 44 */               strBuffer.append(subClassObjectArray[j]);
/* 45 */               strBuffer.append(j < subClassObjectArray.length - 1 ? ", " : "");
/*    */             }
/*    */             
/*    */ 
/* 49 */             strBuffer.append(" ]");
/*    */           }
/*    */         } else {
/* 52 */           strBuffer.append(" [ " + myClassFields[index].get(this) + " ]");
/*    */         }
/*    */       }
/*    */       catch (Exception ex) {
/* 56 */         strBuffer.append(" [ ( " + ex.getMessage() + " ) ]");
/*    */       }
/* 58 */       strBuffer.append(", ");
/*    */     }
/* 60 */     return strBuffer.substring(0, strBuffer.length() - 2) + " }";
/*    */   }
/*    */   
/*    */   public Object clone() throws CloneNotSupportedException
/*    */   {
/* 65 */     return super.clone();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nadeeshani\Desktop\SLREnquiry.war!\WEB-INF\classes\lk\icta\slr\enquiry\vo\BaseVO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */