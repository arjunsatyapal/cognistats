package com.google.cognistats.client.gwtui.tests.multitrial;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.basetest.BaseTestPresenter;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.TrialStatistic;
import com.google.gwt.user.client.Window;

public class MultitrialPresenter extends BaseTestPresenter implements Presenter {

  protected int nTrials;
  protected TrialStatistic trialStatistic;

  public MultitrialPresenter(MultitrialTestDisplay testWidget,
    BaseStatisticWidgetPresenter statPresenter) {
    super(testWidget.getBaseTestView(), statPresenter);
  }
  
  @Override
  protected void initializeStatistics() {
	  super.initializeStatistics();
	  trialStatistic = new TrialStatistic();
	  statPresenter.addRow(trialStatistic);
  }

  protected void initializeTest() {
    nTrials = 0;
    trialStatistic.setTestTrialCount(nTrials);
  }
  
  protected void startTrial() {
  }
  
  protected void increaseTrialCount() {
	  ++nTrials;
	  trialStatistic.setTestTrialCount(nTrials);
  }

  protected void endTrial() {
	  increaseTrialCount();
//    statPresenter.getRow(RowNamesEnum.TRIAL_ROW).setCurrentTest(new TrialStatistic(nTrials, 0));

    if (!isFinished()) {
      startTrial();
    }
    else {
    	isRunning = false;
    	Window.alert("Test finished");
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
  }

}
