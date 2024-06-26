package pageUIsNopcomerce;

public class RegisterPageUI {
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDROWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDROWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDROWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANYNAME_TEXTBOX = "//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRMPASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String REGISTERED_SUCCESS_MESSAGE = "//div[@class='result' and text()='Your registration completed'] ";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID ="//input[@id='%s']"; 
	
}
