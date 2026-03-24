package pageComponents.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.UserPageGenerator;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageObjects.user.myAccount.UserAccountInformationPageObject;
import pageObjects.user.myAccount.UserAddNewAddressPageObject;
import pageUIs.user.components.UserMyAccountSidebarUI;

public class UserMyAccountSidebar extends BasePage {
    private WebDriver driver;

    public UserMyAccountSidebar(WebDriver driver) {
        this.driver = driver;
    }

    public UserAccountDashboardPageObject clickAccountDashboardSidebarLink() {
        waitForElementClickable(driver, UserMyAccountSidebarUI.MY_ACCOUNT_SIDEBAR_LINK_BY_TEXT, "Account Dashboard");
        clickToElement(driver, UserMyAccountSidebarUI.MY_ACCOUNT_SIDEBAR_LINK_BY_TEXT, "Account Dashboard");
        return UserPageGenerator.getUserAccountDashboardPage(driver);
    }

    public UserAccountInformationPageObject clickAccountInformationSidebarLink() {
        waitForElementClickable(driver, UserMyAccountSidebarUI.MY_ACCOUNT_SIDEBAR_LINK_BY_TEXT, "Account Information");
        clickToElement(driver, UserMyAccountSidebarUI.MY_ACCOUNT_SIDEBAR_LINK_BY_TEXT, "Account Information");
        return UserPageGenerator.getUserAccountInformationPage(driver);
    }

    public UserAddNewAddressPageObject clickAddressBookSidebarLink() {
        waitForElementClickable(driver, UserMyAccountSidebarUI.MY_ACCOUNT_SIDEBAR_LINK_BY_TEXT, "Address Book");
        clickToElement(driver, UserMyAccountSidebarUI.MY_ACCOUNT_SIDEBAR_LINK_BY_TEXT, "Address Book");
        return UserPageGenerator.getUserAddNewAddressPage(driver);
    }
}
