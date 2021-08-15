package com.akshay.credstackview.application

import android.app.Application
import com.akshay.credstackview.activity.ActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun setApplication(application: Application): Builder
    fun build(): ApplicationComponent
  }

  fun getActivityComponentBuilderProvider(): Provider<ActivityComponent.Builder>
}
