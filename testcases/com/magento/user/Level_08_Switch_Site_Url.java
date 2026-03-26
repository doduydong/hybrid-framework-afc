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
import pageObjects.magento.admin.AdminLoginPageObject;
import pageObjects.magento.admin.AdminManageCustomersPageObject;
import pageObjects.magento.user.UserHomePageObject;
import pageObjects.magento.user.UserLoginPageObject;
import pageObjects.magento.user.UserRegisterPageObject;
import pageObjects.magento.user.myAccount.UserAccountDashboardPageObject;

public class Level_08_Switch_Site_Url extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private UserAccountDashboardPageObject userAccountDashboardPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminManageCustomersPageObject adminManageCustomersPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName, GlobalConstants.USER_URL);
        userHomePage = UserPageGenerator.getUserHomePage(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dong.afc" + getRandomNumber() + "@gmail.com";
        password = "SeJava4@";
    }

    @Test
    public void TC_01_User_Site_To_Admin_Site() {
        userRegisterPage = userHomePage.headerSide().selectRegisterInMyAccountHeaderDropDown();

        userRegisterPage.sendKeysToFirstNameTextBox(firstName);

        userRegisterPage.sendKeysToLastNameTextBox(lastName);

        userRegisterPage.sendKeysToEmailTextBox(emailAddress);

        userRegisterPage.sendKeysToPasswordTextBox(password);

        userRegisterPage.sendKeysToConfirmPasswordTextBox(password);

        userAccountDashboardPage = userRegisterPage.clickRegisterButton();

        Assert.assertEquals(userAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(userAccountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        userHomePage = userAccountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();

        adminLoginPage = userHomePage.openAdminSite(driver);

        adminLoginPage.sendKeysToUserNameTextBox("user01");

        adminLoginPage.sendKeysToPasswordTextBox("guru99com");

        adminManageCustomersPage = adminLoginPage.clickLogInButton();

        adminManageCustomersPage.closePopup();

        adminLoginPage = adminManageCustomersPage.clickLogOutLink();
    }

    @Test
    public void TC_02_Admin_Site_To_User_Site() {
        userHomePage = adminLoginPage.openUserSite(driver);

        userLoginPage = userHomePage.headerSide().selectLoginInMyAccountHeaderDropDown();

        userLoginPage.sendKeysToEmailTextBox(emailAddress);

        userLoginPage.sendKeysToPasswordTextBox(password);

        userAccountDashboardPage = userLoginPage.clickLoginButton();

        Assert.assertEquals(userAccountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        userHomePage = userAccountDashboardPage.headerSide().selectLogoutInMyAccountHeaderDropDown();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
