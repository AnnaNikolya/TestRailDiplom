package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MySettingsPage {
    String API_KEY_TAB = ".tab4";
    String ADD_KEY_BUTTON = "#addToken > p > a";
    String TOKEN_NAME = "#userTokenName";
    String GENERATE_KEY = "#userTokenGenerate";
    String SAVE_KEY = "#userTokenAdd";
    String NAME_API_REY = ".odd.token>td:nth-child(1)";

    @Step("Create API Key named: '{name}'")
    public void createAPIKey(String name) {
        $(API_KEY_TAB).click();
        $(ADD_KEY_BUTTON).click();
        $(TOKEN_NAME).sendKeys(name);
        $(GENERATE_KEY).click();
        $(SAVE_KEY).click();
    }

    public String findNameAPIKey() {
        return $(NAME_API_REY).getText();
    }
}
