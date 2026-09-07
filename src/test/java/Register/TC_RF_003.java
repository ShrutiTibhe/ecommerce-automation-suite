package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_003 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@Test
	public void verifyRegisteringAccount() throws InterruptedException {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("shruti");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Tibhe");
		WebElement emailId = driver.findElement(By.xpath("//input[@id='input-email']"));

		String email = "shruti" + System.currentTimeMillis() + "@gmail.com";
		emailId.sendKeys(email);

		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8080808080");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Pass@1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Pass@1234");

		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(2000);
		String actualHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))
				.getText();
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(actualHeading, expectedHeading, "Your Account Has Not Been Created!");

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
