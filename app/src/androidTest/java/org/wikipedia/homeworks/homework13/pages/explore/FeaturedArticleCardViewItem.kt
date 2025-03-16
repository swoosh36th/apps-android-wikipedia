package org.wikipedia.homeworks.homework13.pages.explore

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleCardViewItem(matcher: Matcher<View>): KRecyclerItem<FeaturedArticleCardViewItem>(matcher) {
  val featuredArticleCardHeader = KTextView(matcher) { withId(R.id.view_card_header_title) }
  val imageLocator = KImageView(matcher) { withId(R.id.articleImage)}
}