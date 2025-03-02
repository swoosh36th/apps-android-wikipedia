package org.wikipedia.homeworks.homework09.pages.fragment

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework09.pages.fragment.items.CardViewItem

object FragmentNewsScreen : KScreen<FragmentNewsScreen>() {
  override val layoutId = null
  override val viewClass = null
  val fragmentNewsHeader = KTextView { withId(R.id.story_text_view) }
  val items = KRecyclerView(
    builder = { withId(R.id.news_story_items_recyclerview) },
    itemTypeBuilder = {
      itemType(::CardViewItem)
    }
  )
}