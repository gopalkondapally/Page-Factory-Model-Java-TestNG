package com.inter.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.inter.pages.IFramPage;

public class FrameTest 
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

	@Test(priority = 0)
	public void HeadingTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String heading= iframePage.getPageHeader();
		//System.out.println(heading);
		Assert.assertEquals(heading, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}
	
	@Test(dependsOnMethods="HeadingTest")
	public void TextInFieldTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iframePage.switchToFrame();
		iframePage.enterText("Hello World");
		String textInField = iframePage.getTextInField();
		Assert.assertEquals(textInField, "Hello World");
	}
	
	@Test(dependsOnMethods="TextInFieldTest")
	public void DefaultContentTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iframePage.switchToFrame();
		iframePage.enterText("The dude abides");
		iframePage.switchToDefaultContent();
		String heading= iframePage.getPageHeader();
		Assert.assertEquals(heading, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}	
}