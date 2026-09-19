package Register;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_010 {

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
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Ameya");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Belvalkar");
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='input-email']"));
		emailTextbox.sendKeys("shruti");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8080227157");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Pass@12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Pass@12345");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		@Nullable
		String warningMessage1 = driver.findElement(By.xpath("//input[@id='input-email']"))
				.getAttribute("validationMessage");
		Assert.assertTrue(warningMessage1.contains("Please include"));

		emailTextbox = driver.findElement(By.xpath("//input[@id='input-email']"));
		emailTextbox.clear();
		emailTextbox.sendKeys("shruti@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		@Nullable
		String warningMessage2 = driver.findElement(By.xpath("//input[@id='input-email']"))
				.getAttribute("validationMessage");
		Assert.assertTrue(warningMessage2.contains("Please enter a part"));

		emailTextbox = driver.findElement(By.xpath("//input[@id='input-email']"));
		emailTextbox.clear();
		emailTextbox.sendKeys("shruti@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(3000);
		@Nullable
		boolean warningMessage3 = driver.findElement(By.xpath("//div[@class='text-danger']")).isDisplayed();
		Assert.assertTrue(warningMessage3);

		emailTextbox = driver.findElement(By.xpath("//input[@id='input-email']"));
		emailTextbox.clear();
		emailTextbox.sendKeys("s.tibhe@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		@Nullable
		String warningMessage4 = driver.findElement(By.xpath("//input[@id='input-email']"))
				.getAttribute("validationMessage");
		Assert.assertTrue(warningMessage4.contains("'.' is used"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
