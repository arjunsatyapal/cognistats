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
import com.google.gwt.core.client.GWT;

public class MultitrialPresenter extends BaseTestPresenter implements Presenter {

  protected int nTrials;
  protected TrialStatistic trialStatistic;
  protected LinkedList<TrialResult> trialResults;
  protected long trialStartTime;
  protected long trialTime;
  protected boolean isTrialRunning;

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
    trialResults = new LinkedList<TrialResult>();
    trialStatistic.setTestTrialCount(nTrials);
  }
  
  protected void startTrial() {
	  trialStartTime = System.currentTimeMillis();
	  isTrialRunning = true;
	  trialTime = 0;
  }
  
  protected void increaseTrialCount() {
	  ++nTrials;
	  trialStatistic.setTestTrialCount(nTrials);
  }

  protected void endTrial() {
	  saveTrialResult();
	  increaseTrialCount();
//    statPresenter.getRow(RowNamesEnum.TRIAL_ROW).setCurrentTest(new TrialStatistic(nTrials, 0));
	  isTrialRunning = false;

    if (!isFinished()) {
      startTrial();
    }
    else {
    	isRunning = false;
    	testComplete = true;
    	finish();
    }

  }
  
  @Override
  protected void testTimeUpdated() {
	  super.testTimeUpdated();
	  if (isTrialRunning) {
		  long currentTime = System.currentTimeMillis();
		  trialTime = currentTime - trialStartTime;
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
