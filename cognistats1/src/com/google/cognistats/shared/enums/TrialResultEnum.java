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
package com.google.cognistats.shared.enums;

/**
 *
 * @author Arjun Satyapal
 */
public enum TrialResultEnum {
  // Subject responded before Stimulus was shown.
  BEFORE,

  // Subject responded correctly to Stimulus.
  CORRECT,

  // Subject responded incorrectly to Stimulus.
  INCORRECT,

  // Subject did not responed within the trial time period.
  TIME_OUT;
}
