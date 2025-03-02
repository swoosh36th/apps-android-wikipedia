package org.wikipedia.homeworks.homework09.pages.news

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object NewsScreen : KScreen<NewsScreen>() {
  override val layoutId: Int? = null
  override val viewClass: Class<*>? = null
  val webContentLocator = KView { withId(R.id.page_web_view) }
}