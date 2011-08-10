package com.google.cognistats.client.gwtui.tests.span.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;

public interface DigitSpanTestDisplay extends Display {
	SpanTestView getSpanTestView();
	
	void digitOff();
	void setDigit(int digit);
}
