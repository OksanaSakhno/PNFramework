package pn.dataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.*;

import pn.helpers.readers.IReaderFile;
import pn.helpers.readers.ReadFromExcel;


public class DataProviderTest {

	@DataProvider(name = "excelDataForTest")
	public static Object[][] readForTest(Method method) throws IOException {
		String fileName = getDataFileName(method);
		String sheetName = method.getName();

		IReaderFile reader = new ReadFromExcel();
		return reader.read(fileName, sheetName);
	}
	
	@DataProvider()

	private static String getDataFileName(Method method){
	  return  PropertiesFileReader.getReadFromExcel() + method.getDeclaringClass().getSimpleName() + ".xls";
	 }

}
