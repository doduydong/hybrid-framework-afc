package pageFactory;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLogin extends BaseFactory {
    private WebDriver driver;

    public PageFactoryLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[@title='Login']")
    private WebElement loginButton;

    public void sendKeysToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, emailTextBox);
        sendKeysToElement(driver, emailTextBox, emailAddress);
    }

    public void sendKeysToPasswordTextBox(String password) {
        waitForElementVisible(driver, passwordTextBox);
        sendKeysToElement(driver, passwordTextBox, password);
    }

    public void clickLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
        try {
            acceptAlert(driver);
        } catch (TimeoutException ignored) {
        }
    }
}
