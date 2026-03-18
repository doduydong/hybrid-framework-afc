package pageFactory;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryRegister extends BaseFactory {
    private WebDriver driver;

    public PageFactoryRegister(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//button[@title='Register']")
    private WebElement registerButton;

    public void sendKeysToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, firstNameTextBox);
        sendKeysToElement(driver, firstNameTextBox, firstName);
    }

    public void sendKeysToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, lastNameTextBox);
        sendKeysToElement(driver, lastNameTextBox, lastName);
    }

    public void sendKeysToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, emailTextBox);
        sendKeysToElement(driver, emailTextBox, emailAddress);
    }

    public void sendKeysToPasswordTextBox(String password) {
        waitForElementVisible(driver, passwordTextBox);
        sendKeysToElement(driver, passwordTextBox, password);
    }

    public void sendKeysToConfirmPasswordTextBox(String password) {
        waitForElementVisible(driver, confirmPasswordTextBox);
        sendKeysToElement(driver, confirmPasswordTextBox, password);
    }

    public void clickRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
        try {
            acceptAlert(driver);
        } catch (TimeoutException ignored) {
        }
    }
}
