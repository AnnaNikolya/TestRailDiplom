package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AdminPage extends BasePage {
    String ADMIN_TAB = "#navigation-admin";

    @Step("Open tab Administration")
    public void openAdminTab() {
        log.info("Go to te tab administration");
        $(ADMIN_TAB).click();
    }
}