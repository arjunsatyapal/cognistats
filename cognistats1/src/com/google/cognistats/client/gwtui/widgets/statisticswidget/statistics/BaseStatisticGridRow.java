/**
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.user.client.ui.HTML;

/**
 * All Grid Rows should inherit this. Structure of Grid is :
 *
 * Title Trial Test AllTime
 *
 * @author Arjun Satyapal
 */
public abstract class BaseStatisticGridRow {
  public static final int numColumn = 4;

  protected RowNamesEnum name;
  protected HTML rowTitle;
  protected HTML trialColumn;
  protected HTML testColumn;
  protected HTML allTimeColumn;

  public static int getNumcolumn() {
    return numColumn;
  }

  public RowNamesEnum getName() {
    return name;
  }

  public HTML getRowTitle() {
    return rowTitle;
  }

  public HTML getTrialColumn() {
    return trialColumn;
  }

  public HTML getTestColumn() {
    return testColumn;
  }

  public HTML getAllTimeColumn() {
    return allTimeColumn;
  }

  private String getHtmlDivForElement(String text) {
    return "<div>" + text + "</div>";
  }
  
  protected void setName(RowNamesEnum name) {
	  this.name = name;
	  this.rowTitle = new HTML(getHtmlDivForElement(name.getPublicName()));
  }

  protected BaseStatisticGridRow(RowNamesEnum name) {
	  this.rowTitle = new HTML("");
	  this.trialColumn = new HTML("");
	  this.testColumn = new HTML("");
	  this.allTimeColumn = new HTML("");
	  setName(name);
  }

  protected void setCurrentTrialColumn(String trialColumn) {
    this.trialColumn.setHTML(getHtmlDivForElement(trialColumn));
  }

  protected void setCurrentTestColumn(String testColumn) {
    this.testColumn.setHTML(getHtmlDivForElement(testColumn));
  }

  protected void setAllTimeColumn(String allTimeColumn) {
    this.allTimeColumn.setHTML(getHtmlDivForElement(allTimeColumn));
  }
}
