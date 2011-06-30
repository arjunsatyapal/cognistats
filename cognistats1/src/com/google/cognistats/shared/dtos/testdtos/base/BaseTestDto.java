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
import com.google.cognistats.shared.enums.TestResultEnum;

/**
 * Information that is common across all the tests.
 *
 * @author Arjun Satyapal
 */
public class BaseTestDto implements AbstractDto {
  // Total Number of Trials expected for the test.
  private int totalTrials;

  // Number of trials Subject actually completed.
  private int totalTrialsCompleted;

  // Total time taken by user to complete the test.
  private long totalTimeInMillis;

  // Number of trials user successfully completed.
  private int correctTrials;

  // Result of test.
  private TestResultEnum testResult;

  @Override
  public StringBuilder getStringBuilder() {
    return new StringBuilder().append("[totalTrials:")
        .append(totalTrials)
        .append("][totalTrialsCompleted:")
        .append(totalTrialsCompleted)
        .append("][totalTimeInMillis:")
        .append(totalTimeInMillis)
        .append("][correctTrials:")
        .append(correctTrials)
        .append("][testResult:")
        .append(testResult)
        .append("]");
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

  public BaseTestDto(int totalTrials) {
    this.totalTrials = totalTrials;
  }

  public BaseTestDto(int totalTrials, int totalTrialsCompleted,
      long totalTimeInMillis, int correctTrials, TestResultEnum testResult) {
    this.totalTrials = totalTrials;
    this.totalTrialsCompleted = totalTrialsCompleted;
    this.totalTimeInMillis = totalTimeInMillis;
    this.correctTrials = correctTrials;
    this.testResult = testResult;
  }

  public int getTotalTrials() {
    return totalTrials;
  }

  public void setTotalTrials(int totalTrials) {
    this.totalTrials = totalTrials;
  }

  public int getTotalTrialsCompleted() {
    return totalTrialsCompleted;
  }

  public void setTotalTrialsCompleted(int totalTrialsCompleted) {
    this.totalTrialsCompleted = totalTrialsCompleted;
  }


  public long getTotalTimeInMillis() {
    return totalTimeInMillis;
  }

  public void setTotalTimeInMillis(long totalTimeInMillis) {
    this.totalTimeInMillis = totalTimeInMillis;
  }

  public int getCorrectTrials() {
    return correctTrials;
  }

  public void setCorrectTrials(int correctTrials) {
    this.correctTrials = correctTrials;
  }

  public TestResultEnum getTestResult() {
    return testResult;
  }

  public void setTestResult(TestResultEnum testResult) {
    this.testResult = testResult;
  }
}
