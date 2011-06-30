package com.google.cognistats.client.gwtui.tests.base.statisticswidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;

public class BaseStatisticsView extends Composite implements BaseStatisticsDisplay {

	private static BaseTestResultViewUiBinder uiBinder = GWT
			.create(BaseTestResultViewUiBinder.class);
	@UiField Label labelTimeCurrentSession;
	@UiField Label labelTimeAllTime;

	interface BaseTestResultViewUiBinder extends
			UiBinder<Widget, BaseStatisticsView> {
	}

	public BaseStatisticsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
	}
	
	protected String zeroPadding(long number, int padding) {
		String s = Long.toString(number);
		while (s.length() < padding) {
			s = "0" + s;
		}
		return s;
	}
	
	protected String formatTime(long timeInMillis, boolean withMillis) {
		long hours = timeInMillis / 3600000;
		timeInMillis = timeInMillis % 3600000;
		long minutes = timeInMillis / 60000;
		timeInMillis = timeInMillis % 60000;
		long seconds = timeInMillis / 1000;
		timeInMillis = timeInMillis % 1000;
		String s = Long.toString(hours) + ":" + zeroPadding(minutes, 2) + ":" + zeroPadding(seconds, 2);
		if (withMillis) {
			s = s + "." + zeroPadding(timeInMillis, 3);
		}
		return s;
	}

	@Override
	public void setTestTimeCurrent(long timeInMillis) {
		labelTimeCurrentSession.setText(formatTime(timeInMillis, true));		
	}

	@Override
	public void setTestTimeAllTime(long timeInMillis) {
		labelTimeAllTime.setText(formatTime(timeInMillis, false));
	}

}
