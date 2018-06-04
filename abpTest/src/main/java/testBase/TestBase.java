package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Excel_Reader;

public class TestBase {
	
		
		public static WebDriver driver;
		Excel_Reader excel;
		
		public void navigateToHomePage(){
			
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.get("https://www.anandabazar.com");
				driver.manage().window().maximize();
							
		}
		
				
		public String [][] getData(String excelName, String sheetName){
			
			String path = System.getProperty("user.dir")+"\\src\\main\\java\\testData\\"+excelName;
			excel = new Excel_Reader(path);
			String [][] data = excel.getDataFromExcel(sheetName, excelName);
			return data;
		}
}
