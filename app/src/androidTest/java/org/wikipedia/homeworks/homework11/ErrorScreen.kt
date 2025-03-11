package org.wikipedia.homeworks.homework11

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ErrorScreen : KScreen<ErrorScreen>() {
  override val layoutId: Int? = null
  override val viewClass: Class<*>? = null

  val errorHeader = KTextView { withId(R.id.view_wiki_error_text) }
  val retryButton = KButton { withId(R.id.view_wiki_error_button) }
}