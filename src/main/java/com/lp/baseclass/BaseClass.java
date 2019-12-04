package com.lp.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	static WebDriver driver;

	public void openbrowser()
	{
			
		//System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\FinalTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://qa.mylolliandpops.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//img[@src='./resources/static/assets/images/login-with-google.png']")).click();
					
	}
	
	public static WebDriver returndriver()
	{
		return driver;
		
	}
}
