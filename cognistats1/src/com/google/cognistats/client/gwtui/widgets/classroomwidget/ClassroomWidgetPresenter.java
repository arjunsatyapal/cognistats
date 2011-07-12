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

import java.util.Iterator;

import com.google.cognistats.client.gwtui.mainscreen.MainScreenPresenter;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * Presenter for TestWidget.
 *
 * @author Arjun Satyapal
 */
public class ClassroomWidgetPresenter implements Presenter, TestFinisher {
  private ClassroomWidgetDisplay display;
  private TestPresenter testPresenter;

  public ClassroomWidgetPresenter(ClassroomWidgetDisplay display,
      TestPresenter testPresenter) {
    this.display = display;
    this.testPresenter = testPresenter;
    testPresenter.setStatContainer(this.display.getLayoutPanelResult());
    testPresenter.setFinisher(this);
  }
  
  public ClassroomWidgetDisplay getDisplay() {
	  return display;
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(display.asWidget());
    bind();
    display.getBlackboard().setVisible(true);
    display.getInstructions().setVisible(true);
    display.getSummary().setVisible(false);
  }

  @Override
  public void bind() {
    display.getLayoutPanelTest().add(
        testPresenter.getTestView().asWidget());
    display.getLayoutPanelResult().clear();
    display.getLayoutPanelResult()
        .add(testPresenter.getStatPresenter().getStatisticWidget().asWidget());
    display.getInstructionsText().setHTML(testPresenter.getInstructions());

    // Registering KeyPress and Touch Handlers with FocusPanel.
    MainScreenPresenter.getFocusPanel().addKeyPressHandler(
        testPresenter.getFocusPanelKeyPressHandler());
    MainScreenPresenter.getFocusPanel().addTouchStartHandler(
        testPresenter.getFocusPanelTouchStartHandler());

    display.getButtonStart().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        testPresenter.start();
        display.getBlackboard().setVisible(false);
        display.getInstructions().removeFromParent(); // so it doesn't get in the way
        //display.getInstructions().setVisible(false);
      }
    });

    display.getButtonStop().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        testPresenter.stop();
      }
    });

    display.getButtonPause().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        testPresenter.togglePause();
        display.getButtonPause().setText(display.getButtonPause().getText() == "Pause" ? "Unpause" : "Pause");
      }
    });

    display.getButtonSubmit().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        // TODO: do something
    	Window.alert("How can I get us back to the test selector screen from here?");
      }
    });
  }

  @Override
  public void finishTest(HasWidgets results) {
	display.getBlackboard().setVisible(true);
	display.getSummary().setVisible(true);
	Iterator<Widget> it = results.iterator();
	while(it.hasNext())
		display.getSummaryStatistics().setHTML(it.next().getElement().getInnerHTML());
  }
}
