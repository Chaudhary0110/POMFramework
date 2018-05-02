package customListner;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import testBase.TestBase;

public class Retry implements IRetryAnalyzer {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	private int retryCount = 0;
	private int maxRetryCount = 2;

	public boolean retry(ITestResult result) {

		if(retryCount < maxRetryCount){
			log("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount +1) +" time(s)");
			retryCount++ ;
			return true;
		}
		return false;
	}

	
	public String getResultStatusName(int status){
	
		String resultName = null;
		if(status == 1)
			resultName = "Success";	
		if(status == 2)
			resultName = "Failed";	
		if(status == 3)
			resultName = "Skiped";	
		return resultName;
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}
}
