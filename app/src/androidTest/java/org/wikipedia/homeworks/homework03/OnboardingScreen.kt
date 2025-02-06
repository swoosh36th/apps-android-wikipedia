package org.wikipedia.homeworks.homework03

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val onboardingFirstScreenImageLocator = listOf(ImageView::class.java, "imageViewCentered")

val primaryOnboardingFirstScreenHeader = listOf(AppTextView::class.java, "primaryTextView")

val secondaryOnboardingFirstScreenHeader = listOf(AppTextView::class.java, "secondaryTextView")

val languagesListLocator = listOf(RecyclerView::class.java, "languagesList")

val englishLanguageOptionLocator = listOf(AppTextView::class.java, "option_label")

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)
val onboardingPageIndicatorLocator = listOf(TabLayout::class.java, "view_onboarding_page_indicator")

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val onboardingSecondScreenImageLocator = listOf(ImageView::class.java, "imageViewCentered")

val primaryOnboardingSecondScreenHeader = listOf(AppTextView::class.java, "primaryTextView")

val secondaryOnboardingSecondScreenHeader = listOf(AppTextView::class.java, "secondaryTextView")