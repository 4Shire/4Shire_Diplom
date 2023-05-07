package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.utils.Util.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelScreen {

    public ViewInteraction firstPublicationDate = onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0));
    public ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction editNewsButton = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));
    public ViewInteraction newsStatus = onView(withIndex(withId(R.id.news_item_published_text_view), 0));
    public ViewInteraction newsStatusActive = onView(withIndex(withId(R.id.news_item_published_text_view), 0));
    public ViewInteraction buttonDeleteNews = onView(withIndex(withId(R.id.delete_news_item_image_view), 0));
    public ViewInteraction firstPublicationDateNotActive = onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0));
    public ViewInteraction firstPublicationDateActive = onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0));
    public ViewInteraction buttonEditNewsNotActive = onView(withIndex(withId(R.id.edit_news_item_image_view), 0));

}
