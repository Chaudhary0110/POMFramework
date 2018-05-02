package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.TestBase;

public class MyModules extends TestBase{

	public static final Logger log = Logger.getLogger(MyModules.class.getName());
	
	@FindBy (xpath = "//*[@id='ctl00_ContentPlaceHolder1_DataList1']/tbody/tr[4]/td[2]/table/tbody/tr/td/div/div[1]/a/img")
	WebElement examinationAndResultModule;
	
	@FindBy (xpath = "//*[@id='body']/div[2]/table/tbody/tr[1]/td/h1")
	WebElement modulesAssigned;
	
	@FindBy (xpath = "//*[@id='aspnetForm']/div[3]/table/tbody/tr/td/div[1]/table[1]/tbody/tr/td[5]/div/a")
	WebElement logOut;
	
	public MyModules (WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnexaminationAndResultModule(){
		examinationAndResultModule.click();
		log("Clicked on Examination & Result Module");
	}
	
	public String assignedModules(){
		return modulesAssigned.getText();
	}
	
	public void clickOnlogOut(){
		logOut.click();
		log("Clicked on logOut");
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
}
