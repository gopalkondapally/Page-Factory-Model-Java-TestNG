package com.inter.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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

	@Parameters({"username","password"})
	@Test
	public void validUserLoginTest(String username, String password)
	{
	   LoginPage login = new LoginPage(driver);
	   login.loginWith(username, password);
	   System.out.println("Login SuccessFul");
	   Assert.assertTrue(login.getSuccessMessage().contains("secure area"));  
	}
	
	@Parameters({"username","password"})
	@Test
	public void invalidUserNameTest(String username,String password)
	{
	   LoginPage login = new LoginPage(driver);
	   login.loginWith(username,password);
	   Assert.assertTrue(login.getFailureMessage().contains("username"));
	}
	  
	@Parameters({"username","password"})
	@Test
	public void invalidPasswordTest(String username,String password)
	{
	  LoginPage login = new LoginPage(driver);
          login.loginWith(username ,password);
	  Assert.assertTrue(login.getFailureMessage().contains("password"));	
	}

	@Parameters({"username","password"})
	@Test
	public void validUserLogoutTest(String username, String password)
	{
	  LoginPage login = new LoginPage(driver);
	  login.loginWith(username,password);
	  login.logout();
	  System.out.println("Logout Successful");
	  Assert.assertTrue(login.getLoginPageHeader().equals("Login Page"));
	}
}
