package com.magento.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.PageFactoryAccountDashboard;
import pageFactory.PageFactoryHome;
import pageFactory.PageFactoryLogin;
import pageFactory.PageFactoryRegister;

public class Level_05_Page_Factory extends BaseTest {
    private WebDriver driver;
    private PageFactoryHome homePage;
    private PageFactoryRegister registerPage;
    private PageFactoryLogin loginPage;
    private PageFactoryAccountDashboard accountDashboardPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName);
        homePage = new PageFactoryHome(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dong.afc" + getRandomNumber() + "@gmail.com";
        password = "SeJava4@";
    }

    @Test
    public void TC_01_Register() {
        homePage.selectRegisterInMyAccountHeaderDropDown();
        registerPage = new PageFactoryRegister(driver);

        registerPage.sendKeysToFirstNameTextBox(firstName);

        registerPage.sendKeysToLastNameTextBox(lastName);

        registerPage.sendKeysToEmailTextBox(emailAddress);

        registerPage.sendKeysToPasswordTextBox(password);

        registerPage.sendKeysToConfirmPasswordTextBox(password);

        registerPage.clickRegisterButton();
        accountDashboardPage = new PageFactoryAccountDashboard(driver);

        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        accountDashboardPage.selectLogoutInMyAccountHeaderDropDown();
        homePage = new PageFactoryHome(driver);
    }

    @Test
    public void TC_02_Login() {
        homePage.selectLoginInMyAccountHeaderDropDown();
        loginPage = new PageFactoryLogin(driver);

        loginPage.sendKeysToEmailTextBox(emailAddress);

        loginPage.sendKeysToPasswordTextBox(password);

        loginPage.clickLoginButton();

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        accountDashboardPage.selectLogoutInMyAccountHeaderDropDown();
        homePage = new PageFactoryHome(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
