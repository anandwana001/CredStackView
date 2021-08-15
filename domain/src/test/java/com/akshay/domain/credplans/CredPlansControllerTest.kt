package com.akshay.domain.credplans

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import dagger.BindsInstance
import dagger.Component
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject
import javax.inject.Singleton

/** Test for [CredPlansController]. */
@RunWith(RobolectricTestRunner::class)
@Config(application = CredPlansControllerTest.TestApplication::class)
class CredPlansControllerTest {

  @Inject
  lateinit var credPlansController: CredPlansController

  @Before
  fun setUp() {
    setUpTestApplicationComponent()
  }

  private fun setUpTestApplicationComponent() {
    ApplicationProvider.getApplicationContext<TestApplication>().inject(this)
  }

  @Test
  fun testCredPlansController_fetchList_listContainsFourPlans() {
    val listOfCredPlan = credPlansController.getListOfCredPlan()
    assertThat(listOfCredPlan.size).isEqualTo(4)
  }

  @Singleton
  @Component
  interface TestApplicationComponent {
    @Component.Builder
    interface Builder {
      @BindsInstance
      fun setApplication(application: Application): Builder

      fun build(): TestApplicationComponent
    }

    fun inject(credPlansControllerTest: CredPlansControllerTest)
  }

  class TestApplication : Application() {
    private val component: TestApplicationComponent by lazy {
      DaggerCredPlansControllerTest_TestApplicationComponent.builder()
        .setApplication(this)
        .build()
    }

    fun inject(credPlansControllerTest: CredPlansControllerTest) {
      component.inject(credPlansControllerTest)
    }
  }
}