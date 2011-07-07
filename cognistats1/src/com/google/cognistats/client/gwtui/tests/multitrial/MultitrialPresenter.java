package com.google.cognistats.client.gwtui.tests.multitrial;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.basetest.BaseTestPresenter;
import com.google.cognistats.client.gwtui.tests.basetest.statisticswidget.BaseTestStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestDisplay;

public class MultitrialPresenter extends BaseTestPresenter implements Presenter {

  protected int nTrials;

  public MultitrialPresenter(MultitrialTestDisplay testWidget,
      BaseTestStatisticsDisplay statisticsWidget) {
    super(testWidget.getBaseTestView(), statisticsWidget);
  }

  protected void initializeTest() {
    nTrials = 0;
  }

  protected void startTrial() {
  }

  protected void endTrial() {
    ++nTrials;
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
