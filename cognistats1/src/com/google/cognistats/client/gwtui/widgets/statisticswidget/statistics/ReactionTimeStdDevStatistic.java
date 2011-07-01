package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;

public class ReactionTimeStdDevStatistic extends Statistic {
	
	public ReactionTimeStdDevStatistic(double value) {
		formatted = format(value);
		numberFormat = NumberFormat.getDecimalFormat();
	}
	
	protected String format(double value) {
		return numberFormat.format(value) + " ms";
	}

}
