package com.google.cognistats.client.gwtui.tests.levelestimation;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.levelestimation.testwidget.LevelEstimationTestDisplay;
import com.google.cognistats.client.gwtui.tests.results.LevelEstimationTrialResult;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;

public class LevelEstimationPresenter extends TSRPresenter implements Presenter {

	protected int currentLevel;
	protected double targetFractionCorrect;
	
	// If you get a trial correct, with probability pIncrease we increase the level.
	// If you get a trial incorrect, with probability pDecrease we decrease the level.
	// We want pIncrease and pDecrease to be such that:
	// pIncrease * p(success) = pDecrease * (1 - p(success))
	// p(success) (pIncrease + pDecrease) = pDecrease
	// We set pIncrease + pDecrease = 1 to get:
	// pDecrease = p(success), pIncrease = 1 - p(success)
	
	protected void setCurrentLevel() {
		if ((numCorrectTrials > 0) && (numIncorrectTrials > 0)) {
			double u = getGenerator().nextDouble();
			if (responseCorrect) {
				if (u < (1 - targetFractionCorrect)) {
					increaseLevel();
				}
			}
			else {
				if (u < targetFractionCorrect) {
					decreaseLevel();
				}
			}
		}
		else {
			if (numCorrectTrials > 0) {
				increaseLevel();
			}
			else {
				if (numIncorrectTrials > 0) {
					decreaseLevel();
				}
				else {
					setDefaultLevel();
				}
			}
		}
	}

	@Override
	protected void initializeTest() {
		super.initializeTest();
		targetFractionCorrect = 0.5;
		initializeLevel();
	}
	
	protected void initializeLevel() {
		// TODO: read level from config, otherwise default
		setDefaultLevel();
	}

	protected void setDefaultLevel() {
		currentLevel = 0;
	}
	
	protected void increaseLevel() {
		++currentLevel;
	}
	
	protected void decreaseLevel() {
		--currentLevel;
	}

	public LevelEstimationPresenter(LevelEstimationTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getTSRTestView(), statPresenter);
	}

	@Override
	protected void endTrial() {
		super.endTrial();
		setCurrentLevel();
	}

	protected void saveTrialResult() {
		LevelEstimationTrialResult trialResult = new LevelEstimationTrialResult();
		saveLevelEstimationTrialResult(trialResult);
		trialResults.add(trialResult);
	}

	protected void saveLevelEstimationTrialResult(LevelEstimationTrialResult trialResult) {
		saveTSRTrialResult(trialResult);
	}

}
