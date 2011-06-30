package com.google.cognistats.client.gwtui.tests.base.testwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;

public class BaseTestView extends Composite implements BaseTestDisplay {

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);
	@UiField Label fixationPlus;

	interface BaseTestViewUiBinder extends UiBinder<Widget, BaseTestView> {
	}

	public BaseTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFixationPlusEnabled(boolean enabled) {
		fixationPlus.setVisible(enabled);
		
	}

}
