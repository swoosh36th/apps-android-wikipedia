package org.wikipedia.homeworks.homework07.items

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class SearchCardViewItem(matcher: Matcher<View>) : KRecyclerItem<SearchCardViewItem>(matcher) {
  val searchIconLocator = KImageView(matcher) {
    withDrawable(R.drawable.ic_search_white_24dp)
    withContentDescription(R.string.search_hint)
  }
  val searchTextInput = KTextView(matcher) {
    withText(R.string.search_hint)
  }
  val voiceIconLocator = KImageView(matcher) {
    withId(R.id.voice_search_button)
    withContentDescription(R.string.search_hint_voice_search)
  }
}