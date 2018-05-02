package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.TestBase;

public class LoginPage extends TestBase{

	
	public static final Logger log = Logger.getLogger(LoginPage.class.getName());
	
	@FindBy (xpath = "//*[@id='username']")
	WebElement emailAddress;
	
	@FindBy (xpath = "//*[@id='upassword']")
	WebElement loginpassWord;
	
	@FindBy (xpath = "//*[@id='btnLogin']")
	WebElement login;
	
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void iumslogin(String userName, String password){
		emailAddress.sendKeys(userName);
		log("Entered userName is : "+userName);
		loginpassWord.sendKeys(password);
		log("Entered password is : "+password);
		login.click();
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
	
}
