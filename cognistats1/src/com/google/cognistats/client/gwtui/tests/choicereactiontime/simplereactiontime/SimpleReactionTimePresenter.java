package com.google.cognistats.client.gwtui.tests.choicereactiontime.simplereactiontime;

import com.google.cognistats.client.gwtui.tests.choicereactiontime.ChoiceReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultDisplay;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusDisplay;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;

public class SimpleReactionTimePresenter extends ChoiceReactionTimePresenter {
  public SimpleReactionTimePresenter(
      ChoiceReactionTimeStimulusDisplay testWidget,
      ChoiceReactionTimeResultDisplay statisticsWidget) {
    super(testWidget, statisticsWidget);
  }

  @Override
  public KeyPressHandler getFocusPanelKeyPressHandler() {
    KeyPressHandler myHandler = new KeyPressHandler() {
      @Override
      public void onKeyPress(KeyPressEvent event) {
        char code = event.getCharCode();
        // TODO(arjuns) : This will throw exception when test is not running.
        if (code == ' ') {
          handleReaction(currentChoice);
        }
      }
    };
    return myHandler;
  }
}
