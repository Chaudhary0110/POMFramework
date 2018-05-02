package pageObject;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.TestBase;

public class HomePage extends TestBase{
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	@FindBy (xpath = "//*[@id='form1']/div[7]/div/div/div[2]/div/div/div/div[4]/div/div/h1/a")
	WebElement iumsLoginPageLink;
	
	@FindBy (xpath = "//*[@id='form1']/div[3]/div/a")
	WebElement signOut;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void navigateToiumsLoginPage(){
		iumsLoginPageLink.click();
		log("Clicked on IUMS Login link");		
	}
	
	public void clickOnsignOut(){
		signOut.click();
	}

	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
}
