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
        signUpPage.enterValue("diplontestwork1289391252", "YourFistName11", "YourLastName11",
                "BY", "1", "diplontestrail@mailinator.com", "kkk34",
                "Please confirm your account by clicking the link we've just emailed you");
        String informText = "Please confirm your account by clicking the link we've just emailed you";
        String getTextEmailed = signUpPage.findVerifyText();
        Assert.assertEquals(getTextEmailed, informText);
    }
}