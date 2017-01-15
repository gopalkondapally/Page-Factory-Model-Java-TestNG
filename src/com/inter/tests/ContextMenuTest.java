package com.inter.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inter.pages.ContextMenuPage;

public class ContextMenuTest 
{
	/*This is yet to be tested because of problem in geckoDriver */
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","E:\\softwares\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void PageHeadingTest()
	{
		ContextMenuPage conMenuPage = new ContextMenuPage(driver);
		Assert.assertEquals(conMenuPage.getPageHeader(), "Context Menu");
	}
	
	@Test(dependsOnMethods="PageHeadingTest")
	public void optionSelectionTest()
	{
		ContextMenuPage conMenuPage = new ContextMenuPage(driver);
		conMenuPage.performAction();
		Assert.assertEquals(conMenuPage.getAlertText(), "You selected a context menu");
	}	
}