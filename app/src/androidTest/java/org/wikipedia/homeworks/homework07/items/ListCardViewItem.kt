package org.wikipedia.homeworks.homework07.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.view.ListCardItemView

class ListCardViewItem(matcher: Matcher<View>) : KRecyclerItem<ListCardItemView>(matcher) {
  val cardNumberLocator = KTextView(matcher) {
    withId(R.id.numberView)
  }
  val cardTitleLocator = KTextView(matcher) {
    withId(R.id.view_list_card_item_title)
  }
  val cardSubTitleLocator = KTextView(matcher) {
    withId(R.id.view_list_card_item_subtitle)
  }
  val cardViewGraphLocator = KTextView(matcher) {
    withId(R.id.view_list_card_item_graph)
  }
  val cardPageViewsLocator = KTextView(matcher) {
    withId(R.id.view_list_card_item_pageviews)
  }
  val cardImageLocator = KTextView(matcher) {
    withId(R.id.view_list_card_item_image)
  }
}