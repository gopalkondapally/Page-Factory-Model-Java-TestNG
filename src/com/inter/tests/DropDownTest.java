package com.inter.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inter.pages.DropDownPage;

public class DropDownTest extends BaseTest
{
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