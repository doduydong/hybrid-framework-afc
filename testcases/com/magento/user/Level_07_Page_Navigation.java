package com.magento.user;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.UserPageGenerator;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageObjects.user.myAccount.UserAccountInformationPageObject;
import pageObjects.user.myAccount.UserAddNewAddressPageObject;

public class Level_07_Page_Navigation extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserAccountDashboardPageObject accountDashboardPage;
    private UserAccountInformationPageObject accountInformationPage;
    private UserAddNewAddressPageObject addNewAddressPage;
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

        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
    }

    @Test
    public void TC_02_Switch_My_Account_Pages() {
        accountInformationPage = accountDashboardPage.sidebar().clickAccountInformationSidebarLink();

        Assert.assertTrue(accountInformationPage.isPageTitleDisplayed());

        addNewAddressPage = accountInformationPage.sidebar().clickAddressBookSidebarLink();

        Assert.assertTrue(addNewAddressPage.isPageTitleDisplayed());

        accountDashboardPage = addNewAddressPage.sidebar().clickAccountDashboardSidebarLink();

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
