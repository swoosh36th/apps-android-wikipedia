package org.wikipedia.homeworks.homework08.pages

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.pages.items.DataAndPrivacyPagerItem
import org.wikipedia.homeworks.homework08.pages.items.FreeEncyclopediaPagerItem
import org.wikipedia.homeworks.homework08.pages.items.NewWaysToExplorePagerItem
import org.wikipedia.homeworks.homework08.pages.items.ReadingsListWithSyncPagerItem

object OnboardingScreen : KScreen<OnboardingScreen>() {
  override val layoutId: Int? = null
  override val viewClass: Class<*>? = null
  val onboardingItems = KViewPager2(
    builder = { withId(R.id.fragment_pager) },
    itemTypeBuilder = {
      itemType(::FreeEncyclopediaPagerItem)
      itemType(::NewWaysToExplorePagerItem)
      itemType(::ReadingsListWithSyncPagerItem)
      itemType(::DataAndPrivacyPagerItem)
    }
  )
  val skipButton = KButton { withId(R.id.fragment_onboarding_skip_button) }
}