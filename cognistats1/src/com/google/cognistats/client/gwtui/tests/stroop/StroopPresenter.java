package com.google.cognistats.client.gwtui.tests.stroop;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.aggregator.BernoulliAggregator;
import com.google.cognistats.client.gwtui.tests.aggregator.MeanVarianceAggregator;
import com.google.cognistats.client.gwtui.tests.stroop.testwidget.StroopTestDisplay;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.CorrectStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.ReactionTimeStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum;
import com.google.gwt.core.client.GWT;

public class StroopPresenter extends TSRPresenter implements Presenter {

	protected MeanVarianceAggregator overallRTAggregator, concordantRTAggregator, discordantRTAggregator;
	protected BernoulliAggregator overallCorrectAggregator, concordantCorrectAggregator, discordantCorrectAggregator;
	protected ReactionTimeStatistic overallReactionTimeStatistic, concordantReactionTimeStatistic, discordantReactionTimeStatistic;
	protected CorrectStatistic overallCorrectStatistic, concordantCorrectStatistic, discordantCorrectStatistic;
	protected boolean isConcordant, isTaskColor, trialReady;
	protected StroopTestDisplay stroopTestWidget;
	protected int wordColorIndex, wordNameIndex;
	protected StroopColor wordName, wordColor;
	protected static final int TRIAL_START_DELAY = 1000;
	protected static final int NUM_SUBPART_TRIALS = 5;
	protected static final int NUM_COLORS = 3;
	protected int subTestOrder[];
	protected int testPart, testPartIndex, testSubPartIndex;
	protected int subPartTrialsLeft;
	protected int userResponse;
	protected boolean testFinished;
	protected boolean newTestPart;
	protected static final String TEST_PART_NAMES[] = {
		"Inhibition",
		"Context switching",
		"Mixed"
	};

	protected static final String TEST_TASK_NAMES[] = {
		"Word",
		"Color"
	};

