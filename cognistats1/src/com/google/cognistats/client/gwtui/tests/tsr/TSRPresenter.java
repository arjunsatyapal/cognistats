package com.google.cognistats.client.gwtui.tests.tsr;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestDisplay;
import com.google.gwt.user.client.Timer;

public class TSRPresenter extends MultitrialPresenter implements Presenter {

	protected int nTrials;
	protected long stimulusStartDisplayTime, stimulusEndDisplayTime;

	public enum TrialState {
		BEFORE_STIMULUS_DISPLAY,
		DURING_STIMULUS_DISPLAY,
		AFTER_STIMULUS_DISPLAY
	}
	
	protected TrialState trialState;
	
	public TSRPresenter(TSRTestDisplay testWidget, BaseStatisticsDisplay statisticsWidget) {
		super(testWidget.getMultitrialTestView(), statisticsWidget);
	}
	
	protected int stimulusDisplayDelay() {
		return 0;
	}
	
	@Override
	protected void startTrial() {
		super.startTrial();
		trialState = TrialState.BEFORE_STIMULUS_DISPLAY;
		int delay = stimulusDisplayDelay();
		if (delay > 0) {
			stimulusDisplayTimer.schedule(delay);
		}
		else {
			startStimulusDisplay();
		}
	}
	
	protected void startStimulusDisplay() {
		trialState = TrialState.DURING_STIMULUS_DISPLAY;
		stimulusStartDisplayTime = System.currentTimeMillis();
		displayStimulus();
	}

	protected void afterStimulusDisplay() {
		trialState = TrialState.AFTER_STIMULUS_DISPLAY;
		stimulusEndDisplayTime = System.currentTimeMillis();
	}

	protected void displayStimulus() {
		afterStimulusDisplay();
	}
	
	protected Timer stimulusDisplayTimer = new Timer() {
		@Override
		public void run() {
			startStimulusDisplay();
		}
	};
	

	
}
