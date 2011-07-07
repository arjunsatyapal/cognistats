package com.google.cognistats.client.gwtui.tests.simplereactiontime.testwidget;

import com.google.cognistats.client.gwtui.tests.choicereactiontime.testwidget.ChoiceReactionTimeTestView;

public class SimpleReactionTimeTestView extends ChoiceReactionTimeTestView
    implements SimpleReactionTimeTestDisplay {

  // @UiField protected Label textChoice;

  public SimpleReactionTimeTestView() {
    super();
  }

  @Override
  public void showStimulus() {
    // super.showStimulus(); // while the below errors out
    textChoice.setText("(space)");
    textChoice.setVisible(true);
  }
}
