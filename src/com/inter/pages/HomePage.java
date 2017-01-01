package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BasePage
{
	WebDriver driver;
	
		@FindBy(how=How.TAG_NAME, using="h1")
		public WebElement heading;
		
		public HomePage(WebDriver driver)
		{
			super(driver);
			visit("https://the-internet.herokuapp.com/");
			PageFactory.initElements(driver,this);
		}
		public String getHeadingOfPage()
		{
			return getHeading(heading);
		}
}