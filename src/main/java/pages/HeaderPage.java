package pages;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage extends BasePage {
    String ACCOUNT_TAB = "#navigation-user";
    String MY_SETTING_TAB = "#navigation-user-settings";

    public void dropDown() {
        $(ACCOUNT_TAB).click();
        $(MY_SETTING_TAB).click();
    }
}
