package com.nadee.cbtls.util;

import java.io.Serializable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.model.SystemUser;

@Component(value="sessionUtil")
public class SessionUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static <E> void addToSession(String key,E object){
		getSession(true).setAttribute(key, object);
	}
	
	public static <E> E getFromSession(String key){
		return (E) getSession(true).getAttribute(key);
	}
	
	// example usage
	public static HttpSession getSession(boolean doCreateNew) {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(doCreateNew); // true == allow create
	}
	
	public static long getUserIdFromCookie(HttpServletRequest request) {
		long userId=0;
		Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	      for (int i = 0; i < cookies.length; i++) {
	        if (cookies[i].getName().equals(ApplicationConstants.CBTLS_USER_COOKIE)) {
	          String userIdStr = cookies[i].getValue();
	          userId=Long.parseLong(userIdStr);
	          break;
	        }
	      }
	    }
		return userId;
	}

	public static void addUserCookie(HttpServletResponse response, SystemUser systemUser) {
		if(!(systemUser==null)){
			Cookie foo = new Cookie(ApplicationConstants.CBTLS_USER_COOKIE, Long.toString(systemUser.getUserId())); //bake cookie
			foo.setMaxAge((1000*10*60*24*365)); //set expire time to 1000 sec
			response.addCookie(foo); //put cookie in response 
		}
	}

}
