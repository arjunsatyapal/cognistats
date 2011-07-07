package com.google.cognistats.client.gwtui.tests.choicereactiontime.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;

public interface ChoiceReactionTimeTestDisplay extends Display {
  public void setChoice(int choice);

  public void showStimulus();

  public void hideStimulus();
}
