package org.wikipedia.homeworks.homework07.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadCardViewItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardViewItem>(matcher) {
  val cardHeader = KTextView(matcher) {
    withId(R.id.view_card_header_title)
  }
  val listCardButton = KImageView(matcher) {
    withId(R.id.view_list_card_header_menu)
  }
  val items = KRecyclerView(
    parent = matcher,
    builder = { withId(R.id.view_list_card_list) },
    itemTypeBuilder = {
      itemType(::ListCardViewItem)
    }
  )
}