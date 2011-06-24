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

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.cognistats.server.enums.OAuthProviderEnum;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to allow usage of Google as OAuth Provider.
 *
 * @author Arjun Satyapal
 */
@SuppressWarnings("serial")
public class LoginGoogleServlet extends HttpServlet {
  private static Logger log =
      Logger.getLogger(LoginGoogleServlet.class.getName());

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    Set<String> attributes = new HashSet<String>();
    String callbackURL = request.getRequestURL().toString() + "Callback";
    UserService userService = UserServiceFactory.getUserService();
    String loginUrl = userService.createLoginURL(callbackURL, null,
            OAuthProviderEnum.GOOGLE.getProviderUrl(), attributes);
    log.info("Going to " + OAuthProviderEnum.GOOGLE.name() + " URL : "
        + loginUrl);
    response.sendRedirect(loginUrl);
  }
}
