package com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;

public interface ChoiceReactionTimeStimulusDisplay extends Display {
  public void setChoice(int choice);

  public void showStimulus();

  public void hideStimulus();
}
