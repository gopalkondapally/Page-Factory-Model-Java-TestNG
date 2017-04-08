package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{
	@FindBy(how=How.ID, using="login")
	public WebElement loginformLocator;
	
	@FindBy(how=How.ID, using="username")
	public WebElement usernameLocator;
	
	@FindBy(how=How.ID, using="password")
	public WebElement passwordLocator;
	
	@FindBy(how=How.CLASS_NAME, using="radius")
	public WebElement loginButton;
	
	@FindBy(how=How.CSS, using=".error")
	public WebElement failureMessageLocator;
		
	public LoginPage(WebDriver driver)
	{
		super(driver);
		visit("login");
		PageFactory.initElements(driver,this);
	}
	
	public SecurePage loginWithValidCredentials(String username, String password)
	{
		loginWith(username,password);
		return new SecurePage(driver);
	}
	
	public LoginPage loginWithInValidCredentials(String username, String password)
	{
		loginWith(username,password);
		return this;
	}
	
	public void loginWith(String username,String password)
	{
		enter(usernameLocator, username);
		enter(passwordLocator,password);
		clickOn(loginButton);
	}
	
	public String getLoginPageHeader() 
	{
		return getLoginPageHeading();
	}
	
	public boolean failureMessagePresent()
	{
		return isDisplayed(failureMessageLocator);
	}
	
	public String getFailureMessage()
	{
		return getText(failureMessageLocator);
	}
}