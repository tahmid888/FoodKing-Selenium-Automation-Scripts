package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1
	
	@DataProvider(name = "LoginData")
	
	public String[][] getData() throws IOException

	{
		// Excel file path
		String path = ".\\testData\\LoginData.xlsx"; 

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getColumnCount("Sheet1", 1);

		// Prepare the test data
		String logindata[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Fill test data
			}

		}
		return logindata;
	}
}
