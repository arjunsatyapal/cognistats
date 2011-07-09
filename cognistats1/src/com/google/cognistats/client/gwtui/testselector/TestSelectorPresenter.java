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
import com.google.cognistats.client.gwtui.tests.basetest.BaseStatisticsPresenter;
import com.google.cognistats.client.gwtui.tests.basetest.BaseTestPresenter;
<<<<<<< HEAD
import com.google.cognistats.client.gwtui.tests.basetest.testwidget.BaseTestView;
import com.google.cognistats.client.gwtui.tests.reactiontime.ChoiceReactionTimePresenter;
=======
>>>>>>> 92d4e060bbd8e69c537a249620bfd5ffd561979c
import com.google.cognistats.client.gwtui.tests.choicereactiontime.statisticswidget.ChoiceReactionTimeStatisticsPresenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.ChoiceReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.SimpleReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ChoiceReactionTimeTestView;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.SimpleReactionTimeTestView;
import com.google.cognistats.client.gwtui.tests.stroop.StroopPresenter;
import com.google.cognistats.client.gwtui.tests.stroop.testwidget.StroopTestView;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.cognistats.client.gwtui.widgets.classroomwidget.ClassroomWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.classroomwidget.ClassroomWidgetViewUi;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.TrialStatistic;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
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
    display.getButtonCRTT().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        ChoiceReactionTimePresenter testPresenter =
          new ChoiceReactionTimePresenter(new ChoiceReactionTimeTestView(),
            new ChoiceReactionTimeStatisticsPresenter());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(),
            testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonSimpleReactionTime().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        SimpleReactionTimePresenter testPresenter =
          new SimpleReactionTimePresenter(new SimpleReactionTimeTestView(),
            new ChoiceReactionTimeStatisticsPresenter());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(),
            testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonStroop().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        // TODO(arjuns) : fix this.
        BaseTestPresenter testPresenter =
          new StroopPresenter(new StroopTestView(),
            new BaseStatisticWidgetPresenter());

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(),
            testPresenter);
        presenter.go(getWorkspace());
      }
    });

    display.getButtonBase().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        // TODO(arjuns) : Fix this once we have Base test committed.
        /*
         * BasePresenter testPresenter = new BasePresenter( new BaseTestView(),
         * new BaseStatisticsView());
         */BaseTestPresenter testPresenter =
<<<<<<< HEAD
          new BaseTestPresenter(new BaseTestView(), new BaseStatisticsPresenter());
=======
          new TSRPresenter(new TSRTestView(),
            new BaseStatisticWidgetPresenter());
>>>>>>> 92d4e060bbd8e69c537a249620bfd5ffd561979c

        ClassroomWidgetPresenter presenter =
          new ClassroomWidgetPresenter(new ClassroomWidgetViewUi(),
            testPresenter);
        presenter.go(getWorkspace());
        testPresenter.go(presenter.getDisplay().getLayoutPanelTest());
      }
    });

    display.getButtonArjunGrid().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        BaseStatisticWidgetPresenter presenter =
          new BaseStatisticWidgetPresenter();
        final TrialStatistic trial1 = getTrialStatistic();
        presenter.addRow(trial1);

        Timer testTimer = new Timer() {
          @Override
          public void run() {
            trial1.increaseTrialCount();
          }
        };
        testTimer.scheduleRepeating(1000);

        presenter.go(getWorkspace());
      }
    });
  }

  public TrialStatistic getTrialStatistic() {
    TrialStatistic trial = new TrialStatistic(100, 7);
    return trial;
  }
}
