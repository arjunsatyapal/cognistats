package com.google.cognistats.client.gwtui.tests.basetest.statisticswidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;

public interface BaseTestStatisticsDisplay extends Display {
	public void setTestTimeCurrent(long timeInMillis);
	public void setTestTimeAllTime(long timeInMillis);
}
