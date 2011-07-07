package com.google.cognistats.client.gwtui.widgets.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class TestWidgetViewUi extends View implements TestWidgetDisplay{
  @UiField
  LayoutPanel layoutPanelTest;
  @UiField
  LayoutPanel layoutPanelResult;
  @UiField
  Button buttonStart;
  @UiField
  Button buttonStop;

  private static TestWidgetViewUiUiBinder uiBinder =
      GWT.create(TestWidgetViewUiUiBinder.class);

  interface TestWidgetViewUiUiBinder extends UiBinder<Widget, TestWidgetViewUi> {
  }

  public TestWidgetViewUi() {
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
  public void setEnabled(boolean enabled) {
    buttonStart.setEnabled(enabled);
    buttonStop.setEnabled(enabled);
  }

  @Override
  public LayoutPanel getLayoutPanelResult() {
    return layoutPanelResult;
  }
}
