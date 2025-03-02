package org.wikipedia.homeworks.homework09.pages.explore.items

import android.view.View

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsCardViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsCardViewItem>(matcher) {
  val newsHeader = KTextView(matcher) { withId(R.id.view_card_header_title) }
  val items = KRecyclerView(
    parent = matcher,
    builder = { withId(R.id.news_cardview_recycler_view) },
    itemTypeBuilder = {
      itemType(::NewsViewItem)
    }
  )
}