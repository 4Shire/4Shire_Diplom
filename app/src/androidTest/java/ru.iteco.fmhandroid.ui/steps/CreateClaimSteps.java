package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.CreateClaimScreen;

public class CreateClaimSteps {

    CreateClaimScreen CreateClaimScreen = new CreateClaimScreen();

    public void isCreateClaimsScreen() {
        Allure.step("Проверка отображения экрана создания заявки");
        CreateClaimScreen.title.check(matches(withText("Creating")));
        CreateClaimScreen.subTitle.check(matches(withText("Claims")));
    }

    public void checkClaimTitleLength() {
        Allure.step("Проверка длины заголовка");
        CreateClaimScreen.claimTitle.perform(replaceText("Ввод длинного текстового заголовка"));
        CreateClaimScreen.claimTitle.check(matches(withText("Ввод длинного текстового заголовка")));
    }

    public void checkToastEmptyFields() {
        Allure.step("Проверка появления предупреждения о пустых полях");
        CreateClaimScreen.emptyFieldsAlert.check(matches(isDisplayed()));
    }

    public void enterClaimTitle(String text) {
        Allure.step("Ввод заголовка");
        CreateClaimScreen.claimTitle.check(matches(isDisplayed()));
        CreateClaimScreen.claimTitle.perform(replaceText(text));
    }

    public void checkEnterClaimTitle(String text) {
        Allure.step("Проверка ввода заголовка");
        CreateClaimScreen.claimTitle.check(matches(isDisplayed()));
        CreateClaimScreen.claimTitle.check(matches(withText(text)));
    }

    public void selectExecutor() {
        Allure.step("Выбор исполнителя");
        CreateClaimScreen.executorList.perform(click());
        SystemClock.sleep(2000);
        CreateClaimScreen.claimTitle.perform(click(), closeSoftKeyboard());
    }

    public void enterClaimDate(String text) {
        Allure.step("Ввод даты");
        CreateClaimScreen.claimDate.check(matches(isDisplayed()));
        CreateClaimScreen.claimDate.perform(replaceText(text));
    }

    public void checkEnterClaimDate(String text) {
        Allure.step("Проверка ввода даты");
        CreateClaimScreen.claimDate.check(matches(isDisplayed()));
        CreateClaimScreen.claimDate.check(matches(withText(text)));
    }

    public void enterClaimTime(String text) {
        Allure.step("Ввод времени");
        CreateClaimScreen.claimTime.check(matches(isDisplayed()));
        CreateClaimScreen.claimTime.perform(replaceText(text));
    }

    public void checkEnterClaimTime(String text) {
        Allure.step("Проверка ввода времени");
        CreateClaimScreen.claimTime.check(matches(isDisplayed()));
        CreateClaimScreen.claimTime.check(matches(withText(text)));
    }

    public void enterClaimDescription(String text) {
        Allure.step("Ввод описания");
        CreateClaimScreen.claimDescription.check(matches(isDisplayed()));
        CreateClaimScreen.claimDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    public void checkEnterClaimDescription(String text) {
        Allure.step("Проверка ввода описания");
        CreateClaimScreen.claimDescription.check(matches(isDisplayed()));
        CreateClaimScreen.claimDescription.check(matches(withText(text)));
    }
}
