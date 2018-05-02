package customListner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class WebEventListener implements WebDriverEventListener {
	
	public static final Logger log = Logger.getLogger(WebEventListener.class.getName());

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		//log("Before Navigate to '"+url+"'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log("Navigate to '"+url+"'");	
	}

	public void beforeNavigateBack(WebDriver driver) {
		log("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		log("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		log("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		log("Navigated forward to next page");
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		log("Navigating refresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		log("Navigated refresh");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		//log("Trying to find element by : "+by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log("Found element by : "+by.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//log("Trying to click on "+element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		log("Clicked on "+element.toString());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log("Value of :"+element.toString()+" Before any change made");		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log("Value of :"+element.toString()+" Before any change made");	
	}

	public void beforeScript(String script, WebDriver driver) {
		//log("Just before Script : "+driver);
	}

	public void afterScript(String script, WebDriver driver) {
		//log("Just after Script : "+driver);		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		log("Exception occured : "+throwable);
	}
	
	public void log(String data){
		log.info(data);
		Reporter.log(data);
	}



}
