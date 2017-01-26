package com.inter.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		driver.get(BASE_URL);
	}
	
	public void visit(String url)
	{
		driver.get(BASE_URL+url);
	}
	
	public void clickOn(WebElement ele)
	{
		ele.click();
	}

	public void enter(WebElement ele,String inputText)
	{
		clear(ele);
		ele.sendKeys(inputText);
	}
	
	public void clear(WebElement ele)
	{
		ele.clear();
	}
	
	public String getHeading()
	{
		Header header = new Header(driver);
		System.out.println(header.getHeadingOfPage().getText()+" is loaded");
		return header.getHeadingOfPage().getText();
	}
	
	public String getLoginPageHeading()
	{
		Header header = new Header(driver);
		return header.getHeadingOfLoginPage().getText();
	}
	
	public boolean isDisplayed(WebElement ele)
	{
		try
		{
			return ele.isDisplayed();
		}
		catch(NoSuchElementException exception)
		{
			return false;
		}
	}
	
	public String getText(WebElement ele)
	{
		String elementText="";
		if(ele.isDisplayed())
		{
		   elementText=ele.getText();
		}
		else
		{
			System.out.println("Element cannot be found");
		}
		return elementText;
	}
}