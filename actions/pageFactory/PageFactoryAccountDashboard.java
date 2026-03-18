package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageFactoryAccountDashboard extends BaseFactory {
    private WebDriver driver;

    public PageFactoryAccountDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='success-msg']//span")
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//div[@class='welcome-msg']//strong")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//span[text()='Account']/parent::a")
    private WebElement myAccountHeaderDropDown;

    @FindBy(xpath = "//div[@id='header-account']//a")
    private List<WebElement> myAccountHeaderDropDownOptions;

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, registerSuccessMessage);
        return getElementText(driver, registerSuccessMessage);
    }

    public String getWelcomeMessage() {
        waitForElementVisible(driver, welcomeMessage);
        return getElementText(driver, welcomeMessage);
    }

    public void selectLogoutInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, myAccountHeaderDropDown, myAccountHeaderDropDownOptions, "Log Out");
    }
}
