package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.myAccount.AccountDashboardPageObject;
import pageObjects.myAccount.AccountInformationPageObject;
import pageObjects.myAccount.AddNewAddressPageObject;

public class PageGeneratorManager {

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static AccountDashboardPageObject getAccountDashboardPage(WebDriver driver) {
        return new AccountDashboardPageObject(driver);
    }

    public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
        return new AccountInformationPageObject(driver);
    }

    public static AddNewAddressPageObject getAddNewAddressPage(WebDriver driver) {
        return new AddNewAddressPageObject(driver);
    }
}
