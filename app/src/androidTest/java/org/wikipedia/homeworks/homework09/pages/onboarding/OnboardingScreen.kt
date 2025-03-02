package org.wikipedia.homeworks.homework09.pages.onboarding

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object OnboardingScreen : KScreen<OnboardingScreen>() {
  override val layoutId: Int? = null
  override val viewClass: Class<*>? = null
  val onboardingScreenHeader = KTextView { withId(R.id.primaryTextView) }
  val skipButton = KButton { withId(R.id.fragment_onboarding_skip_button) }
}