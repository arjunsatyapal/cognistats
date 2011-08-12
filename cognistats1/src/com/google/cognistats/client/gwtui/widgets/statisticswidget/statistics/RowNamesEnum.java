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
  HEADER_ROW(""),
  DURATION_ROW("Duration"),
  REACTION_TIME_ROW("Reaction Time"),
  OVERALL_REACTION_TIME_ROW("Overall reaction time"),
  CONCORDANT_REACTION_TIME_ROW("Concordant reaction time"),
  DISCORDANT_REACTION_TIME_ROW("Discordant reaction time"),
  LEVEL_ROW("Level"),
  TRIAL_ROW("Trials"),
  CORRECT_ROW("Correct"),
  OVERALL_CORRECT_ROW("Overall correct"),
  CONCORDANT_CORRECT_ROW("Concordant correct"),
  DISCORDANT_CORRECT_ROW("Discordant correct"),
  READY_ROW("Ready"),
  TAP_COUNT_ROW("Taps");

  private String publicName;

  private RowNamesEnum(String publicName) {
    this.publicName = publicName;
  }

  public String getPublicName() {
    return publicName;
  }
}
