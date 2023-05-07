package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutAppScreen {

    public ViewInteraction versionTitle = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction versionValue = onView(withId(R.id.about_version_value_text_view));
    public ViewInteraction privacyPolicyValue = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction termsLabel = onView(withId(R.id.about_terms_of_use_label_text_view));
    public ViewInteraction termsValue = onView(withId(R.id.about_terms_of_use_value_text_view));
    public ViewInteraction companyLabel = onView(withId(R.id.about_company_info_label_text_view));
    public ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
}
