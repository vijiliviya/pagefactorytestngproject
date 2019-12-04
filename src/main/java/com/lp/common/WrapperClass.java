package com.lp.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WrapperClass {
	static WebDriver driver;
	
	
	public static void txtbox(WebElement element, String value)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(value);
		}
	}
	
	
	public static void hitenter() throws AWTException
	{
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		
	}
	public static void clickbtn(WebElement element) throws InterruptedException
	{
		if(element.isEnabled())
		{
			Thread.sleep(10000);
			element.click();
			
		}
		
	}

	
}
