package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_004 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");

	}

	@Test
	public void verifyNotificationMessages() {
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualFirstNameMsg = driver
				.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		String actualLastNameMsg = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div"))
				.getText();
		String actualEmailId = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"))
				.getText();
		String actualTelephone = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div"))
				.getText();
		String actualPassword = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div"))
				.getText();
		String actualPolicyMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();

		String expectedFirstName = "First Name must be between 1 and 32 characters!";
		String expectedLastName = "Last Name must be between 1 and 32 characters!";
		String expectedEmailId = "E-Mail Address does not appear to be valid!";
		String expectedTelephone = "Telephone must be between 3 and 32 characters!";
		String expectedPassword = "Password must be between 4 and 20 characters!";
		String expectedPolicyMsg = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(actualFirstNameMsg, expectedFirstName, "First Name is Incorrect");
		Assert.assertEquals(actualLastNameMsg, expectedLastName, "Last Name is Incorrect");
		Assert.assertEquals(actualEmailId, expectedEmailId, "EmailId Name is Incorrect");
		Assert.assertEquals(actualTelephone, expectedTelephone, "Telephone is Incorrect");
		Assert.assertEquals(actualPassword, expectedPassword, "Password is Incorrect");
		Assert.assertEquals(actualPolicyMsg, expectedPolicyMsg, "Policy Message is Incorrect");

	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}

}
