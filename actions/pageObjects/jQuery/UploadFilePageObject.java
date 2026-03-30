package pageObjects.jQuery;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.UploadFilePageUI;

public class UploadFilePageObject extends BasePage {
    private WebDriver driver;

    public UploadFilePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFilesToPage(String... fileNames) {
        uploadFiles(driver, fileNames);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public boolean isFileLoaded(String fileName) {
        waitForElementVisible(driver, UploadFilePageUI.FILE_NAME_LOADED, fileName);
        return isElementDisplayed(driver, UploadFilePageUI.FILE_NAME_LOADED, fileName);
    }

    public void clickStartButton() {
        waitForElementClickable(driver, UploadFilePageUI.START_BUTTON);
        clickToElement(driver, UploadFilePageUI.START_BUTTON);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public boolean isFileUploaded(String fileName) {
        waitForElementVisible(driver, UploadFilePageUI.FILE_LINK_UPLOADED, fileName);
        return isElementDisplayed(driver, UploadFilePageUI.FILE_LINK_UPLOADED, fileName);
    }

    public boolean isFileImageDisplayed(String fileName) {
        waitForElementVisible(driver, UploadFilePageUI.FILE_IMAGE_UPLOADED, fileName);
        return isImageLoaded(driver, UploadFilePageUI.FILE_IMAGE_UPLOADED, fileName);
    }

    public void clickDeleteButton() {
        waitForElementClickable(driver, UploadFilePageUI.DELETE_BUTTON);
        clickToElement(driver, UploadFilePageUI.DELETE_BUTTON);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public void clickStartUploadButton() {
        waitForElementClickable(driver, UploadFilePageUI.START_UPLOAD_BUTTON);
        checkToCheckboxOrRadio(driver, UploadFilePageUI.START_UPLOAD_BUTTON);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public void checkToSelectAllCheckBox() {
        waitForElementClickable(driver, UploadFilePageUI.SELECT_ALL_CHECKBOX);
        checkToCheckboxOrRadio(driver, UploadFilePageUI.SELECT_ALL_CHECKBOX);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public void clickDeleteSelectedButton() {
        waitForElementClickable(driver, UploadFilePageUI.DELETE_SELECTED_BUTTON);
        checkToCheckboxOrRadio(driver, UploadFilePageUI.DELETE_SELECTED_BUTTON);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }
}
