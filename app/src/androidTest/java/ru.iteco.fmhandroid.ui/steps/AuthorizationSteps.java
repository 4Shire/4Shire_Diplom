package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AuthorizationScreen;

public class AuthorizationSteps {

    AuthorizationScreen AuthorizationScreen = new AuthorizationScreen();

    public void isAuthorizationScreen() {
        Allure.step("Проверка отображения экрана авторизации");
        AuthorizationScreen.label.check(matches(isDisplayed()));
    }

    public void enterLogin(String text) {
        Allure.step("Ввод логина");
        AuthorizationScreen.loginInput.check(matches(isEnabled()));
        AuthorizationScreen.loginInput.perform(replaceText(text));
    }

    public void checkEnterLogin(String text) {
        Allure.step("Проверка ввода логина");
        AuthorizationScreen.loginInput.check(matches(isEnabled()));
        AuthorizationScreen.loginInput.check(matches(withText(text)));
    }

    public void enterPassword(String text) {
        Allure.step("Ввод пароля");
        AuthorizationScreen.passwordInput.check(matches(isEnabled()));
        AuthorizationScreen.passwordInput.perform(replaceText(text));
    }

    public void checkEnterPassword(String text) {
        Allure.step("Проверка ввода пароля");
        AuthorizationScreen.passwordInput.check(matches(isEnabled()));
        AuthorizationScreen.passwordInput.check(matches(withText(text)));
    }

    public void clickSignInButton() {
        Allure.step("Нажатие кнопки SIGN IN");
        AuthorizationScreen.signInButton.check(matches(isClickable()));
        AuthorizationScreen.signInButton.perform(click());
    }
}

