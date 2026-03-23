package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminManageCustomersPageObject;

public class AdminPageGenerator {

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminManageCustomersPageObject getAdminManageCustomersPage(WebDriver driver) {
        return new AdminManageCustomersPageObject(driver);
    }
}
