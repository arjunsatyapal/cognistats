package com.google.cognistats.client.gwtui.tests.multitrial;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.base.BasePresenter;
import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestDisplay;

public class MultitrialPresenter extends BasePresenter implements Presenter {

	protected int nTrials;
	
	public MultitrialPresenter(MultitrialTestDisplay testWidget, BaseStatisticsDisplay statisticsWidget) {
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
