package pageObjects.magento.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageComponents.user.UserHeaderSide;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHeaderSide headerSide() {
        return new UserHeaderSide(driver);
    }
}
