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

public class TC_RF_022 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verifyPasswordVisibilit() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
		@Nullable
		String password = driver.findElement(By.xpath("(//input[@id='input-password'])[1]")).getAttribute("type");
		@Nullable
		String confirmPassword = driver.findElement(By.xpath("(//input[@id='input-confirm'])[1]")).getAttribute("type");

		Assert.assertEquals(password, "password", "Password type is visible");
		Assert.assertEquals(confirmPassword, "password", "Confirm Password type is visible");

	}

	@AfterMethod
	public void teardown() {

		driver.quit();

	}

}
