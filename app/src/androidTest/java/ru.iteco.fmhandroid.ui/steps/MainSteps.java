package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static ru.iteco.fmhandroid.ui.utils.Util.waitId;

import android.os.SystemClock;

import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.MainScreen;

public class MainSteps {

    MainScreen MainScreen = new MainScreen();

    public void isMainScreen() {
        Allure.step("Проверка отображения главного экрана");
        MainScreen.allNewsLink.check(matches(isDisplayed()));
        MainScreen.newsLabel.check(matches(withText("News")));
    }

    public void expandNews() {
        Allure.step("Разворачивание блока новостей");
        MainScreen.expandNews.check(matches(isDisplayed()));
        MainScreen.expandNews.perform(click());
    }

    public void expandClaims() {
        Allure.step("Разворачивание блока заявок");
        MainScreen.expandClaims.check(matches(isDisplayed()));
        MainScreen.expandClaims.perform(click());
    }

    public static void waitForLoadingMain() {
        onView(isRoot()).perform(waitId(R.id.all_news_text_view, 7000));
    }

    public void allNewsNotDisplayed() {
        Allure.step("Проверка скрытия ссылки на Все новости");
        MainScreen.allNewsLink.check(matches(not(isDisplayed())));
    }

    public void allNewsDisplayed() {
        Allure.step("Проверка видимости ссылки Все новости");
        MainScreen.allNewsLink.check(matches(isDisplayed()));
    }

    public void allClaimsNotDisplayed() {
        Allure.step("Проверка скрытия ссылки на Все заявки");
        MainScreen.allClaims.check(matches(not(isDisplayed())));
    }

    public void allClaimsDisplayed() {
        Allure.step("Проверка видимости ссылки Все заявки");
        MainScreen.allClaims.check(matches(isDisplayed()));
    }

    public void openAllNews() {
        Allure.step("Клик на Все новости");
        MainScreen.allNewsLink.check(matches(isDisplayed()));
        MainScreen.allNewsLink.perform(click());
    }

    public void openAllClaims() {
        Allure.step("Клик на Все заявки");
        MainScreen.allClaims.check(matches(isDisplayed()));
        MainScreen.allClaims.perform(click());
    }

    public void expandSingleNews() {
        Allure.step("Разворачивание новости");
        MainScreen.expandSingleNews.perform(actionOnItemAtPosition(0, click()));
        MainScreen.newsDescription.check(matches(isDisplayed()));
    }

    public void collapseSingleNews() {
        Allure.step("Сворачивание новость");
        MainScreen.categoryIcon.perform(click());
        MainScreen.newsDescriptionAfterCollapse.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    public void openSingleClaim() {
        Allure.step("Открытие заявки");
        MainScreen.firstClaimExecutorName.perform(click());
        SystemClock.sleep(2000);
    }

    public void createClaim() {
        Allure.step("Создать заявку");
        MainScreen.addNewClaimButton.perform(click());
        SystemClock.sleep(1000);
    }
}
