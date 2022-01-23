import constants.IConstants;
import org.testng.annotations.Test;

public class TestRailTest extends BaseTest implements IConstants {
    @Test
    public void createAPIKeyTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        testRailPage.createAPIKey("ProjectKey");
    }

    @Test
    public void createProjectWithoutValueTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        testRailPage.createProjectWithoutValue();
    }

    @Test
    public void createProjectWithValueTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        testRailPage.createProjectWithValue("Test 2", "Successfully added the new project.");
    }

    @Test
    public void createTestRunTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        testRailPage.createTestRun("Successfully added the new test run.");
    }

    @Test
    public void createExampleProjectTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        testRailPage.createExampleProject("Test 3");
    }

    @Test
    public void deleteProjectTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        testRailPage.deleteProject();
    }
}
