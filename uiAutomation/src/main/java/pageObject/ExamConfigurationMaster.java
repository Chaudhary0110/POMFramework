package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.TestBase;

public class ExamConfigurationMaster extends TestBase {

	public static final Logger log = Logger.getLogger(ExamConfigurationMaster.class.getName());
	
	
	WebElement AcademicSession;
	
	@FindBy (xpath = "//*[@id='body']/div[2]/table/tbody/tr[3]/td[7]/a/img")
	WebElement ConfigDate;
	
	WebElement FromMonth;
	
	WebElement FromYear;
	
	WebElement ToMonth;
	
	WebElement ToYear;
	
	WebElement ExamCategory;
	
	@FindBy (id = "ctl00_ContentPlaceHolder1_btnSave")
	WebElement saveButton;
	
	@FindBy (xpath = "//*[@id='ctl00_ContentPlaceHolder1_chkActive']")
	WebElement IsActive;
	
	public ExamConfigurationMaster(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getAcademicSession() {
		AcademicSession = dr.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_D_ddlSession']"));
		log("Session Selected"); 
	    return AcademicSession;
	    } 
	
	public void clickOnConfigDate(){
		ConfigDate.click();
	}
	
	public WebElement getFromMonth() {
		FromMonth = dr.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_D_ddlFMonth']"));
		log("From Month Selected"); 
	    return FromMonth;
	    }
	
	public WebElement getFromYear() {
		FromYear = dr.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_D_ddlFYear']"));
		log("From Year Selected"); 
	    return FromYear;
	    }
	
	public WebElement getToMonth() {
		ToMonth = dr.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_D_ddlTMonth']"));
		log("To Month Selected"); 
	    return ToMonth;
	    }
	
	public WebElement getToYear() {
		ToYear = dr.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_D_ddlTYear']"));
		log("To Year Selected"); 
	    return ToYear;
	    }
	
	public WebElement getExamCategory() {
		ExamCategory = dr.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_D_ddlExamCat']"));
		log("Exam Category Selected"); 
	    return ExamCategory;
	    }
	
	public void selectIsActive(){
		IsActive.click();
		log("Is Active Selected");
	}
	
	public void clickOnSaveButton(){
		saveButton.click();
		log("Clicked on Save Button");
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}

	
}
