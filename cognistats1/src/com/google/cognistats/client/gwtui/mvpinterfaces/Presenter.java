package com.google.cognistats.client.gwtui.mvpinterfaces;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * All Presenter Classes should implement this.
 *
 * @author Arjun Satyapal
 */
public interface Presenter {
  void go(final HasWidgets container);

  void bind();
}