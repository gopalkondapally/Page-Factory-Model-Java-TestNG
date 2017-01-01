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
	
	@Test(priority = 0)
	public void HeadingTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String heading= iframePage.getHeadingOfPage();
		//System.out.println(heading);
		Assert.assertEquals(heading, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}
	
	@Test(priority = 1)
	public void TextInFieldTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iframePage.switchToFrame();
		iframePage.enterText("The dude abides");
		String textInField = iframePage.getTextInField();
		Assert.assertEquals(textInField, "The dude abides");
	}
	
	@Test(priority = 2)
	public void DefaultContentTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iframePage.switchToFrame();
		iframePage.enterText("The dude abides");
		iframePage.switchToDefaultContent();
		String heading= iframePage.getHeadingOfPage();
		Assert.assertEquals(heading, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
