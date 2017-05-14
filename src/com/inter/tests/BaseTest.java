package com.inter.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.inter.resources.DriverManager;

public class BaseTest 
{
	public WebDriver driver;
	DriverManager driverManager = new DriverManager();

	@BeforeMethod
	public void setUp()
	{
		driver = driverManager.openBrowser("firefox");
	}
	
	@AfterMethod
	public void tearDown()
	{
	  driver.close();
	}
}
