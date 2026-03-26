package pageComponents.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.UserPageGenerator;
import pageObjects.magento.user.UserHomePageObject;
import pageObjects.magento.user.UserLoginPageObject;
import pageObjects.magento.user.UserRegisterPageObject;
import pageUIs.magento.user.components.UserHeaderSideUI;

public class UserHeaderSide extends BasePage {
    private WebDriver driver;

    public UserHeaderSide(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject selectRegisterInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, UserHeaderSideUI.MY_ACCOUNT_HEADER_DROPDOWN, UserHeaderSideUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
        return UserPageGenerator.getUserRegisterPage(driver);
    }

    public UserLoginPageObject selectLoginInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, UserHeaderSideUI.MY_ACCOUNT_HEADER_DROPDOWN, UserHeaderSideUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log In");
        return UserPageGenerator.getUserLoginPage(driver);
    }

    public UserHomePageObject selectLogoutInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, UserHeaderSideUI.MY_ACCOUNT_HEADER_DROPDOWN, UserHeaderSideUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log Out");
        return UserPageGenerator.getUserHomePage(driver);
    }
}
