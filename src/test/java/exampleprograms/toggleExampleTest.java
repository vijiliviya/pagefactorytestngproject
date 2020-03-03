package exampleprograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.lp.baseclass.BaseClass;
import com.lp.common.WrapperClass;
import com.lp.common.commonclass;

public class toggleExampleTest {

	public toggleExampleTest()
	{
		driver=BaseClass.returndriver();
		PageFactory.initElements(driver, this);
	}
	static WebDriver driver;
	@FindBy(xpath="//h3[text()='Stacked checkboxes']//following::label[1]/div")
	public static WebElement samplebutton;

	@Test
	public void verifyAttributePresent() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vraja\\workspace\\FinalTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.bootstraptoggle.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//WrapperClass.enabledordisable(driver, samplebutton, 60, commonclass.valueis);
		Thread.sleep(2000);
		String basicexample = "//h3[text()='Basic example']//following::div[1]//div[starts-with(@class,'toggle btn')]";
		String stackedboxes1 = "//h3[text()='Stacked checkboxes']//following::label[1]/div";
		String stackedboxed2 = "//h3[text()='Stacked checkboxes']//following::div[5]/label/div";
		//String Inlinebox=""
		WebElement toogle = driver.findElement(By.xpath(stackedboxes1));
		if(toogle.isSelected())
		{

			boolean status = toogle.isEnabled();
			System.out.println("toogle is enabled"+status);
			//toogle.click();
		}
		else
		{
			System.out.println("toogle is not enabled");
			toogle.click();
			System.out.println("Again it is enabled");
			Thread.sleep(4000);
		}


	}
}
