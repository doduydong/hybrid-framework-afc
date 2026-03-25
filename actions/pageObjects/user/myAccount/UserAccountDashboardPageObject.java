package pageObjects.user.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.UserHeaderSide;
import pageComponents.user.UserMyAccountSidebar;
import pageObjects.user.UserHomePageObject;
import pageObjects.UserPageGenerator;
import pageUIs.user.myAccount.UserAccountDashboardPageUI;

public class UserAccountDashboardPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHeaderSide headerSide() {
        return new UserHeaderSide(driver);
    }

    public UserMyAccountSidebar sidebar() {
        return new UserMyAccountSidebar(driver);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getWelcomeMessage() {
        waitForElementVisible(driver, UserAccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, UserAccountDashboardPageUI.WELCOME_MESSAGE);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, UserAccountDashboardPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, UserAccountDashboardPageUI.PAGE_TITLE);
    }
}
