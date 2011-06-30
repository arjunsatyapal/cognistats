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
package com.google.cognistats.shared.dtos.testdtos.trials;

import com.google.cognistats.shared.dtos.AbstractDto;
import com.google.cognistats.shared.dtos.testdtos.base.BaseTrialDto;

/**
 * DTO for SimpleReactionTime Trial.
 *
 * @author Arjun Satyapal
 */
public class SimpleReactionTimeTrialDto implements AbstractDto {
  private BaseTrialDto baseTrialDto;

  public BaseTrialDto getBaseTrialDto() {
    return baseTrialDto;
  }

  public SimpleReactionTimeTrialDto(int trialNumber) {
    this.baseTrialDto = new BaseTrialDto(trialNumber);
  }

  @Override
  public StringBuilder getStringBuilder() {
    return baseTrialDto.getStringBuilder();
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
