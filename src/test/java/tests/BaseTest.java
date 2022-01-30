package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    MySettingsPage mySettingsPage;
    ProjectsPage projectsPage;


    @BeforeMethod
    public void init(ITestContext context) {
        if (System.getProperty("browser") != null) {
            if (System.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (System.getProperty("browser").equals("safari")) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
//        Configuration.browser = "chrome";
//        Configuration.timeout = 30000;
//        Configuration.holdBrowserOpen = true;
//        Configuration.headless = false;
        driver.manage().window().maximize();
        String driverVariable = "driver";
        context.setAttribute(driverVariable, driver);
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        mySettingsPage = new MySettingsPage();
        projectsPage = new ProjectsPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}