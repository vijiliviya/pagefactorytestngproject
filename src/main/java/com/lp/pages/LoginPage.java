package com.lp.pages;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lp.baseclass.BaseClass;
import com.lp.common.WrapperClass;
import com.lp.common.commonclass;
import com.opencsv.CSVReader;

import junit.framework.Assert;

public class LoginPage {
	WebDriver driver;
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
			//String downloadPath = fl.getPath();
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
					//File f2 = new File("C:\\Users\\vraja\\Downloads\\user.csv");
	
					File f2= new File(downloadPath+"\\"+dirContents[i].getName());
					System.out.println(f2);
					String downloadPathcsv = f2.getPath();
					Path path = Paths.get(downloadPathcsv); 
					System.out.println(path);
					// call getFileName() and get FileName path object 
					Path fileName = path.getFileName(); 
					System.out.println(fileName.toString());
					CSVReader reader = new CSVReader(new FileReader(downloadPathcsv));
					String [] nextLine;
					while ((nextLine = reader.readNext()) != null) {
						System.out.println("Value 1 : "+nextLine[0]);	 


						//dirContents[i].delete();
						System.out.println("It is deleted successfully");

						break;
					}
				}
			}} catch (Exception e) {
				e.getMessage();
			}
		return false;

	}

}


