package com.akshay.credstackview.application

import androidx.appcompat.app.AppCompatActivity
import androidx.multidex.MultiDexApplication
import com.akshay.credstackview.activity.ActivityComponent

class CredStackViewApplication : ActivityComponentFactory,
  MultiDexApplication() {

  private val component: ApplicationComponent by lazy {
    DaggerApplicationComponent.builder()
      .setApplication(this)
      .build()
  }

  override fun createActivityComponent(activity: AppCompatActivity): ActivityComponent {
    return component.getActivityComponentBuilderProvider().get().setActivity(activity).build()
  }
}
