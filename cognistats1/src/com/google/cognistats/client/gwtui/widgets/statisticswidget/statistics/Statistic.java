package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;

public class Statistic {

	protected String formatted;
	protected NumberFormat numberFormat;

	public String getFormatted() {
		return formatted;
	}
	
	protected String format(String value) {
		return value;
	}

}
