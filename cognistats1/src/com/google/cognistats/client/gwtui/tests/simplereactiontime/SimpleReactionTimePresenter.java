package com.google.cognistats.client.gwtui.tests.simplereactiontime;

import com.google.cognistats.client.gwtui.tests.choicereactiontime.ChoiceReactionTimePresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.statisticswidget.ChoiceReactionTimeStatisticsPresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.testwidget.ChoiceReactionTimeTestDisplay;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;

public class SimpleReactionTimePresenter extends ChoiceReactionTimePresenter {

  public SimpleReactionTimePresenter(ChoiceReactionTimeTestDisplay testWidget,
      ChoiceReactionTimeStatisticsPresenter statPresenter) {
    super(testWidget, statPresenter);
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
