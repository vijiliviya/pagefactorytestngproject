package exampleprograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;

public class Fileuploadtesting {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		Fileuploadtesting fileobj=new Fileuploadtesting();
		System.setProperty("webdriver.chrome.driver", "..\\FinalTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		StringSelection sel = new StringSelection("D:\\Lolliandpopspo\\po_input -603.zip");
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		System.out.println("selection" +sel);
		driver.get("http://192.168.1.37:8080/lolliandpopweb/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		WebElement user=driver.findElement(By.xpath("//input[@id='email']"));
		user.sendKeys("pouser@lolliandpops.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Test@123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
		WebElement loginbutton=driver.findElement(By.xpath("//button[@id='login']"));
		loginbutton.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement browse = driver.findElement(
				By.xpath("//input[@id='uploadFile']"));
		actions.moveToElement(browse).perform();
		browse.click();


		//WebElement browserbutton= driver.findElement(By.xpath("//input[@id='uploadFile']"));
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//Thread.sleep(5000);
		//js.executeScript("arguments[0].click();", browserbutton);
		//browserbutton.sendKeys("D:\\po_input (2).zip");
		//browserbutton.click();
		Thread.sleep(5000);
		//System.out.println("done");
		fileobj.robotcalls();
		System.out.println("File copied on server");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='upload']")));
		WebElement upload=driver.findElement((By.xpath("//input[@id='upload']")));
		upload.click();
		System.out.println("File uploaded on server");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='btn btn-default btn-sm']")).click();
		Thread.sleep(1000);
		System.out.println("referesh");
		driver.navigate().refresh();
		//System.out.println("completed");

		for(int i=0; i<=7200;i++)

		{
			Thread.sleep(25000);

			driver.findElement(By.xpath("//a[@class='btn btn-default btn-sm']")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			WebElement downloadfile=driver.findElement(By.xpath
					("//div[contains(@class,'pagination')]//tbody/tr[2]//td[5]//a"));
			String exactName = downloadfile.getText();
			if(exactName.equals("download"))
			{

				System.out.println("Name is: " +exactName);
				//driver.close();
				downloadfile.click();
				Thread.sleep(20000);
				break;
			}}


		//driver.findElement(By.xpath("//tbody//tr[2]//td[5]//a[text()='download']")).click();


		String filename = "po_output";
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

							//System.out.println("Value of PO Number is  : "+nextLine[0]);
							//System.out.println("Status : "+nextLine[2]);
							//System.out.println("Message: "+nextLine[3]);
							Thread.sleep(2000);
							if(nextLine[2].contains("Failed"))
							{
								System.out.println("PO Number : "+nextLine[0]);
								System.out.println("Status : "+nextLine[2]);
								System.out.println("Message: "+nextLine[3]);
								System.out.println("---------------------------------------------------------------------------------------------------");
							}

							//dirContents[i].delete();

						}
						System.out.println("Remaining all are pass");
						//dirContents[i].delete();
						break;
					}


					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {

			e.getMessage();
		}

		//return false;
	}		

	//sel=new StringSelection("C:\\Users\\vraja\\Downloads\\po_input (2).zip");
	//System.out.println("hi");
	//browserbutton.click();
	//JavascriptExecutor executor = (JavascriptExecutor) driver;
	//WebElement browserbutton1= driver.findElement(By.xpath("//input[@id='uploadFile']"));
	//WebDriverWait wait = new WebDriverWait(driver,30);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='uploadFile']"))).click();




	//executor.executeScript("arguments[0].click();", browserbutton1);
	//Thread.sleep(5000);
	//System.out.println("browserclick");
	//fileobj.robotcalls();
	//driver.findElement((By.xpath("//input[@id='upload']"))).click();
	//Thread.sleep(5000);
	//String valuetxt= browserbutton.getAttribute("value");
	//System.out.println(valuetxt);
	//driver.findElement(By.xpath("//input[@id='upload']")).click();


	public void robotcalls() throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		Thread.sleep(1000);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		//Press Enter 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(20000);

	}

}
