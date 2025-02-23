package org.wikipedia.homeworks.homework07.items

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.dayheader.DayHeaderCardView

class DayHeaderCardViewItem(matcher: Matcher<View>) : KRecyclerItem<DayHeaderCardView>(matcher) {
  val dayHeader = KTextView(matcher) {
    withId(R.id.day_header_text)
  }
}