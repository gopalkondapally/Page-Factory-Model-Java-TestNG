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
	String BASE_URL="https://the-internet.herokuapp.com/";
	
	//Constructor which initializes the driver
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void visit()
	{
		driver.get(BASE_URL);
	}
	
	//Navigates to the web site given of the URL
	public void visit(String url)
	{
		driver.get(BASE_URL+url);
	}
	
	// Finds the elements
	public WebElement find(By locator)
	{
		waitfor(locator);
		return driver.findElement(locator);
	}
	
	// Returns title of the 
	public String title()
	{
		return driver.getTitle();
	}
	
	//Clicks on an element
	public void clickOn(By locator)
	{
		find(locator).click();
    }
	
	//Clicks on an element
	public void clickOn(WebElement ele)
	{
		ele.click();
	}
	
	// This method is used to enter text when locators are passed
	public void enter(By locator,String inputText)
	{
		find(locator).sendKeys(inputText);
	}
	
	/*This method is used to enter text when web elements are passed*/
	public void enter(WebElement ele,String inputText)
	{
		clear(ele);
		ele.sendKeys(inputText);
	}
	
	//Clears the text of an element
	public void clear(WebElement ele)
	{
		ele.clear();
	}
	
	// Returns heading of the page
	public String getHeading(WebElement ele)
	{
		System.out.println(ele.getText().toString());
		return ele.getText().toString();
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
	
	//This method is used to wait for the for the element, default wait time is 10 seconds
	public void waitfor(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	// Returns an Web Element text
	public String getText(WebElement ele)
	{
		return ele.getText();
	}
}
