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
package com.google.cognistats.client.gwtui.mvpinterfaces;

import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.ui.LayoutPanel;

/**
 * Presenter interface for each test.
 *
 * @author Arjun Satyapal
 */
public interface TestPresenter extends Presenter {
  Display getTestView();

  BaseStatisticWidgetPresenter getStatPresenter();

  KeyPressHandler getFocusPanelKeyPressHandler();

  TouchStartHandler getFocusPanelTouchStartHandler();

  void start();

  void stop();
  
  void finish();

  void setStatContainer(LayoutPanel layoutPanelResult);
  
  String getInstructions();
}
