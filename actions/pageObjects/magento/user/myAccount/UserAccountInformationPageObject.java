package pageObjects.magento.user.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.UserMyAccountSidebar;
import pageUIs.magento.user.myAccount.UserAccountInformationPageUI;

public class UserAccountInformationPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInformationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserMyAccountSidebar sidebar() {
        return new UserMyAccountSidebar(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, UserAccountInformationPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, UserAccountInformationPageUI.PAGE_TITLE);
    }
}
