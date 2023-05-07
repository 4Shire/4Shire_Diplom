package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimScreen;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class ClaimsSteps {

    MainScreen MainScreen = new MainScreen();
    ClaimScreen ClaimScreen = new ClaimScreen();

    public void isClaimsScreen() {
        Allure.step("Проверка отображения экрана заявок");
        MainScreen.addNewClaimButton.check(matches(isDisplayed()));
        MainScreen.allNewsLink.check(doesNotExist());
    }

    public void openFiltering() {
        Allure.step("Открытие фильтра");
        ClaimScreen.claimFilterButton.perform(click());
        ClaimScreen.claimFilterTitle.check(matches(isDisplayed()));
    }

    public void clickCheckboxInProgress() {
        Allure.step("Выбор чекбокса В процессе");
        ClaimScreen.inProgressFilter.perform(click());
    }

    public void checkCheckboxInProgress(boolean checked) {
        Allure.step("Проверка чекбокса В процессе");
        if (checked) {
            ClaimScreen.inProgressFilter.check(matches(isChecked()));
        } else {
            ClaimScreen.inProgressFilter.check(matches(isNotChecked()));
        }
    }

    public void clickCancel() {
        Allure.step("Клик Отмена");
        ClaimScreen.cancelButton.perform(click());
    }

    public void clickOK() {
        Allure.step("Клик ОК");
        ClaimScreen.okButton.perform(click());
    }


    public void createClaim() {
        Allure.step("Клик на кнопку создания заявки");
        ClaimScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1500);
    }
}
