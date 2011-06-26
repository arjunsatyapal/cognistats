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
package com.google.cognistats.client.gwtui.testselector;

import static com.google.cognistats.client.gwtui.mainscreen.MainScreenPresenter.getWorkspace;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.ChoiceReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultView;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusView;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.SimpleReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.resultwidget.SimpleReactionTimeResultView;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.stimuluswidget.SimpleReactionTimeStimulusView;
import com.google.cognistats.client.gwtui.widgets.testwidget.TestWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.testwidget.TestWidgetViewUi;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Presenter for the TestSelector.
 *
 * @author Arjun Satyapal
 */
public class TestSelectorPresenter implements Presenter {
  private TestSelectorDisplay display;

  public TestSelectorPresenter(TestSelectorDisplay display) {
    this.display = display;
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(display.asWidget());
    bind();
  }

  @Override
  public void bind() {
    display.getButtonSRTT().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        SimpleReactionTimePresenter testPresenter =
            new SimpleReactionTimePresenter(
                new SimpleReactionTimeStimulusView(),
                new SimpleReactionTimeResultView());

        TestWidgetPresenter presenter =
            new TestWidgetPresenter(new TestWidgetViewUi(), testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonCRTT().addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
          ChoiceReactionTimePresenter testPresenter =
              new ChoiceReactionTimePresenter(
                  new ChoiceReactionTimeStimulusView(),
                  new ChoiceReactionTimeResultView());

          TestWidgetPresenter presenter =
              new TestWidgetPresenter(new TestWidgetViewUi(), testPresenter);
          presenter.go(getWorkspace());
        }
      });
  }
}
