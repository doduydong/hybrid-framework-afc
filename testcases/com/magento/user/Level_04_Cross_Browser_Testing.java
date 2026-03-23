package com.magento.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

public class Level_04_Cross_Browser_Testing extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserAccountDashboardPageObject accountDashboardPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName);
        homePage = new UserHomePageObject(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dong.afc" + getRandomNumber() + "@gmail.com";
        password = "SeJava4@";
    }

    @Test
    public void TC_01_Register() {
        homePage.selectRegisterInMyAccountHeaderDropDown();
        registerPage = new UserRegisterPageObject(driver);

        registerPage.sendKeysToFirstNameTextBox(firstName);

        registerPage.sendKeysToLastNameTextBox(lastName);

        registerPage.sendKeysToEmailTextBox(emailAddress);

        registerPage.sendKeysToPasswordTextBox(password);

        registerPage.sendKeysToConfirmPasswordTextBox(password);

        registerPage.clickRegisterButton();
        accountDashboardPage = new UserAccountDashboardPageObject(driver);

        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        accountDashboardPage.selectLogoutInMyAccountHeaderDropDown();
        homePage = new UserHomePageObject(driver);
    }

    @Test
    public void TC_02_Login() {
        homePage.selectLoginInMyAccountHeaderDropDown();
        loginPage = new UserLoginPageObject(driver);

        loginPage.sendKeysToEmailTextBox(emailAddress);

        loginPage.sendKeysToPasswordTextBox(password);

        loginPage.clickLoginButton();
        accountDashboardPage = new UserAccountDashboardPageObject(driver);

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        accountDashboardPage.selectLogoutInMyAccountHeaderDropDown();
        homePage = new UserHomePageObject(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
