package org.wikipedia.homeworks.homework08.pages.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ReadingsListWithSyncPagerItem(matcher: Matcher<View>): KViewPagerItem<ReadingsListWithSyncPagerItem>(matcher) {
  val logoImageLocator = KImageView(matcher) { withId(R.id.imageViewCentered) }
  val primaryHeader = KTextView(matcher) { withId(R.id.primaryTextView) }
  val secondaryHeader = KTextView(matcher) { withId(R.id.secondaryTextView) }
  val continueButton = KButton(matcher) { withId(R.id.fragment_onboarding_forward_button) }
}