package com.inter.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.inter.pages.*;

public class InternetTest 
{
	 WebDriver driver;
	 String exepath = "E:\\softwares\\chromedriver.exe";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", exepath);
		driver = new ChromeDriver();
	}
	@Test
	public void HomepageLoadTest()
	{
		HomePage homepage= new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String heading= homepage.getHeadingOfPage();
		//System.out.println(heading);
		Assert.assertEquals(heading, "Welcome to the Internet");
}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
