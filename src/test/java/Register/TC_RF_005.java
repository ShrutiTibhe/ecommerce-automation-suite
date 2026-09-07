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

public class TC_RF_005 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");
	}

	@Test
	public void subscribeToNewsletter() {
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Shruti");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Tibhe");
		WebElement EmailId = driver.findElement(By.xpath("//input[@id='input-email']"));
		String email = "shruti" + System.currentTimeMillis() + "@gmail.com";
		EmailId.sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8080222222");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Test");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		boolean AccountText = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))
				.isDisplayed();
		Assert.assertTrue(AccountText);
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		boolean subscribe = driver.findElement(By.xpath("//input[@value='1']")).isSelected();

		Assert.assertTrue(subscribe);

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
