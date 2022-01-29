package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.security.SecureRandom;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    String FIELD_PROJECT = "#content_container>div.summary-auto";
    String DASHBOARD_TAB = "#navigation-dashboard";

    @Step("Open select project")
    public void openProject(String nameProject) {
        $(FIELD_PROJECT).find(withText(nameProject)).click();
    }


    @Step("Open tab Dashboard")
    public void openDashboardTab() {
        $(DASHBOARD_TAB).click();
    }
}
