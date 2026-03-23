package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.UserPageGenerator;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPageObject selectRegisterInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, UserHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, UserHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
        return UserPageGenerator.getUserRegisterPage(driver);
    }

    public UserLoginPageObject selectLoginInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, UserHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, UserHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log In");
        return UserPageGenerator.getUserLoginPage(driver);
    }
}
