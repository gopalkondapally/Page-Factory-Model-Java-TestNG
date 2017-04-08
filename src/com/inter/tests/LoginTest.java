package com.inter.tests;

import org.testng.annotations.Test;

import org.testng.Assert;

import com.inter.pages.LoginPage;
import com.inter.pages.SecurePage;
import com.inter.resources.TestDataProvider;

public class LoginTest extends BaseTest
{
	
	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void validUserLoginTest(String username, String password)
	{
	  LoginPage login = new LoginPage(driver);
	  SecurePage secure = login.loginWithValidCredentials(username, password);
	  System.out.println("Login SuccessFul");
	  Assert.assertTrue(secure.getSuccessMessage().contains("secure area"),"Login Not Successful");
	}
	
	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void invalidUserNameTest(String username,String password)
	{
	  LoginPage login = new LoginPage(driver);
      login.loginWithInValidCredentials(username,password);
      Assert.assertTrue(login.getFailureMessage().contains("username"),"Invalid Username is provided");
	}
	  
	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void invalidPasswordTest(String username,String password)
	{
	  LoginPage login = new LoginPage(driver);
	  login.loginWithInValidCredentials(username ,password);
	  Assert.assertTrue(login.getFailureMessage().contains("password"),"Invalid Password is provided");
	}

	@Test(dataProvider="TestData", dataProviderClass=TestDataProvider.class)
	public void validUserLogoutTest(String username, String password)
	{
	  LoginPage login = new LoginPage(driver);
	  SecurePage secure = login.loginWithValidCredentials(username,password);
	  Assert.assertTrue(secure.isLogOutDisplayed());
	  LoginPage afterLogout= secure.logout();
	  System.out.println("Logout Successful");
	  Assert.assertTrue(afterLogout.getLoginPageHeader().equals("Login Page"),"Logout Not Successful");
	}
}