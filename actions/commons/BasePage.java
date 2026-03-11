package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

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
    private By getByXPath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    protected WebElement getElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXPath(xpathLocator));
    }

    protected List<WebElement> getElements(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXPath(xpathLocator));
    }

    protected void clickToElement(WebDriver driver, String xpathLocator) {
        getElement(driver, xpathLocator).click();
    }

    protected void sendKeysToElement(WebDriver driver, String xpathLocator, String keysToSend) {
        WebElement element = getElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected String getElementText(WebDriver driver, String xpathLocator) {
        return getElement(driver, xpathLocator).getText();
    }

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getElement(driver, xpathLocator).getAttribute(attributeName);
    }

    protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getElement(driver, xpathLocator).getCssValue(propertyName);
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return getElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        return getElement(driver, xpathLocator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getElement(driver, xpathLocator).isSelected();
    }

    protected void checkToCheckboxOrRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = getElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
        new Select(getElement(driver, xpathLocator)).selectByVisibleText(textItem);
    }

    protected String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
        return new Select(getElement(driver, xpathLocator)).getFirstSelectedOption().getText();
    }

    protected boolean isDefaultDropdownMultiple(WebDriver driver, String xpathLocator) {
        return new Select(getElement(driver, xpathLocator)).isMultiple();
    }

    protected int getElementCount(WebDriver driver, String xpathLocator) {
        return getElements(driver, xpathLocator).size();
    }

    // Frame methods
    protected void switchToFrame(WebDriver driver, String xpathLocator) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXPath(xpathLocator)));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Actions methods
    private Actions getActions(WebDriver driver) {
        return new Actions(driver);
    }

    protected void moveToElement(WebDriver driver, String xpathLocator) {
        getActions(driver).moveToElement(getElement(driver, xpathLocator)).perform();
    }

    protected void doubleClickToElement(WebDriver driver, String xpathLocator) {
        getActions(driver).doubleClick(getElement(driver, xpathLocator)).perform();
    }

    protected void rightClickToElement(WebDriver driver, String xpathLocator) {
        getActions(driver).contextClick(getElement(driver, xpathLocator)).perform();
    }

    protected void clickAndHoldElement(WebDriver driver, String xpathLocator) {
        getActions(driver).clickAndHold(getElement(driver, xpathLocator)).perform();
    }

    protected void releaseMouse(WebDriver driver) {
        getActions(driver).release().perform();
    }

    protected void sendKeyboardToElement(WebDriver driver, String xpathLocator, Keys key) {
        getActions(driver).sendKeys(getElement(driver, xpathLocator), key).perform();
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

    protected void scrollToElement(WebDriver driver, String xpathLocator) {
        getJSExecutor(driver).executeScript("arguments[0].scrollIntoView({block:'center'});", getElement(driver, xpathLocator));
    }

    protected void highlightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getElement(driver, xpathLocator);
        getJSExecutor(driver).executeScript("arguments[0].style.outline='2px dashed red';", element);
        sleepForSeconds(twoSeconds);
        getJSExecutor(driver).executeScript("arguments[0].style.outline='';", element);
    }

    protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
        getJSExecutor(driver).executeScript("arguments[0].click();", getElement(driver, xpathLocator));
    }

    protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        return (String) getJSExecutor(driver).executeScript("return arguments[0].validationMessage;", getElement(driver, xpathLocator));
    }

    protected void setAttributeInDOM(WebDriver driver, String xpathLocator, String attributeName, String attributeValue) {
        getJSExecutor(driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", getElement(driver, xpathLocator), attributeName, attributeValue);
    }

    protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeName) {
        getJSExecutor(driver).executeScript("arguments[0].removeAttribute(arguments[1]);", getElement(driver, xpathLocator), attributeName);
    }

    protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        return (Boolean) getJSExecutor(driver).executeScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", getElement(driver, xpathLocator));
    }

    // Wait methods
    private WebDriverWait getExplicitWait(WebDriver driver, long timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(xpathLocator)));
    }

    protected void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(xpathLocator)));
    }

    protected void waitForElementInvisible(WebDriver driver, String xpathLocator) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(xpathLocator)));
    }

    protected void waitForAllElementsInvisible(WebDriver driver, String xpathLocator) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(xpathLocator)));
    }

    protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
        getExplicitWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByXPath(xpathLocator)));
    }

    // Custom methods
    protected void sleepForSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void selectOptionInCustomDropDown(WebDriver driver, String dropdownXPath, String allOptionsXPath, String expectedValue) {
        waitForElementClickable(driver, dropdownXPath);
        clickToElement(driver, dropdownXPath);
        sleepForSeconds(oneSecond);
        waitForAllElementsVisible(driver, allOptionsXPath);
        List<WebElement> allOptions = getElements(driver, allOptionsXPath);
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
