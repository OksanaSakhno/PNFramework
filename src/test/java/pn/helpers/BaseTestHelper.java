package pn.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import pn.configuration.Constants;
import pn.configuration.WebDriverFactory;
import pn.dataProvider.PropertiesFileReader;
import pn.tests.BaseTest;

public class BaseTestHelper {
	

	public WebDriver selectBrowser(String nameDriver,
			PropertiesFileReader propertyReader) {
		propertyReader.readPropertiesFile(BaseTest.nameFileProperties);
		log("Select " + nameDriver + " browser");

		switch (nameDriver) {

		case Constants.DEFAULT_FIREFOX_BROWSER:
			return WebDriverFactory.getDriver(DesiredCapabilities.firefox());

		case Constants.CHROME_BROWSER:
			System.setProperty(Constants.CHROME_DRIVER_NAME,
					propertyReader.getDriverDirChrome());
			return WebDriverFactory.getDriver(DesiredCapabilities.chrome());

		case Constants.IE_BROWSER:
			System.setProperty(Constants.IE_DRIVER_NAME, propertyReader.getDriverDirIE());
			return WebDriverFactory.getDriver(DesiredCapabilities
					.internetExplorer()); 

		case Constants.OPERA_BROWSER:
			System.setProperty(Constants.OPERA_DRIVER_NAME,
					propertyReader.getDriverDirOpera());
			return WebDriverFactory.getDriver(DesiredCapabilities.opera());
		default:
			return getDefaultBrowser();
		}
	}
	
	
	private WebDriver getDefaultBrowser() {
		log("Select default browser ");
		return WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	}


	public static void log(String message) {
		Reporter.log("[LOG]" + " " + message + "<br>");
	}
	
}
