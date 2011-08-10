package com.google.cognistats.client.gwtui.tests.fingertapping;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.fingertapping.testwidget.FingerTappingTestDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.ReactionTimeStatistic;
import com.google.gwt.core.client.GWT;

public class FingerTappingPresenter extends MultitrialPresenter implements
		Presenter {

	protected FingerTappingTestDisplay fingerTappingTestWidget;
	protected int pressCount = 0;
	protected long trialStartTime;
	protected ReactionTimeStatistic reactionTimeStatistic;
	protected boolean keyIsUp = true;
	protected static final int testTotalTrials = 3;
	protected static final int trialDuration = 10;
	
	public FingerTappingPresenter(FingerTappingTestDisplay testWidget,
			BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getMultiTrialTestView(), statPresenter);
		this.fingerTappingTestWidget = testWidget;
	}
	
	@Override
	public Display getTestView() {
		return fingerTappingTestWidget;
	}
	
	@Override
	protected void initializeStatistics() {
	  super.initializeStatistics();
	  reactionTimeStatistic = new ReactionTimeStatistic();
	  statPresenter.addRow(reactionTimeStatistic);
	}

	@Override
	protected void setupKeys() {
		super.setupKeys();
		keyMap.put(' ', 1);
	}

	@Override
	protected void startTrial() {
		// set a timer here to startTrialAlmost() after a second
		startTrialAlmost();
	}
	
	protected void startTrialAlmost() {
		fingerTappingTestWidget.setInstructionsVisible(true);
	}
	
	protected void reallyStartTrial() {
		fingerTappingTestWidget.setInstructionsVisible(false);
		fingerTappingTestWidget.setTimeAndCountVisible(true);
		pressCount = 0;
		super.startTrial();
	}
	
	@Override
	protected void endTrial() {
	    fingerTappingTestWidget.setTimeAndCountVisible(false);
		super.endTrial();
	}
	
	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == 1 && !isFinished() && keyIsUp) {
			keyIsUp = false;
			if (!isTrialRunning)
				reallyStartTrial();
			else {
				pressCount += 1;
				fingerTappingTestWidget.setCount(pressCount);
			}
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
			fingerTappingTestWidget.setTime((int)(trialTime / 1000));
			if (trialTime > trialDuration * 1000)
				endTrial();
		}
	}

	@Override
	protected boolean isFinished() {
		return (nTrials == testTotalTrials);
	}

	@Override
	public String getInstructions() {
		return "Press the space bar to start, and then press space as quickly as you can. There will be multiple trials.";
	}
}
