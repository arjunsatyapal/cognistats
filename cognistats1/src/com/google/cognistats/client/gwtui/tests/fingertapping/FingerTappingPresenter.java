package com.google.cognistats.client.gwtui.tests.fingertapping;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.fingertapping.testwidget.FingerTappingTestDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;

public class FingerTappingPresenter extends MultitrialPresenter implements
		Presenter {

	protected FingerTappingTestDisplay fingerTappingTestWidget;
	protected int pressCount = 0;
	protected long trialStartTime;
	protected boolean trialRunning = false;
	protected static final int testTotalTrials = 3;
	protected static final int trialDuration = 10;
	
	public FingerTappingPresenter(FingerTappingTestDisplay testWidget,
			BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getMultiTrialTestView(), statPresenter);
		this.fingerTappingTestWidget = testWidget;
	}

	@Override
	protected void setupKeys() {
		super.setupKeys();
		keyMap.put(' ', 1);
	}

	protected void prepareToStartTrial() {
		// set a timer here to startTrial() after a second
		startTrial();
	}
	
	@Override
	protected void startTrial() {
		fingerTappingTestWidget.setInstructionsVisible(true);
		super.startTrial();
	}
	
	protected void reallyStartTrial() {
		trialStartTime = System.currentTimeMillis();
		fingerTappingTestWidget.setInstructionsVisible(false);
		fingerTappingTestWidget.setTimeAndCountVisible(true);
	}
	
	@Override
	protected void endTrial() {
	    ++nTrials;
	    trialRunning = false;
	    fingerTappingTestWidget.setTimeAndCountVisible(false);
	    if (!isFinished()) {
	      prepareToStartTrial();
	    }
	}
	
	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == 1 && !isFinished()) {
			if(!trialRunning)
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
	protected boolean isFinished() {
		return (nTrials == testTotalTrials);
	}

	@Override
	public String getInstructions() {
		return "Press the space bar to start, and then press space as quickly as you can. There will be multiple trials.";
	}
}
