/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mariobanay.diplomski.vfmsclientcc.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.activity.GpsPermissionActivity;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.activity.LocationPermissionActivity;
import mariobanay.diplomski.vfmsclientcc.presentation.ui.activity.LoginActivity;

/**
 * Class used to navigate through the application.
 */

public class Navigator {

  public static Navigator sNavigator;

  public Navigator() {
    //empty
  }

  /**
   * Goes to the user list screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToLocationPermission(Context context) {
    if (context != null) {
      Intent intentToLaunch = LocationPermissionActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToGpsPermission(Context context) {
    if (context != null) {
      Intent intentToLaunch = GpsPermissionActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToLoginFragment(Context context) {
    if (context != null) {
      Intent intentToLaunch = LoginActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }


  public static Navigator getInstance() {
    if (sNavigator == null) {
      sNavigator = new Navigator();
    }

    return sNavigator;
  }



}
