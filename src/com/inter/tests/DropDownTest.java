package com.inter.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inter.pages.DropDownPage;

public class DropDownTest
{
	public WebDriver driver;
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
	public void PageHeadingTest()
	{
		DropDownPage ddPage = new DropDownPage(driver);
		Assert.assertEquals(ddPage.getPageHeader(), "Dropdown List");
	}
	
	@Test(dependsOnMethods="PageHeadingTest")
	public void optionSelectionTest()
	{
		DropDownPage ddPage = new DropDownPage(driver);
		ddPage.selectOptionByValue(1);
		Assert.assertEquals(ddPage.getSelectedOption(), "Option 1");
	}
}