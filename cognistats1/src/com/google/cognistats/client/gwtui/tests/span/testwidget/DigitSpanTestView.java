package com.google.cognistats.client.gwtui.tests.span.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DigitSpanTestView extends View implements DigitSpanTestDisplay {
	@UiField
	SpanTestView spanTest;
	
	@UiField Label digitLabel;
	
	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, DigitSpanTestView> {
	}

	public DigitSpanTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {		
	}

	@Override
	public SpanTestView getSpanTestView() {
		return spanTest;
	}

	@Override
	public void digitOff() {
		digitLabel.setText("");
	}

	@Override
	public void setDigit(int digit) {
		digitLabel.setText(new Integer(digit).toString());
	}


}
