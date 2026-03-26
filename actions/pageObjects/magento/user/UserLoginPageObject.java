package pageObjects.magento.user;

import commons.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.UserPageGenerator;
import pageObjects.magento.user.myAccount.UserAccountDashboardPageObject;
import pageUIs.magento.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserAccountDashboardPageObject clickLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        try {
            acceptAlert(driver);
        } catch (TimeoutException ignored) {
        }
        return UserPageGenerator.getUserAccountDashboardPage(driver);
    }
}
