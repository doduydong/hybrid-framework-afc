package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AccountDashboardPageUI;

public class AccountDashboardPageObject extends BasePage {
    private WebDriver driver;

    public AccountDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getWelcomeMessage() {
        waitForElementVisible(driver, AccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, AccountDashboardPageUI.WELCOME_MESSAGE);
    }

    public void selectLogoutInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, AccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN, AccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log Out");
    }
}
