package com.magento.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_Selenium_Wrapper extends BasePage {
    WebDriver driver;
    WebDriverWait explicitWait;
    String firstName, lastName, fullName, emailAddress, password;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://live.techpanda.org/");

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dong.afc" + getRandomNumber() + "@gmail.com";
        password = "SeJava4@";
    }

    @Test
    public void TC_01_Register() {
        selectOptionInCustomDropDown(driver, "//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Register");

        sendKeysToElement(driver, "//input[@id='firstname']", firstName);

        sendKeysToElement(driver, "//input[@id='lastname']", lastName);

        sendKeysToElement(driver, "//input[@id='email_address']", emailAddress);

        sendKeysToElement(driver, "//input[@id='password']", password);

        sendKeysToElement(driver, "//input[@id='confirmation']", password);

        waitForElementClickable(driver, "//button[@title='Register']");
        clickToElement(driver, "//button[@title='Register']");
        acceptAlert(driver);

        Assert.assertEquals(getElementText(driver, "//li[@class='success-msg']//span"), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(getElementText(driver, "//div[@class='welcome-msg']//strong"), "Hello, " + fullName + "!");

        selectOptionInCustomDropDown(driver, "//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Log Out");
    }

    @Test
    public void TC_02_Login() {
        selectOptionInCustomDropDown(driver, "//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Log In");

        sendKeysToElement(driver, "//input[@id='email']", emailAddress);

        sendKeysToElement(driver, "//input[@id='pass']", password);

        waitForElementClickable(driver, "//button[@title='Login']");
        clickToElement(driver, "//button[@title='Login']");
        acceptAlert(driver);

        Assert.assertEquals(getElementText(driver, "//div[@class='welcome-msg']//strong"), "Hello, " + fullName + "!");

        selectOptionInCustomDropDown(driver, "//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Log Out");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }
}
