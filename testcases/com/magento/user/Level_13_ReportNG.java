package com.magento.user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.SoftAssertListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.magento.UserPageGenerator;
import pageObjects.magento.user.UserHomePageObject;
import pageObjects.magento.user.UserLoginPageObject;
import pageObjects.magento.user.UserRegisterPageObject;
import pageObjects.magento.user.myAccount.UserAccountDashboardPageObject;

public class Level_13_ReportNG extends BaseTest {
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
    public void TC_01_Register() {
        log.info("******* TC_01_Register *******");

        log.info("Select 'Register' in 'My Account' header dropdown");
        registerPage = homePage.headerSide().selectRegisterInMyAccountHeaderDropDown();

        log.info("Enter '" + firstName + "' into 'FirstName' textbox");
        registerPage.sendKeysToFirstNameTextBox(firstName);

        log.info("Enter '" + lastName + "' into 'LastName' textbox");
        registerPage.sendKeysToLastNameTextBox(lastName);

        log.info("Enter '" + emailAddress + "' into 'Email' textbox");
        registerPage.sendKeysToEmailTextBox(emailAddress);

        log.info("Enter '" + password + "' into 'Password' textbox");
        registerPage.sendKeysToPasswordTextBox(password);

        log.info("Enter '" + password + "' into 'Confirm Password' textbox");
        registerPage.sendKeysToConfirmPasswordTextBox(password);

        log.info("Click 'Register' button");
        accountDashboardPage = registerPage.clickRegisterButton();

        log.info("Verify register success message is displayed");
        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        log.info("Verify welcome message with username '" + fullName + "' is displayed");
        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        log.info("Verify page title is displayed");
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());
    }

    @Test
    public void TC_02_Login() {
        log.info("******* TC_02_Login *******");

        log.info("Select 'Log Out' in 'My Account' header dropdown");
        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();

        log.info("Select 'Log In' in 'My Account' header dropdown");
        loginPage = homePage.headerSide().selectLoginInMyAccountHeaderDropDown();

        log.info("Enter '" + emailAddress + "' into 'Email' textbox");
        loginPage.sendKeysToEmailTextBox(emailAddress);

        log.info("Enter '" + password + "' into 'Password' textbox");
        loginPage.sendKeysToPasswordTextBox(password);

        log.info("Click 'Log In' button");
        accountDashboardPage = loginPage.clickLoginButton();

        log.info("Verify welcome message with username '" + fullName + "' is displayed");
        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        log.info("Verify page title is displayed");
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        log.info("Select 'Log Out' in 'My Account' header dropdown");
        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
