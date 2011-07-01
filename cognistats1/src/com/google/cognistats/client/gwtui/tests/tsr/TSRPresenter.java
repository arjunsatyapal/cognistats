package com.google.cognistats.client.gwtui.tests.tsr;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestDisplay;
import com.google.gwt.user.client.Timer;

public class TSRPresenter extends MultitrialPresenter implements Presenter {

	protected int nTrials;
	protected long stimulusDisplayTime;
	protected boolean stimulusDisplayed;
	
	public TSRPresenter(TSRTestDisplay testWidget, BaseStatisticsDisplay statisticsWidget) {
		super(testWidget.getMultitrialTestView(), statisticsWidget);
	}
	
	protected int stimulusDisplayDelay() {
		return 0;
	}
	
	@Override
	protected void startTrial() {
		super.startTrial();
		stimulusDisplayTimer.schedule(stimulusDisplayDelay());
	}

	protected void displayStimulus() {}

	protected Timer stimulusDisplayTimer = new Timer() {
		@Override
		public void run() {
			displayStimulus();
			stimulusDisplayed = true;
			stimulusDisplayTime = System.currentTimeMillis();
		}
	};
	

	
}
