package com.akshay.credstackview.home

import android.os.Bundle
import com.akshay.credstackview.activity.InjectableAppCompatActivity
import javax.inject.Inject

class HomeActivity : InjectableAppCompatActivity() {

  @Inject
  lateinit var homePresenter: HomePresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityComponent.inject(this)
    homePresenter.handleOnCreate()
  }
}
