package com.google.cognistats.client.gwtui.tests.span;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.levelestimation.LevelEstimationPresenter;
import com.google.cognistats.client.gwtui.tests.results.SpanTrialResult;
import com.google.cognistats.client.gwtui.tests.span.testwidget.SpanTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.CorrectStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.SpanStatistic;
import com.google.gwt.user.client.Timer;

public class SpanPresenter extends LevelEstimationPresenter implements Presenter {

	protected int delayBetweenSequenceElements;
	protected int delayBeforeFirstSequenceElement;
	protected int sequenceElementOnTime;
	protected boolean elementOn;
	int currentlyDisplayedElement;
	int currentSequenceLength;
	protected SpanStatistic spanStatistic;
	protected CorrectStatistic correctStatistic;

	@Override
	protected void initializeTest() {
		super.initializeTest();
		sequenceElementOnTime = 1000;
		delayBeforeFirstSequenceElement = 1000;
		delayBetweenSequenceElements = 500;
	}

	protected void setDefaultLevel() {
		currentLevel = 7;
	}
	
	public SpanPresenter(SpanTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getLevelEstimationTestView(), statPresenter);
	}

	protected void saveTrialResult() {
		SpanTrialResult trialResult = new SpanTrialResult();
		saveSpanTrialResult(trialResult);
		trialResults.add(trialResult);
	}

	protected void saveSpanTrialResult(SpanTrialResult trialResult) {
		saveLevelEstimationTrialResult(trialResult);
	}
	
	protected void setupSequenceDisplay() {
		elementOn = false;
		currentlyDisplayedElement = 0;
		elementDisplayTimer.schedule(delayBeforeFirstSequenceElement);
	}
	
	protected void displaySequenceElement(int number) {
	}

	@Override
	protected void displayStimulus() {
		setupSequenceDisplay();
	}
	
	protected Timer elementDisplayTimer = new Timer() {
		@Override
		public void run() {
			displayNextElement();
		}
	};
	
	protected void displayNextElement() {
		if (elementOn) {
			hideSequenceElement();
			elementOn = false;
			++currentlyDisplayedElement;
			elementDisplayTimer.schedule(delayBetweenSequenceElements);
			return;
		}
		if (currentlyDisplayedElement >= currentSequenceLength) {
			afterStimulusDisplay();
		}
		else {
			displaySequenceElement(currentlyDisplayedElement);
			elementOn = true;
			elementDisplayTimer.schedule(sequenceElementOnTime);
		}
	}
	
	protected void setupReadInput() {
	}
	
	@Override
	protected void afterStimulusDisplay() {
		super.afterStimulusDisplay();
		setupReadInput();
	}
	
	protected void inputDone(boolean responseCorrect) {
		this.responseCorrect = responseCorrect;
		correctStatistic.setTrialCorrect(responseCorrect);
		processResponse();
	}
	
	protected void hideSequenceElement() {
	}

	protected void createTrial() {
		currentSequenceLength = currentLevel;
		generateSequence(currentSequenceLength);
	}
	
	@Override
	protected void startTrial() {
		createTrial();
		spanStatistic.setTrialSpan(currentLevel);
		setupSequenceDisplay();
		super.startTrial();
	}

	protected void generateSequence(int sequenceSize) {
	}

	@Override
	protected void initializeStatistics() {
		super.initializeStatistics();
		spanStatistic = new SpanStatistic();
		statPresenter.addRow(spanStatistic);
		correctStatistic = new CorrectStatistic(RowNamesEnum.CORRECT_ROW);
		statPresenter.addRow(correctStatistic);
	}
	
}
