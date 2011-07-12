//package com.google.cognistats.client.gwtui.tests.span;
//
//import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
//import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
//import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestDisplay;
//import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
//import com.google.gwt.user.client.Timer;
//
//public class SpanPresenter extends MultitrialPresenter implements Presenter {
//
//	@Override
//	protected void initializeTest() {
//		super.initializeTest();
//	}
//
//	public enum TrialState {
//		BEFORE_STIMULUS_DISPLAY,
//		DURING_STIMULUS_DISPLAY,
//		AFTER_STIMULUS_DISPLAY
//	}
//
//	protected TrialState trialState;
//
//	public SpanPresenter(TSRTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
//		super(testWidget.getMultitrialTestView(), statPresenter);
//	}
//
//	protected int stimulusDisplayDelay() {
//		return 0;
//	}
//
//	@Override
//	protected void startTrial() {
//		super.startTrial();
//		testWidget.setFixationPlusEnabled(true);
//		trialState = TrialState.BEFORE_STIMULUS_DISPLAY;
//		int delay = stimulusDisplayDelay();
//		if (delay > 0) {
//			stimulusDisplayTimer.schedule(delay);
//		}
//		else {
//			startStimulusDisplay();
//		}
//	}
//
//	protected void startStimulusDisplay() {
//		trialState = TrialState.DURING_STIMULUS_DISPLAY;
//		stimulusStartDisplayTime = System.currentTimeMillis();
//		displayStimulus();
//	}
//
//	protected void afterStimulusDisplay() {
//		trialState = TrialState.AFTER_STIMULUS_DISPLAY;
//		stimulusEndDisplayTime = System.currentTimeMillis();
//	}
//
//	protected void displayStimulus() {
//		testWidget.setFixationPlusEnabled(false);
//		afterStimulusDisplay();
//	}
//
//	protected Timer stimulusDisplayTimer = new Timer() {
//		@Override
//		public void run() {
//			startStimulusDisplay();
//		}
//	};
//
//	protected void processResponse() {
//		reactionTime = System.currentTimeMillis() - stimulusEndDisplayTime;
//		if (responseCorrect) {
//			++numCorrectTrials;
//		}
//		else {
//			++numIncorrectTrials;
//		}
//		endTrial();
//	}
//
//	@Override
//	public BaseStatisticWidgetPresenter getStatPresenter() {
//		return super.getStatPresenter();
//	}
//
//	@Override
//	protected void endTrial() {
//		super.endTrial();
//	}
//
//
//}
