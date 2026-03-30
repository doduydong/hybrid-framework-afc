package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class JQueryPageGenerator {

    public static WebTablePageObject getWebTablePage(WebDriver driver) {
        return new WebTablePageObject(driver);
    }

    public static UploadFilePageObject getUploadFilePage(WebDriver driver) {
        return new UploadFilePageObject(driver);
    }
}
