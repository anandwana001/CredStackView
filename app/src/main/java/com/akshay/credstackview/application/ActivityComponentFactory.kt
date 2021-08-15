package com.akshay.credstackview.application

import androidx.appcompat.app.AppCompatActivity
import com.akshay.credstackview.activity.ActivityComponent

interface ActivityComponentFactory {
  /**
   * Returns a new [ActivityComponent] for the specified activity. This should only be used by
   * src/main/java/com/akshay/credstackview/activity/InjectableAppCompatActivity.kt.
   */
  fun createActivityComponent(activity: AppCompatActivity): ActivityComponent
}
