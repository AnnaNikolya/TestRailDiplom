package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    String CHOOSE_PROJECT = "//a[contains(text(),'Test 3')]";

    public void openProject() {
        $(By.xpath(CHOOSE_PROJECT)).click();
    }
}
