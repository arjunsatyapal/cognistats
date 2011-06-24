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
package com.google.cognistats.client;

import com.google.cognistats.client.gwtui.mainscreen.MainScreenPresenter;
import com.google.cognistats.client.gwtui.mainscreen.MainScreenView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entrypoint class for Cognistats.
 *
 * @author Arjun Satyapal
 */
public class Cognistats implements EntryPoint {
  @Override
  public void onModuleLoad() {
//    TestSelectorPresenter presenter = new TestSelectorPresenter(new TestSelectorView());
//    presenter.go(RootLayoutPanel.get());
    MainScreenPresenter presenter = new MainScreenPresenter(new MainScreenView());
    presenter.go(RootLayoutPanel.get());
  }
}
