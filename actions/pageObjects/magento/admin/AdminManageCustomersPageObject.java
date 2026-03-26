package pageObjects.magento.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.AdminPageGenerator;
import pageUIs.magento.admin.AdminManageCustomersPageUI;

public class AdminManageCustomersPageObject extends BasePage {
    private WebDriver driver;

    public AdminManageCustomersPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup() {
        waitForElementClickable(driver, AdminManageCustomersPageUI.POPUP_CLOSE_BUTTON);
        clickToElement(driver, AdminManageCustomersPageUI.POPUP_CLOSE_BUTTON);
    }

    public AdminLoginPageObject clickLogOutLink() {
        waitForElementClickable(driver, AdminManageCustomersPageUI.LOGOUT_LINK);
        clickToElement(driver, AdminManageCustomersPageUI.LOGOUT_LINK);
        return AdminPageGenerator.getAdminLoginPage(driver);
    }
}
