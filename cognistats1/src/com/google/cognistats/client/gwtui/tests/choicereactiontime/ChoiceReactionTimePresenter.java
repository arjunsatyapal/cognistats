package com.google.cognistats.client.gwtui.tests.choicereactiontime;

import java.util.LinkedList;
import java.util.Random;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultDisplay;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusDisplay;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class ChoiceReactionTimePresenter implements TestPresenter {

	protected int nTrials;
	protected static int totalNumTrials = 50;
	protected static int randomSeed = 0;
	protected static int numChoices = 3;
	protected static int delayLambda = 500;
	protected static int constantDelay = 250;
	protected int currentDelay;
	protected ChoiceReactionTimeStimulusDisplay stimulusWidget;
	protected ChoiceReactionTimeResultDisplay resultWidget;
	protected Random generator = new Random();
	protected int currentChoice;
	protected long t0, t1, t2;
	protected boolean stimulusDisplayed;
	protected int numCorrect;
	protected String lastReactionTimeMessage;
	protected LinkedList<ChoiceReactionTimeTrialResult> trialResults;
	//protected LinkedList<>
	protected ChoiceReactionTimeTrialResult currentTrialResult;
	protected ChoiceReactionTimeStatistics statistics;
	NumberFormat numberFormat;
	
	public ChoiceReactionTimePresenter(
		ChoiceReactionTimeStimulusDisplay stimulusWidget,
		ChoiceReactionTimeResultDisplay resultWidget) {
	    this.stimulusWidget = stimulusWidget;
	    this.resultWidget = resultWidget;
	    this.numberFormat = NumberFormat.getDecimalFormat();
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub

	}

	@Override
	public Display getStimulusView() {
		return stimulusWidget;
}

	@Override
	public Display getResultView() {
		// TODO Auto-generated method stub
		return resultWidget;
	}
	
	protected void handleReaction(int userChoice) {
		t2 = System.currentTimeMillis();
		currentTrialResult.userAnswer = userChoice;
		currentTrialResult.clickedTooEarly = !stimulusDisplayed;
		if (stimulusDisplayed) {
			if (userChoice == currentChoice) {
				correctClick();
			}
			else {
				wrongClick();
			}
		}
		else {
			clickedTooEarly();
		}
		endTrial();
	}
	
	protected void endTrial() {
		trialResults.add(currentTrialResult);
		statistics.updateStatistics(currentTrialResult);
		startTrial();
	}
	
	protected void correctClick() {
		currentTrialResult.userReactionTime = t2 - t1;
		lastReactionTimeMessage = numberFormat.format(t2 - t1).toString();
	}
	
	protected void wrongClick() {
		currentTrialResult.userReactionTime = t2 - t1;
		lastReactionTimeMessage = "Wrong choice!";
	}
	
	protected void clickedTooEarly() {
		currentTrialResult.userReactionTime = t2 - t0;
		lastReactionTimeMessage = "Too early!";
		
	}

	@Override
	public KeyPressHandler getFocusPanelKeyPressHandler() {
	    KeyPressHandler myHandler = new KeyPressHandler() {
	        @Override
	        public void onKeyPress(KeyPressEvent event) {
	        	char code = event.getCharCode();
	        	if ((code >= '1') && (code < '1' + numChoices)) {
	        		handleReaction(code - '1');
	        	}
	        }
	      };
	      return myHandler;
	}

	@Override
	public TouchStartHandler getFocusPanelTouchStartHandler() {
	    TouchStartHandler myTouchHandler = new TouchStartHandler() {
	        @Override
	        public void onTouchStart(TouchStartEvent event) {
	          handleReaction(currentChoice);  // TODO: figure out if they tapped the right one
	        }
	      };
	      return myTouchHandler;
	}

	@Override
	public void start() {
		initialize();
		startTrial();

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
	
	protected void initialize() {
		nTrials = 0;
		numCorrect = 0;
		trialResults = new LinkedList<ChoiceReactionTimeTrialResult>();
		statistics = new ChoiceReactionTimeStatistics();
		generator.setSeed(randomSeed);
	}
	
	
	protected void startTrial() {
		++nTrials;
		currentTrialResult = new ChoiceReactionTimeTrialResult();
		currentTrialResult.trialNumber = nTrials;
		stimulusDisplayed = false;
		stimulusWidget.hideStimulus();
		updateText();
		createTrial();
		startTimer();
	}
	
	protected void updateText() {
		resultWidget.getTextCorrectPercentage().setText(numberFormat.format(statistics.getCorrectFraction() * 100));
		resultWidget.getTextLastReactionTime().setText(lastReactionTimeMessage);
		resultWidget.getTextTrialNumber().setText(Integer.toString(statistics.getTotalTrials()));
	}
	
	protected void createTrial() {
		currentChoice = generator.nextInt(numChoices);
		currentDelay = constantDelay - (int) (delayLambda * Math.log(generator.nextDouble()));
		stimulusWidget.setChoice(currentChoice);
		currentTrialResult.correctAnswer = currentChoice;
		currentTrialResult.delay = currentDelay;
	}

	protected Timer timer = new Timer() {

		@Override
		public void run() {
			stimulusWidget.showStimulus();
			stimulusDisplayed = true;
			t1 = System.currentTimeMillis();
		}
		
	};
	
	protected void startTimer() {
		timer.schedule(currentDelay);
		t0 = System.currentTimeMillis();
	}
}
