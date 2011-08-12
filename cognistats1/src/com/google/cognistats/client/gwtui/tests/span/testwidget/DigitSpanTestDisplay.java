package com.google.cognistats.client.gwtui.tests.span.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.gwt.user.client.ui.Button;

public interface DigitSpanTestDisplay extends Display {
	SpanTestView getSpanTestView();
	
	void digitOff();
	void setDigit(int digit);
	void setInputVisible(boolean visible);
	void clearInput();
	Button getInputDoneButton();
	String getInputText();
}
