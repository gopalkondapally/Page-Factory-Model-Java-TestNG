package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
		visit();
		PageFactory.initElements(driver,this);
	}
		
	public String getPageHeader() 
	{
		return getHeading();
	}
}