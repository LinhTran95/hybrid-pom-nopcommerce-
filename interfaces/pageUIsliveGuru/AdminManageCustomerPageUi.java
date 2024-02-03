package pageUIsliveGuru;

public class AdminManageCustomerPageUi {
	public static String COLUMN_NAME_POSITION = "//span[text()='Email']/ancestor::th/preceding-sibling::th";
	public static String TEXT_BOX_BY_COLUMN_POSITION = "//tr[@class='filter']/th[%s]//input";
	public static String FULL_NAME_AND_EMAIL_IN_TABLE = "//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]]";
	public static String SEARCH_BUTTON = "//button[@title='Search']";
	public static String LOADING_ICON = "//p[@id='loading_mask_loader']";
	public static String POPUP_WINDOW = "//div[@id='message-popup-window']//a[@title='close']";

}
