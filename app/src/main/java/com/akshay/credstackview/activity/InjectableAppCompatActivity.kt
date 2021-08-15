package com.akshay.credstackview.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akshay.credstackview.application.ActivityComponentFactory

abstract class InjectableAppCompatActivity : AppCompatActivity() {

  lateinit var activityComponent: ActivityComponent

  override fun onCreate(savedInstanceState: Bundle?) {
    initializeActivityComponent()
    super.onCreate(savedInstanceState)
  }

  private fun initializeActivityComponent() {
    activityComponent = (application as ActivityComponentFactory).createActivityComponent(this)
  }
}