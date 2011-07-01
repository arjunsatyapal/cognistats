package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;

public class TrialStatistic extends Statistic {

	public TrialStatistic(long value) {
		formatted = format(value);
		numberFormat = NumberFormat.getFormat("00");
	}
	
	protected String format(long value) {
		value = (long) (value / 1000);
		int seconds = (int) (value % 60);
		int minutes = (int) (value / 60 % 60);
		int hours = (int) (value / 3600 % 24);
		int days = (int) (value / 86400);
		
		StringBuilder sb = new StringBuilder();
		if(days > 0) {
			sb.append(days);
			sb.append(":");
		}
		if(hours > 0) {
			if(days > 0)
				sb.append(numberFormat.format(hours));
			else
				sb.append(hours);
			sb.append(":");
		}
		if(hours > 0)
			sb.append(numberFormat.format(minutes));
		else
			sb.append(minutes);
		sb.append(":");
		sb.append(numberFormat.format(seconds));
		return sb.toString();
	}
}
