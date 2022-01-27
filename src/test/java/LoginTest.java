import constants.IConstants;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static pages.LoginPage.openDashboardPage;

public class LoginTest extends BaseTest implements IConstants {

    @Before
    @Test
    public void openLoginTest() {
        openDashboardPage();
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertEquals(loginPage.getText(), "DASHBOARD");
    }

}
