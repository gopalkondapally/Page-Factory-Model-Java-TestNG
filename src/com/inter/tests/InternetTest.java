package com.inter.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inter.pages.*;

public class InternetTest extends BaseTest
{
	@Test
	public void HomepageLoadTest()
	{
		HomePage homepage= new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(homepage.getURL().contains("the-internet"));
    }
}