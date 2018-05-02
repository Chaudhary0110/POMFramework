package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;














import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Reporter;

import customListner.WebEventListener;
import utilities.Excel_Reader;


public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public static WebDriver dr;
	public EventFiringWebDriver driver;
	public WebEventListener eventListener;
	public Properties OR;
	
	Excel_Reader excel;
	
	
	public void init() throws IOException{
		loadData();
		String log4jconfpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
		
	}
	
	public void loadData() throws IOException{
		OR = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}
	
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			log("Creating the object of : " + browser);
			dr = new FirefoxDriver();
			driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			driver.register(eventListener);
		}
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			log("Creating the object of : " + browser);
			dr = new ChromeDriver();
			driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			//driver.register(eventListener);
		}
		
		if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			log("Creating the object of : " + browser);
			dr = new InternetExplorerDriver();
			driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			driver.register(eventListener);
		}
		
	}
	
	
	public void getUrl(String url){
		
		log("Navigating to the : " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public String [][] getData(String excelName, String sheetName){
		
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\testData\\"+excelName;
		excel = new Excel_Reader(path);
		String [][] data = excel.getDataFromExcel(sheetName, excelName);
		return data;
	}

	
	public void waitForElement(int timeOutInSec, WebElement element){
		WebDriverWait wait =  new WebDriverWait(dr, timeOutInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void getScreenShot(String name){
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File srcFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		try{		
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\Screenshot\\GenralScreenshot\\";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime())+".png");
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href ='" + destFile.getAbsolutePath() + "'> <img src ='" + destFile.getAbsolutePath() + "' hight =100 width =100 /> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Iterator<String> getAllWindows(){
		Set<String> windows = dr.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}


}
