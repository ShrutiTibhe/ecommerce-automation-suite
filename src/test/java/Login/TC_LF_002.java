package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_LF_002 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");
	}

	@Test
	public void loginApplicationWithInvalidCredentials() {

		driver.findElement(By.xpath("(//span[normalize-space()='My Account'])[1]")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();
		driver.findElement(By.xpath("(//input[@id='input-email'])[1]")).sendKeys("shruti.tibhe@gmail.com");
		driver.findElement(By.xpath("(//input[@id='input-password'])[1]")).sendKeys("Aqm@12345");
		driver.findElement(By.xpath("(//input[@value='Login'])[1]")).click();

		// when using assert equals for actual element always use getText() at last
		// since assert.equals uses String based values
		boolean actualAccountHeading = driver.findElements(By.xpath("(//h2[normalize-space()='My Account'])[1]"))
				.size() > 0;

		Assert.assertFalse(actualAccountHeading, "My Account Is Displayed");

		String warningMessage = driver
				.findElement(By.xpath("(//div[@class='alert alert-danger alert-dismissible'])[1]")).getText();
		Assert.assertNotEquals(warningMessage, "My Account", "My Account is Displayed");

	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}

}
