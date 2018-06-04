package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase {

	WebElement homeLink;
	
	WebElement firstMenu;
		
	WebElement firstLink;
	
	WebElement searchButton;
	
	WebElement searchTextBox;
	
	WebElement searchResult;
	
	WebElement date;
	
		
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getfirstMenu(){
		firstMenu = driver.findElement(By.cssSelector("#abp_nav_calcutta > a"));
		return firstMenu;
	}	
	
	public WebElement getfirstLink(){
		firstLink = driver.findElement(By.cssSelector("#abp_nav_calcutta > div > ul > li > a"));
		return firstLink;
	}	
	
	public void clickhomeLink(){
		homeLink = driver.findElement(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li.gtm-class-topnav.hidden-sm.hidden-xs.hm-nav > a > i"));
		homeLink.click();
	}	
	
	public void clickOnSearchButton(){
		searchButton = driver.findElement(By.cssSelector("#search-open2"));
		searchButton.click();
	}
	
	public WebElement getSearchTextBox(){
		searchTextBox = driver.findElement(By.cssSelector("#search-text"));
		return searchTextBox;
	}
	
	public WebElement getsearchResult(){
		searchResult = driver.findElement(By.cssSelector("body > div:nth-child(18) > div:nth-child(1) > div > div:nth-child(1) > div.col-lg-8.col-md-8.col-sm-12.col-xs-12 > div.well.well-sm > ol > li.result-list.pull-right"));
		return searchResult;
	}

	public WebElement getDate(){
		date = driver.findElement(By.cssSelector("#collapsible4 > div.expanded > div.collapsible-content > div.line > span.text"));
		return date;
	}
	
	
}

