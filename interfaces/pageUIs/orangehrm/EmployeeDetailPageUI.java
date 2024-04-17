package pageUIs.orangehrm;

public class EmployeeDetailPageUI {
	public static final String FIRST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//input[@name='firstName']";
	public static final String MIDDLE_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//input[@name='middleName']";
	public static final String LAST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//input[@name='lastName']";
	public static final String EMPLOYEE_ID_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//input";
	public static final String SAVE_BUTTON_AT_ADD_EMPLOYEE_PAGE = "//button[@type='submit']";

	public static final String FIRST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//input[@name='firstName']";
	public static final String MIDDLE_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//input[@name='middleName']";
	public static final String LAST_NAME_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//input[@name='lastName']";
	public static final String EMPLOYEE_ID_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//label[text()='Employee Id']/ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//input";
	public static final String FULLNAME_HEADER_TEXT_AT_PERSONAL_DETAIL_PAGE = "//div[@class='orangehrm-edit-employee-name']//h6";
	public static final String SAVE_BUTTON_PERSONAL_DETAIL = "//h6[text()='Personal Details']/ancestor::div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button";
	public static final String DRIVER_LINCENSE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][2]/div[2]/div[1]//input";
	public static final String LINCESE_EXPIRY_DATE_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][2]/div[2]/div[2]//input";
	public static final String NATIONALITY_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][3]/div[1]/div[1]//div[@class='oxd-select-text-input']";
	public static final String MARITAL_STATUS_DROP_DOWN_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][3]/div[1]/div[2]//div[@class='oxd-select-text-input']";
	public static final String DATE_OF_BIRTH_TEXT_BOX_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][3]/div[2]/div[1]//input";
	public static final String MALE_GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][3]/div[2]/div[2]//input[@value='1']";
	public static final String FEMALE_GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_PAGE = "//div[@class='oxd-form-row'][3]/div[2]/div[2]//input[@value='2']";
	public static final String SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_PAGE = "//div[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]";

	
	public static final String DYNAMIC_BUTTON_AT_QUALIFICATION_PAGE = "//h6[text()='%s']/ancestor::div[@class='orangehrm-action-header']//button";

}
