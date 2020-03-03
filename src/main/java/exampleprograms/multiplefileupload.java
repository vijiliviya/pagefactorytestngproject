package exampleprograms;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class multiplefileupload {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "..\\FinalTesting\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		WebDriver driver =new ChromeDriver();
		driver.get("http://192.168.1.37:8080/lolliandpopweb/");
		Thread.sleep(3000);
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
		
		File file = new File("D:\\Lolliandpopspo\\TestData");
		File[] files = file.listFiles();
		for(File f: files)
		{
		String filename = f.getName();
		System.out.println(filename);
		//driver.findElement(
				//By.xpath("//input[@id='uploadFile']")).click();;
		//driver.findElement(By.xpath("//input[@id='use_var_TNresume']")).click();
		Actions actions = new Actions(driver);
		WebElement browse = driver.findElement(
				By.xpath("//input[@id='uploadFile']"));
		actions.moveToElement(browse).perform();
		browse.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\vraja\\Documents\\fileupload.exe"+" " +"D:\\Lolliandpopspo\\Test Data\\" +filename);
		Thread.sleep(3000);
		}
		//driver.close();
		}

}
