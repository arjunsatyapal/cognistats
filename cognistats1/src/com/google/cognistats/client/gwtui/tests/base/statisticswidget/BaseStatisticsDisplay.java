package com.google.cognistats.client.gwtui.tests.base.statisticswidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;

public interface BaseStatisticsDisplay extends Display {
	public void setTestTimeCurrent(long timeInMillis);
	public void setTestTimeAllTime(long timeInMillis);
}
