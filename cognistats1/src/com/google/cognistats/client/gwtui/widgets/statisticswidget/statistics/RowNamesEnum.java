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

/**
 *
 * @author Arjun Satyapal
 */
public enum RowNamesEnum {
  DURATION_ROW("Duration"),
  REACTION_TIME_ROW("Reaction Time"),
  REACTION_TIME_STD_DEV_ROW("Standard Deviation"),
  TIME_ROW("Time"),
  TRIAL_ROW("Trials"),
  CORRECT_ROW("Correct"),
  READY_ROW("Ready");

  private String publicName;

  private RowNamesEnum(String publicName) {
    this.publicName = publicName;
  }

  public String getPublicName() {
    return publicName;
  }
}
