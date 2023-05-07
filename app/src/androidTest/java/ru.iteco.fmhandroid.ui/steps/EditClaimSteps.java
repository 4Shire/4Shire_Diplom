package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.utils.Util.nestedScrollTo;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.EditClaimScreen;

public class EditClaimSteps {

    EditClaimScreen EditClaimScreen = new EditClaimScreen();

    public void isClaimsEditScreen() {
        Allure.step("Проверка отображения экрана редактирования заявки");
        EditClaimScreen.claimStatus.check(matches(isDisplayed()));
    }

    public void backFromClaim() {
        Allure.step("Возврат назад");
        EditClaimScreen.backButton.perform(nestedScrollTo());
        EditClaimScreen.backButton.perform(click());
    }
}
