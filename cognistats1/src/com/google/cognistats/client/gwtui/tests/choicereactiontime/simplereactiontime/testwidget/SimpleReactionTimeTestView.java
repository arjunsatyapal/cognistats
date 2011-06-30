package com.google.cognistats.client.gwtui.tests.choicereactiontime.simplereactiontime.testwidget;

import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusView;

public class SimpleReactionTimeTestView extends ChoiceReactionTimeStimulusView
    implements SimpleReactionTimeTestDisplay {

  // @UiField protected Label textChoice;

  public SimpleReactionTimeTestView() {
    super();
  }

  public SimpleReactionTimeTestView(String firstName) {
    super(firstName);
  }

  @Override
  public void showStimulus() {
    // super.showStimulus(); // while the below errors out
    textChoice.setText("(space)");
    textChoice.setVisible(true);
  }
}
