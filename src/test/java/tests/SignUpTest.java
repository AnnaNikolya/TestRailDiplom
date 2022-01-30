package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.SignUpPage.openHomePage;

@Log4j2
public class SignUpTest extends BaseTest {
    @Test(priority = 1, description = "this test validates the sign-up test")
    @Description("Create account")
    public void openHomePageTest() {
        openHomePage();
        signUpPage.enterValue("diplontestrai3347", "YourFistName", "YourLastName",
                "BY", "1", "diplontestrail@mailinator.com", "JJJJ",
                "Waiting for email confirmation from");
        String informText = "Waiting for email confirmation from";
        String getTextСonfirmation = signUpPage.findVerifyText();
        Assert.assertEquals(getTextСonfirmation, informText);
    }
}