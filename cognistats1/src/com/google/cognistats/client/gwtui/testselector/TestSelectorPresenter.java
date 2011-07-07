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
import com.google.cognistats.client.gwtui.tests.basetest.BaseTestPresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.ChoiceReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.testwidget.ChoiceReactionTimeTestView;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.SimpleReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.testwidget.SimpleReactionTimeTestView;
import com.google.cognistats.client.gwtui.tests.stroop.StroopPresenter;
import com.google.cognistats.client.gwtui.tests.stroop.testwidget.StroopTestView;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.cognistats.client.gwtui.widgets.classroomwidget.ClassroomWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.classroomwidget.ClassroomWidgetViewUi;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.DurationGridRow;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.DurationStatistic;
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
  public void go(
    HasWidgets container) {
    container.clear();
    container.add(display.asWidget());
    bind();
  }

  @Override
  public void bind() {
    display.getButtonCRTT().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(
        ClickEvent event) {
        ChoiceReactionTimePresenter testPresenter =
          new ChoiceReactionTimePresenter(new ChoiceReactionTimeTestView());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(), testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonSimpleReactionTime().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(
        ClickEvent event) {
        SimpleReactionTimePresenter testPresenter =
          new SimpleReactionTimePresenter(new SimpleReactionTimeTestView());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(), testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonStroop().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(
        ClickEvent event) {
        // TODO(arjuns) : fix this.
        BaseTestPresenter testPresenter =
          new StroopPresenter(new StroopTestView(), null);
        //new BaseTestStatisticsView());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(), testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonBase().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(
        ClickEvent event) {
        // TODO(arjuns) : Fix this once we have Base test committed.
        /*
         * BasePresenter testPresenter = new BasePresenter( new BaseTestView(),
         * new BaseStatisticsView());
         */BaseTestPresenter testPresenter =
          new TSRPresenter(new TSRTestView(), null);
         //TODO(arjuns) : fix this.
         //new BaseTestStatisticsView());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(), testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonArjunGrid().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(
        ClickEvent event) {
        BaseStatisticWidgetPresenter presenter =
          new BaseStatisticWidgetPresenter();
        presenter.addRow(getDurationGridRow());
        presenter.addRow(getDurationGridRow());
        presenter.go(getWorkspace());
      }
    });
  }

  public DurationGridRow getDurationGridRow() {
    DurationGridRow row = new DurationGridRow();
    row.setAllTime(new DurationStatistic(System.currentTimeMillis()));
    row.setCurrentTest(new DurationStatistic(1234L));
    row.setCurrentTrial(new DurationStatistic(1234L));

    return row;
  }
}
