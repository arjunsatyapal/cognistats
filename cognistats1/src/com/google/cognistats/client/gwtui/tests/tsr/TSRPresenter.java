package com.google.cognistats.client.gwtui.tests.tsr;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.multitrial.MultitrialPresenter;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestDisplay;

public class TSRPresenter extends MultitrialPresenter implements Presenter {

	protected int nTrials;
	
	public TSRPresenter(TSRTestDisplay testWidget, BaseStatisticsDisplay statisticsWidget) {
		super(testWidget.getMultitrialTestView(), statisticsWidget);
	}

	
}
