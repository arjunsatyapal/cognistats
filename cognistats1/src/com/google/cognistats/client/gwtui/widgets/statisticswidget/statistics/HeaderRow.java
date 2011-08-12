package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.HEADER_ROW;

public class HeaderRow extends BaseStatisticGridRow {

	public HeaderRow() {
		super(HEADER_ROW);
		setCurrentTrialColumn("Current Trial");
		setCurrentTestColumn("Current Test");
		setAllTimeColumn("All Time");
	}

}
