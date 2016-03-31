package com.nadee.cbtls.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.nadee.cbtls.constant.ApplicationConstants;
import com.nadee.cbtls.model.SystemUser;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  private AuthenticationSuccessHandler target = new SavedRequestAwareAuthenticationSuccessHandler();

  public LoginSuccessHandler() {}

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    System.out.println("CAME HERE onAuthenticationSuccess");
    if (authentication != null) {
      Object principal = authentication.getPrincipal();
      UserDetails userDetails = (UserDetails) (principal instanceof UserDetails ? principal : null);
      // If the user has logged in
      if (userDetails != null) {
        try {
          SystemUser systemUser = (SystemUser) userDetails;
          HttpSession session = request.getSession();

          session.setAttribute(ApplicationConstants.SYSTEM_USER, systemUser);
          session.setAttribute("displayName", systemUser.getUserDisplayName());

          // otherwise send to the default location from front end
          target.onAuthenticationSuccess(request, response, authentication);

        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }



  }
}
