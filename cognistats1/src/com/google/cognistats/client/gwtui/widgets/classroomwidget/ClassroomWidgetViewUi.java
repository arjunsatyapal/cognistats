package com.google.cognistats.client.gwtui.widgets.classroomwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ClassroomWidgetViewUi extends View implements
    ClassroomWidgetDisplay {
  @UiField
  LayoutPanel layoutPanelTest;
  @UiField
  LayoutPanel layoutPanelResult;
  @UiField
  Button buttonStart;
  @UiField
  Button buttonStop;

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
  public Button getButtonStart() {
    return buttonStart;
  }

  @Override
  public Button getButtonStop() {
    return buttonStop;
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