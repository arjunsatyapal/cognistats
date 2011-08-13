package com.google.cognistats.client.gwtui.tests.span;

import java.util.ArrayList;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.span.testwidget.DigitSpanTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.SpanStatistic;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;

public class DigitSpanPresenter extends SpanPresenter implements Presenter {

	protected DigitSpanTestDisplay digitSpanTestWidget;
	protected ArrayList<Integer> currentSequence;
	protected boolean isBackwards;
	protected SpanStatistic spanStatistic;

	public DigitSpanPresenter(DigitSpanTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getSpanTestView(), statPresenter);
		digitSpanTestWidget = testWidget;
		isBackwards = false;
		setupUi();
	}
	
	protected void setBackwards(boolean isBackwards) {
		this.isBackwards = isBackwards;
	}
	
	@Override
	public String getInstructions() {
		return "Repeat the sequence of digits.";
	}

	@Override
	protected void displaySequenceElement(int number) {
		digitSpanTestWidget.setDigit(currentSequence.get(number));
	}

	@Override
	protected void setupReadInput() {
		digitSpanTestWidget.setInputVisible(true);
		digitSpanTestWidget.clearInput();
		super.setupReadInput();
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
	
	public void setupUi() {
		digitSpanTestWidget.setInputVisible(false);
		digitSpanTestWidget.getInputDoneButton().addClickHandler(new ClickHandler() {

		      @Override
		      public void onClick(ClickEvent event) {
		    	  userInputDone();
		      }
		    });
	}
	
	@Override
	protected void setupKeys() {
		super.setupKeys();
		keyMap.put(new Character((char) KeyCodes.KEY_ENTER), 1);
	}

	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == 1) {
			userInputDone();
			return;
		}
		super.keyPressed(keyCode);
	}

	public void userInputDone() {
		StringBuffer correctAnswer = new StringBuffer();
		int i;
		for (i = 0; i < currentSequence.size(); ++i) {
			correctAnswer.append(new Character((char) ('0' + currentSequence.get(i))));
		}
		inputDone(correctAnswer.toString().equals(digitSpanTestWidget.getInputText()));
		digitSpanTestWidget.setInputVisible(false);
	}
	
	@Override
	protected void setDefaultLevel() {
		currentLevel = 3;
	}


}
