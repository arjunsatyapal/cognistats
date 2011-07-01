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
package com.google.cognistats.client.gwtui.tests.mystatisticwidget;

import com.google.gwt.user.client.ui.HTML;

/**
 * All Grid Rows should inherit this.
 * 
 * @author Arjun Satyapal
 */
public abstract class BaseStatisticGridRow {
  public static final int numColumn = 4;

  protected HTML rowTitle;
  protected HTML trialColumn;
  protected HTML testColumn;
  protected HTML allTimeColumn;
  
  public static int getNumcolumn() {
    return numColumn;
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
    return "<div>" + text + "</div";
  }
  protected BaseStatisticGridRow(String rowTitle) {
    this.rowTitle = new HTML(getHtmlDivForElement(rowTitle));
  }
  
  protected void setCurrentTrial(String trialColumn) {
    this.trialColumn = new HTML(getHtmlDivForElement(trialColumn));
  }
  
  protected void setCurrentTest(String testColumn) {
    this.testColumn = new HTML(getHtmlDivForElement(testColumn));
  }
  
  protected void setAllTime(String allTimeColumn) { 
    this.allTimeColumn = new HTML(getHtmlDivForElement(allTimeColumn));
  }
}
