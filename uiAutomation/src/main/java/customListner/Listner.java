package customListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testBase.TestBase;


public class Listner extends TestBase implements ITestListener {
	
	public static final Logger log = Logger.getLogger(Listner.class.getName());
	
	
	public void onFinish(ITestContext arg0) {
		
		
	}

	public void onStart(ITestContext arg0) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String methodName = result.getName();
			
		if(!result.isSuccess()) {
			
			File srcFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
			try{		
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\Screenshot\\FailedTestScreenshot";
				File destFile = new File((String) reportDirectory + "\\failure_screenshots" + methodName + "_" + formater.format(calendar.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href ='" + destFile.getAbsolutePath() + "'> <img src ='" + destFile.getAbsolutePath() + "' hight =100 width =100 /> </a>");
			} catch (IOException e) {
				e.printStackTrace();
				}
		}
	}

	public void onTestSkipped(ITestResult name) {
		
		log("Test Case "+name.getName()+" Skipped");
	}

	public void onTestStart(ITestResult name) {
		
		log("Test case "+name.getName()+" Started");
	}

	public void onTestSuccess(ITestResult result) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		String methodName = result.getName();
		
		if(result.isSuccess()) {
			File srcFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
			try{		
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\Screenshot\\PassedTestScreenshot\\";
				File destFile = new File((String) reportDirectory + "\\pass_screenshots" + methodName + "_" + formater.format(calendar.getTime())+".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href ='" + destFile.getAbsolutePath() + "'> <img src ='" + destFile.getAbsolutePath() + "' hight =100 width =100 /> </a>");
			} catch (IOException e) {
				e.printStackTrace();
				}
		}
		
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}

	
}
