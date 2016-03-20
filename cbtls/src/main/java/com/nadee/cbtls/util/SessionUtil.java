package com.nadee.cbtls.util;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component(value="sessionUtil")
public class SessionUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static <E> void addToSession(String key,E object){
		getSession(false).setAttribute(key, object);
	}
	
	public static <E> E getFromSession(String key){
		return (E) getSession(true).getAttribute(key);
	}
	
	// example usage
	public static HttpSession getSession(boolean doCreateNew) {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(doCreateNew); // true == allow create
	}

}
