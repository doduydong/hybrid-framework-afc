package pageObjects.user.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.MyAccountSidebar;
import pageUIs.user.myAccount.UserAccountInformationPageUI;

public class UserAccountInformationPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInformationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountSidebar sidebar() {
        return new MyAccountSidebar(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, UserAccountInformationPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, UserAccountInformationPageUI.PAGE_TITLE);
    }
}
