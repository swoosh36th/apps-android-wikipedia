package org.wikipedia.homeworks.homework09.pages.fragment.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CardViewItem(matcher: Matcher<View>) : KRecyclerItem<CardViewItem>(matcher) {
  val cardSubtitleLocator = KTextView(matcher) { withId(R.id.view_list_card_item_subtitle) }
}