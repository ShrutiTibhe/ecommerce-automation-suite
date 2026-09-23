package Register;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_013 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");

	}

	@Test
	public void registerAccountProperPlaceholders() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();

		@Nullable
		String firstName = driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("placeholder");
		System.out.println(firstName);
		@Nullable
		String lastName = driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("placeholder");
		String EmailId = driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("placeholder");

		@Nullable
		String telephone = driver.findElement(By.xpath("//input[@id='input-telephone']")).getAttribute("placeholder");
		@Nullable
		String password = driver.findElement(By.xpath("//input[@id='input-password']")).getAttribute("placeholder");
		@Nullable
		String confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"))
				.getAttribute("placeholder");

		driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertEquals(firstName, "First Name", "First name placeholder is not displayed");
		Assert.assertEquals(lastName, "Last Name", "last name placeholder is not displayed");
		Assert.assertEquals(EmailId, "E-Mail", "Email Id placeholderis not displayed");
		Assert.assertEquals(telephone, "Telephone", "Telephone placeholder is not displayed");
		Assert.assertEquals(password, "Password", "Password placeholder is not displayed");
		Assert.assertEquals(confirmPassword, "Password Confirm", "Confirm Password Placeholder is not displayed");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
