package signInAction;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import pageObject.ExamConfigurationMaster;
import pageObject.ExamConfigurationTransaction;
import pageObject.ExaminationAndResult;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyModules;
import testBase.TestBase;

public class TC_Login extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC_Login.class.getName());
	
	LoginPage loginpage;
	HomePage homepage;
	MyModules mymodules;
	ExaminationAndResult examResult;
	ExamConfigurationMaster examConfig;
	ExamConfigurationTransaction examConfigTran;
	
	
	@Test(dataProvider = "loginData")
	public void LoginWithMultipleUser(String userid, String password, String runMode) throws InterruptedException{
		
		homepage = new HomePage(dr);
		mymodules = new MyModules(dr);
		examResult = new ExaminationAndResult(dr);
		examConfig = new ExamConfigurationMaster(dr);
		examConfigTran = new ExamConfigurationTransaction(dr);
		
		if(runMode.equalsIgnoreCase("N"))
			throw new SkipException("User Marked this test as no run");
			
		homepage.navigateToiumsLoginPage();
			for(String s : dr.getWindowHandles())
				dr.switchTo().window(s);
				log("Switched to new window");
					
		loginpage = new LoginPage(dr);
		loginpage.iumslogin(userid, password);
		log("User logged in to IUMS JNVU");
		Assert.assertEquals("MODULES ASSIGNED", mymodules.assignedModules());
		mymodules.clickOnlogOut();
		log("User logged Out from IUMS JNVU");
		homepage.clickOnsignOut();
		log("Navigate back to home page");
		
	}
	
		
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
	
}
