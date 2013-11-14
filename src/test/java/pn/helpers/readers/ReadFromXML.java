package pn.helpers.readers;

import static pn.helpers.BaseTestHelper.log;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.*;

public class ReadFromXML implements IReaderFile {

	private Object[][] data = null;
	List<String> allParams = new ArrayList<>();
	
	@Override
	public Object[][] read(String filePath, String sheetName) {
		try {
			SAXBuilder parser = new SAXBuilder();
			Reader fr = new BufferedReader(new InputStreamReader(
					new FileInputStream(sheetName), "UTF-8"));
			Document rDoc = parser.build(fr);
			List<Element> element = rDoc.getRootElement().getChildren();
			int countParameters = element.get(0).getChildren().size();
			int countRows = element.size() - 1;
			data = new Object[countRows][countParameters];
			List<Element> getChildren = null;
			int indexByRow = 0;
			
			for (int i = 1; i < element.size(); i++) {
				getChildren = element.get(i).getChildren();
				for (Element row : getChildren) {
					data[i-1][indexByRow] = row.getValue();
					indexByRow ++;
				}
			}
			return data;
		} catch (Exception ex) {
			log("<b><h3>" + "It is impossible to read the file!" + "</h3></b>");
		}
		return null;
	}
	
	
}
