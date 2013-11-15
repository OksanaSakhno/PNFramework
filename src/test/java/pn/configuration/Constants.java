package pn.configuration;

public class Constants {
	////////WebDriverFactory, BaseTest//////
	public static final String DEFAULT_FIREFOX_BROWSER = "firefox";
	public static final String CHROME_BROWSER = "chrome";
	public static final String IE_BROWSER = "IE";
	public static final String OPERA_BROWSER = "opera";
	public static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	public static final String IE_DRIVER_NAME = "webdriver.ie.driver";
	public static final String OPERA_DRIVER_NAME = "opera.binary";
	////Helpers
	public static final int PARAMETR_NOT_SET = -1;
	public static final String ATTRIBURE_HREF = "href";
	//////TakeScreenShot////////////////////
	public final static String DIRECTORY_FOR_SCREEN= "target/surefire-reports/html/screenshots/";
	public final static String SCREEN_SHOTS_FILE_EXTENTION = ".png";
	public static final String HIPERLINK_IMAGE = "<a href=\"%s\"><img src=\"%<s\" width=200 height=150></a><br>";

	/////FunctionMenuHelper////////////////
	public static final int SORTED_BY_MAX = -1;
	public static final int SORTED_BY_MIN = 1;
	public static final int SORTED_BY_MIN_MAX = 2;
	public static final int NO_SORTED = 0;
	public static final String SHOW_ALL_LINK = "показать все";
	public static final String HIDE_OTHER_LINK = "скрыть остальные";
}
