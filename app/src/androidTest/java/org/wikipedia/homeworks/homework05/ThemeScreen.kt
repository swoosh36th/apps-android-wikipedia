package org.wikipedia.homeworks.homework05

import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.materialswitch.MaterialSwitch
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import io.github.kakaocup.kakao.text.KTextView


val readingTitleLocator = KTextView {
  withId(R.id.textSettingsCategory)
  withText("Reading")
  withParent { isInstanceOf(LinearLayout::class.java) }
}

val textScaleHeaderLocator = KTextView {
  withId(R.id.text_size_percent)
  containsText("100%")
}

val sansSerifFontButton = KButton {
  withId(R.id.button_font_family_sans_serif)
  isInstanceOf(MaterialButton::class.java)
}

val serifFontButton = KButton {
  withId(R.id.button_font_family_serif)
  isInstanceOf(MaterialButton::class.java)
}

val focusReadingModeViewLocator = KImageView {
  withDrawable(R.drawable.ic_icon_reading_focus_mode)
  isInstanceOf(AppCompatImageView::class.java)
}

val focusReadingModeSwitch = KSwitch {
  withId(R.id.theme_chooser_reading_focus_mode_switch)
  withText(R.string.reading_focus_mode)
  isInstanceOf(MaterialSwitch::class.java)
}

val focusReadingModeDescriptionLocator = KTextView {
  withId(R.id.theme_chooser_reading_focus_mode_description)
  withParent { isInstanceOf(LinearLayout::class.java) }
}

val themeTitleLocator = KTextView {
  withText("Theme")
}

val lightThemeButton = KButton {
  withId(R.id.button_theme_light)
  withParent { isInstanceOf(LinearLayout::class.java) }
}

val sepiaThemeButton = KButton {
  withId(R.id.button_theme_sepia)
  withParent { isInstanceOf(LinearLayout::class.java) }
}

val darkThemeButton = KButton {
  withId(R.id.button_theme_dark)
  withParent { isInstanceOf(LinearLayout::class.java) }
}

val blackThemeButton = KButton {
  withId(R.id.button_theme_black)
  withParent { isInstanceOf(LinearLayout::class.java) }
}

val matchSystemThemeSwitch = KSwitch {
  withId(R.id.theme_chooser_match_system_theme_switch)
  withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
  isInstanceOf(MaterialSwitch::class.java)
}

val darkModeThemeSwitch = KSwitch {
  withId(R.id.theme_chooser_dark_mode_dim_images_switch)
  withText(R.string.theme_chooser_dialog_image_dimming_switch_label)
  isInstanceOf(MaterialSwitch::class.java)
}