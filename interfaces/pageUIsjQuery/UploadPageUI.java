package pageUIsjQuery;

public class UploadPageUI {
	public static final String UPLOAD_FILE ="//input[@type='file']";
	public static final String FILE_NAME_LOADED_TEXT ="//p[@class ='name' and text()='%s']";
	public static final String FILE_NAME_UPLOADED_TEXT ="//p[@class ='name']/a[text()='%s']";
	public static final String START_BUTTON_BY_FILE_NAME ="//p[@class ='name' and text()='%s']//parent::td//following-sibling::td/button[@class='btn btn-primary start']";
}
