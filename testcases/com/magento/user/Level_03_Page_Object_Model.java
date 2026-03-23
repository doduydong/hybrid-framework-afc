package com.magento.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object_Model {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserAccountDashboardPageObject accountDashboardPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://live.techpanda.org/");

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

    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }
}
