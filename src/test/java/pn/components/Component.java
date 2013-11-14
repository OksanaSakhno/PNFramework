package pn.components;

import org.openqa.selenium.WebDriver;

public abstract class Component {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Component.driver = driver;
	}
	

}
