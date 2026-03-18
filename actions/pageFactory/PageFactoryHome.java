package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageFactoryHome extends BaseFactory {
    private WebDriver driver;

    public PageFactoryHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Account']/parent::a")
    private WebElement myAccountHeaderDropDown;

    @FindBy(xpath = "//div[@id='header-account']//a")
    private List<WebElement> myAccountHeaderDropDownOptions;

    public void selectRegisterInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, myAccountHeaderDropDown, myAccountHeaderDropDownOptions, "Register");
    }

    public void selectLoginInMyAccountHeaderDropDown() {
        selectOptionInCustomDropDown(driver, myAccountHeaderDropDown, myAccountHeaderDropDownOptions, "Log In");
    }
}
