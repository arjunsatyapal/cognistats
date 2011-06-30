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
//import com.google.cognistats.client.gwtui.tests.base.BasePresenter;
//import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsView;
//import com.google.cognistats.client.gwtui.tests.base.testwidget.BaseTestView;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.ChoiceReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultView;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusView;
import com.google.cognistats.client.gwtui.tests.oldsimplereactiontime.OldSimpleReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.oldsimplereactiontime.resultwidget.OldSimpleReactionTimeResultView;
import com.google.cognistats.client.gwtui.tests.oldsimplereactiontime.stimuluswidget.OldSimpleReactionTimeStimulusView;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.SimpleReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.statisticswidget.SimpleReactionTimeStatisticsView;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.testwidget.SimpleReactionTimeTestView;
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
    display.getButtonOldSRTT().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        OldSimpleReactionTimePresenter testPresenter =
            new OldSimpleReactionTimePresenter(
                new OldSimpleReactionTimeStimulusView(),
                new OldSimpleReactionTimeResultView());

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

    display.getButtonSimpleReactionTime().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        SimpleReactionTimePresenter testPresenter =
            new SimpleReactionTimePresenter(
                new SimpleReactionTimeTestView(),
                new SimpleReactionTimeStatisticsView());

        TestWidgetPresenter presenter =
            new TestWidgetPresenter(new TestWidgetViewUi(), testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonBase().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        // TODO(arjuns) : Fix this once we have Base test committed.
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
