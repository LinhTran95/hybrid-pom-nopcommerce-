package pageUIsNopcomerce;

public class BasePageUI {
	//Common locator 
	public static final String REWARD_POINT_PAGE_LINK = "//div[@class='listbox']//a[text()='Reward points']";
	public static final String CUSTOMER_INFOR_PAGE_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	public static final String ORDER_PAGE_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String ADDRESSES_PAGE_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	
	public static final String DYNAMIC_SIDE_BAR_PAGE_LINK ="//div[@class='listbox']//a[text()='%s']";
	
	//1 locator dynamic for 20 pages 
	public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_RADIOBUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT= "//button[text()='%s']";
	
	//Employee List Side Bar menu
	public static final String DYNAMIC_SIDE_BAR_MENU_BY_TEXT= "//div[@class='orangehrm-tabs-wrapper']/a[text()='%s']";

	
}
