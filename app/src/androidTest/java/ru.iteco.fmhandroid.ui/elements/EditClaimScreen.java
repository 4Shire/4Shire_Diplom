package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class EditClaimScreen {

    public ViewInteraction claimStatus = onView(allOf(withId(R.id.status_label_text_view), withParent(withParent(IsInstanceOf.instanceOf(androidx.cardview.widget.CardView.class)))));
    public ViewInteraction backButton = onView(withId(R.id.close_image_button));
}
