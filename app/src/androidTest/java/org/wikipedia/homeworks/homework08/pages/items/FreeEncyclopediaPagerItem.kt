package org.wikipedia.homeworks.homework08.pages.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.pages.items.languages.LanguageItem

class FreeEncyclopediaPagerItem(matcher: Matcher<View>): KViewPagerItem<FreeEncyclopediaPagerItem>(matcher) {
  val logoImageLocator = KImageView(matcher) { withId(R.id.imageViewCentered) }
  val primaryHeader = KTextView(matcher) { withId(R.id.primaryTextView) }
  val secondaryHeader = KTextView(matcher) { withId(R.id.secondaryTextView) }
  val languagesListItems = KRecyclerView(
    parent = matcher,
    builder = { withId(R.id.languagesList) },
    itemTypeBuilder = {
      itemType(::LanguageItem)
    }
  )
  val addOrEditLanguageButton = KButton(matcher) { withId(R.id.addLanguageButton) }
  val continueButton = KButton(matcher) { withId(R.id.fragment_onboarding_forward_button) }
}