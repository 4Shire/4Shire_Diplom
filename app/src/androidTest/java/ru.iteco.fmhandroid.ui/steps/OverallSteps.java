package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.OverallElements;

public class OverallSteps {

    OverallElements OverallElements = new OverallElements();

    public void logout() {
        Allure.step("Клик Выйти из приложения");
        OverallElements.manImage.perform(click());
        OverallElements.exitButton.perform(click());
    }

    public void clickSave() {
        Allure.step("Клик сохранить");
        OverallElements.buttonSave.perform(click());
        SystemClock.sleep(1500);
    }

    public void clickOK() {
        Allure.step("Клик ОК");
        OverallElements.buttonOkText.perform(click());
    }

    public void clickCancel() {
        Allure.step("Клик отмена");
        OverallElements.buttonCancel.perform(click());
    }

    public void clickCancelText() {
        Allure.step("Клик отмена для подтверждения");
        OverallElements.buttonCancelText.perform(click());
    }

    public void goToThematicQuotes() {
        Allure.step("Перейти в тематические цитаты");
        OverallElements.thematicQuotes.perform(click());
    }

    public void goToScreen(String screen) {
        Allure.step("Перейти к экранам через меню");
        OverallElements.mainMenu.perform(click());
        switch (screen) {
            case ("Main"):
                OverallElements.menuMain.perform(click());
                break;
            case ("News"):
                OverallElements.menuNews.perform(click());
                break;
            case ("About"):
                OverallElements.menuAbout.perform(click());
                break;
            case ("Claims"):
                OverallElements.menuClaims.perform(click());
                break;
        }
    }
}
