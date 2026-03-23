package pageComponents.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.UserPageGenerator;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageObjects.user.myAccount.UserAccountInformationPageObject;
import pageObjects.user.myAccount.UserAddNewAddressPageObject;

public class MyAccountSidebar extends BasePage {
    private WebDriver driver;

    public MyAccountSidebar(WebDriver driver) {
        this.driver = driver;
    }

    public UserAccountDashboardPageObject clickAccountDashboardSidebarLink() {
        waitForElementClickable(driver, "//div[@class='block-content']//a[text()='Account Dashboard']");
        clickToElement(driver, "//div[@class='block-content']//a[text()='Account Dashboard']");
        return UserPageGenerator.getUserAccountDashboardPage(driver);
    }

    public UserAccountInformationPageObject clickAccountInformationSidebarLink() {
        waitForElementClickable(driver, "//div[@class='block-content']//a[text()='Account Information']");
        clickToElement(driver, "//div[@class='block-content']//a[text()='Account Information']");
        return UserPageGenerator.getUserAccountInformationPage(driver);
    }

    public UserAddNewAddressPageObject clickAddressBookSidebarLink() {
        waitForElementClickable(driver, "//div[@class='block-content']//a[text()='Address Book']");
        clickToElement(driver, "//div[@class='block-content']//a[text()='Address Book']");
        return UserPageGenerator.getUserAddNewAddressPage(driver);
    }
}
