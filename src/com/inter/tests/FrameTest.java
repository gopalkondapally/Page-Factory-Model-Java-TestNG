package com.inter.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inter.pages.IFramPage;

public class FrameTest extends BaseTest
{
	@Test(priority = 0)
	public void HeadingTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String heading= iframePage.getPageHeader();
		//System.out.println(heading);
		Assert.assertEquals(heading, "An iFrame containing the TinyMCE WYSIWYG Editor");
	}
	
	@Test(dependsOnMethods={"HeadingTest"})
	public void TextInFieldTest()
	{
		IFramPage iframePage = new IFramPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iframePage.switchToFrame();
		iframePage.enterText("Hello World");
		String textInField = iframePage.getTextInField();
		Assert.assertEquals(textInField, "Hello World");
	}
	
	@Test(dependsOnMethods={"TextInFieldTest"})
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