package pageUIs.jQuery;

public class WebTablePageUI {

    // Paginated Data Table
    public static final String PAGINATION_PAGE_BY_NUMBER = "//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String TEXTBOX_BY_LABEL = "//div[text()='Country']/parent::div/following-sibling::input";
    public static final String ROW_BY_VALUE = "//tr//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";

    // Editable Data Table
    public static final String COLUMN_INDEX_BY_LABEL = "//th[text()='%s']/preceding-sibling::th";
    public static final String TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "//tr/td[text()='%s']/following-sibling::td[%s]/input";
    public static final String COUNTRY_DROPDOWN_BY_ROW = "//tr/td[text()='%s']/following-sibling::td/div[@class='select']/select";
    public static final String NPO_CHECKBOX_BY_ROW = "//tr/td[text()='%s']/following-sibling::td//input[@type='checkbox']";
    public static final String MEMBER_SINCE_DATE_PICKER_BY_ROW = "//tr/td[text()='%s']/following-sibling::td//input[@type='date']";
    public static final String ACTION_ICON_BY_TITLE_AND_ROW = "//tr/td[text()='%s']/following-sibling::td//button[@title='%s']";
    public static final String LOAD_DATA_BUTTON = "//button[@id='load']";
    public static final String APPEND_ROW_BUTTON = "//button[@title='Append Row']";
    public static final String REMOVE_LAST_ROW_BUTTON = "//button[@title='Remove Last Row']";
}
