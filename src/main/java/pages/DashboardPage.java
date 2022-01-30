package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.security.SecureRandom;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DashboardPage {
    private static final String FIELD_PROJECT = "#content_container>div.summary-auto";
    private static final String DASHBOARD_TAB = "#navigation-dashboard";

    @Step("Open select project: '{nameProject}'")
    public void openProject(String nameProject) {
        $(FIELD_PROJECT).find(withText(nameProject)).click();
    }

    @Step("Open tab Dashboard")
    public void openDashboardTab() {
        log.info("Click tab Dashboard");
        $(DASHBOARD_TAB).click();
    }
}
