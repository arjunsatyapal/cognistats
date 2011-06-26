package com.google.cognistats.client.gwtui.tests.choicereactiontime;

import java.util.Random;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultDisplay;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusDisplay;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.Timer;
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
	protected long t1;
	protected boolean stimulusDisplayed;
	
	public ChoiceReactionTimePresenter(
		ChoiceReactionTimeStimulusDisplay stimulusWidget,
		ChoiceReactionTimeResultDisplay resultWidget) {
	    this.stimulusWidget = stimulusWidget;
	    this.resultWidget = resultWidget;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Display getResultView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void handleReaction(int userChoice) {
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
	
	protected void correctClick() {
		
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
	          handleReaction(currentChoice);
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
		generator.setSeed(randomSeed);
	}
	
	
	protected void startTrial() {
		++nTrials;
		stimulusDisplayed = false;
		stimulusWidget.hideStimulus();
		updateText();
		createTrial();
		startTimer();
	}
	
	protected void updateText() {
		resultWidget.getTextTrialNumber().setText(Integer.toString(nTrials) + " / " + Integer.toString(totalNumTrials));
	}
	
	protected void createTrial() {
		currentChoice = generator.nextInt(numChoices);
		currentDelay = constantDelay - (int) (delayLambda * Math.log(generator.nextDouble()));
		stimulusWidget.setChoice(currentChoice);
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
	}
}
