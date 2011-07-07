package com.google.cognistats.client.gwtui.tests.multitrial;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.basetest.BaseTestPresenter;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.RowNamesEnum;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.DurationStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.TrialStatistic;

public class MultitrialPresenter extends BaseTestPresenter implements Presenter {

  protected int nTrials;

  public MultitrialPresenter(MultitrialTestDisplay testWidget,
    BaseStatisticWidgetPresenter statPresenter) {
    super(testWidget.getBaseTestView(), statPresenter);
  }

  protected void initializeTest() {
    nTrials = 0;
  }

  protected void startTrial() {
  }

  protected void endTrial() {
    ++nTrials;
    statPresenter.getRow(RowNamesEnum.TRIAL_ROW).setCurrentTest(new TrialStatistic(nTrials, 0));

    if (!isFinished()) {
      startTrial();
    }

  }

  protected boolean isFinished() {
    return false;
  }

  @Override
  public void start() {
    super.start();
    initializeTest();
    startTrial();
  };

}
