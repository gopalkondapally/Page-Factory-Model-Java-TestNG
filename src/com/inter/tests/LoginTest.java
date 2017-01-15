package com.inter.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inter.pages.LoginPage;

public class LoginTest 
{
	WebDriver driver;
	String exepath = "E:\\softwares\\chromedriver.exe";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", exepath);
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void loginTest()
	{
		LoginPage login = new LoginPage(driver);
		login.with("tomsmith", "SuperSecretPassword!");
		Assert.assertTrue(login.successMessagePresent(), "Success message is not displayed");
	}
}
