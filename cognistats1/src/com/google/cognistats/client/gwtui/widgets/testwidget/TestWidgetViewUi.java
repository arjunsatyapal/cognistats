package com.google.cognistats.client.gwtui.widgets.testwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestWidgetViewUi extends Composite {

	private static TestWidgetViewUiUiBinder uiBinder = GWT
			.create(TestWidgetViewUiUiBinder.class);

	interface TestWidgetViewUiUiBinder extends
			UiBinder<Widget, TestWidgetViewUi> {
	}

	public TestWidgetViewUi() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
