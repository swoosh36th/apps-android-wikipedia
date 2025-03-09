package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.bottomnav.UiBottomNavigationView
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
  override val packageName: String = "org.wikipedia.alpha"

  val logoImageLocator = UiView { withId(this@OnboardingUiScreen.packageName, "imageViewCentered") }
  val primaryHeader = UiTextView { withId(this@OnboardingUiScreen.packageName, "primaryTextView") }
  val secondaryHeader = UiTextView { withId(this@OnboardingUiScreen.packageName, "secondaryTextView") }
  val englishLanguageLocator = UiTextView { containsText("English") }
  val addOrEditLanguageButton = UiButton { withId(this@OnboardingUiScreen.packageName, "addLanguageButton") }
  val continueButton = UiButton { withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button") }
  val skipButton = UiButton { withText("Skip") }
  val pageIndicatorLocator = UiBottomNavigationView { withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator") }
}
