package com.lp.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lp.baseclass.BaseClass;
import com.lp.common.WrapperClass;
import com.lp.common.commonclass;
import com.opencsv.CSVReader;

import junit.framework.Assert;

public class LoginPage {
	static WebDriver driver;
	public LoginPage()
	{
		driver=BaseClass.returndriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@src='./resources/static/assets/images/login-with-google.png']")
	public static WebElement loginimage;
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement username;
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextbutton;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//a[text()='User']")
	WebElement userlink;
	@FindBy(xpath="//a[@ng-click='Export()']//img")
	WebElement exportlink;
	@FindBy(xpath="//button[text()='Yes']")
	WebElement yesbutton;
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginbutton;
	@FindBy(xpath="//input[@name='email']")
	WebElement emailaddresstxtbox;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordtxtbox;

	public void logindetails() throws InterruptedException
	{
		Thread.sleep(5000);
		WrapperClass.clickbtn(loginimage);
		WrapperClass.txtbox(username,commonclass.usenamevalue);
		WrapperClass.clickbtn(nextbutton);
		Thread.sleep(2000);
		WrapperClass.txtbox(password,commonclass.passwordvalue);
		Thread.sleep(2000);
		WrapperClass.clickbtn(nextbutton);
		Thread.sleep(10000);

	}

	public void verifyTitle()
	{
		String ActualTitle= driver.getTitle();
		System.out.println("Title of the Page is "+ActualTitle);
		Assert.assertEquals("LolliandPops", ActualTitle);
	}


	public void userdetails() throws InterruptedException
	{
		
		WrapperClass.clickbtn(userlink);
		WrapperClass.clickbtn(exportlink);
		WrapperClass.clickbtn(yesbutton);
		Thread.sleep(15000);

	}

	public boolean isFileDownloaded()
	{

		String filename = "user";
		try {
			//File fl = new File("C:\\Users\\vraja\\Downloads");
			File fl= new File(System.getProperty("user.home"));
			System.out.println("file path: "+fl);
			String downloadPath = fl + "\\Downloads";
			System.out.println(downloadPath);
			File dir = new File(downloadPath);
			System.out.println(dir);
			File[] dirContents = dir.listFiles();
			System.out.println(dirContents.length);
			Thread.sleep(5000);
			for (int i = 0; i < dirContents.length; i++) {
				Thread.sleep(5000);
				System.out.println(dirContents[i].getName());
				if (dirContents[i].getName().contains(filename)) {
					// File has been found, it can now be deleted:
					System.out.println("It is downloaded successfully");
					File f2= new File(downloadPath+"\\"+dirContents[i].getName());
					String downloadPathcsv = f2.getPath();
					Path path = Paths.get(downloadPathcsv); 
					// call getFileName() and get FileName path object 
					Path fileName = path.getFileName(); 
					CSVReader reader = null;
					try
					{
						reader = new CSVReader(new FileReader(downloadPathcsv));
						String [] nextLine;
						int iteration = 0;
						while ((nextLine = reader.readNext()) != null) {
							// To avoid the header to read in csv file
							if(iteration == 0)
							{
								iteration++;  
								continue;
							}
							System.out.println("Value 1 : "+nextLine[0]);
							Thread.sleep(2000);
							//driver.close();
							Thread.sleep(2000);
							System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\FinalTesting\\Drivers\\chromedriver.exe");
							driver = new ChromeDriver();
							driver.get("https://freecrm.co.in/");
							driver.manage().window().maximize();
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							Thread.sleep(3000);
							switchToWindow(1);
							 System.out.println(driver.getTitle());
														
							driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
							 //loginbutton.click();
							
							Thread.sleep(6000);
							//emailaddresstxtbox.click();
							//WrapperClass.txtbox(emailaddresstxtbox, nextLine[0]);
							//WrapperClass.clickbtn(emailaddresstxtbox);
							//WrapperClass.txtbox(emailaddresstxtbox, nextLine[0]);
							driver.findElement(By.xpath("//input[@name='email']")).click();
							driver.findElement(By.xpath("//input[@name='email']")).sendKeys(nextLine[0]);
							System.out.println(nextLine[0]);
							//driver.close();
							//dirContents[i].delete();
							//System.out.println("It is deleted successfully");
//							driver.switchTo().defaultContent();
//							System.out.println(driver.getTitle());
//							break;
						}
						
					}
					
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			} catch (Exception e) {

				e.getMessage();
			}
		return false;

	}
	public static void switchToWindow(int index)
	{
		String WindowId=null;
		Set<String> setobj=driver.getWindowHandles();
		Iterator<String> it=setobj.iterator();
		for(int i=1;i<=index;i++)
		{
			WindowId=it.next();
		}
		driver.switchTo().window(WindowId);
	}

}


