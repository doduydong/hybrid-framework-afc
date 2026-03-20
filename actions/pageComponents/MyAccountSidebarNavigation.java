package pageComponents;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneratorManager;
import pageObjects.myAccount.AccountDashboardPageObject;
import pageObjects.myAccount.AccountInformationPageObject;
import pageObjects.myAccount.AddNewAddressPageObject;

public class MyAccountSidebarNavigation extends BasePage {
    private WebDriver driver;

    public MyAccountSidebarNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public AccountDashboardPageObject clickAccountDashboardSidebarLink() {
        waitForElementClickable(driver, "//div[@class='block-content']//a[text()='Account Dashboard']");
        clickToElement(driver, "//div[@class='block-content']//a[text()='Account Dashboard']");
        return PageGeneratorManager.getAccountDashboardPage(driver);
    }

    public AccountInformationPageObject clickAccountInformationSidebarLink() {
        waitForElementClickable(driver, "//div[@class='block-content']//a[text()='Account Information']");
        clickToElement(driver, "//div[@class='block-content']//a[text()='Account Information']");
        return PageGeneratorManager.getAccountInformationPage(driver);
    }

    public AddNewAddressPageObject clickAddressBookSidebarLink() {
        waitForElementClickable(driver, "//div[@class='block-content']//a[text()='Address Book']");
        clickToElement(driver, "//div[@class='block-content']//a[text()='Address Book']");
        return PageGeneratorManager.getAddNewAddressPage(driver);
    }
}
