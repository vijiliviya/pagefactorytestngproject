package exampleprograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.FindBy;

public class comparingcsvwithUItable {
	@FindBy(xpath = "//img[@src='./resources/static/assets/images/login-with-google.png']")
	public static WebElement loginimage;
	@FindBy(xpath="//input[@id='identifierId']")
	static
	WebElement username;
	@FindBy(xpath="//span[text()='Next']")
	static
	WebElement nextbutton;
	@FindBy(xpath="//input[@name='password']")
	static
	WebElement password;
	@FindBy(xpath="//a[text()='User']")
	WebElement userlink;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\FinalTesting\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://qa.mylolliandpops.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@src='./resources/static/assets/images/login-with-google.png']")).click();
	//loginimage.click();
	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("vijayalakshmiraja88@gmail.com");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("jesviji@123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='User']")).click();
	Thread.sleep(3000);
	int noOfEntries = getNumberOfEntries();
	System.out.println(noOfEntries);
	String button= driver.findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']//div[@class='ui-grid-header custom-ui-grid-header ng-scope']//child::div//child::span")).getText();
	System.out.println(button);
	
	}
	
public static int getNumberOfEntries() {
		
		String entriesTxt = driver.findElement(By.xpath("//span[@ng-show='grid.options.totalItems > 0']")).getText().trim();
		String[] aEntriesText = entriesTxt.split(" ");
		String totalEntriesText = aEntriesText[aEntriesText.length-2];
		return Integer.parseInt(totalEntriesText);
	}

}
