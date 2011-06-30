package com.google.cognistats.client.gwtui.tests.multitrial.testwidget;

import com.google.cognistats.client.gwtui.tests.base.testwidget.BaseTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class MultitrialTestView extends BaseTestView implements MultitrialTestDisplay {

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);
//	@UiField Label fixationPlus;

	interface BaseTestViewUiBinder extends UiBinder<Widget, MultitrialTestView> {
	}

	public MultitrialTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}


}
