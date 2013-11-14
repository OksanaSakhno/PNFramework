package pn.reporting;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import pn.components.Component;


public class TakeScreenShot extends TestListenerAdapter {

	public final static String DIRECTORY_FOR_SCREEN= "target/surefire-reports/screenshot/";
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			File screenShot = getScreenShot();
			tr.setAttribute("screenshot", screenShot.getName());
			tr.setAttribute("screenshotURL", screenShot.getAbsolutePath());

			String logString = String
					.format("<br /><a href='%s'><img src='%s' hight='100' width='100' /></a>",
							screenShot.getAbsolutePath(),
							screenShot.getAbsolutePath());

			Reporter.log("<br>Screenshot: ");
			Reporter.log(logString);
		} catch (Exception e) {
			System.out.println("Error generating screenshot: " + e);
		}
	}

	private File getScreenShot() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();

		File screenshot = ((TakesScreenshot) Component.getDriver())
				.getScreenshotAs(OutputType.FILE);
		String path = DIRECTORY_FOR_SCREEN + dateFormat.format(date);
		File screenShotInFileSystem = new File(path);
		try {
			FileUtils.copyFile(screenshot, screenShotInFileSystem);
		} catch (IOException e) {
			System.out.println("Caught IOException");
		}
		return screenShotInFileSystem;
	}
}