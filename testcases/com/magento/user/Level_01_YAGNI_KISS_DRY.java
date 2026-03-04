package com.magento.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Level_01_YAGNI_KISS_DRY {
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
        selectOptionInCustomDropDown("//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Register");

        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);

        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);

        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Register']")).click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + fullName + "!");

        selectOptionInCustomDropDown("//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Log Out");
    }

    @Test
    public void TC_02_Login() {
        selectOptionInCustomDropDown("//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Log In");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);

        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@title='Login']")).click();
        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + fullName + "!");

        selectOptionInCustomDropDown("//span[text()='Account']/parent::a", "//div[@id='header-account']//a", "Log Out");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void selectOptionInCustomDropDown(String dropdownXPath, String allOptionsXPath, String expectedValue) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(dropdownXPath))).click();
        List<WebElement> allOptions = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allOptionsXPath)));
        for (WebElement option : allOptions) {
            if (option.getText().equals(expectedValue)) {
                option.click();
                sleepForSeconds(1);
                break;
            }
        }
    }

    public void sleepForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getRandomNumber() {
        return new Random().nextInt(10000);
    }
}
