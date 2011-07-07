package com.google.cognistats.client.gwtui.tests.choicereactiontime.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;

public interface ChoiceReactionTimeTestDisplay extends Display {
  TSRTestView getTSRTestView();
  
  public void setChoice(int choice);

  public void showStimulus();

  public void hideStimulus();
}
