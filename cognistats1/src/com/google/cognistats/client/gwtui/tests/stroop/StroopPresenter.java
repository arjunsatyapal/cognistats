package com.google.cognistats.client.gwtui.tests.stroop;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.stroop.testwidget.StroopTestDisplay;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;

public class StroopPresenter extends TSRPresenter implements Presenter {

	protected boolean isConcordant;
	protected StroopTestDisplay stroopTestWidget;
	
	public StroopPresenter(StroopTestDisplay testWidget, BaseStatisticsDisplay statisticsWidget) {
		super(testWidget.getTSRTestView(), statisticsWidget);
		stroopTestWidget = testWidget;
	}
	
	@Override
	protected void startTrial() {
		super.startTrial();
	}
	
	@Override
	protected void displayStimulus() {
		//testWidget.setFixationPlusEnabled(false);
		stroopTestWidget.setWordVisible(true);
		afterStimulusDisplay();
	}
	
}
