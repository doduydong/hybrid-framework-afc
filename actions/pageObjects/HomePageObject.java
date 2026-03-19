package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject selectRegisterInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject selectLoginInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log In");
        return PageGeneratorManager.getLoginPage(driver);
    }
}
