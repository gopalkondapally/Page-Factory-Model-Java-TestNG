package com.inter.tests;

import org.testng.annotations.Test;

import org.testng.Assert;

import com.inter.pages.LoginPage;
import com.inter.resources.TestDataProvider;

public class LoginTest extends BaseTest
{
	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void validUserLoginTest(String username, String password)
	{
	  LoginPage login = new LoginPage(driver);
	  login.loginWith(username, password);
	  System.out.println("Login SuccessFul");
	  Assert.assertTrue(login.getSuccessMessage().contains("secure area"),"Login Not Successful");
	}
	
	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void invalidUserNameTest(String username,String password)
	{
	  LoginPage login = new LoginPage(driver);
      login.loginWith(username,password);
      Assert.assertTrue(login.getFailureMessage().contains("username"),"Valid Username is provided");
	}
	  
	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void invalidPasswordTest(String username,String password)
	{
	  LoginPage login = new LoginPage(driver);
	  login.loginWith(username ,password);
	  Assert.assertTrue(login.getFailureMessage().contains("password"),"Valid Password is provided");
	}

	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void validUserLogoutTest(String username, String password)
	{
	  LoginPage login = new LoginPage(driver);
	  login.loginWith(username,password);
	  login.logout();
	  System.out.println("Logout Successful");
	  Assert.assertTrue(login.getLoginPageHeader().equals("Login Page"),"Logout Not Successful");
	}
}