import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TestRailPage;
import pages.LoginPage;
import pages.SignUpPage;

public class BaseTest {
    LoginPage loginPage;
    SignUpPage signUpPage;
    TestRailPage testRailPage;

    @BeforeMethod
    public void init() {
        Configuration.browser = "chrome";
        Configuration.timeout = 30000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        testRailPage = new TestRailPage();
    }

    @AfterMethod
    public void quit() {
    }

}
