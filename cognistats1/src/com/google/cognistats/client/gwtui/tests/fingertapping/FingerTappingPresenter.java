package com.google.cognistats.client.gwtui.tests.fingertapping;

import java.util.LinkedList;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.aggregator.MeanVarianceAggregator;
import com.google.cognistats.client.gwtui.tests.fingertapping.testwidget.FingerTappingTestDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
import com.google.cognistats.client.gwtui.tests.results.FingerTappingTrialResult;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.TapCountStatistic;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;

public class FingerTappingPresenter extends MultitrialPresenter implements
		Presenter {

	protected FingerTappingTestDisplay fingerTappingTestWidget;
	protected int tapCount = 0;
	protected boolean keyIsUp = true;
	protected boolean trialIsAlmostStarted = false;
	protected String hand;  // "left" or "right"
	protected LinkedList<Integer> tapTimes;
	protected TapCountStatistic tapCountStatistic;
	protected MeanVarianceAggregator tapCountAggregator;
	protected static final int trialDuration = 10;
	
	public FingerTappingPresenter(FingerTappingTestDisplay testWidget,
			BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getMultiTrialTestView(), statPresenter);
		this.fingerTappingTestWidget = testWidget;
		fingerTappingTestWidget.setInstructionsVisible(false);
		fingerTappingTestWidget.setTimeAndCountVisible(false);
		testTotalTrials = 4;
	}
	
	@Override
	public Display getTestView() {
		return fingerTappingTestWidget;
	}
	
	@Override
	protected void initializeStatistics() {
	  super.initializeStatistics();
	  tapCountStatistic = new TapCountStatistic();
	  tapCountAggregator = new MeanVarianceAggregator();
	  statPresenter.addRow(tapCountStatistic);
	}

	@Override
	protected void setupKeys() {
		super.setupKeys();
		keyMap.put(' ', 1);
	}
	
	protected Timer trialDelayTimer = new Timer() {
		@Override
		public void run() {
			startTrialAlmost();
		}
	};
	
	@Override
	protected void startTrial() {
		if(hand == "")
			hand = (Math.random() < 0.5) ? "left" : "right";
		else
			hand = (hand == "right") ? "left" : "right";
		tapTimes = new LinkedList<Integer>();
		
		// set a timer here to startTrialAlmost() after a second
		trialDelayTimer.schedule(1000);
	}
	
	protected void startTrialAlmost() {
		fingerTappingTestWidget.setInstructionsHand(hand);
		fingerTappingTestWidget.setInstructionsVisible(true);
	    trialIsAlmostStarted = true;
	}
	
	protected void reallyStartTrial() {
		fingerTappingTestWidget.setInstructionsVisible(false);
		fingerTappingTestWidget.setTimeAndCountVisible(true);
		tapCount = 0;
	    trialIsAlmostStarted = false;
		super.startTrial();
	}
	
	@Override
	protected void endTrial() {
	    fingerTappingTestWidget.setTimeAndCountVisible(false);
		tapCountAggregator.add(tapCount);
		tapCountStatistic.setTestTapCount(tapCountAggregator.mean(), tapCountAggregator.variance());
		super.endTrial();
	}
	
	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == 1 && !isFinished() && keyIsUp) {
			keyIsUp = false;
			if (trialIsAlmostStarted)
				reallyStartTrial();
			else if (isTrialRunning)
				incrementTapCount();
			return;
		}
		super.keyPressed(keyCode);
	}
	
	@Override
	protected void keyUp(int keyCode) {
		if (keyCode == 1)
			keyIsUp = true;
	}
	
	@Override
	protected void testTimeUpdated() {
		super.testTimeUpdated();
		if (isTrialRunning) {
			fingerTappingTestWidget.setTimeLeft(trialDuration - (int)(trialTime / 1000));
			durationStatistic.setCurrTrialTimeInMillis(trialTime);
			if (trialTime > trialDuration * 1000)
				endTrial();
		}
	}
	
	protected void incrementTapCount() {
		tapCount += 1;
		fingerTappingTestWidget.setTapCount(tapCount);
		tapTimes.add(new Integer((int)(System.currentTimeMillis() - trialStartTime)));
		tapCountStatistic.setTrialTapCount(tapCount);
	}
	
	@Override
	protected void saveTrialResult() {
		FingerTappingTrialResult trialResult = new FingerTappingTrialResult();
		saveFingerTappingTrialResult(trialResult);
		trialResults.add(trialResult);
	}

	protected void saveFingerTappingTrialResult(FingerTappingTrialResult trialResult) {
		saveMultitrialTrialResult(trialResult);
		trialResult.setHand(hand);
		trialResult.setTapTimes(tapTimes);
		trialResult.setDuration(trialDuration);
	}
	
	@Override
	protected boolean isFinished() {
		return (nTrials == testTotalTrials);
	}

	@Override
	public String getInstructions() {
		return "Tap the space bar to start, and then tap space as quickly as you can. There will be " + testTotalTrials + " " + trialDuration + "-second trials.";
	}
}
