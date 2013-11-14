package pn.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import pn.configuration.WebDriverFactory;

public class BaseTestHelper {
	
	public WebDriver selectBrowser(String nameDriver, String driverPath) {
		log("Select " + nameDriver + " browser");
		switch (nameDriver) {
		case "firefox":
			return WebDriverFactory.getDriver(DesiredCapabilities.firefox());
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", driverPath);
			return WebDriverFactory.getDriver(DesiredCapabilities.chrome());
		}
		case "IE": {
			System.setProperty("webdriver.ie.driver", driverPath);
			return WebDriverFactory.getDriver(DesiredCapabilities
					.internetExplorer());
		}
		case "opera": {
			System.setProperty("opera.binary", driverPath);
			return WebDriverFactory.getDriver(DesiredCapabilities.opera());
		}
		}
		return WebDriverFactory.getDriver(DesiredCapabilities.firefox());
	}

	public static void log(String message) {
		Reporter.log("[LOG]" + " " + message + "<br>");
	}
	
	
}
