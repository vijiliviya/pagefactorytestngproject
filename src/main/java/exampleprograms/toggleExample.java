//package exampleprograms;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//
//public class toggleExample {
//	static WebDriver driver;
//	static String valueis = "btn btn-default active toggle-off";
//	String actualvalue; 
//	@FindBy(xpath="//*[@id='usage']/div[2]/div[1]/label/div/div/label[2]")
//	WebElement samplebutton;
//	public static void main(String[] args) throws InterruptedException {
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\FinalTesting\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://www.bootstraptoggle.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Thread.sleep(5000);
//		//WebElement sample=driver.findElement(By.xpath("//*[@id='usage']/div[2]/div[1]/label/div/div/label[2]"));
//		//String d = driver.findElement(By.xpath("//*[@id='usage']/div[2]/div[1]/label/div/div/label[2]")).getAttribute("outerHTML");
//		//boolean dvalue=sample.isEnabled();
//
//		if (d.contains(valueis))
//		{
//		       sample.click();
//	}
//		
//
//	}
//	
//	
//	public void verifyAttributePresent(String locator, String testData)
//	{
//		
//	}
//	}
//
