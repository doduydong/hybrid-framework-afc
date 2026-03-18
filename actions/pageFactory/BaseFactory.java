package pageFactory;

import commons.GlobalConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseFactory {

    // Browser methods
    protected void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getWindowId(WebDriver driver) {
        return driver.getWindowHandle();
    }

    protected Set<String> getAllWindowIds(WebDriver driver) {
        return driver.getWindowHandles();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void navigateToUrl(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    // Alert methods
    protected Alert waitForAlertPresence(WebDriver driver) {
        return getExplicitWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    protected void dismissAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    protected void sendKeysToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    protected void getAlertText(WebDriver driver) {
        waitForAlertPresence(driver).getText();
    }

    // Window methods
    protected void switchToWindowByParentId(WebDriver driver, String parentWindowId) {
        Set<String> allWindowIds = getAllWindowIds(driver);
        for (String windowId : allWindowIds) {
            if (!windowId.equals(parentWindowId)) {
                driver.switchTo().window(windowId);
                break;
            }
        }
    }

    protected void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindowIds = getAllWindowIds(driver);
        for (String id : allWindowIds) {
            driver.switchTo().window(id);
            String actualTitle = getTitle(driver);
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    protected void closeAllWindowsWithoutParent(WebDriver driver, String parentWindowId) {
        Set<String> allWindowIds = getAllWindowIds(driver);
        for (String windowId : allWindowIds) {
            if (!windowId.equals(parentWindowId)) {
                driver.switchTo().window(windowId);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowId);
    }

    // Element methods
    protected void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    protected void sendKeysToElement(WebDriver driver, WebElement element, String keysToSend) {
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected String getElementText(WebDriver driver, WebElement element) {
        return element.getText();
    }

    protected String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    protected String getElementCssValue(WebDriver driver, WebElement element, String propertyName) {
        return element.getCssValue(propertyName);
    }

    protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, WebElement element) {
        return element.isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, WebElement element) {
        return element.isSelected();
    }

    protected void checkToCheckboxOrRadio(WebDriver driver, WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToCheckbox(WebDriver driver, WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void selectItemInDefaultDropdown(WebDriver driver, WebElement element, String textItem) {
        new Select(element).selectByVisibleText(textItem);
    }

    protected String getSelectedItemDefaultDropdown(WebDriver driver, WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    protected boolean isDefaultDropdownMultiple(WebDriver driver, WebElement element) {
        return new Select(element).isMultiple();
    }

    protected int getElementCount(WebDriver driver, List<WebElement> elements) {
        return elements.size();
    }

    // Frame methods
    protected void switchToFrame(WebDriver driver, WebElement element) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Actions methods
    private Actions getActions(WebDriver driver) {
        return new Actions(driver);
    }

    protected void moveToElement(WebDriver driver, WebElement element) {
        getActions(driver).moveToElement(element).perform();
    }

    protected void doubleClickToElement(WebDriver driver, WebElement element) {
        getActions(driver).doubleClick(element).perform();
    }

    protected void rightClickToElement(WebDriver driver, WebElement element) {
        getActions(driver).contextClick(element).perform();
    }

    protected void clickAndHoldElement(WebDriver driver, WebElement element) {
        getActions(driver).clickAndHold(element).perform();
    }

    protected void releaseMouse(WebDriver driver) {
        getActions(driver).release().perform();
    }

    protected void sendKeyboardToElement(WebDriver driver, WebElement element, Keys key) {
        getActions(driver).sendKeys(element, key).perform();
    }

    // JavascriptExecutor methods
    private JavascriptExecutor getJSExecutor(WebDriver driver) {
        return (JavascriptExecutor) driver;
    }

    protected Object executeForBrowser(WebDriver driver, String javaScript) {
        return getJSExecutor(driver).executeScript(javaScript);
    }

    protected void scrollToBottomPage(WebDriver driver) {
        getJSExecutor(driver).executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");
    }

    protected void scrollToTopPage(WebDriver driver) {
        getJSExecutor(driver).executeScript("window.scrollTo(0, 0);");
    }

    protected void scrollToElement(WebDriver driver, WebElement element) {
        getJSExecutor(driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    protected void highlightElement(WebDriver driver, WebElement element) {
        getJSExecutor(driver).executeScript("arguments[0].style.outline='2px dashed red';", element);
        sleepForSeconds(twoSeconds);
        getJSExecutor(driver).executeScript("arguments[0].style.outline='';", element);
    }

    protected void clickToElementByJS(WebDriver driver, WebElement element) {
        getJSExecutor(driver).executeScript("arguments[0].click();", element);
    }

    protected String getElementValidationMessage(WebDriver driver, WebElement element) {
        return (String) getJSExecutor(driver).executeScript("return arguments[0].validationMessage;", element);
    }

    protected void setAttributeInDOM(WebDriver driver, WebElement element, String attributeName, String attributeValue) {
        getJSExecutor(driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    protected void removeAttributeInDOM(WebDriver driver, WebElement element, String attributeName) {
        getJSExecutor(driver).executeScript("arguments[0].removeAttribute(arguments[1]);", element, attributeName);
    }

    protected boolean isImageLoaded(WebDriver driver, WebElement element) {
        return (Boolean) getJSExecutor(driver).executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", element);
    }

    // Wait methods
    private WebDriverWait getExplicitWait(WebDriver driver, long timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected void waitForElementVisible(WebDriver driver, WebElement element) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForAllElementsVisible(WebDriver driver, List<WebElement> elements) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForElementInvisible(WebDriver driver, WebElement element) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForAllElementsInvisible(WebDriver driver, List<WebElement> elements) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    protected void waitForElementClickable(WebDriver driver, WebElement element) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    // Custom methods
    protected void sleepForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void selectOptionInCustomDropDown(WebDriver driver, WebElement dropdown, List<WebElement> allOptions, String expectedValue) {
        waitForElementClickable(driver, dropdown);
        clickToElement(driver, dropdown);
        sleepForSeconds(oneSecond);
        waitForAllElementsVisible(driver, allOptions);
        for (WebElement option : allOptions) {
            if (option.getText().trim().equals(expectedValue)) {
                option.click();
                sleepForSeconds(oneSecond);
                break;
            }
        }
    }

    // Constants
    private final long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private final long twoSeconds = GlobalConstants.TWO_SECONDS;
    private final long oneSecond = GlobalConstants.ONE_SECOND;
}
