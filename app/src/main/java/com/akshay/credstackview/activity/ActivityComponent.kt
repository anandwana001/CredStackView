package com.akshay.credstackview.activity

import androidx.appcompat.app.AppCompatActivity
import com.akshay.credstackview.home.HomeActivity
import dagger.BindsInstance
import dagger.Subcomponent

/** Root subcomponent for all activities. */
@Subcomponent(modules = [ActivityModule::class])
@ActivityScope
interface ActivityComponent {

  @Subcomponent.Builder
  interface Builder {
    @BindsInstance
    fun setActivity(appCompatActivity: AppCompatActivity): Builder

    fun build(): ActivityComponent
  }

  fun inject(homeActivity: HomeActivity)
}
