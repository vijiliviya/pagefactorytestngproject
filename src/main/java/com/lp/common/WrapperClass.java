package com.lp.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WrapperClass {
	static WebDriver driver;
	
	
	public static void txtbox(WebElement element, String value)
	{
		element=isElementLoaded(element);
		if(element.isDisplayed())
		{
			element.clear();
			
			System.out.println("working");
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
		element=isElementLoaded(element);
		if(element.isEnabled())
		{
			//Thread.sleep(10000);
			element.click();
			}
		
	}
	
	public static WebElement isElementLoaded(WebElement elementToBeLoaded) {
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
	    return element;
	}


	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		//if(locator.isEnabled())
		
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", locator);
        //locator.click();
		
		
	}
	public static void texton(WebDriver driver, WebElement locator, int timeout,String value) {
		//if(locator.isDisplayed())
		
			System.out.println("done");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(locator));
			locator.clear();
			locator.sendKeys(value);
		}
		
		
			
		
		
		
	
}
