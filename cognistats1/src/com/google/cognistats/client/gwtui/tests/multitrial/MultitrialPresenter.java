package com.google.cognistats.client.gwtui.tests.multitrial;

import java.util.LinkedList;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.basetest.BaseTestPresenter;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestDisplay;
import com.google.cognistats.client.gwtui.tests.results.MultitrialResult;
import com.google.cognistats.client.gwtui.tests.results.MultitrialTrialResult;
import com.google.cognistats.client.gwtui.tests.results.TrialResult;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.TrialStatistic;

public class MultitrialPresenter extends BaseTestPresenter implements Presenter {

  protected int nTrials;
  protected TrialStatistic trialStatistic;
  protected LinkedList<TrialResult> trialResults;

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
	  saveTrialResult();
	  increaseTrialCount();
//    statPresenter.getRow(RowNamesEnum.TRIAL_ROW).setCurrentTest(new TrialStatistic(nTrials, 0));

    if (!isFinished()) {
      startTrial();
    }
    else {
    	isRunning = false;
    	testComplete = true;
    	finish();
    }

  }
  
  protected void saveTrialResult() {
	  MultitrialTrialResult trialResult = new MultitrialTrialResult();
	  saveMultitrialTrialResult(trialResult);
	  trialResults.add(trialResult);
  }
  
  protected void saveMultitrialTrialResult(MultitrialTrialResult trialResult) {
	  trialResult.setTrialNumber(nTrials);
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

  @Override
  public void buildResults() {
	  MultitrialResult results = new MultitrialResult();
	  buildMultitrialResults(results);
  }
  
  protected void buildMultitrialResults(MultitrialResult results) {
	  buildBaseResults(results);
	  results.setTrialResults(trialResults);
  }

}
