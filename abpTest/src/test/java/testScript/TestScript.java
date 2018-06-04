package testScript;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.TestBase;
import utilities.Excel_Reader;

public class TestScript extends TestBase {

	TestScript testHomePage;
	HomePage homePage;
	Excel_Reader excelReader;
	
		

	@DataProvider (name = "searchKeyWords")
	public Object[][] getTestData(){
		Object [][] data = getData("Keywords-Selenium.xlsx","Keyword");
		return data;
	}
	
		@BeforeTest
		public void beforeTest(){
			homePage = new HomePage(driver);
			homePage.navigateToHomePage();
		}
	
		@Test (priority = 0)
		public void navigationTest(){
			
			long start = System.currentTimeMillis();
			Actions action = new Actions(driver);
			action.moveToElement(homePage.getfirstMenu()).moveToElement(homePage.getfirstLink()).click().build().perform();
			long finish = System.currentTimeMillis();
			long totalTime = finish - start;
			System.out.println("Time taken bt the page : "+totalTime);
			homePage.clickhomeLink();
			
		}
		
		@Test (priority = 1, dataProvider = "searchKeyWords") 
		public void searchKeywordTest(String KEYWORDS){
		
			homePage.clickOnSearchButton();
			homePage.getSearchTextBox().sendKeys(KEYWORDS, Keys.ENTER);		
			String result = homePage.getsearchResult().getText();
			System.out.println(result);
			
			driver.quit();
		}

		@Test (priority = 2)
		public void verfyDate(){
		
			driver.get("anandabazar.com/news-sitemap.xml");
			String actualDate = homePage.getDate().getText();
			if(actualDate == "2018-06-02")
				System.out.println("Date is correct");
			else 
				System.out.println("Date is incorrect");
		}
		
	}

