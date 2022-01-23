package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    String EMAIL_INPUT = "#name";
    String PASSWORD_INPUT = "#password";
    String LOGIN_BUTTON = "#button_primary";

    public static void openDashboardPage() {
        open(DASHBOARD_URL);
    }

    public void login(String email, String password) {
        $(EMAIL_INPUT).sendKeys(email);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }
}
