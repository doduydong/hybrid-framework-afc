package com.magento.user;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.SoftAssertListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.magento.UserPageGenerator;
import pageObjects.magento.user.UserHomePageObject;
import pageObjects.magento.user.UserLoginPageObject;
import pageObjects.magento.user.UserRegisterPageObject;
import pageObjects.magento.user.myAccount.UserAccountDashboardPageObject;

@Listeners(SoftAssertListener.class)
public class Level_11_Custom_Soft_Assert extends BaseTest {
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
        registerPage = homePage.headerSide().selectRegisterInMyAccountHeaderDropDown();

        registerPage.sendKeysToFirstNameTextBox(firstName);

        registerPage.sendKeysToLastNameTextBox(lastName);

        registerPage.sendKeysToEmailTextBox(emailAddress);

        registerPage.sendKeysToPasswordTextBox(password);

        registerPage.sendKeysToConfirmPasswordTextBox(password);

        accountDashboardPage = registerPage.clickRegisterButton();

        verifyEqual(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store");

        verifyEqual(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        verifyTrue(!accountDashboardPage.isPageTitleDisplayed());

        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();
    }

    @Test
    public void TC_02_Login() {
        loginPage = homePage.headerSide().selectLoginInMyAccountHeaderDropDown();

        loginPage.sendKeysToEmailTextBox(emailAddress);

        loginPage.sendKeysToPasswordTextBox(password);

        accountDashboardPage = loginPage.clickLoginButton();

        verifyEqual(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName);

        verifyFalse(accountDashboardPage.isPageTitleDisplayed());

        homePage = accountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
