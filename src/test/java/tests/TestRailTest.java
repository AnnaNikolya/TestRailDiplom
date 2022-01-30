package tests;

import constants.IConstants;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
@Log4j2
public class TestRailTest extends BaseTest implements IConstants {
    @Test(priority = 3)
    @Description("Create API Key")
    public void createAPIKeyTest() {
       // loginPage.openPage(DASHBOARD_URL);
     //   loginPage.login(EMAIL, PASSWORD);
        mySettingsPage.createAPIKey("ProjectKey");
        String nameAPIRey = "ProjectKey";
        String getTextCreateAPI = mySettingsPage.findNameAPIKey();
        Assert.assertEquals(nameAPIRey, getTextCreateAPI);
    }

    @Test(priority = 4)
    @Description("Checking the creation of a project without entering data")
    public void createProjectWithoutValueTest() {
      //  loginPage.openPage(DASHBOARD_URL);
      //  loginPage.login(EMAIL, PASSWORD);
        dashboardPage.openDashboardTab();
        projectsPage.createProjectWithoutValue();
        assertTrue(projectsPage.getMistakeText().contains("Field Name is a required field."));
    }

    @Test(priority = 5)
    @Description("Create project Test 2")
    public void createProjectWithValueTest() {
//        loginPage.openPage(DASHBOARD_URL);
//        loginPage.login(EMAIL, PASSWORD);
        adminPage.openAdminTab();
        projectsPage.createProjectWithValue("Test 2", "Successfully added the new project.");
        Assert.assertEquals(projectsPage.findNameProject(), "Test 2");
    }

    @Test(priority = 6)
    @Description("Create test run for project Test 2")
    public void createTestRunTest() {
//        loginPage.openPage(DASHBOARD_URL);
//        loginPage.login(EMAIL, PASSWORD);
        dashboardPage.openDashboardTab();
        dashboardPage.openProject("Test 2");
        projectsPage.createTestRun("FirstTestRun");
        assertTrue(projectsPage.getContentTextInHeader().contains("FirstTestRun"));
    }

    @Test(priority = 7)
    @Description("Create example project Test 3")
    public void createExampleProjectTest() {
//        loginPage.openPage(DASHBOARD_URL);
//        loginPage.login(EMAIL, PASSWORD);
        adminPage.openAdminTab();
        projectsPage.createExampleProject("Test 3");
        String nameExampleProject = "Test 3";
        String getTextNameExampleProjectProject = projectsPage.findNameExampleProject();
        Assert.assertEquals(nameExampleProject, getTextNameExampleProjectProject);
    }

    @Test(priority = 8, dependsOnMethods = "createProjectWithValueTest")
    @Description("Delete project Test 2")
    public void deleteProjectTest() {
//        loginPage.openPage(DASHBOARD_URL);
//        loginPage.login(EMAIL, PASSWORD);
        adminPage.openAdminTab();
        projectsPage.deleteProject();
        assertTrue(projectsPage.getContentAboutDelete().contains("Successfully deleted the project."));
    }

    @Test
    public void loggerTests(){
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }
}
