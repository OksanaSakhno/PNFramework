package pn.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import pn.configuration.WebDriverFactory;
import pn.dataProvider.PropertiesFileReader;
import pn.tests.BaseTest;

public class BaseTestHelper {
	
	public WebDriver selectBrowser(String nameDriver, PropertiesFileReader propertyReader) {
		propertyReader.readPropertiesFile(BaseTest.nameFileProperties);
		log("Select " + nameDriver + " browser");
		switch (nameDriver) {
		case "firefox":
			return WebDriverFactory.getDriver(DesiredCapabilities.firefox());
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", propertyReader.getDriverDirChrome());
			return WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		}
		case "IE": {
			System.setProperty("webdriver.ie.driver", propertyReader.getDriverDirIE());
			return WebDriverFactory.getDriver(DesiredCapabilities
					.internetExplorer());
		}
		case "opera": {
			System.setProperty("opera.binary", propertyReader.getDriverDirOpera());
			return WebDriverFactory.getDriver(DesiredCapabilities.opera());
		}
		}
		return WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	}
	
	
	public static void log(String message) {
		Reporter.log("[LOG]" + " " + message + "<br>");
	}
	
	
}
