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
package com.google.cognistats.client.gwtui.mainscreen;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;

/**
 *
 * @author Arjun Satyapal
 */
public interface MainScreenDisplay extends Display {
  FocusPanel getFocusPanel();

  Label getLabelUserId();

  MenuItem getMenuItemLoginLogout();

  FlowPanel getWorkspace();

  MenuItem getMenuItemTestSelector();

  Button getButtonTestSelector();
}
