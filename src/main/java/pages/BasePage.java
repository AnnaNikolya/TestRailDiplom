package pages;

import constants.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;


import static com.codeborne.selenide.Selenide.open;
@Log4j2
public class BasePage implements IConstants {
    @Step("Opening URL: '{url}'")
    public void openPage(String url) {
        log.info("Open URL:" +url);
        open(url);
    }
}