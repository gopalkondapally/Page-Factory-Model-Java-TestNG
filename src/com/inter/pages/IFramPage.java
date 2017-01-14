package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IFramPage extends BasePage
{
	@FindBy(how = How.ID,using ="mce_0_ifr")
	public WebElement iFrame;
	
	@FindBy(how =How.ID, using = "tinymce")
	public WebElement textfield;
	
	@FindBy(how =How.TAG_NAME, using ="h3")
	public WebElement heading;
	
	public IFramPage(WebDriver driver)
	{
		super(driver);
		visit("iframe");
		PageFactory.initElements(driver,this);
	}
	
	public String getHeadingOfPage()
	{
		return getHeading(heading);
	}
	
	//Switching to a frame
	public void switchToFrame()
	{
		driver.switchTo().frame(iFrame);
	}
	
	//Switching to default Content of the page
	public void switchToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	public void enterText(String text)
	{
		enter(textfield, text);
	}
	public String getTextInField()
	{
		System.out.println(textfield.getText().toString());
		return textfield.getText().toString();
	}
}
