package com.google.cognistats.client;

import com.google.cognistats.client.gwtui.tests.simplereactiontime.SimpleReactionTimeView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Cognistats implements EntryPoint {
  @Override
  public void onModuleLoad() {
    RootLayoutPanel root = RootLayoutPanel.get();
    root.clear();
    root.add(new SimpleReactionTimeView());
  }
}
