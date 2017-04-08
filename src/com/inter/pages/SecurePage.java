package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage
{
	
	@FindBy(how=How.CSS, using=".success")
	public WebElement successMessageLocator;
	
	@FindBy(how=How.CSS, using=".button.radius")
	public WebElement logoutButton;
	
	public SecurePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	public boolean successMessagePresent()
	{
		return isDisplayed(successMessageLocator);
	}
	
	public String getSuccessMessage()
	{
		return getText(successMessageLocator);
	}
 
	public boolean isLogOutDisplayed()
	{
		return isDisplayed(logoutButton);
	}
	public LoginPage logout()
	{
		clickOn(logoutButton);
		return new LoginPage(driver);
	}
}
