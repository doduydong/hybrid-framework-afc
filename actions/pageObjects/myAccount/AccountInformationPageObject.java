package pageObjects.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.MyAccountSidebarNavigation;
import pageUIs.myAccount.AccountInformationPageUI;

public class AccountInformationPageObject extends BasePage {
    private WebDriver driver;

    public AccountInformationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountSidebarNavigation sidebar() {
        return new MyAccountSidebarNavigation(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, AccountInformationPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, AccountInformationPageUI.PAGE_TITLE);
    }
}
