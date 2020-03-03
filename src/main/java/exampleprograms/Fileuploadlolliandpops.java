package exampleprograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fileuploadlolliandpops {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		Fileuploadtesting fileobj=new Fileuploadtesting();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\FinalTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		StringSelection sel = new StringSelection
				("D:\\po_input (2).zip");


		//Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		System.out.println("selection" +sel);
		
		//To maximize browser
		driver.manage().window().maximize();

		System.out.println("Chrome browser started...");

		WebDriverWait wait=new WebDriverWait(driver, 20);

		driver.get("http://192.168.1.37:8080/lolliandpopweb/logout");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		WebElement user = driver.findElement(By.id("email"));
		user.sendKeys("pouser@lolliandpops.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("Test@123");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		WebElement browse = driver.findElement(
				By.xpath("//div[contains(@class,'fileinput')]//input[@id='uploadFile']"));
		actions.moveToElement(browse).perform();
		browse.click();

		Robot robot = new Robot();
		robot.delay(5000);
		// Press Enter

		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.delay(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(10000);
		System.out.println("File copied on server");
		wait.until(ExpectedConditions.elementToBeClickable
				(By.xpath("//form[@id='adjustRewardsForm']//input[contains(@class,'btn-success')]")));
		WebElement upload = driver.findElement
				(By.xpath("//form[@id='adjustRewardsForm']//input[contains(@class,'btn-success')]"));
		upload.click();
		System.out.println("File uploaded on server");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(@class,'glyphicon')])[2]")).click();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		for(int i=0; i<=7200;i++)

		{
			Thread.sleep(25000);

			driver.findElement(By.xpath("(//span[contains(@class,'glyphicon')])[2]")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			String exactName = driver.findElement(By.xpath
					("(//div[contains(@class,'pagination')])[2]//tbody/tr[2]/td[5]/a")).getText();
			if(exactName.equals("download"))
			{
				
				System.out.println("Name is: " +exactName);
				driver.close();
				break;

			}
			

		
		}
	}
}
