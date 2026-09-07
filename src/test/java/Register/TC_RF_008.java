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
		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Ameya");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Belwalkar");
		WebElement EmailID = driver.findElement(By.xpath("//input[@id='input-email']"));
		String email = "ameyabelwalkar" + System.currentTimeMillis() + "@gmail.com";
		EmailID.sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("7977711075");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("898989");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("989898");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Assert Equal
		String actualMessage = driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
		String ExpectedMessage = "Password confirmation does not match password!";
		Assert.assertEquals(actualMessage, ExpectedMessage, "Password confirmation does not match password!");

		// Assert True
		boolean warningMeassage = driver.findElement(By.xpath("//div[@class='text-danger']")).isDisplayed();
		Assert.assertTrue(warningMeassage);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}