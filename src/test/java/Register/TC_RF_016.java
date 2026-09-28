package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_016 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");

	}

	@Test
	public void MandatoryFieldsDoNotAcceptSpace() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		boolean createAccountText = driver
				.findElements(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).size() > 0;
		Assert.assertFalse(createAccountText);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
