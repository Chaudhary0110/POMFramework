package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.TestBase;

public class ExamConfigurationTransaction  extends TestBase {

	public static final Logger log = Logger.getLogger(ExamConfigurationTransaction.class.getName());
	
	
	@FindBy (xpath = "//*[@id='body']/div[2]/table/tbody/tr[4]/td[3]/a/img")
	WebElement ExamFormStartDate;
	
	public ExamConfigurationTransaction(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnExamFormStartDate(){
		ExamFormStartDate.click();
		log("Clicked on Exam Form Start Date");
	}
	
	
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
}
