package pageObjects.myAccount;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.MyAccountSidebarNavigation;
import pageUIs.myAccount.AccountInformationPageUI;
import pageUIs.myAccount.AddNewAddressPageUI;

public class AddNewAddressPageObject extends BasePage {
    private WebDriver driver;

    public AddNewAddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountSidebarNavigation sidebar() {
        return new MyAccountSidebarNavigation(driver);
    }

    public boolean isPageTitleDisplayed() {
        waitForElementVisible(driver, AddNewAddressPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, AddNewAddressPageUI.PAGE_TITLE);
    }
}
