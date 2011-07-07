package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;

public class ReactionTimeStatistic extends Statistic {
	
	public ReactionTimeStatistic(double value) {
		numberFormat = NumberFormat.getDecimalFormat();
		formatted = format(value);
	}
	
	protected String format(double value) {
		return numberFormat.format(value) + " ms";
	}

}