package pages;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    String EMAIL_INPUT = "#name";
    String PASSWORD_INPUT = "#password";
    String LOGIN_BUTTON = "#button_primary";
    String DASHBOARD = "#navigation-dashboard";

    public static void openDashboardPage() {
        open(DASHBOARD_URL);
    }

    @Step("Login as email: '{email}' with password: '{password}'")
    public void login(String email, String password) {
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    public String getText() {
        return $(DASHBOARD).getText();
    }
}
