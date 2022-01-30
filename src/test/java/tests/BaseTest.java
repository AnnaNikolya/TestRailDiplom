package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    LoginPage loginPage;
    SignUpPage signUpPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    MySettingsPage mySettingsPage;
    ProjectsPage projectsPage;

    @BeforeMethod
    public void init(ITestContext context) {
        Configuration.browser = "chrome";
        Configuration.timeout = 30000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        mySettingsPage = new MySettingsPage();
        projectsPage = new ProjectsPage();
        ChromeDriverFactory driver = new ChromeDriverFactory();
        String driverVariable = "driver" ;
        context.setAttribute(driverVariable, driver);
    }

    @AfterMethod
    public void quit() {
    }
}
