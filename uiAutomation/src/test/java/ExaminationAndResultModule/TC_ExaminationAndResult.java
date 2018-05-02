package ExaminationAndResultModule;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObject.ExamConfigurationMaster;
import pageObject.ExaminationAndResult;
import testBase.TestBase;

public class TC_ExaminationAndResult extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_ExaminationAndResult.class.getName());
	
	ExaminationAndResult examinationAndResult;
	ExamConfigurationMaster examConfigurationMaster;
	
	@Test
	public void tc_examinationConfigurationMaster(){
		
		examinationAndResult = new ExaminationAndResult(driver);
		
		examConfigurationMaster = new ExamConfigurationMaster(driver);
		
	}

}
