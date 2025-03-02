package org.wikipedia.homeworks.homework09.pages.explore.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsViewItem>(matcher) {
  val newsTextLocator = KTextView(matcher) {
    withId(R.id.horizontal_scroll_list_item_text)
  }
}