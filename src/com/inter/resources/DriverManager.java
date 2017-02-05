package com.inter.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager 
{
	WebDriver driver=null;
	final static String GECKO_DRIVER_PATH ="E:\\softwares\\geckodriver-v0.11.1-win32\\geckodriver.exe";
	final static String CHROME_DRIVER_PATH="E:\\softwares\\chromedriver.exe";
	
	public WebDriver openBrowser(String browserName) 
    {
        try 
        {
            System.out.printf("Opening %s browser.\n", browserName);

            switch (browserName)
            {
                case "firefox":
                {
                    System.setProperty("webdriver.gecko.driver",GECKO_DRIVER_PATH);
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome":
                {
                    System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                }
            }       
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return driver;
    }
	
}
