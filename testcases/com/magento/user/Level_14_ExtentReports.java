package com.magento.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.magento.UserPageGenerator;
import pageObjects.magento.user.UserHomePageObject;
import pageObjects.magento.user.UserLoginPageObject;
import pageObjects.magento.user.UserRegisterPageObject;
import pageObjects.magento.user.myAccount.UserAccountDashboardPageObject;
import reportsConfig.ExtentReportsManager;

import java.lang.reflect.Method;

public class Level_14_ExtentReports extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserAccountDashboardPageObject accountDashboardPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName, GlobalConstants.USER_URL);
        homePage = UserPageGenerator.getUserHomePage(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dong.afc" + getRandomNumber() + "@gmail.com";
        password = "SeJava4@";
    }

    @Test
    public void TC_01_Register(Method method) {
        ExtentReportsManager.startTest(method.getName(), "TC_01_Register");

        ExtentReportsManager.getTest().log(Status.INFO, "Select 'Register' in 'My Account' header dropdown");
        registerPage = homePage.headerSide().selectRegisterInMyAccountHeaderDropDown();

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + firstName + "' into 'FirstName' textbox");
        registerPage.sendKeysToFirstNameTextBox(firstName);

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + lastName + "' into 'LastName' textbox");
        registerPage.sendKeysToLastNameTextBox(lastName);

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + emailAddress + "' into 'Email' textbox");
        registerPage.sendKeysToEmailTextBox(emailAddress);

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + password + "' into 'Password' textbox");
        registerPage.sendKeysToPasswordTextBox(password);

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + password + "' into 'Confirm Password' textbox");
        registerPage.sendKeysToConfirmPasswordTextBox(password);

        ExtentReportsManager.getTest().log(Status.INFO, "Click 'Register' button");
        accountDashboardPage = registerPage.clickRegisterButton();

        ExtentReportsManager.getTest().log(Status.INFO, "Verify register success message is displayed");
        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        ExtentReportsManager.getTest().log(Status.INFO, "Verify welcome message with username '" + fullName + "' is displayed");
        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        ExtentReportsManager.getTest().log(Status.INFO, "Verify page title is displayed");
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());
    }

    @Test
    public void TC_02_Login(Method method) {
        ExtentReportsManager.startTest(method.getName(), "TC_02_Login");

        ExtentReportsManager.getTest().log(Status.INFO, "Select 'Log Out' in 'My Account' header dropdown");
        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();

        ExtentReportsManager.getTest().log(Status.INFO, "Select 'Log In' in 'My Account' header dropdown");
        loginPage = homePage.headerSide().selectLoginInMyAccountHeaderDropDown();

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + emailAddress + "' into 'Email' textbox");
        loginPage.sendKeysToEmailTextBox(emailAddress);

        ExtentReportsManager.getTest().log(Status.INFO, "Enter '" + password + "' into 'Password' textbox");
        loginPage.sendKeysToPasswordTextBox(password);

        ExtentReportsManager.getTest().log(Status.INFO, "Click 'Log In' button");
        accountDashboardPage = loginPage.clickLoginButton();

        ExtentReportsManager.getTest().log(Status.INFO, "Verify welcome message with username '" + fullName + "' is displayed");
        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        ExtentReportsManager.getTest().log(Status.INFO, "Verify page title is displayed");
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        ExtentReportsManager.getTest().log(Status.INFO, "Select 'Log Out' in 'My Account' header dropdown");
        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
