package pages;

import constants.IConstants;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.open;

public class BasePage implements IConstants {
    @Step("Opening URL: '{url}'")
    public void openPage(String url) {
        open(url);
    }
}