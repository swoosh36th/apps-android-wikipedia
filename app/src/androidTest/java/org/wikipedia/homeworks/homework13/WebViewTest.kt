package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator.CSS_SELECTOR
import androidx.test.espresso.web.webdriver.Locator.ID
import androidx.test.espresso.web.webdriver.Locator.XPATH
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework13.pages.article.ArticleScreen
import org.wikipedia.homeworks.homework13.pages.article.DynamicArticleBlock
import org.wikipedia.homeworks.homework13.pages.article.ReferencePagerItem
import org.wikipedia.homeworks.homework13.pages.explore.ExploreScreen
import org.wikipedia.homeworks.homework13.pages.explore.FeaturedArticleCardViewItem
import org.wikipedia.homeworks.homework13.pages.onboarding.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {
  @get:Rule
  val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

  @Test
  fun webViewTest() {
    run {
      OnboardingScreen {
        step("Verify 'Onboarding' screen is opened") { onboardingScreenHeader.isDisplayed() }
        step("Pass 'Onboarding' screen") {
          skipButton {
            step("Verify 'Skip' button is displayed") { isDisplayed() }
            step("Click 'Skip' button") { click() }
          }
        }
      }
      ExploreScreen {
        step("Verify 'Explore' screen is opened") { exploreScreenHeader.isDisplayed() }
        items.childAt<FeaturedArticleCardViewItem>(3) {
          step("Verify header is displayed") { featuredArticleCardHeader.isDisplayed() }
          step("Open article") { imageLocator.click() }
        }
      }
      ArticleScreen {
        pageWebView {
          step("Verify text") {
            withElement(ID, "References") { this.containsText("References") }
          }
          step("Open 5th link") {
            withElement(XPATH, ".//*[@id='cite_ref-OBrien_5-0']/a") { this.click() }
          }
        }
        items.childAt<ReferencePagerItem>(2) {
          step("Verify reference id number") { referenceId.containsText("5") }
          step("Verify reference text") { referenceText.containsText("Roisin") }
        }
        device.uiDevice.pressBack()
        device.uiDevice.pressBack()
        device.uiDevice.pressBack()
        pageWebView {
          step("Click 2nd link") {
            withElement(CSS_SELECTOR, "[title='Crescendo'].mw-redirect") { this.click() }
          }
        }
        DynamicArticleBlock {
          step("Click 'Read' article button") { readArticleButton.click() }
        }
        pageWebView {
          step("Scroll to 'References") {
            withElement(ID, "References") { this.scroll() }
          }
        }
      }
    }
  }
}