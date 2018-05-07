package signInAction;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testpractis {
	
	public WebDriver driver;
	
	
	@Test (dataProvider = "UserNamePassword") 
	//@Parameters ({"userName","passWord"})
	public void testingDataProvider(String userName, String passWord){
			
		System.out.println("userName : "+userName);
		System.out.println("passWord : "+passWord);
		
	}
	
	@Test
	public void print(){
		System.out.println("testing testng");
	}

	
	
	public String[][] getExcelData(String fileName, String sheetName) {
		
		String[][] ar = null;
		
		try {
			
			FileInputStream fs = new FileInputStream(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);

			int totalNoOfRows = sh.getLastRowNum()+1;
			int totalNoOfCols = sh.getRow(0).getLastCellNum();
			
			ar = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {
				XSSFRow rows = sh.getRow(i);
				for (int j=0; j < totalNoOfCols; j++) {
					XSSFCell cell = rows.getCell(j);
					ar[i-1][j] = cell.getStringCellValue();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ar;
	}
	
	@DataProvider (name = "UserNamePassword")
	public Object[][] getData()	{
	
		Object[][] data = getExcelData("\\D:\\TestPractisData.xlsx","LoginTestData"); 	
		
		/*Object[][] data = new Object[3][2];

		data[0][0] ="sampleuser1";
		data[0][1] = "abcdef";

		data[1][0] ="testuser2";
		data[1][1] = "zxcvb";
	
		data[2][0] ="guestuser3";
		data[2][1] = "pass123";*/

	return data;
	
	}

	
	
	
}
