package pageObjects.magento;

import org.openqa.selenium.WebDriver;
import pageObjects.magento.admin.AdminLoginPageObject;
import pageObjects.magento.admin.AdminManageCustomersPageObject;

public class AdminPageGenerator {

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminManageCustomersPageObject getAdminManageCustomersPage(WebDriver driver) {
        return new AdminManageCustomersPageObject(driver);
    }
}
