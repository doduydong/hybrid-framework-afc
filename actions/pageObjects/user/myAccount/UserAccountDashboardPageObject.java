package pageObjects.user.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.MyAccountSidebar;
import pageObjects.user.UserHomePageObject;
import pageObjects.UserPageGenerator;
import pageUIs.user.myAccount.UserAccountDashboardPageUI;

public class UserAccountDashboardPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountSidebar sidebar() {
        return new MyAccountSidebar(driver);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getWelcomeMessage() {
        waitForElementVisible(driver, UserAccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, UserAccountDashboardPageUI.WELCOME_MESSAGE);
    }

    public UserHomePageObject selectLogoutInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, UserAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN, UserAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log Out");
        return UserPageGenerator.getUserHomePage(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, UserAccountDashboardPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, UserAccountDashboardPageUI.PAGE_TITLE);
    }
}
