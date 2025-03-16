package org.wikipedia.homeworks.homework13.pages.article

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object DynamicArticleBlock: KScreen<DynamicArticleBlock>() {
  override val layoutId = null
  override val viewClass = null

  val readArticleButton = KButton { withId(R.id.link_preview_primary_button) }
}