/**
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cognistats.server.servlets.login;


import com.google.appengine.api.utils.SystemProperty;
import com.google.cognistats.server.enums.OAuthProviderEnum;
import com.google.cognistats.shared.enums.ServletPaths;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Helper class for Login Servlets.
 *
 * @author Arjun Satyapal
 */
public class LoginHelper extends RemoteServiceServlet {
  private static final long serialVersionUID = 6690557021950311538L;
  private static Logger logger = Logger.getLogger(LoginHelper.class.getName());
  private static String DEVELOPMENT_URL =
      "http://127.0.0.1:8888/Cognistats.html?gwt.codesvr="
          + "127.0.0.1:9997";

  static public String getApplicationURL(HttpServletRequest request) {
    if (isDevelopment(request)) {
      return DEVELOPMENT_URL;
    } else {
      return request.getScheme() + "://" + request.getServerName()
          + request.getContextPath();
    }
  }

  static public String getLogoutUrl(HttpServletRequest request,
      OAuthProviderEnum oAuthProvider) {
    if(isDevelopment(request)) {
      return ServletPaths.UserNotLoggedIn.getRelativePath();
    } else {
      return oAuthProvider.getLogOutUrl();
    }
  }


//  static public boolean isLoggedIn(HttpServletRequest req) {
//    if (req == null) {
//      return false;
//    } else {
//      HttpSession session = req.getSession();
//      if (session == null) {
//        logger.info("User is not logged in.");
//        return false;
//      } else {
//        Boolean isLoggedIn =
//            (Boolean) session.getAttribute(LOGGED_IN.getAttributeString());
//        if (isLoggedIn == null) {
//          logger.info("Session found, but user is not logged in");
//          return false;
//        } else if (isLoggedIn) {
//          logger.info("User is logged in.");
//          return true;
//        } else {
//          logger.info("User is not logged in");
//          return false;
//        }
//      }
//    }
//  }

//  public static void loginStarts(HttpSession session,
//      UserAccountDao userAccountDao, OAuthProviderEnum oAuthProvider) {
//    /*
//     * NOTE : Email is not the best way because many different providers can
//     * share the same emal. e.g. MyOpenId will return User's primary emailId
//     * with MyOpenId. So in that case, you may face collisions. But this is for
//     * demo purpose, so using email for convenience.
//     */
//    session.setAttribute(EMAIL.getAttributeString(), userAccountDao.getEmail());
//    session.setAttribute(LOGGED_IN.getAttributeString(), true);
//    session.setAttribute(OAuthProvider.getAttributeString(),
//        oAuthProvider.name());
//  }

//  public static OAuthProviderEnum logout(HttpSession session) {
//    String oAuthProviderName =
//        (String) session.getAttribute(OAuthProvider.getAttributeString());
//    session.invalidate();
//    logger.info("OAuthprovider enum name = " + oAuthProviderName);
//    return OAuthProviderEnum.valueOf(oAuthProviderName);
//  }
//
//  public static boolean isDevelopment(HttpServletRequest request) {
//    return SystemProperty.environment.value() != SystemProperty.Environment.Value.Production;
//  }

  public static boolean isDevelopment(HttpServletRequest request) {
	    return SystemProperty.environment.value() != SystemProperty.Environment.Value.Production;
	  }
}