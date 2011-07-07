package com.google.cognistats.client.gwtui.tests.choicereactiontime.testwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ChoiceReactionTimeTestView extends Composite implements
    ChoiceReactionTimeTestDisplay {

  private static ChoiceReactionTimeStimulusViewUiBinder uiBinder =
      GWT.create(ChoiceReactionTimeStimulusViewUiBinder.class);

  @UiField
  public Label textChoice;
  private int choice;

  interface ChoiceReactionTimeStimulusViewUiBinder extends
      UiBinder<Widget, ChoiceReactionTimeTestView> {
  }

  public ChoiceReactionTimeTestView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  public ChoiceReactionTimeTestView(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setEnabled(boolean enabled) {
    // TODO Auto-generated method stub
  }

  @Override
  public void setChoice(int choice) {
    this.choice = choice;
  }

  @Override
  public void showStimulus() {
    textChoice.setText(Integer.toString(choice + 1));
    textChoice.setVisible(true);
  }

  @Override
  public void hideStimulus() {
    textChoice.setVisible(false);
  }
}
