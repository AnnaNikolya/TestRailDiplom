package tests;

import constants.IConstants;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
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
        Assert.assertEquals(loginPage.getDashboardText(), "DASHBOARD");
    }
}