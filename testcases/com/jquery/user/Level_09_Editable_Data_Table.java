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

public class Level_09_Editable_Data_Table extends BaseTest {
    private WebDriver driver;
    private WebTablePageObject webTablePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        webTablePage = JQueryPageGenerator.getWebTablePage(driver);
    }

    @Test
    public void TC_01_Inline_Table_Editing() {
        webTablePage.senKeysToTextBoxOfColumnAtRow("Company", "1", "SDET");

        webTablePage.senKeysToTextBoxOfColumnAtRow("Contact Person", "2", "Dong");

        webTablePage.selectCountryDropDownAtRow("3", "Japan");

        Assert.assertFalse(webTablePage.isNPOCheckBoxCheckedAtRow("1"));
        webTablePage.checkNPOCheckBoxAtRow("1");
        Assert.assertTrue(webTablePage.isNPOCheckBoxCheckedAtRow("1"));

        webTablePage.senKeysToTextBoxOfColumnAtRow("Order Placed", "2", "167");

        webTablePage.setDateToMemberSinceDatePickerAtRow("3", "2026-03-27");

        webTablePage.clickIconActionByTitleAtRow("Insert", "1");

        webTablePage.clickIconActionByTitleAtRow("Remove", "2");

        webTablePage.clickIconActionByTitleAtRow("Up", "3");

        webTablePage.clickIconActionByTitleAtRow("Down", "1");
    }

    @Test
    public void TC_02_Load_Data() {
        webTablePage.clickLoadDataButton();

        webTablePage.clickAppendRowButton();

        webTablePage.senKeysToTextBoxOfColumnAtRow("Company", "9", "SDET");

        webTablePage.clickIconActionByTitleAtRow("insert", "9");

        webTablePage.senKeysToTextBoxOfColumnAtRow("Contact Person", "10", "Dong");

        webTablePage.clickIconActionByTitleAtRow("REMOVE", "5");

        Assert.assertFalse(webTablePage.isNPOCheckBoxCheckedAtRow("9"));

        webTablePage.clickIconActionByTitleAtRow("up", "9");

        webTablePage.clickRemoveLastRowButton();

        webTablePage.clickIconActionByTitleAtRow("dOWN", "7");

        webTablePage.selectCountryDropDownAtRow("7", "Japan");

        webTablePage.clickIconActionByTitleAtRow("remove", "1");

        webTablePage.checkNPOCheckBoxAtRow("6");

        webTablePage.clickIconActionByTitleAtRow("dOwn", "5");

        Assert.assertTrue(webTablePage.isNPOCheckBoxCheckedAtRow("5"));

        webTablePage.clickRemoveLastRowButton();

        webTablePage.senKeysToTextBoxOfColumnAtRow("Order Placed", "5", "167");

        webTablePage.clickIconActionByTitleAtRow("removE", "4");

        webTablePage.clickIconActionByTitleAtRow("down", "3");

        webTablePage.clickIconActionByTitleAtRow("UP", "3");

        webTablePage.setDateToMemberSinceDatePickerAtRow("2", "2026-03-27");

        webTablePage.clickIconActionByTitleAtRow("remove", "1");

        Assert.assertTrue(webTablePage.isNPOCheckBoxCheckedAtRow("1"));

        webTablePage.clickRemoveLastRowButton();

        webTablePage.clickIconActionByTitleAtRow("reMove", "2");

        webTablePage.clickIconActionByTitleAtRow("uP", "2");

        webTablePage.clickIconActionByTitleAtRow("rEMOve", "1");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
