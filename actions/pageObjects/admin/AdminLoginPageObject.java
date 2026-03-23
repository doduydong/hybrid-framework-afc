package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.AdminPageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToUserNameTextBox(String userName) {
        waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
    }

    public void sendKeysToPasswordTextBox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminManageCustomersPageObject clickLogInButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return AdminPageGenerator.getAdminManageCustomersPage(driver);
    }
}
