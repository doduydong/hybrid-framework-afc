package com.magento.user;

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
import reportsConfig.ExtentReportsHelper;

import java.lang.reflect.Method;

public class Level_14_ExtentReports_Assert extends BaseTest {
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

    @Test(description = "Register")
    public void TC_01_Register(Method method) {
        ExtentReportsHelper.step("Select 'Register' in 'My Account' header dropdown");
        registerPage = homePage.headerSide().selectRegisterInMyAccountHeaderDropDown();

        ExtentReportsHelper.step("Enter '" + firstName + "' into 'FirstName' textbox");
        registerPage.sendKeysToFirstNameTextBox(firstName);

        ExtentReportsHelper.step("Enter '" + lastName + "' into 'LastName' textbox");
        registerPage.sendKeysToLastNameTextBox(lastName);

        ExtentReportsHelper.step("Enter '" + emailAddress + "' into 'Email' textbox");
        registerPage.sendKeysToEmailTextBox(emailAddress);

        ExtentReportsHelper.step("Enter '" + password + "' into 'Password' textbox");
        registerPage.sendKeysToPasswordTextBox(password);

        ExtentReportsHelper.step("Enter '" + password + "' into 'Confirm Password' textbox");
        registerPage.sendKeysToConfirmPasswordTextBox(password);

        ExtentReportsHelper.step("Click 'Register' button");
        accountDashboardPage = registerPage.clickRegisterButton();

        ExtentReportsHelper.step("Verify register success message is displayed");
        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store");

        ExtentReportsHelper.step("Verify welcome message with username '" + fullName + "' is displayed");
        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        ExtentReportsHelper.step("Verify page title is displayed");
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());
    }

    @Test(description = "Login")
    public void TC_02_Login(Method method) {
        ExtentReportsHelper.step("Select 'Log Out' in 'My Account' header dropdown");
        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();

        ExtentReportsHelper.step("Select 'Log In' in 'My Account' header dropdown");
        loginPage = homePage.headerSide().selectLoginInMyAccountHeaderDropDown();

        ExtentReportsHelper.step("Enter '" + emailAddress + "' into 'Email' textbox");
        loginPage.sendKeysToEmailTextBox(emailAddress);

        ExtentReportsHelper.step("Enter '" + password + "' into 'Password' textbox");
        loginPage.sendKeysToPasswordTextBox(password);

        ExtentReportsHelper.step("Click 'Log In' button");
        accountDashboardPage = loginPage.clickLoginButton();

        ExtentReportsHelper.step("Verify welcome message with username '" + fullName + "' is displayed");
        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        ExtentReportsHelper.step("Verify page title is displayed");
        Assert.assertFalse(accountDashboardPage.isPageTitleDisplayed());

        ExtentReportsHelper.step("Select 'Log Out' in 'My Account' header dropdown");
        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
