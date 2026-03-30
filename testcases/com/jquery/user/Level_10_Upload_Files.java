package com.jquery.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.JQueryPageGenerator;
import pageObjects.jQuery.UploadFilePageObject;

public class Level_10_Upload_Files extends BaseTest {
    private WebDriver driver;
    private UploadFilePageObject uploadFilePage;
    private String javaFile = "Java.jpg";
    private String seleniumFile = "Selenium.jpg";
    private String testngFile = "TestNG.jpg";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = createWebDriver(browserName, "https://blueimp.github.io/jQuery-File-Upload/");
        uploadFilePage = JQueryPageGenerator.getUploadFilePage(driver);
    }

    @Test
    public void TC_01_Single_File() {
        uploadFilePage.uploadFilesToPage(seleniumFile);

        Assert.assertTrue(uploadFilePage.isFileLoaded(seleniumFile));

        uploadFilePage.clickStartButton();

        Assert.assertTrue(uploadFilePage.isFileUploaded(seleniumFile));

        Assert.assertTrue(uploadFilePage.isFileImageDisplayed(seleniumFile));

        uploadFilePage.clickDeleteButton();
    }

    @Test
    public void TC_02_Multiple_Files() {
        uploadFilePage.uploadFilesToPage(javaFile, seleniumFile, testngFile);

        Assert.assertTrue(uploadFilePage.isFileLoaded(javaFile));
        Assert.assertTrue(uploadFilePage.isFileLoaded(seleniumFile));
        Assert.assertTrue(uploadFilePage.isFileLoaded(testngFile));

        uploadFilePage.clickStartUploadButton();

        Assert.assertTrue(uploadFilePage.isFileUploaded(javaFile));
        Assert.assertTrue(uploadFilePage.isFileUploaded(seleniumFile));
        Assert.assertTrue(uploadFilePage.isFileUploaded(testngFile));

        Assert.assertTrue(uploadFilePage.isFileImageDisplayed(javaFile));
        Assert.assertTrue(uploadFilePage.isFileImageDisplayed(seleniumFile));
        Assert.assertTrue(uploadFilePage.isFileImageDisplayed(testngFile));

        uploadFilePage.checkToSelectAllCheckBox();

        uploadFilePage.clickDeleteSelectedButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
