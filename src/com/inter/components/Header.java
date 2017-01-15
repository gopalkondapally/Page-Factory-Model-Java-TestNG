package com.inter.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Header
{
	public WebDriver driver;
	
	@FindBy(how=How.TAG_NAME,using="h3")
	public WebElement header;

	public Header(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public WebElement getHeadingOfPage()
	{
		return header;
	}
}
