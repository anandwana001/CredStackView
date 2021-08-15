package com.akshay.domain.user

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

/** Test for [UserController]. */
@RunWith(RobolectricTestRunner::class)
@Config(application = UserControllerTest.TestApplication::class)
class UserControllerTest {

  @Inject
  lateinit var userController: UserController

  @Before
  fun setUp() {
    setUpTestApplicationComponent()
  }

  private fun setUpTestApplicationComponent() {
    ApplicationProvider.getApplicationContext<TestApplication>().inject(this)
  }

  @Test
  fun testUserController_fetchUser_userNameIsNikunj() {
    val user = userController.getUser()
    assertThat(user.name).isEqualTo("Nikunj")
  }

  @Test
  fun testUserController_fetchUser_userPhoneNumberIsCorrect() {
    val user = userController.getUser()
    assertThat(user.phoneNumber).isEqualTo(919935670475)
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

    fun inject(userControllerTest: UserControllerTest)
  }

  class TestApplication : Application() {
    private val component: TestApplicationComponent by lazy {
      DaggerUserControllerTest_TestApplicationComponent.builder()
        .setApplication(this)
        .build()
    }

    fun inject(userControllerTest: UserControllerTest) {
      component.inject(userControllerTest)
    }
  }
}
