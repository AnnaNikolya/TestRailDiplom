package tests;

import constants.IConstants;

import io.qameta.allure.Description;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.LoginPage.openDashboardPage;

public class LoginTest extends BaseTest implements IConstants {

    @Before
    @Test(priority = 2)
    @Description("Open TestRail account")
    public void openLoginTest() {
        openDashboardPage();
        loginPage.login(EMAIL, PASSWORD);
        // loginPage.login(System.getenv().getOrDefault("username", PropertyReader.getProperty("username")), System.getProperty("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(loginPage.getText(), "DASHBOARD");
    }
}
