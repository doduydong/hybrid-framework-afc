package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectRegisterInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
    }

    public void selectLoginInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, HomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log In");
    }
}
