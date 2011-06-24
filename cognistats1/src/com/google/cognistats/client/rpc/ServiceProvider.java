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
package com.google.cognistats.client.rpc;

import com.google.gwt.core.client.GWT;

/**
 * Provider for all the GWT Services.
 *
 * @author Arjun Satyapal
 */
public class ServiceProvider {
  private static ServiceProvider instance = new ServiceProvider();
  private UserServiceAsync userService;

  private ServiceProvider() {
    userService = GWT.create(UserService.class);
  }

  public static ServiceProvider getServiceProvider() {
    return instance;
  }

  public UserServiceAsync getLoginService() {
    return userService;
  }
}