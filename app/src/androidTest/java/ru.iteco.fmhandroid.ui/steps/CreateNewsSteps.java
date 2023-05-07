package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.CreateNewsScreen;

public class CreateNewsSteps {

    CreateNewsScreen CreateNewsScreen = new CreateNewsScreen();

    public void isCreateNewsScreen() {
        Allure.step("Проверка отображения экрана создания новости");
        CreateNewsScreen.title.check(matches(withText("Creating")));
        CreateNewsScreen.subTitle.check(matches(withText("News")));
    }

    public void selectNewsCategory() {
        Allure.step("Выбор категории новости");
        CreateNewsScreen.categoryList.perform(click());
        CreateNewsScreen.newsTitle.perform(click());
    }

    public void enterNewsTitle(String text) {
        Allure.step("Ввод заголовка");
        CreateNewsScreen.newsTitle.perform(replaceText(text), closeSoftKeyboard());
    }

    public void enterNewsPublicationDate(String text) {
        Allure.step("Ввод даты публикации");
        CreateNewsScreen.newsDate.perform(replaceText(text));
    }

    public void checkEnterNewsPublicationDate(String text) {
        Allure.step("Проверка ввода даты публикации");
        CreateNewsScreen.newsDate.check(matches(withText(text)));
    }

    public void enterNewsTime(String text) {
        Allure.step("Ввод времени");
        CreateNewsScreen.newsTime.perform(replaceText(text));
    }

    public void checkEnterNewsTime(String text) {
        Allure.step("Проверка ввода времени");
        CreateNewsScreen.newsTime.check(matches(withText(text)));
    }

    public void enterNewsDescription(String text) {
        Allure.step("Ввод описания");
        CreateNewsScreen.newsDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    public void checkEnterNewsDescription(String text) {
        Allure.step("Проверка ввода описания");
        CreateNewsScreen.newsDescription.check(matches(withText(text)));
    }

    public void checkNewsTitle(String text) {
        Allure.step("Проверка заголовка");
        CreateNewsScreen.newsTitle.check(matches(withText(text)));
    }

    public void checkNewsSwitcher() {
        Allure.step("Проверка переключателя");
        CreateNewsScreen.newsSwitcher.check(matches(allOf(withText("Active"), isDisplayed())));
    }

    public void clickNewsSwitcher() {
        Allure.step("Нажатие переключателя");
        CreateNewsScreen.newsSwitcher.perform(click());
    }
}
