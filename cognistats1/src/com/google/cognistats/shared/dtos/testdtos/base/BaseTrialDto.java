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
package com.google.cognistats.shared.dtos.testdtos.base;

import com.google.cognistats.shared.dtos.AbstractDto;
import com.google.cognistats.shared.enums.TrialResultEnum;


/**
 * Information that is common across all trials across all tests.
 *
 * @author Arjun Satyapal
 */
public class BaseTrialDto implements AbstractDto {
  private int trialNumber;
  private long trialTimeInMillis;
  private TrialResultEnum trialResult;
  private Seed trialSeed;

  public int getTrialNumber() {
    return trialNumber;
  }

  public long getTrialTimeInMillis() {
    return trialTimeInMillis;
  }

  public void setTrialTimeInMillis(long trialTimeInMillis) {
    this.trialTimeInMillis = trialTimeInMillis;
  }

  public TrialResultEnum getTrialResult() {
    return trialResult;
  }

  public void setTrialResult(TrialResultEnum trialResult) {
    this.trialResult = trialResult;
  }

  public Seed getTrialSeed() {
    return trialSeed;
  }

  public void setTrialSeed(Seed trialSeed) {
    this.trialSeed = trialSeed;
  }

  @Override
  public StringBuilder getStringBuilder() {
    return new StringBuilder().append("[trialNumber:")
        .append(trialNumber)
        .append("][trialTimeInMillis:")
        .append(trialTimeInMillis)
        .append("][trialResult:")
        .append(trialResult)
        .append("][seed:")
        .append(trialSeed)
        .append("]");
  }

  @Override
  public String validate() {
    // TODO(arjuns): Auto-generated method stub
    return null;
  }

  public BaseTrialDto(int trialNumber) {
    this.trialNumber = trialNumber;
  }
}
