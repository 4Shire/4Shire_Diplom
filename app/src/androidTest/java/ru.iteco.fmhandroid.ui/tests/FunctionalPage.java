package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Util.checkClaimStatus;
import static ru.iteco.fmhandroid.ui.utils.Util.getCurrentTime;
import static ru.iteco.fmhandroid.ui.utils.Util.getTestCurrentDate;
import static ru.iteco.fmhandroid.ui.utils.Util.isDisplayedWithSwipe;

import android.content.Intent;
import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutAppSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.CreateClaimSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.EditClaimSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsFilterSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.OverallSteps;
import ru.iteco.fmhandroid.ui.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class FunctionalPage {

    AuthorizationSteps AuthorizationSteps = new AuthorizationSteps();
    MainSteps MainSteps = new MainSteps();
    NewsSteps NewsSteps = new NewsSteps();
    ClaimsSteps ClaimsSteps = new ClaimsSteps();
    EditClaimSteps EditClaimSteps = new EditClaimSteps();
    CreateClaimSteps CreateClaimSteps = new CreateClaimSteps();
    OverallSteps OverallSteps = new OverallSteps();
    ControlPanelSteps ControlPanelSteps = new ControlPanelSteps();
    CreateNewsSteps CreateNewsSteps = new CreateNewsSteps();
    NewsFilterSteps NewsFilterSteps = new NewsFilterSteps();
    AboutAppSteps AboutAppSteps = new AboutAppSteps();
    QuotesSteps QuotesSteps = new QuotesSteps();

    public static String newsTitleString = "Тестовый тайтл" + getTestCurrentDate();
    public static String newsTitleForEditing = "Тестовый заголовок" + getTestCurrentDate();
    public static String newsDescriptionString = "Тестовое описание" + getTestCurrentDate();
    String newsPublicationDate = getTestCurrentDate();
    String newsTime = getCurrentTime();


    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void loginCheck() {
        SystemClock.sleep(8000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.enterLogin("login2");
        AuthorizationSteps.enterPassword("password2");
        AuthorizationSteps.clickSignInButton();
        SystemClock.sleep(2000);
    }

    @Test
    @DisplayName("Разворачивание блока новостей и заявок")
    public void expandAll() {
        MainSteps.expandNews();
        MainSteps.allNewsNotDisplayed();
        MainSteps.expandClaims();
        MainSteps.allClaimsNotDisplayed();

        MainSteps.expandNews();
        MainSteps.allNewsDisplayed();
        MainSteps.expandClaims();
        MainSteps.allClaimsDisplayed();
    }

    @Test
    @DisplayName("Открытие экрана всех новостей")
    public void openAllNews() {
        MainSteps.openAllNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    @DisplayName("Открытие экрана всех заявок")
    public void openAllClaims() {
        MainSteps.openAllClaims();
        ClaimsSteps.isClaimsScreen();
    }


    @Test
    @DisplayName("Разворачивание одной новости")
    public void expandSingleNews() {
        MainSteps.expandSingleNews();
        MainSteps.collapseSingleNews();
    }

    @Test
    @DisplayName("Просмотр заявки")
    public void openSingleClaim() {
        MainSteps.waitForLoadingMain();
        MainSteps.openSingleClaim();
        EditClaimSteps.isClaimsEditScreen();
        EditClaimSteps.backFromClaim();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("Создание заявки")
    public void createClaim() {
        String claimTitleString = "Тестовый тайтл " + getTestCurrentDate() + "В" + getCurrentTime();
        String newClaimTitleString = "Тестовое описание заявки " + getTestCurrentDate();
        String currentDate = getTestCurrentDate();
        String currentTime = getCurrentTime();
        MainSteps.createClaim();
        SystemClock.sleep(1000);

        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.checkClaimTitleLength();

        OverallSteps.clickSave();
        CreateClaimSteps.checkToastEmptyFields();
        OverallSteps.clickOK();

        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.checkEnterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.checkEnterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.checkEnterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        CreateClaimSteps.checkEnterClaimDescription(newClaimTitleString);

        OverallSteps.clickCancel();
        OverallSteps.clickCancelText();
        CreateClaimSteps.isCreateClaimsScreen();

        OverallSteps.clickCancel();
        OverallSteps.clickOK();
        MainSteps.isMainScreen();


        MainSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
        CreateClaimSteps.enterClaimTitle(claimTitleString);
        CreateClaimSteps.checkEnterClaimTitle(claimTitleString);
        CreateClaimSteps.selectExecutor();
        CreateClaimSteps.enterClaimDate(currentDate);
        CreateClaimSteps.enterClaimTime(currentTime);
        CreateClaimSteps.enterClaimDescription(newClaimTitleString);
        OverallSteps.clickSave();
        SystemClock.sleep(1000);

        MainSteps.openAllClaims();

        if (isDisplayedWithSwipe(onView(withText(claimTitleString)), 2, true)) {
            onView(withText(claimTitleString)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        } else {
            throw new NoSuchElementException("Not found " + onView(withText(claimTitleString)).toString());
        }
    }

    @Test
    @DisplayName("Фильтрация заявок")
    public void filteringClaims() {
        MainSteps.openAllClaims();
        ClaimsSteps.openFiltering();
        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickCancel();
        ClaimsSteps.openFiltering();
        ClaimsSteps.checkCheckboxInProgress(true);

        ClaimsSteps.clickCheckboxInProgress();
        ClaimsSteps.clickOK();
        checkClaimStatus("Open");
        ClaimsSteps.isClaimsScreen();
    }


    @Test
    @DisplayName("Открытие экрана заявок")
    public void claimScreen() {
        OverallSteps.goToScreen("Claims");
        ClaimsSteps.isClaimsScreen();

        ClaimsSteps.createClaim();
        CreateClaimSteps.isCreateClaimsScreen();
    }


    @Test
    @DisplayName("Создание новости")             //Иногда выпадает в перезагрузку девайса
    public void controlPanelCreateNews() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();

        ControlPanelSteps.createNews();

        CreateNewsSteps.isCreateNewsScreen();

        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        OverallSteps.clickCancel();
        OverallSteps.clickCancelText();
        CreateNewsSteps.checkNewsTitle(newsTitleString);

        OverallSteps.clickCancel();
        OverallSteps.clickOK();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        OverallSteps.clickSave();
        ControlPanelSteps.isControlPanel();
    }


    @Test
    @DisplayName("Фильтрация новостей")
    public void newsScreenFiltering() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleString);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.checkEnterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.checkEnterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkEnterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        OverallSteps.clickSave();
        ControlPanelSteps.isControlPanel();

        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickFilter();

        NewsSteps.checkFirstNewsDate(newsPublicationDate);

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDate(newsPublicationDate);

        ControlPanelSteps.clickEditNews();
        CreateNewsSteps.clickNewsSwitcher();
        OverallSteps.clickSave();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.clickCheckboxActive();
        NewsFilterSteps.checkCheckboxActive(false);
        NewsFilterSteps.checkCheckboxNotActive(true);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDateNotActive(newsPublicationDate);
        ControlPanelSteps.checkNewsStatus();

        ControlPanelSteps.checkNewsStatusNotActive();
        CreateNewsSteps.clickNewsSwitcher();
        OverallSteps.clickSave();

        NewsSteps.openFilter();
        NewsFilterSteps.enterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateStart(newsPublicationDate);
        NewsFilterSteps.enterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.checkEnterPublishDateEnd(newsPublicationDate);
        NewsFilterSteps.checkCheckboxActive(true);
        NewsFilterSteps.clickCheckboxNotActive();
        NewsFilterSteps.checkCheckboxNotActive(false);
        NewsFilterSteps.clickFilter();

        ControlPanelSteps.checkFirstPublicationDateActive(newsPublicationDate);
        ControlPanelSteps.checkNewsStatusActive();

        ControlPanelSteps.clickDeleteNews();
        OverallSteps.clickOK();
    }

    @Test
    @DisplayName("Редактирование новости")
    public void newsEditing() {
        OverallSteps.goToScreen("News");
        NewsSteps.isNewsScreen();

        NewsSteps.goToControlPanel();
        ControlPanelSteps.isControlPanel();

        ControlPanelSteps.createNews();
        CreateNewsSteps.isCreateNewsScreen();
        CreateNewsSteps.selectNewsCategory();
        CreateNewsSteps.enterNewsTitle(newsTitleForEditing);
        CreateNewsSteps.enterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.checkEnterNewsPublicationDate(newsPublicationDate);
        CreateNewsSteps.enterNewsTime(newsTime);
        CreateNewsSteps.checkEnterNewsTime(newsTime);
        CreateNewsSteps.enterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkEnterNewsDescription(newsDescriptionString);
        CreateNewsSteps.checkNewsSwitcher();

        OverallSteps.clickSave();
        ControlPanelSteps.isControlPanel();
    }

    @Test
    @DisplayName("Открытие информации о приложении и возврат на главный экран")
    public void aboutScreenAndBackToMain() {
        OverallSteps.goToScreen("About");
        AboutAppSteps.checkScreenAboutTheAplication();
        AboutAppSteps.goBack();
        MainSteps.isMainScreen();
    }

    @Test
    @DisplayName("Открытие экрана цитат и проверка функционала")
    public void thematicQuotes() {
        OverallSteps.goToThematicQuotes();
        QuotesSteps.checkTitleText();
        QuotesSteps.expandQuote();
        QuotesSteps.collapseQuote();
    }

    @Test
    @DisplayName("Проверка открытия ссылки на политику конфиденциальности")
    public void privacyPolicyLink() {
        OverallSteps.goToScreen("About");
        Intents.init();
        AboutAppSteps.goToPrivacyPolicy();
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Test
    @DisplayName("Проверка открытия ссылки на правила пользования")
    public void termsOfUseLink() {
        OverallSteps.goToScreen("About");
        Intents.init();
        AboutAppSteps.goToTermsOfUse();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }
}
