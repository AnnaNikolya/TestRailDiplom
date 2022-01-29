package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.SignUpPage.openHomePage;


public class SignUpTest extends BaseTest {
    @Test(priority = 1, description = "this test validates the sign-up test")
    @Description ("Create account")
    public void openHomePageTest() {
        openHomePage();
        signUpPage.enterValue("diplontestrail93447", "YourFistName", "YourLastName",
                "BY", "1", "diplontestrail@mailinator.com", "JJJJ",
                "Waiting for email confirmation from");
        String informText = "Waiting for email confirmation from";
        Assert.assertEquals(informText, "Waiting for email confirmation from");
    }
}
