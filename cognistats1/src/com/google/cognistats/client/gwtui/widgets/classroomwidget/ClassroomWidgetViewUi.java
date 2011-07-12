package com.google.cognistats.client.gwtui.widgets.classroomwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ClassroomWidgetViewUi extends View implements
    ClassroomWidgetDisplay {
  @UiField LayoutPanel layoutPanelTest;
  @UiField LayoutPanel layoutPanelResult;
  @UiField Button buttonStart;
  @UiField Button buttonStop;
  @UiField Button buttonPause;
  @UiField Button buttonSubmit;
  @UiField LayoutPanel blackboard;
  @UiField LayoutPanel instructions;
  @UiField LayoutPanel summary;
  @UiField HTML summaryStatistics;
  @UiField HTML instructionsText;

  private static ClassroomWidgetViewUiUiBinder uiBinder = GWT
    .create(ClassroomWidgetViewUiUiBinder.class);

  interface ClassroomWidgetViewUiUiBinder extends
      UiBinder<Widget, ClassroomWidgetViewUi> {
  }

  public ClassroomWidgetViewUi() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public LayoutPanel getLayoutPanelTest() {
    return layoutPanelTest;
  }
  
  @Override
  public LayoutPanel getBlackboard() {
	  return blackboard;
  }
  
  @Override
  public LayoutPanel getInstructions() {
	  return instructions;
  }
  
  @Override
  public LayoutPanel getSummary() {
	  return summary;
  }
  
  @Override
  public HTML getInstructionsText() {
	  return instructionsText;
  }
  
  @Override
  public HTML getSummaryStatistics() {
	  return summaryStatistics;
  }

  @Override
  public Button getButtonStart() {
    return buttonStart;
  }

  @Override
  public Button getButtonStop() {
    return buttonStop;
  }

  @Override
  public Button getButtonPause() {
    return buttonPause;
  }

  @Override
  public Button getButtonSubmit() {
    return buttonSubmit;
  }

  @Override
  public void setEnabled(
    boolean enabled) {
    buttonStart.setEnabled(enabled);
    buttonStop.setEnabled(enabled);
  }

  @Override
  public LayoutPanel getLayoutPanelResult() {
    return layoutPanelResult;
  }
}
