package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TestRailPage extends LoginPage {
    String ACCOUNT_TAB = "#navigation-user";
    String MY_SETTING_TAB = "#navigation-user-settings";
    String API_KEY_TAB = "[class='tab4']";
    String ADD_KEY_BUTTON = "#addToken > p > a";
    String TOKEN_NAME = "#userTokenName";
    String GENERATE_KEY = "#userTokenGenerate";
    String SAVE_KEY = "#userTokenAdd";

    String ADD_PROJECT_BUTTON = "#navigation-empty-addproject";
    String SAVE_ADD_PROJECT_BUTTON = "#accept";
    String MISTAKE_TEXT = "[class='message message-error']";


    String ADMIN_TAB = "#navigation-admin";
    String PROJECT_TAB = "#navigation-sub-projects";
    String FIELD_NAME = "#name";
    String BUTTON_ADD_PROJECT = "a[href*='add']";
    String SUCCESSFULLY_TEXT = "[class='message message-success']";

    String CHOOSE_PROJECT = "//a[contains(text(),'Test 2')]";
    String TEST_RUN_TAB = "#navigation-runs";
    String ADD_TEST_RUN_BUTTON = "#navigation-runs-add";
    String SAVE_ADD_TEST_RAN = "#accept";
    String SUCCESSFULLY_TEST_RUN = "[class='content-header-title page_title display-inline-block']";

    String BUTTON_ADD_EXAMPLE_PROJECT = "//a[contains(text(),'Add Example Project')]";
    String INPUT_NAME = "#addProjectName";
    String ADD_EXAMPLE_PROJECT_BUTTON = "#addProjectSubmit";
    String DOWNLOAD = "#activities-as-png-download";

    String DELETE = "//a[contains(text(),'aaef')]/ancestor::tr//div[@class = 'icon-small-delete']";
    String DELETE_CLICK = "//*[@id='deleteDialog']//input[@name='deleteCheckbox']";
    String OK_BUTTON = "//*[@id='deleteDialog']//div[contains(@class,'button-group')]/a[contains(@class,'button-ok')]";


    public void createAPIKey(String name) {
        $(ACCOUNT_TAB).click();
        $(MY_SETTING_TAB).click();
        $(API_KEY_TAB).click();
        $(ADD_KEY_BUTTON).click();
        $(TOKEN_NAME).sendKeys(name);
        $(GENERATE_KEY).click();
        $(SAVE_KEY).click();
    }

    public void createProjectWithoutValue() {
        $(ADD_PROJECT_BUTTON).click();
        $(SAVE_ADD_PROJECT_BUTTON).click();
        $(MISTAKE_TEXT).shouldHave(Condition.visible);// shouldHave(text(" "));
    }

    public void createProjectWithValue(String name, String text) {
        $(ADMIN_TAB).click();
        $(PROJECT_TAB).click();
        $(BUTTON_ADD_PROJECT).click();
        $(FIELD_NAME).sendKeys(name);
        $(SAVE_ADD_PROJECT_BUTTON).click();
        $(SUCCESSFULLY_TEXT).shouldHave(text(text));
    }

    public void createTestRun(String text) {
        $(By.xpath(CHOOSE_PROJECT)).click();
        $(TEST_RUN_TAB).click();
        $(ADD_TEST_RUN_BUTTON).click();
        $(SAVE_ADD_TEST_RAN).click();
        $(SUCCESSFULLY_TEST_RUN).shouldHave(text(text));
    }

    public void createExampleProject(String name) {
        $(ADMIN_TAB).click();
        $(PROJECT_TAB).click();
        $(By.xpath(BUTTON_ADD_EXAMPLE_PROJECT)).click();
        $(INPUT_NAME).sendKeys(name);
        $(ADD_EXAMPLE_PROJECT_BUTTON).click();
        $(DOWNLOAD).click();
    }

    public void deleteProject() {
        $(ADMIN_TAB).click();
        $(PROJECT_TAB).click();
        $(By.xpath(DELETE)).click();
        $(DELETE_CLICK).click();
        $(OK_BUTTON).click();
    }

}


