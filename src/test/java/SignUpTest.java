import org.testng.annotations.Test;
import pages.SignUpPage;

import static pages.SignUpPage.openHomePage;


public class SignUpTest extends BaseTest {
    @Test
    public void openHomePageTest() {
        openHomePage();
        signUpPage.enterValue("diplontestrail", "YourFistName", "YourLastName",
                "BY", "1", "diplontestrail@mailinator.com", "JJJJ",
                "Waiting for email confirmation from");
    }
}
