package com.akshay.credstackview.application

import android.app.Application
import android.content.Context
import com.akshay.credstackview.activity.ActivityComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/** Provides core infrastructure needed to support all other dependencies in the app. */
@Module(subcomponents = [ActivityComponent::class])
class ApplicationModule {
  @Provides
  @Singleton
  @ApplicationContext
  fun provideApplicationContext(application: Application): Context {
    return application
  }

  @Provides
  @Singleton
  fun provideContext(@ApplicationContext context: Context): Context {
    return context
  }
}
