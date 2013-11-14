package pn.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pn.components.Component;
import pn.components.ListOfCategories;
import pn.dataProvider.PropertiesFileReader;
import pn.helpers.BaseTestHelper;


public class BaseTest extends BaseTestHelper{
	
	public String baseUrl;
	public static String nameFileProperties = "fileProperties.txt";
	public static String excelFileForTests;

	

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		PropertiesFileReader propertyReader = new PropertiesFileReader();
		propertyReader.readPropertiesFile(nameFileProperties);
		Component.setDriver(selectBrowser(System.getProperty("browser"), propertyReader));
		Component.getDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		baseUrl = propertyReader.getBaseUrl();
		excelFileForTests = PropertiesFileReader.getReadFromExcel();
		log("Starting test " + this.getClass().getSimpleName());
	}
	
	
	@AfterClass
	  public void afterClass() throws Exception {
		log("Finishing test " + this.getClass().getSimpleName());
	  }
	
	
	@AfterSuite
	  public void afterSuite() throws Exception {
		log("Browser closed ");
		Component.getDriver().quit();
	  }
	
	
	public ListOfCategories goToMailPage(){
		Component.getDriver().get(baseUrl);
		log("Going to base URL " + baseUrl);
		return PageFactory.initElements(Component.getDriver(), ListOfCategories.class);
	}
	

	
}
