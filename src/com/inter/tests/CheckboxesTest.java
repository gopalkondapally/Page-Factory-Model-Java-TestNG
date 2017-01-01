package com.inter.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inter.pages.CheckboxesPage;

public class CheckboxesTest 
{
	WebDriver driver;
	String exepath = "E:\\softwares\\chromedriver.exe";
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", exepath);
		driver = new ChromeDriver();
	}
	
	@Test(priority = 0)
	public void HeadingTest()
	{
		CheckboxesPage chboxPage = new CheckboxesPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String pageHeading= chboxPage.getHeadingOfPage();
		Assert.assertEquals(pageHeading, "Checkboxes");
	}
	
	@Test(priority = 1)
	public void Checkbox1Test()
	{
		CheckboxesPage chboxPage = new CheckboxesPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(!chboxPage.getCheckbox1Status())
		{
			chboxPage.selectcheckbox(1);
		}
		Assert.assertTrue(chboxPage.getCheckbox1Status(), "CheckBox 1 is not selected");
	}
	
	@Test(priority = 2)
	public void Checkbox2Test()
	{
		CheckboxesPage chboxPage = new CheckboxesPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(!chboxPage.getCheckbox2Status())
		{
			chboxPage.selectcheckbox(2);
		}
		Assert.assertTrue(chboxPage.getCheckbox2Status(), "CheckBox 1 is not selected");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
