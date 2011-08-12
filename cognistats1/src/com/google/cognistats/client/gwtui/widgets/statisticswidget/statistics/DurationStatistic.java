package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.DURATION_ROW;

import com.google.gwt.i18n.client.NumberFormat;

public class DurationStatistic extends BaseStatisticGridRow {
	protected NumberFormat numberFormat;
	
	public DurationStatistic() {
		super(DURATION_ROW);
		numberFormat = NumberFormat.getFormat("00");
	}

	protected String format(long value) {
		if(value <= 0)
			return "";
		value = (long) (value / 1000);
		int seconds = (int) (value % 60);
		int minutes = (int) (value / 60 % 60);
		int hours = (int) (value / 3600 % 24);
		int days = (int) (value / 86400);

		StringBuilder sb = new StringBuilder();
		if (days > 0) {
			sb.append(days);
			sb.append(":");
		}
		if (hours > 0) {
			if (days > 0)
				sb.append(numberFormat.format(hours));
			else
				sb.append(hours);
			sb.append(":");
		}
		if (hours > 0)
			sb.append(numberFormat.format(minutes));
		else
			sb.append(minutes);
		sb.append(":");
		sb.append(numberFormat.format(seconds));
		return sb.toString();
	}

	public void setCurrTrialTimeInMillis(long currTrialTimeInMillis) {
		setCurrentTrialColumn(format(currTrialTimeInMillis));
	}

	public void setTestTimeInMillis(long testTimeInMillis) {
		setCurrentTestColumn(format(testTimeInMillis));
	}

	public void setAllTimeTimeInMillis(long allTimeTimeInMillis) {
		setCurrentTestColumn(format(allTimeTimeInMillis));
	}
}
