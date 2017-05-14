package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inter.components.Header;

public class BasePage 
{
	public WebDriver driver;
	String BASE_URL="https://the-internet.herokuapp.com/";
	
	// Constructor which initializes the driver
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// Navigates to the default the-internet page 
	public void visit()
	{
		try {
			driver.get(BASE_URL);
		}
		catch(Exception e) {
			System.out.println("FAILURE: URL did not load: " + BASE_URL);  
		}
	}

	// Navigate to specific page of site
	public void visit(String url)
	{
		try {
			driver.get(BASE_URL+url);
		}
		catch(Exception e) {
			System.out.println("FAILURE: URL did not load: " + BASE_URL+url);  
		}
	}
	
	public String getURL()
	{
		try {
		    return driver.getCurrentUrl().toString();
		}
		catch(Exception e) {
			System.out.println("Currently at URL: "+driver.getCurrentUrl().toString());
		}
		return null;
	}
	
	public void clickOn(WebElement ele)
	{
		try{
			ele.click();			
		}
		catch(Exception e) {
			System.out.println("The following element is not clickable: "+ele);
		}
	}

	public void enter(WebElement ele,String inputText)
	{
		try {
			clear(ele);
			ele.sendKeys(inputText);	
		}
		catch(Exception e) {
			System.out.println("Unable to enter "+inputText+ "into the following element: "+ele);
		}
	}
	
	public void clear(WebElement ele)
	{
		try {
			ele.clear();
		}
		catch(Exception e) {
			System.out.println("Unable to clear into the following element: "+ele);
		}
	}
	
	public String getHeading()
	{
		try {
			Header header = new Header(driver);
			System.out.println(header.getHeadingOfPage().getText()+" is loaded");
			return header.getHeadingOfPage().getText();			
		}
		catch(Exception e) {
			System.out.println("Page Header not loaded correctly");
		}
		return null;
	}
	
	public String getLoginPageHeading()
	{
		try {
			Header loginPageHeader = new Header(driver);
			System.out.println(loginPageHeader.getHeadingOfLoginPage().getText() +" is loaded");
			return loginPageHeader.getHeadingOfLoginPage().getText();
		}
		catch(Exception e) {
			System.out.println("Header not loaded correctly");
		}
		return null;
	}
	
	public boolean ifDisplayed(WebElement ele)
	{
		try{
			waitFor(ele);
			return ele.isDisplayed();
		}
		catch(Exception exception) {
			return false;
		}
	}
	
	public String getText(WebElement ele)
	{
		try {
			return ele.getText();
		}
		catch(Exception e) {
			System.out.println("Text is not present on the element :"+ele);
		}
		return null;
	}
	
	// Waits 10 sec for visibility of element
	public void waitFor(WebElement ele)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		catch(Exception e) {
			System.out.println(ele+" the following element is not present on the page");
		}
	}
}