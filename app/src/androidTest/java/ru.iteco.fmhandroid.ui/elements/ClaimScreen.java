package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimScreen {

    public ViewInteraction claimFilterButton = onView(withId(R.id.filters_material_button));
    public ViewInteraction claimFilterTitle = onView(withId(R.id.claim_filter_dialog_title));
    public ViewInteraction inProgressFilter = onView(withId(R.id.item_filter_in_progress));
    public ViewInteraction cancelButton = onView(withId(R.id.claim_filter_cancel_material_button));
    public ViewInteraction okButton = onView(withId(R.id.claim_list_filter_ok_material_button));
    public ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));
}
