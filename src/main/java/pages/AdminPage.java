package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage extends BasePage {
    String ADMIN_TAB = "#navigation-admin";

    @Step("Open tab Administration")
    public void openAdminTab() {
        $(ADMIN_TAB).click();
    }
}
