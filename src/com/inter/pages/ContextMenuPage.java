package com.inter.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends BasePage
{
	@FindBy(how=How.ID, using="hot-spot" )
	public WebElement contextMenu;
	
	public ContextMenuPage(WebDriver driver)
	{
		super(driver);
		visit("context_menu");
		PageFactory.initElements(driver,this);
	}
	
	public String getPageHeader() 
	{
		return getHeading();
	}
	
	public Actions action()
	{
		return new Actions(driver);
	}

	public void performAction()
	{
		action().contextClick(contextMenu).sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER)
        .perform();
	}
	
	public String getAlertText()
	{
		try { 
		 WebDriverWait wait = new WebDriverWait(driver, 5);
         wait.until(ExpectedConditions.alertIsPresent());
		}
		catch (NoAlertPresentException noAlert) {
			noAlert.getMessage();
		}
		
		Alert alert=driver.switchTo().alert();
        
		String alertText=alert.getText();
        alert.accept();
        return alertText;
	}	
}