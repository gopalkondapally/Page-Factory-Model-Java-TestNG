package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage 
{
	@FindBy(how = How.ID, using ="dropdown")
	public WebElement dropdownList;
	
	public DropDownPage(WebDriver driver)
	{
		super(driver);
		visit("dropdown");
		PageFactory.initElements(driver,this);
	}
	
	public String getPageHeader() 
	{
		return getHeading();
	}
	
	/* Creating a method which returns an Select object
	 * The returned Select object is used in setter and getter methods respectively*/
	public Select getSelectOptions()
	{
		return new Select(dropdownList);
	}
	
	public String getPagerHeader() 
	{
		return getHeading();
	}
	
	public void selectOptionByValue(int value)
	{
		getSelectOptions().selectByIndex(value);
	}
	
	public String getSelectedOption()
	{
		return getSelectOptions().getFirstSelectedOption().getText();
	}
}