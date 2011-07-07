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
package com.google.cognistats.client.gwtui.widgets.classroomwidget;

import com.google.cognistats.client.gwtui.mainscreen.MainScreenPresenter;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Presenter for TestWidget.
 *
 * @author Arjun Satyapal
 */
public class ClassroomWidgetPresenter implements Presenter {
  private ClassroomWidgetDisplay display;
  private TestPresenter testPresenter;

  public ClassroomWidgetPresenter(ClassroomWidgetDisplay display,
      TestPresenter testPresenter) {
    this.display = display;
    this.testPresenter = testPresenter;
    testPresenter.setStatContainer(this.display.getLayoutPanelResult());
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(display.asWidget());
    bind();
  }

  @Override
  public void bind() {
    display.getLayoutPanelTest().add(
        testPresenter.getTestView().asWidget());
    display.getLayoutPanelResult()
        .add(testPresenter.getStatPresenter().getStatisticWidget().asWidget());

    // Registering KeyPress and Touch Handlers with FocusPanel.
    MainScreenPresenter.getFocusPanel().addKeyPressHandler(
        testPresenter.getFocusPanelKeyPressHandler());
    MainScreenPresenter.getFocusPanel().addTouchStartHandler(
        testPresenter.getFocusPanelTouchStartHandler());

    display.getButtonStart().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        testPresenter.start();
      }
    });

    display.getButtonStop().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        testPresenter.stop();
      }
    });
  }
}
