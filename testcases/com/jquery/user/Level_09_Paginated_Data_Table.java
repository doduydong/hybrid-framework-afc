package com.jquery.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.JQueryPageGenerator;
import pageObjects.jQuery.WebTablePageObject;

public class Level_09_Paginated_Data_Table extends BaseTest {
    private WebDriver driver;
    private WebTablePageObject webTablePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
        webTablePage = JQueryPageGenerator.getWebTablePage(driver);
    }

    @Test
    public void TC_01_Pagination() {
        webTablePage.goToPaginationPageByNumber("13");

        Assert.assertTrue(webTablePage.isPaginationPageActiveByNumber("13"));

        webTablePage.goToPaginationPageByNumber("10");

        Assert.assertTrue(webTablePage.isPaginationPageActiveByNumber("10"));
    }

    @Test
    public void TC_02_Filter_By_Column() {
        webTablePage.goToPaginationPageByNumber("23");

        Assert.assertTrue(webTablePage.isPaginationPageActiveByNumber("23"));

        webTablePage.sendKeysToTextBoxByLabel("Country", "Vietnam");

        Assert.assertTrue(webTablePage.isRowDisplayedByValues("642000", "Vietnam", "678000", "1320000"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
