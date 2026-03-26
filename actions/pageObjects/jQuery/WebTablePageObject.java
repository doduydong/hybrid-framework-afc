package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.WebTablePageUI;

public class WebTablePageObject extends BasePage {
    private WebDriver driver;

    public WebTablePageObject(WebDriver driver) {
        this.driver = driver;
    }

    // Paginated Data Table
    public void goToPaginationPageByNumber(String pageNumber) {
        waitForElementClickable(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
        clickToElement(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
        sleepForSeconds(3);
    }

    public boolean isPaginationPageActiveByNumber(String pageNumber) {
        waitForElementVisible(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
        return getElementAttribute(driver, WebTablePageUI.PAGINATION_PAGE_BY_NUMBER, "class", pageNumber).endsWith("active");
    }

    public void sendKeysToTextBoxByLabel(String labelName, String keysToSend) {
        waitForElementVisible(driver, WebTablePageUI.TEXTBOX_BY_LABEL, labelName);
        sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_LABEL, keysToSend, labelName);
        sendKeyboardToElement(driver, WebTablePageUI.TEXTBOX_BY_LABEL, Keys.ENTER, labelName);
        sleepForSeconds(1);
    }

    public boolean isRowDisplayedByValues(String femalesValue, String countryName, String malesValue, String totalValue) {
        waitForElementVisible(driver, WebTablePageUI.ROW_BY_VALUE, femalesValue, countryName, malesValue, totalValue);
        return isElementDisplayed(driver, WebTablePageUI.ROW_BY_VALUE, femalesValue, countryName, malesValue, totalValue);
    }

    // Editable Data Table
    private String getColumnIndexByColumnLabel(String columnLabel) {
        return String.valueOf(getElementCount(driver, WebTablePageUI.COLUMN_INDEX_BY_LABEL, columnLabel));
    }

    public void senKeysToTextBoxOfColumnAtRow(String columnLabel, String rowNumber, String keysToSend) {
        String columnIndex = getColumnIndexByColumnLabel(columnLabel);
        waitForElementVisible(driver, WebTablePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, columnIndex);
        sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, keysToSend, rowNumber, columnIndex);
        sleepForSeconds(1);
    }

    public void selectCountryDropDownAtRow(String rowNumber, String optionValue) {
        waitForElementClickable(driver, WebTablePageUI.COUNTRY_DROPDOWN_BY_ROW, rowNumber);
        selectItemInDefaultDropdown(driver, WebTablePageUI.COUNTRY_DROPDOWN_BY_ROW, optionValue, rowNumber);
        sleepForSeconds(1);
    }

    public void checkNPOCheckBoxAtRow(String rowNumber) {
        waitForElementClickable(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, rowNumber);
        checkToCheckboxOrRadio(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, rowNumber);
        sleepForSeconds(1);
    }

    public boolean isNPOCheckBoxCheckedAtRow(String rowNumber) {
        waitForElementVisible(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, rowNumber);
        return isElementSelected(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, rowNumber);
    }

    public void setDateToMemberSinceDatePickerAtRow(String rowNumber, String dateValue) {
        waitForElementVisible(driver, WebTablePageUI.MEMBER_SINCE_DATE_PICKER_BY_ROW, rowNumber);
        sendKeysToElement(driver, WebTablePageUI.MEMBER_SINCE_DATE_PICKER_BY_ROW, dateValue, rowNumber);
        sleepForSeconds(1);
    }

    public void clickIconActionByTitleAtRow(String actionTitle, String rowNumber) {
        String action = null;
        switch (actionTitle.toLowerCase()) {
            case "insert":
                action = "Insert Row Above";
                break;
            case "remove":
                action = "Remove Current Row";
                break;
            case "up":
                action = "Move Up";
                break;
            case "down":
                action = "Move Down";
                break;
            default:
                throw new RuntimeException("'" + actionTitle + "' is not valid!");
        }
        waitForElementClickable(driver, WebTablePageUI.ACTION_ICON_BY_TITLE_AND_ROW, rowNumber, action);
        clickToElement(driver, WebTablePageUI.ACTION_ICON_BY_TITLE_AND_ROW, rowNumber, action);
        sleepForSeconds(1);
    }

    public void clickLoadDataButton() {
        waitForElementClickable(driver, WebTablePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, WebTablePageUI.LOAD_DATA_BUTTON);
        sleepForSeconds(1);
    }

    public void clickAppendRowButton() {
        waitForElementClickable(driver, WebTablePageUI.APPEND_ROW_BUTTON);
        clickToElement(driver, WebTablePageUI.APPEND_ROW_BUTTON);
        sleepForSeconds(1);
    }

    public void clickRemoveLastRowButton() {
        waitForElementClickable(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
        clickToElement(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
        sleepForSeconds(1);
    }
}