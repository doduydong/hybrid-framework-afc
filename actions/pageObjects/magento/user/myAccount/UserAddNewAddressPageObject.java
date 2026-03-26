package pageObjects.magento.user.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.UserMyAccountSidebar;
import pageUIs.magento.user.myAccount.UserAddNewAddressPageUI;

public class UserAddNewAddressPageObject extends BasePage {
    private WebDriver driver;

    public UserAddNewAddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserMyAccountSidebar sidebar() {
        return new UserMyAccountSidebar(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, UserAddNewAddressPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, UserAddNewAddressPageUI.PAGE_TITLE);
    }
}
