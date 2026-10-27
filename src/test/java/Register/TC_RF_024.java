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

public class TC_RF_024 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void checkConfirmPasswordFunctionality() {
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();

		driver.findElement(By.xpath("(//input[@id='input-firstname'])[1]")).sendKeys("Spruha");
		driver.findElement(By.xpath("(//input[@id='input-lastname'])[1]")).sendKeys("Vilankar");
		WebElement emailTextbox = driver.findElement(By.xpath("(//input[@id='input-email'])[1]"));
		String email = "spruhavilankar" + System.currentTimeMillis() + "@gmil.com";
		emailTextbox.sendKeys(email);
		driver.findElement(By.xpath("(//input[@id='input-telephone'])[1]")).sendKeys("8080808890");
		driver.findElement(By.xpath("(//input[@id='input-password'])[1]")).sendKeys("Spruha@123");
		driver.findElement(By.xpath("(//input[@value='0'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='agree'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();

		boolean confirmPasswordWarningMessage = driver.findElement(By.xpath("(//div[@class='text-danger'])[1]"))
				.isDisplayed();
		Assert.assertTrue(confirmPasswordWarningMessage, "Warning Message Is Not Displayed");

		boolean accountCreateMessage = driver
				.findElements(By.xpath("(//h1[normalize-space()='Your Account Has Been Created!'])[1]")).size() > 0;

		Assert.assertFalse(accountCreateMessage, "Account is getting Created");

	}

	@AfterMethod
	public void teardown() {

		driver.quit();

	}

}
