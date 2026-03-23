package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageObjects.user.myAccount.UserAccountInformationPageObject;
import pageObjects.user.myAccount.UserAddNewAddressPageObject;

public class UserPageGenerator {

    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserAccountDashboardPageObject getUserAccountDashboardPage(WebDriver driver) {
        return new UserAccountDashboardPageObject(driver);
    }

    public static UserAccountInformationPageObject getUserAccountInformationPage(WebDriver driver) {
        return new UserAccountInformationPageObject(driver);
    }

    public static UserAddNewAddressPageObject getUserAddNewAddressPage(WebDriver driver) {
        return new UserAddNewAddressPageObject(driver);
    }
}
