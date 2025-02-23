package org.wikipedia.homeworks.homework07.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class NewsViewItem(matcher: Matcher<View>) : KRecyclerItem<NewsViewItem>(matcher) {
  val newsImageLocator = KImageView(matcher) {
    withId(R.id.horizontal_scroll_list_item_image)
  }
  val newsTextLocator = KTextView(matcher) {
    withId(R.id.horizontal_scroll_list_item_text)
  }
}