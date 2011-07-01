package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

public class TrialStatistic extends Statistic {

	public TrialStatistic(int value, int total) {
		formatted = format(value, total);
	}
	
	protected String format(int value, int total) {
		return Integer.toString(value) + " / " + Integer.toString(total);
	}
}
