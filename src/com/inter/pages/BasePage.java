package com.inter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	public WebDriver driver;
	
	//Constructor initializes the driver
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Navigates to the website given in the url
	public void visit(String url)
	{
		driver.get(url);
	}
	
	/*Takes a By instance
	 * returns a WebElement 
	 * */
	public WebElement find(By locator)
	{
		waitfor(locator);
		return driver.findElement(locator);
	}
	
	/*Takes a By locator
	 * Calls find method and receives a WebElement element
	 * clicks on the WebElement
	 * */
	public void clickOn(By locator)
	{
		find(locator).click();
    }
	
	/* This method is used to enter text when Page has locators
	  */
	public void enter(String inputText,By locator)
	{
		find(locator).sendKeys(inputText);
	}
	
	/*This method is used to enter text when Page has Webelements*/
	public void enter(WebElement ele,String inputText)
	{
		clear(ele);
		ele.sendKeys(inputText);
	}
	
	/*This method is used to clear the text in an element*/
	public void clear(WebElement ele)
	{
		ele.clear();
	}
	
	// Returns heading of the page
	public String getHeading(WebElement element)
	{
		System.out.println(element.getText().toString());
		return element.getText().toString();
	}
	
	// Returns a boolean value based on whether element is present or not
	public boolean isDisplayed(By locator)
	{
		try
		{
			return find(locator).isDisplayed();
		}
		catch(NoSuchElementException exception)
		{
			return false;
		}
	}
	public void waitfor(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
}
