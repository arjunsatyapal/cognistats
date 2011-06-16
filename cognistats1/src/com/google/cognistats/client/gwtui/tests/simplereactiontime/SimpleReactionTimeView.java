package com.google.cognistats.client.gwtui.tests.simplereactiontime;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class SimpleReactionTimeView extends Composite {

	@UiField
	Image imageCircle;
	@UiField
	FocusPanel focusPanel;

	@UiField
	LayoutPanel layoutPanel;
	private static SimpleReactionTimeViewUiBinder uiBinder = GWT
			.create(SimpleReactionTimeViewUiBinder.class);

	interface SimpleReactionTimeViewUiBinder extends
			UiBinder<Widget, SimpleReactionTimeView> {
	}

	public SimpleReactionTimeView() {
		initWidget(uiBinder.createAndBindUi(this));
		// imageCircle.addDomHandler(handler, type)
		KeyDownHandler myHandler = new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				// TODO Auto-generated method stub

			}
		};

		focusPanel.addKeyDownHandler(myHandler);
	}
}
