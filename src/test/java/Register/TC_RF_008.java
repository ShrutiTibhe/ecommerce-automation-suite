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

public class TC_RF_008 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@Test
	public void confirmedPasswordValidation() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Ameya");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Belvalkar");
		WebElement emailIdTextbox = driver.findElement(By.xpath("//input[@id='input-email']"));
		String email = "ameyabelvalkar" + System.currentTimeMillis() + "@gmail.com";
		emailIdTextbox.sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8080227157");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Pass@12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Pass@12345");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		boolean warningMessage = driver.findElement(By.xpath("//div[@class='text-danger']")).isDisplayed();
		Assert.assertTrue(warningMessage);

		boolean accountCreatedText = driver
				.findElements(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).size() > 0;
		Assert.assertFalse(accountCreatedText);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}