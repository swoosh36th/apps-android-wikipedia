package org.wikipedia.homeworks.homework13.pages.article

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleScreen : KScreen<ArticleScreen>() {
  override val layoutId = null
  override val viewClass = null

  val pageWebView = KWebView { withId(R.id.page_web_view) }
  val items = KViewPager2(
    builder = { withId(R.id.reference_pager) },
    itemTypeBuilder = { itemType(::ReferencePagerItem) }
  )
}