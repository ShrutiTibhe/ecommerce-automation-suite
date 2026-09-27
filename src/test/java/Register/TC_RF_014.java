package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_014 {

	WebDriver driver;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");

	}

	@Test
	public void mandatoryFieldsSymbolValidation() {
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		// Expected values
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";

		// First Name
		WebElement firstNameLabel = driver.findElement(By.xpath("//label[normalize-space()='First Name']"));
		String firstNameLabelContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0], '::before').content; ", firstNameLabel);
		System.out.println(firstNameLabelContent);

		String firstNameColorContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0], '::before').color;", firstNameLabel);
		System.out.println(firstNameColorContent);

		Assert.assertEquals(firstNameLabelContent, expectedContent, "First Name does not have * ");
		Assert.assertEquals(firstNameColorContent, expectedColor, "First Name does not have red color symbol ");

		// Last Name

		WebElement lastNameLabel = driver.findElement(By.xpath("//label[normalize-space()='Last Name']"));
		String lastNameLabelContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0], '::before').content;", lastNameLabel);
		System.out.println(lastNameLabelContent);

		String lastNameColorContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0], '::before').color;", lastNameLabel);
		System.out.println(lastNameColorContent);

		Assert.assertEquals(lastNameLabelContent, expectedContent, "Last Name does not have * ");
		Assert.assertEquals(lastNameColorContent, expectedColor, "Last Name does not have red color symbol ");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
