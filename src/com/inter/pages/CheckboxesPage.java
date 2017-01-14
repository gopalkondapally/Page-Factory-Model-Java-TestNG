package com.inter.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inter.pages.BasePage;

public class CheckboxesPage extends BasePage
{
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using=".//*[@id='checkboxes']/input[1]")
	public WebElement checkbox1;
	
	@FindBy(how=How.XPATH, using=".//*[@id='checkboxes']/input[2]")
	public WebElement checkbox2;
	
	@FindBy(how=How.TAG_NAME, using ="h3")
	public WebElement heading;
	
	public CheckboxesPage(WebDriver driver)
	{
		super(driver);
		visit("checkboxes");
		PageFactory.initElements(driver,this);
	}
	public boolean getCheckbox1Status()
	{
		return checkbox1.isSelected();
	}
	public boolean getCheckbox2Status()
	{
		return checkbox2.isSelected();
	}
	public void selectcheckbox(int n)
	{
		if(n==1)
		{
			checkbox1.click();
		}
		if(n==2)
		{
			checkbox2.click();
		}
	}
	public void deselectcheckbox(int n)
	{
		if(n==1)
		{
			checkbox1.click();
		}
		if(n==2)
		{
			checkbox2.click();
		}
	}
	public String getHeadingOfPage() {
		return getHeading(heading);
	}
}
