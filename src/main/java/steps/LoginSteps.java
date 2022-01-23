package steps;

import constants.IConstants;
import pages.LoginPage;
import pages.TestRailPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {
    private LoginPage loginPage;
    public TestRailPage testRailPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        testRailPage = new TestRailPage();
    }

    public static void openDashboardPage() {
        open("https://diplontestrail1234.testrail.io/");
    }

    public LoginSteps loginAndWorkWithTestRail(String email, String password) {
        loginPage.login(email, password);
        return this;
    }
}
