package pageObjects.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.MyAccountSidebarNavigation;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageUIs.myAccount.AccountDashboardPageUI;

public class AccountDashboardPageObject extends BasePage {
    private WebDriver driver;

    public AccountDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountSidebarNavigation sidebar() {
        return new MyAccountSidebarNavigation(driver);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, AccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getWelcomeMessage() {
        waitForElementVisible(driver, AccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, AccountDashboardPageUI.WELCOME_MESSAGE);
    }

    public HomePageObject selectLogoutInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, AccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN, AccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log Out");
        return PageGeneratorManager.getHomePage(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, AccountDashboardPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, AccountDashboardPageUI.PAGE_TITLE);
    }
}
