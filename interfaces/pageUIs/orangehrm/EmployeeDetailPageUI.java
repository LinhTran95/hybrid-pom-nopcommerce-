package pageUIs.orangehrm;

public class EmployeeDetailPageUI {
	public static final String FIRST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//input[@name='firstName']";
	public static final String MIDDLE_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//input[@name='middleName']";
	public static final String LAST_NAME_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//input[@name='lastName']";
	public static final String EMPLOYEE_ID_TEXT_BOX_AT_ADD_EMPLOYEE_PAGE = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//input";
	public static final String SAVE_BUTTON_AT_ADD_EMPLOYEE_PAGE = "//button[@type='submit']";

	
	// Personal Details Page
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
	public static final String SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_PAGE = "//div[@id='oxd-toaster_1']/div/div[1]/div[2]/p[2]";

	
	public static final String DYNAMIC_BUTTON_AT_QUALIFICATION_PAGE = "//h6[text()='%s']/ancestor::div[@class='orangehrm-action-header']//button";

	// Contract Details Form
	public static final String STREET_1_TEXT_BOX_AT_CONTRACT_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input";
	public static final String CITY_TEXT_BOX_AT_CONTRACT_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]//input";
	public static final String STATE_PROVINCE_TEXT_BOX_AT_CONTRACT_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]//input";
	public static final String COUNTRY_DROPDOWN_AT_CONTRACT_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][6]//div[@class='oxd-select-text-input']";
	public static final String MOBILE_TEXT_BOX_AT_CONTRACT_PAGE ="//div[@class='oxd-form-row'][2]//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//input";
	public static final String WORK_EMAIL_BOX_AT_CONTRACT_PAGE ="//div[@class='oxd-form-row'][3]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input";
	public static final String SUCCESS_MESSAGE_AT_CONTRACT_DETAIL_PAGE = "//div[@id='oxd-toaster_1']/div/div[1]/div[2]/p[2]";
	
	// Job Form 
	public static final String JOINED_DATE_TEXT_BOX_AT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input";
	public static final String JOB_TITLE_DROP_DOWN_AT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//div[@class='oxd-select-text-input']";
	public static final String JOB_CATEGORY_DROP_DOWN_AT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]//div[@class='oxd-select-text-input']";
	public static final String SUB_UNIT_DROP_DOWN_AT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][5]//div[@class='oxd-select-text-input']";
	public static final String LOCATION_DROP_DOWN_AT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][6]//div[@class='oxd-select-text-input']";
	public static final String EMPLOYMENT_STATUS_DROP_DOWN_AT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][7]//div[@class='oxd-select-text-input']";
	public static final String SUCCESS_MESSAGE_AT_CONTRACT_JOB_PAGE ="//div[@class='oxd-form-row'][1]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input";
}
