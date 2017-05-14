package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage
{	
	@FindBy(how=How.CSS, using=".success")
	public WebElement successMessage;
	
	@FindBy(how=How.CSS, using=".button.radius")
	public WebElement logoutButton;
	
	public SecurePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public String getSuccessMessage()
	{
		if(isSuccessMessageDisplayed()) {
			return getText(successMessage);
		}
		else {
			return null;
		}	
	}
	
	public boolean isSuccessMessageDisplayed()
	{
		return ifDisplayed(successMessage);
	}
 
	public boolean isLogOutDisplayed()
	{
		return ifDisplayed(logoutButton);
	}
	
	public LoginPage logout()
	{
		clickOn(logoutButton);
		return new LoginPage(driver);
	}
}