
import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestRailTest extends BaseTest implements IConstants {
    @Test
    public void createAPIKeyTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        headerPage.dropDown();
        mySettingsPage.createAPIKey("ProjectKey");
        String nameAPIRey = "ProjectKey";
        String getTextCreateAPI = mySettingsPage.findNameAPIKey();
        Assert.assertEquals(nameAPIRey, getTextCreateAPI);
    }

    @Test
    public void createProjectWithoutValueTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        projectsPage.createProjectWithoutValue();
        assertTrue(projectsPage.textMistakeCreate().contains("Field Name is a required field."));
    }

    @Test
    public void createProjectWithValueTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        adminPage.openAdminTab();
        projectsPage.createProjectWithValue("Test 2", "Successfully added the new project.");
        Assert.assertEquals(projectsPage.findNameProject(), "Test 2");
    }

    @Test
    public void createTestRunTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.openProject();
        projectsPage.createTestRun("FirstTestRun");
        assertTrue(projectsPage.contentTextInHeader().contains("FirstTestRun"));
    }

    @Test
    public void createExampleProjectTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        adminPage.openAdminTab();
        projectsPage.createExampleProject("Test 3");
        String nameExampleProject = "Test 3";
        String getTextNameExampleProjectProject = projectsPage.findNameExampleProject();
        Assert.assertEquals(nameExampleProject, getTextNameExampleProjectProject);
    }

    @Test
    public void deleteProjectTest() {
        loginPage.openPage(DASHBOARD_URL);
        loginPage.login(EMAIL, PASSWORD);
        adminPage.openAdminTab();
        projectsPage.deleteProject();
        assertTrue(projectsPage.contentTextAboutDelete().contains("Successfully deleted the project."));

    }
}
