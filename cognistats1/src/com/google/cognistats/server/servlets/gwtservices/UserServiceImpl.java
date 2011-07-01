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
package com.google.cognistats.server.servlets.gwtservices;

import com.google.cognistats.client.rpc.UserService;
import com.google.cognistats.server.domain.UserAccountDao;
import com.google.cognistats.server.servlets.login.LoginHelper;
import com.google.cognistats.shared.dtos.UserAccountDto;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.servlet.http.HttpSession;

/**
 * Service Implementation for UserService.
 *
 * @author Arjun Satyapal
 */
@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements
    UserService {
  @Override
  public UserAccountDto getUserAccountDto() {

    UserAccountDto userAccountDto;
    HttpSession session = getThreadLocalRequest().getSession();

    UserAccountDao userAccountDao = LoginHelper.getLoggedInUser(session);

    if (userAccountDao == null) {
      return null;
    }

    return userAccountDao.toDto();
  }
}
