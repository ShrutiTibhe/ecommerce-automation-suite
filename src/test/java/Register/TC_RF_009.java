package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_009 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://tutorialsninja.com/demo");

	}

	@Test
	public void invalidEmailInput() throws InterruptedException {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Shruti");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Tibhe");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("shruti.tibhe@aqmtechnologies.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8080227157");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Pass@12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Pass@12345");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		boolean warningMessage1 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.isDisplayed();
		Assert.assertTrue(warningMessage1);

		boolean accountCreatedText = driver
				.findElements(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).size() > 0;
		Assert.assertFalse(accountCreatedText);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
