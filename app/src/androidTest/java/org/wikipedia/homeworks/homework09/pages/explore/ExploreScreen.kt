package org.wikipedia.homeworks.homework09.pages.explore

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.items.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.items.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework09.pages.explore.items.NewsCardViewItem
import org.wikipedia.homeworks.homework07.items.SearchCardViewItem
import org.wikipedia.homeworks.homework07.items.TopReadCardViewItem

object ExploreScreen : KScreen<ExploreScreen>() {
  override val layoutId = R.layout.fragment_feed
  override val viewClass = FeedView::class.java
  val exploreScreenHeader = KImageView { withId(R.id.main_toolbar_wordmark) }

  val items = KRecyclerView(
    builder = { withId(R.id.feed_view) },
    itemTypeBuilder = {
      itemType(::SearchCardViewItem)
      itemType(::AnnouncementCardViewItem)
      itemType(::DayHeaderCardViewItem)
      itemType(::TopReadCardViewItem)
      itemType(::NewsCardViewItem)
    }
  )
}