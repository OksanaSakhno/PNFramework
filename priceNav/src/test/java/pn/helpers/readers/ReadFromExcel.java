package pn.helpers.readers;

import static pn.helpers.BaseTestHelper.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


public class ReadFromExcel implements IReaderFile{
	
	public Object[][] read(String filePath, String sheetName) {
		Object[][] data = null;
		try (FileInputStream file = new FileInputStream(new File(filePath))){
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(sheetName);

			HSSFRow row = sheet.getRow(0);

			int numberOfRows = sheet.getLastRowNum();
			int numberOfColumns = row.getLastCellNum();

			data = new Object[numberOfRows][numberOfColumns];

			for (int rowNum = 1; rowNum < numberOfRows + 1; rowNum++) {

				for (int cellNum = 0; cellNum < numberOfColumns; cellNum++) {

					Cell cell = sheet.getRow(rowNum).getCell(cellNum);
					
					if(cell != null) {
						
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	
							data[rowNum - 1][cellNum] = cell.getStringCellValue();
						}
						if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
							
							data[rowNum - 1][cellNum] = cell.getNumericCellValue();
						}
					}else data[rowNum - 1][cellNum] = -1;
				}
			}
			file.close();
			return data;
		} catch (FileNotFoundException e) {
			log("<b><h3>" + "File .xls NOT FOUND!" + "</h3></b>");
		} catch (IOException e) {
			log("<b><h3>" + "It is impossible to read the .xls file!" + "</h3></b>");
		}
		return null;
	}
	


}
