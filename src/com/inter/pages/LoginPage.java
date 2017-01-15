package com.inter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage
{
	WebDriver driver;
	By loginformLocator = By.id("login");
	By usernameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By loginButton = By.className("radius");
	By successMessageLocator = By.cssSelector("#flash");
	By failureMessageLocator = By.cssSelector(".flash error");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		visit("login");
		//assertTrue(isDisplayed(loginformLocator), "Login form is not displayed");
	}
	public void with(String username,String password)
	{
		enter(usernameLocator, username);
		enter(passwordLocator,password);
		clickOn(loginButton);
	}
	public boolean successMessagePresent()
	{
		return isDisplayed(successMessageLocator);
	}
	
	public boolean failureMessagePresent()
	{
		return isDisplayed(failureMessageLocator);
	}
}
