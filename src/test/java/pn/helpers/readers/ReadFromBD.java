package pn.helpers.readers;

import static pn.helpers.BaseTestHelper.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pn.dataProvider.PropertiesFileReader;
import pn.tests.BaseTest;

public class ReadFromBD implements IReaderFile{
	
	private String URL;
	private String NAME;
	private String PASSWORD;
	
	public void connect (){
		PropertiesFileReader prop = new PropertiesFileReader();
		prop.readPropertiesFile(BaseTest.nameFileProperties);
		/*setURL(prop.getUrl());
		setNAME(prop.getName());;
		setPASSWORD(prop.getPassword());*/
		
	}
	

	@Override
	public Object[][] read(String filePath, String sheetName) {
		connect();
		Object[][] data = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection connect = DriverManager.getConnection(URL, NAME,
						PASSWORD);
				Statement statement = connect.createStatement();
				// statement.executeUpdate(createTableQuery);
				String query = "select*from " + sheetName;
				ResultSet rs = statement.executeQuery(query);
				int resultSetColumn = rs.getMetaData().getColumnCount();
				rs.last();
				int resultSetRows = rs.getRow();
				rs.beforeFirst();
				data = new Object[resultSetColumn][resultSetRows];
				int currentRow = 1;
				while (rs.next()) {
					for (int column = 0; column < resultSetColumn; column++) {
						data[currentRow][column] = rs.getString(column);
					}
					currentRow++;
				}
				connect.close();
				return data;
			} catch (SQLException e) {
				log("<b><h3>" + "It is impossible to read the file!"
						+ "</h3></b>");
			}

		} catch (ClassNotFoundException e) {
			log("<b><h3>" + "File NOT FOUND!" + "</h3></b>");
		}
		return null;
	}
	

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}



}
