package pn.reporting;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pn.components.Component;
import static pn.helpers.BaseTestHelper.*;



public class TakeScreenShot extends TestListenerAdapter {

	public final static String DIRECTORY_FOR_SCREEN= "target/surefire-reports/html/screenshots/";
	private final static String SCREEN_SHOTS_FILE_EXTENTION = ".png";
	private static final String HIPERLINK_IMAGE = "<a href=\"%s\"><img src=\"%<s\" width=200 height=150></a><br>";

	
	public void onTestFailure(ITestResult tr) {
		takeScreenshot();
	}

	public static void takeScreenshot() {
		WebDriver driver = Component.getDriver();
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");

		String dstFileName = dateFormat.format(new Date()) + SCREEN_SHOTS_FILE_EXTENTION;
		String relativeFileName = "screenshots/" + dstFileName;

		new File(DIRECTORY_FOR_SCREEN).mkdirs();
		File destFile = new File(DIRECTORY_FOR_SCREEN + "/" + dstFileName);

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			log("IO exception has occured");
		}
		log(String.format(HIPERLINK_IMAGE, relativeFileName));
	}

}
