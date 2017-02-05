package com.inter.resources;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider 
{
	@DataProvider(name="TestData")
	public  Object[][] provideData(Method method)
	{
		Object [][] result=null;
		
		if(method.getName().equals("validUserLoginTest") || method.getName().equals("validUserLogoutTest"))
		{
			result=new Object[][] {
				{"tomsmith","SuperSecretPassword!"}
			};
		}
		else if(method.getName().equals("invalidUserNameTest"))
		{
			result=new Object[][] {
				{"WrongUserName","SuperSecretPassword!"}
			};
		}
		else if(method.getName().equals("invalidPasswordTest"))
		{
			result=new Object[][] {
				{"tomsmith","WrongPassword"}
			};
		}
		return result;
	}

}
