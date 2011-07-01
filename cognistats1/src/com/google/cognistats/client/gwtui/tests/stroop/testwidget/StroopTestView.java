package com.google.cognistats.client.gwtui.tests.stroop.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;
import com.google.cognistats.client.gwtui.tests.stroop.StroopColor;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;

public class StroopTestView extends View implements StroopTestDisplay {
	@UiField
	TSRTestView tsrTest;
	@UiField Label stroopLabel;
	
	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, StroopTestView> {
	}

	public StroopTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {		
	}


	@Override
	public TSRTestView getTSRTestView() {
		return tsrTest;
	}

	@Override
	public void setWordAndColor(String word, StroopColor color) {
		stroopLabel.setText(word);
		stroopLabel.setStyleName(color.getName());
	}

	@Override
	public void setWordVisible(boolean visible) {
		stroopLabel.setVisible(visible);
		
	}


}
