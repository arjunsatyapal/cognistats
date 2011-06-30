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
package com.google.cognistats.shared.dtos.testdtos.tests;

import com.google.cognistats.shared.dtos.AbstractDto;
import com.google.cognistats.shared.dtos.testdtos.base.BaseTestDto;
import com.google.cognistats.shared.dtos.testdtos.trials.SimpleReactionTimeTrialDto;

import java.util.ArrayList;

/**
 * DTO for SimpleReactionTime Test.
 *
 * @author Arjun Satyapal
 */
public class SimpleReactionTimeTestDto implements AbstractDto {
  private BaseTestDto baseTestDto;
  private double meanResponseTime;
  private double standardDevaition;
  private ArrayList<SimpleReactionTimeTrialDto> listTrials;

  public BaseTestDto getBaseTestDto() {
    return baseTestDto;
  }

  public void setBaseTestDto(BaseTestDto baseTestDto) {
    this.baseTestDto = baseTestDto;
  }

  public double getMeanResponseTime() {
    return meanResponseTime;
  }

  public void setMeanResponseTime(double meanResponseTime) {
    this.meanResponseTime = meanResponseTime;
  }

  public double getStandardDevaition() {
    return standardDevaition;
  }

  public void setStandardDevaition(double standardDevaition) {
    this.standardDevaition = standardDevaition;
  }

  public ArrayList<SimpleReactionTimeTrialDto> getListTrials() {
    return listTrials;
  }

  public void setListTrials(ArrayList<SimpleReactionTimeTrialDto> listTrials) {
    this.listTrials = listTrials;
  }

  public SimpleReactionTimeTestDto(int totalTrials) {
    this.baseTestDto = new BaseTestDto(totalTrials);
    listTrials = new ArrayList<SimpleReactionTimeTrialDto>(totalTrials);
    for (int trialNumber = 0; trialNumber < totalTrials; trialNumber++) {
      SimpleReactionTimeTrialDto trial =
        new SimpleReactionTimeTrialDto(trialNumber);
      listTrials.add(trial);
    }
  }

  public SimpleReactionTimeTestDto(BaseTestDto baseTestDto,
      double meanResponseTime, double standardDevaition) {
    this.baseTestDto = baseTestDto;
    this.meanResponseTime = meanResponseTime;
    this.standardDevaition = standardDevaition;
  }

  @Override
  public StringBuilder getStringBuilder() {
    return baseTestDto.getStringBuilder()
        .append("[meanResponseTime:")
        .append(meanResponseTime)
        .append("][standardDeviation:")
        .append(standardDevaition)
        .append("].");
  }

  @Override
  public String toString() {
    return getStringBuilder().toString();
  }

  @Override
  public String validate() {
    // TODO(arjuns): Auto-generated method stub
    return null;
  }
}
