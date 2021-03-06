package ExaminationAndResultModule;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import pageObject.ExaminationAndResult;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyModules;
import testBase.TestBase;

public class SanityTest extends TestBase {

	public static final Logger log = Logger.getLogger(SanityTest.class.getName());
	
	@Test(priority = 0, dataProvider = "loginData")
	public void examinationResultSanityTest(String userid, String password, String runMode) throws InterruptedException{
		
		LoginPage loginpage;
		HomePage homepage;
		MyModules mymodules;
		ExaminationAndResult examResult;
				
		loginpage = new LoginPage(dr);
		homepage = new HomePage(dr);
		mymodules = new MyModules(dr);
		examResult = new ExaminationAndResult(dr);
		
		
		if(runMode.equalsIgnoreCase("N"))
			throw new SkipException("User Marked this test as no run");
					
		homepage.navigateToiumsLoginPage();
		
			for(String s : dr.getWindowHandles())
				dr.switchTo().window(s);
				log("Switched to new window");
				
		
		loginpage.iumslogin(userid, password);
		log("User logged in to IUMS");
		Assert.assertEquals("MODULES ASSIGNED", mymodules.assignedModules());
			
		mymodules.clickOnexaminationAndResultModule();
		Actions action = new Actions(dr);
		action.moveToElement(examResult.getExaminationMaster()).moveToElement(examResult.getExamConfigMaster()).click().build().perform();
		action.moveToElement(examResult.getExaminationMaster()).moveToElement(examResult.getExamConfigurationTransaction()).click().build().perform();
		action.moveToElement(examResult.getExaminationMaster()).moveToElement(examResult.getGraceConfigurationMaster()).click().build().perform();
		action.moveToElement(examResult.getExaminationMaster()).moveToElement(examResult.getDistrictPlaceMapping()).click().build().perform();
		action.moveToElement(examResult.getExaminationMaster()).moveToElement(examResult.getExamChallanNoConfiguration()).click().build().perform();
		action.moveToElement(examResult.getExaminationMaster()).moveToElement(examResult.getExamConfigurationTransactionCollegeWise()).click().build().perform();
		mymodules.clickOnlogOut();
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
	
}
