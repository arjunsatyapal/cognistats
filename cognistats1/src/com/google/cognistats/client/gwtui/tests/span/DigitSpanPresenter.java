package com.google.cognistats.client.gwtui.tests.span;

import java.util.ArrayList;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.span.testwidget.DigitSpanTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.gwt.core.client.GWT;

public class DigitSpanPresenter extends SpanPresenter implements Presenter {

	protected DigitSpanTestDisplay digitSpanTestWidget;
	protected ArrayList<Integer> currentSequence;

	public DigitSpanPresenter(DigitSpanTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getSpanTestView(), statPresenter);
		digitSpanTestWidget = testWidget;
	}
	
	@Override
	public String getInstructions() {
		return "Repeat the sequence of digits.";
	}

	@Override
	protected void displaySequenceElement(int number) {
		digitSpanTestWidget.setDigit(currentSequence.get(number));
		GWT.log("displaying " + number);
	}

	@Override
	protected void generateSequence(int sequenceSize) {
		currentSequence = new ArrayList<Integer>(sequenceSize);
		int i;
		for (i = 0; i < sequenceSize; ++i) {
			int newElement = getGenerator().nextInt(8)+1;
			if (newElement == 7) {
				newElement = 9;
			}
			currentSequence.add(newElement);
		}
	}

	@Override
	protected void hideSequenceElement() {
		digitSpanTestWidget.digitOff();
	}

	@Override
	public Display getTestView() {
		return digitSpanTestWidget;
	}
}
