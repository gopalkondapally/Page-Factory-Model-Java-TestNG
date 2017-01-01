package com.inter.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inter.pages.LoginPage;

public class LoginTest 
{
	WebDriver driver;
	public LoginPage login;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","E:\\softwares\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		/* One thing remember is that instance of the class 
		 * LoginPage is created in the setUp() method rather than in
		 * the Test method 
		*/
		login = new LoginPage(driver);
	}
	
	@Test
	public void loginTest()
	{
		login.with("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(login.successMessagePresent(), "Success message is not displayed");
	}
	
	/*
	@Test 
	public void loginFailTest()
	{
		login.with("username", "password");
		Assert.assertTrue(login.failureMessagePresent(), "Failure message is not displayed");
	}
    */
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
