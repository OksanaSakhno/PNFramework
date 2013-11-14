package pn.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static pn.helpers.BaseTestHelper.*;


public class PropertiesFileReader {
	
	static {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}
	
	private static String readFromExcelDir;
	private String baseUrl;
	private String driver;
	private String driverPathChrome;
	private String driverPathIE;
	private String driverPathOpera;
	
	
	
	public void readPropertiesFile(String path) {
		try(FileInputStream fis = new FileInputStream(path)){
			try {
				Properties p = new Properties();
				p.load(fis);
				this.setReadFromExcel(p.getProperty("read.fromExcelDir"));
				this.setBaseUrl(p.getProperty("baseUrl"));
				this.setDriver(p.getProperty("driver"));
				this.setDriverDirChrome(p.getProperty("driverPathChrome"));
				this.setDriverDirIE(p.getProperty("driverPathIE"));
				this.setDriverDirOpera(p.getProperty("driverPathOpera"));
			} catch (IOException ex) {
				log("<b><h3>" + "The file properties could not be read!" + "</h3></b>");
				System.out.println("The file properties could not be read!");
			}
		} catch (IOException e) {
			log("<b><h3>" + "File properties NOT FOUND!" + "</h3></b>");
			System.out.println("File properties is NOT FOUND!");
		}
		
	}
	

	public static String getReadFromExcel() {
		return readFromExcelDir;
	}

	public void setReadFromExcel(String readFromExcel) {
		readFromExcelDir = readFromExcel;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getDriverDirChrome() {
		return driverPathChrome;
	}


	public void setDriverDirChrome(String driverDir) {
		this.driverPathChrome = driverDir;
	}

	public String getDriverDirIE() {
		return driverPathIE;
	}


	public void setDriverDirIE(String driverDir) {
		this.driverPathIE = driverDir;
	}

	
	public String getDriverDirOpera() {
		return driverPathOpera;
	}


	public void setDriverDirOpera(String driverDir) {
		this.driverPathOpera = driverDir;
	}


}
