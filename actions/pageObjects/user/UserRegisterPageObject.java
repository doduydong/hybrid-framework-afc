package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pageObjects.UserPageGenerator;
import pageObjects.user.myAccount.UserAccountDashboardPageObject;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void sendKeysToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void sendKeysToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void sendKeysToConfirmPasswordTextBox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public UserAccountDashboardPageObject clickRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
        try {
            acceptAlert(driver);
        } catch (TimeoutException ignored) {
        }
        return UserPageGenerator.getUserAccountDashboardPage(driver);
    }
}