	public StroopPresenter(StroopTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getTSRTestView(), statPresenter);
		stroopTestWidget = testWidget;
	}

	protected void setupKeys() {
		super.setupKeys();
		int i,j;
		for (i = 0; i < StroopColor.values().length; ++i) {
			StroopColor color = StroopColor.values()[i];
			GWT.log("setting up keys for color: " + color.getName());
			for (j = 0; j < color.getKeys().length; ++j) {
				keyMap.put(new Character(color.getKeys()[j]), new Integer(i+1));
			}
		}
	}

	@Override
	protected int stimulusDisplayDelay() {
		return TRIAL_START_DELAY;
	}

	@Override
	protected void startTrial() {
		stroopTestWidget.setWordVisible(false);
		createTrial();
		super.startTrial();
	}

	protected void chooseSubTestOrder() {
		subTestOrder = new int[3];
		int i = getGenerator().nextInt(6);
		subTestOrder[0] = i % 3;
		i = i / 3;
		subTestOrder[1] = i;
		if (subTestOrder[1] == subTestOrder[0]) {
			subTestOrder[1]++;
		}
		for (subTestOrder[2] = 0; (subTestOrder[2] == subTestOrder[0]) || (subTestOrder[2] == subTestOrder[1]); ++subTestOrder[2]);
	}

	protected void createTrial() {
		switch (testPart) {
			case 0:
				// No randomization, leave as is
				trialReady = false;
				break;
			case 1:
				isConcordant = false;
				trialReady = false;
				isTaskColor = getGenerator().nextBoolean();
				break;
			case 2:
				isTaskColor = getGenerator().nextBoolean();
				wordColorIndex = getGenerator().nextInt(NUM_COLORS);
				wordNameIndex = getGenerator().nextInt(NUM_COLORS);
				isConcordant = (wordColorIndex == wordNameIndex);
				trialReady = true;
		}
		if (!trialReady) {
			wordColorIndex = getGenerator().nextInt(NUM_COLORS);
			if (isConcordant) {
				wordNameIndex = wordColorIndex;
			}
			else {
				wordNameIndex = getGenerator().nextInt(NUM_COLORS-1);
				if (wordNameIndex == wordColorIndex) {
					++wordNameIndex;
				}
			}
		}
		wordName = StroopColor.byNumber(wordNameIndex);
		wordColor = StroopColor.byNumber(wordColorIndex);
	}

	protected String testPartName() {
		return TEST_PART_NAMES[testPart];
	}

	protected String taskName() {
		return TEST_TASK_NAMES[isTaskColor ? 1 : 0];
	}

	@Override
	protected void displayStimulus() {
		testWidget.setFixationPlusEnabled(false);
		StringBuffer instructionsText = new StringBuffer();
		instructionsText.append("Test part: ");
		instructionsText.append(testPartIndex);
		instructionsText.append("; ");
		instructionsText.append("Test type: ");
		instructionsText.append(testPartName());
		instructionsText.append("; ");
		instructionsText.append("Subpart trials left: ");
		instructionsText.append(subPartTrialsLeft);
		instructionsText.append("; ");
		instructionsText.append("Concordant? ");
		instructionsText.append(isConcordant);
		instructionsText.append("; ");
		instructionsText.append("Task: ");
		instructionsText.append(taskName());
		instructionsText.append("; ");
		stroopTestWidget.setTrialInstructions(instructionsText.toString());
		stroopTestWidget.setWordAndColor(wordName.getName(), wordColor);
		stroopTestWidget.setWordVisible(true);
		afterStimulusDisplay();
	}

	@Override
	protected void initializeTest() {
		overallCorrectAggregator = new BernoulliAggregator();
		concordantCorrectAggregator = new BernoulliAggregator();
		discordantCorrectAggregator = new BernoulliAggregator();
		overallRTAggregator = new MeanVarianceAggregator();
		concordantRTAggregator = new MeanVarianceAggregator();
		discordantRTAggregator = new MeanVarianceAggregator();
		chooseSubTestOrder();
		testFinished = false;
		testPartIndex = 0;
		initializeTestPart();
		super.initializeTest();
	}

	protected void initializeTestPart() {
		testPart = subTestOrder[testPartIndex];
		switch (testPart) {
		case 0:
			testSubPartIndex = 0;
			setSubPartParameters();
			break;
		case 1:
			subPartTrialsLeft = 6*NUM_SUBPART_TRIALS;
			break;
		case 2:
			subPartTrialsLeft = 6*NUM_SUBPART_TRIALS;
			break;
		}
	}

	protected void setSubPartParameters() {
		switch (testSubPartIndex) {
		case 0:
			isConcordant = true;
			isTaskColor = false;
			subPartTrialsLeft = NUM_SUBPART_TRIALS;
			break;
		case 1:
			isConcordant = false;
			isTaskColor = false;
			subPartTrialsLeft = 2*NUM_SUBPART_TRIALS;
			break;
		case 2:
			isConcordant = true;
			isTaskColor = true;
			subPartTrialsLeft = NUM_SUBPART_TRIALS;
			break;
		case 3:
			isConcordant = false;
			isTaskColor = true;
			subPartTrialsLeft = 2*NUM_SUBPART_TRIALS;
			break;
		}
	}

	@Override
	protected void endTrial() {
		if (--subPartTrialsLeft == 0) {
			newTestPart = false;
			if (testPart == 0) {
				if (++testSubPartIndex == 4) {
					++testPartIndex;
					newTestPart = true;
				}
				else {
					setSubPartParameters();
				}
			}
			else {
				++testPartIndex;
				newTestPart = true;
			}
			if (newTestPart) {
				if (testPartIndex == 3) {
					testFinished = true;
				}
				else {
					testPart = subTestOrder[testPartIndex];
					initializeTestPart();
				}
			}
		}
		super.endTrial();
	}

	@Override
	protected boolean isFinished() {
		return testFinished;
	}

	@Override
	public Display getTestView() {
		return stroopTestWidget;
	}

	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode > 0) {
			if (trialState == TrialState.BEFORE_STIMULUS_DISPLAY) {
				stroopTestWidget.setCommentText("Patience!");
				return;
			}
			if (testFinished) {
				return;
			}
			userResponse = keyCode - 1;
			processResponse();
			return;
		}
		super.keyPressed(keyCode);
	}

	@Override
	protected void processResponse() {
		if (isTaskColor) {
			responseCorrect = (userResponse == wordColorIndex);
		}
		else {
			responseCorrect = (userResponse == wordNameIndex);
		}
		super.processResponse();
		overallCorrectAggregator.add(responseCorrect);
		overallCorrectStatistic.setTrialCorrect(responseCorrect);
		overallCorrectStatistic.setTestCorrect(overallCorrectAggregator.getFraction());
		if (responseCorrect) {
			overallRTAggregator.add(reactionTime);
			overallReactionTimeStatistic.setTrialReactionTime(reactionTime);
			overallReactionTimeStatistic.setTestReactionTime(overallRTAggregator.mean(), overallRTAggregator.variance());
		}
		if (isConcordant) {
			concordantCorrectAggregator.add(responseCorrect);
			concordantCorrectStatistic.setTrialCorrect(responseCorrect);
			concordantCorrectStatistic.setTestCorrect(concordantCorrectAggregator.getFraction());
			discordantCorrectStatistic.clearTrial();
			discordantReactionTimeStatistic.clearTrial();
			if (responseCorrect) {
				concordantRTAggregator.add(reactionTime);
				concordantReactionTimeStatistic.setTrialReactionTime(reactionTime);
				concordantReactionTimeStatistic.setTestReactionTime(concordantRTAggregator.mean(), concordantRTAggregator.variance());
			}
			else {
				concordantReactionTimeStatistic.clearTrial();
			}
		}
		else {
			discordantCorrectAggregator.add(responseCorrect);
			discordantCorrectStatistic.setTrialCorrect(responseCorrect);
			discordantCorrectStatistic.setTestCorrect(discordantCorrectAggregator.getFraction());
			concordantCorrectStatistic.clearTrial();
			concordantReactionTimeStatistic.clearTrial();
			if (responseCorrect) {
				discordantRTAggregator.add(reactionTime);
				discordantReactionTimeStatistic.setTrialReactionTime(reactionTime);
				discordantReactionTimeStatistic.setTestReactionTime(discordantRTAggregator.mean(), discordantRTAggregator.variance());
			}
			else {
				discordantReactionTimeStatistic.clearTrial();
			}
		}
		if (responseCorrect) {
			stroopTestWidget.setCommentText("Correct! RT = " + reactionTime);
		}
		else {
			stroopTestWidget.setCommentText("Incorrect! RT = " + reactionTime);
		}
	}

	@Override
	public BaseStatisticWidgetPresenter getStatPresenter() {
		return super.getStatPresenter();
	}

	@Override
	protected void initializeStatistics() {
		super.initializeStatistics();
		overallReactionTimeStatistic = new ReactionTimeStatistic();
		concordantReactionTimeStatistic = new ReactionTimeStatistic();
		discordantReactionTimeStatistic = new ReactionTimeStatistic();
		overallReactionTimeStatistic.setName(RowNamesEnum.OVERALL_REACTION_TIME_ROW);
		concordantReactionTimeStatistic.setName(RowNamesEnum.CONCORDANT_REACTION_TIME_ROW);
		discordantReactionTimeStatistic.setName(RowNamesEnum.DISCORDANT_REACTION_TIME_ROW);
		overallCorrectStatistic = new CorrectStatistic(RowNamesEnum.OVERALL_CORRECT_ROW);
		concordantCorrectStatistic = new CorrectStatistic(RowNamesEnum.CONCORDANT_CORRECT_ROW);
		discordantCorrectStatistic = new CorrectStatistic(RowNamesEnum.DISCORDANT_CORRECT_ROW);
		statPresenter.addRow(overallReactionTimeStatistic);
		statPresenter.addRow(overallCorrectStatistic);
		statPresenter.addRow(concordantReactionTimeStatistic);
		statPresenter.addRow(concordantCorrectStatistic);
		statPresenter.addRow(discordantReactionTimeStatistic);
		statPresenter.addRow(discordantCorrectStatistic);
	}

}
