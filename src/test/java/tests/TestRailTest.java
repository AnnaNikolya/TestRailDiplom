package tests;

import constants.IConstants;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Log4j2
public class TestRailTest extends LoginTest implements IConstants {
    @Test(priority = 3)
    @Description("Create API Key")
    public void createAPIKeyTest() {
        dashboardPage.openDashboardTab();
        mySettingsPage.createAPIKey("ProjectKey");
        String nameAPIRey = "ProjectKey";
        String getTextCreateAPI = mySettingsPage.findNameAPIKey();
        Assert.assertEquals(getTextCreateAPI, nameAPIRey);
    }

    @Test(priority = 4)
    @Description("Checking the creation of a project without entering data")
    public void createProjectWithoutValueTest() {
        dashboardPage.openDashboardTab();
        projectsPage.createProjectWithoutValue();
        assertTrue(projectsPage.getMistakeText().contains("Field Name is a required field."));
    }

    @Test(priority = 5)
    @Description("Create project Test 2")
    public void createProjectWithValueTest() {
        adminPage.openAdminTab();
        projectsPage.createProjectWithValue("Test 2", "Successfully added the new project.");
        assertTrue(projectsPage.findNameProject().contains("Test 2"));
    }

    @Test(priority = 6)
    @Description("Create test run for project Test 2")
    public void createTestRunTest() {
        dashboardPage.openDashboardTab();
        dashboardPage.openProject("Test 2");
        projectsPage.createTestRun("FirstTestRun");
        assertTrue(projectsPage.getContentTextInHeader().contains("FirstTestRun"));
    }

    @Test(priority = 7)
    @Description("Create example project Test 3")
    public void createExampleProjectTest() {
        adminPage.openAdminTab();
        projectsPage.createExampleProject("Test 3");
        String nameExampleProject = "Test 3";
        String getTextNameExampleProjectProject = projectsPage.findNameExampleProject();
        Assert.assertEquals(nameExampleProject, getTextNameExampleProjectProject);
    }

    @Test(priority = 8, dependsOnMethods = "createProjectWithValueTest")
    @Description("Delete project Test 2")
    public void deleteProjectTest() {
        adminPage.openAdminTab();
        projectsPage.deleteProject();
        assertTrue(projectsPage.getContentAboutDelete().contains("Successfully deleted the project."));
    }
}
