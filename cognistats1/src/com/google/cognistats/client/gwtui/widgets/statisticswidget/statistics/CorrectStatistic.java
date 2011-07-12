package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum;

public class CorrectStatistic extends BaseStatisticGridRow {

	NumberFormat numberFormat;

	public CorrectStatistic(RowNamesEnum name) {
		super(name);

		// For a correct ratio, i.e. 0.95
		numberFormat = NumberFormat.getPercentFormat();
	}

	public void setTrialCorrect(boolean correct) {
		if (correct) {
			setCurrentTrialColumn("<span style=\"color: green;\">✓</span>");
		}
		else {
			setCurrentTrialColumn("<span style=\"color: red;\">×</span>");
		}
	}

	public void setTestCorrect(double fraction) {
		setCurrentTestColumn(format(fraction));
	}

	protected String format(double value) {
		return numberFormat.format(value);
	}
}
