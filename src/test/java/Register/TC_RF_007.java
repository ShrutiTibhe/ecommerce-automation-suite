
package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_007 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().to("http://tutorialsninja.com/demo");

	}

	@Test
	public void verifyRegisterAccountPage() {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']"))).click();
		String actualMessage = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
		String expectedMeassage = "Register Account";
		Assert.assertEquals(actualMessage, expectedMeassage, "Register Account is not Displayed!");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Login'])[1]"))).click();

		boolean LoginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']")))
				.isDisplayed();
		Assert.assertTrue(LoginBtn);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Continue']"))).click();
		Assert.assertEquals(actualMessage, expectedMeassage, "Register Account is not displayed!");

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

}
