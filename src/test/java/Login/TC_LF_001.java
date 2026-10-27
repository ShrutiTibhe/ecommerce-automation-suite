package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_LF_001 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");
	}

	@Test
	public void loginApplicationWithValidCredentials() {

		driver.findElement(By.xpath("(//span[normalize-space()='My Account'])[1]")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();
		driver.findElement(By.xpath("(//input[@id='input-email'])[1]")).sendKeys("shruti.tibhe0207@gmail.com");
		driver.findElement(By.xpath("(//input[@id='input-password'])[1]")).sendKeys("Aqm@12345");
		driver.findElement(By.xpath("(//input[@value='Login'])[1]")).click();

		// when using assert equals for actual element always use getText() at last
		//since assert.equals uses String based values
		String actualAccountHeading = driver.findElement(By.xpath("(//h2[normalize-space()='My Account'])[1]"))
				.getText();
		Assert.assertEquals(actualAccountHeading, "My Account", "My Account Is Not Displayed");

		// Why using Assert.true for the webelement we have to use isDisplyed,
		// isSelected, isEnabled since assertTrue only take boolean values
		boolean logoutLinkVisible = driver
				.findElement(By.xpath("(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")).isDisplayed();
		Assert.assertTrue(logoutLinkVisible, "Logout Visible Link Is Not Displayed");

	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}

}
