package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class ProjectsPage extends BasePage {
    String ADD_PROJECT_BUTTON = "#sidebar-projects-add";
    String SAVE_ADD_PROJECT_BUTTON = "#accept";
    String MISTAKE_TEXT = ".message.message-error";

    String PROJECT_TAB = "#navigation-sub-projects";
    String FIELD_NAME = "#name";
    String BUTTON_ADD_PROJECT = "a[href*='add']";
    String SUCCESSFULLY_TEXT = ".message.message-success";

    String CHOOSE_PROJECT = ".grid>tbody";
    String TEST_RUN_TAB = "#navigation-runs";
    String ADD_TEST_RUN_BUTTON = "#navigation-runs-add";
    String NAME_TEST_RUN = "#name";
    String SAVE_ADD_TEST_RAN = "#accept";
    String CONTENT_HEADER = "//div[contains(@class,'page_title')]";

    String BUTTON_ADD_EXAMPLE_PROJECT = "//a[contains(text(),'Add Example Project')]";
    String INPUT_NAME = "#addProjectName";
    String ADD_EXAMPLE_PROJECT_BUTTON = "#addProjectSubmit";
    String CHOOSE_EXAMPLE_PROJECT = "//a[contains(text(),'Test 3')]";

    String DELETE = "//a[contains(text(),'Test 2')]/ancestor::tr//div[@class = 'icon-small-delete']";
    String DELETE_CLICK = "//*[@id='deleteDialog']//input[@name='deleteCheckbox']";
    String OK_BUTTON = "//*[@id='deleteDialog']//div[contains(@class,'button-group')]/a[contains(@class,'button-ok')]";
    String TEXT_DELETE = "#content-inner >.message-success";

    @Step("Create project without value")
    public void createProjectWithoutValue() {
        $(ADD_PROJECT_BUTTON).click();
        $(SAVE_ADD_PROJECT_BUTTON).click();
        $(MISTAKE_TEXT).shouldHave(visible);
    }

    public String getMistakeText() {
        return $(MISTAKE_TEXT).getText();
    }

    @Step("Create project called: '{name}' and successful creation:'{text}'")
    public void createProjectWithValue(String name, String text) {
        log.error("ERROR: not input name project");
        $(PROJECT_TAB).click();
        $(BUTTON_ADD_PROJECT).click();
        $(FIELD_NAME).sendKeys(name);
        $(SAVE_ADD_PROJECT_BUTTON).click();
        $(SUCCESSFULLY_TEXT).shouldHave(text(text));
    }

    public String findNameProject() {
        return $(CHOOSE_PROJECT).getText();
    }

    @Step("Create test run called:'{name}'")
    public void createTestRun(String name) {
        log.info("Create project:" + name);
        $(TEST_RUN_TAB).click();
        $(ADD_TEST_RUN_BUTTON).click();
        $(NAME_TEST_RUN).clear();
        $(NAME_TEST_RUN).sendKeys(name);
        $(SAVE_ADD_TEST_RAN).click();
    }

    public String getContentTextInHeader() {
        return $(By.xpath(CONTENT_HEADER)).getText();
    }

    @Step("Create example project called: '{name}'")
    public void createExampleProject(String name) {
        $(PROJECT_TAB).click();
        $(By.xpath(BUTTON_ADD_EXAMPLE_PROJECT)).click();
        $(INPUT_NAME).sendKeys(name);
        $(ADD_EXAMPLE_PROJECT_BUTTON).click();
    }

    public String findNameExampleProject() {
        return $(By.xpath(CHOOSE_EXAMPLE_PROJECT)).getText();
    }

    @Step("Delete select project: Test 2'")
    public void deleteProject() {
        $(PROJECT_TAB).click();
        $(By.xpath(DELETE)).click();
        $(By.xpath(DELETE_CLICK)).click();
        $(By.xpath(OK_BUTTON)).click();
    }

    public String getContentAboutDelete() {
        return $(TEXT_DELETE).getText();
    }
}