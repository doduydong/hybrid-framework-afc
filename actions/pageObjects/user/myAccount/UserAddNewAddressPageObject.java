package pageObjects.user.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.MyAccountSidebar;
import pageUIs.user.myAccount.UserAddNewAddressPageUI;

public class UserAddNewAddressPageObject extends BasePage {
    private WebDriver driver;

    public UserAddNewAddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountSidebar sidebar() {
        return new MyAccountSidebar(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, UserAddNewAddressPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, UserAddNewAddressPageUI.PAGE_TITLE);
    }
}
