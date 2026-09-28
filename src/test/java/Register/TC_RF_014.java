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

		// Email
		WebElement emailLabel = driver.findElement(By.xpath("//label[normalize-space()='E-Mail']"));
		String emailLabelContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').content;", emailLabel);
		System.out.println(emailLabelContent);

		String emailLabelColor = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').color;", emailLabel);
		System.out.println(emailLabelColor);

		Assert.assertEquals(emailLabelContent, expectedContent, "E-mail Name does not have *");
		Assert.assertEquals(emailLabelColor, expectedColor, "E-mail Name does not have red color symbol ");

		// Telephone

		WebElement telephoneLabel = driver.findElement(By.xpath("//label[normalize-space()='Telephone']"));
		String telephoneLabelContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').content;", telephoneLabel);
		System.out.println(telephoneLabelContent);

		String telephoneLabelColor = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').color;", telephoneLabel);
		System.out.println(telephoneLabelColor);

		Assert.assertEquals(telephoneLabelContent, expectedContent, "Telephone Name does not have *");
		Assert.assertEquals(telephoneLabelColor, expectedColor, "Telephone Name does not have red color symbol ");

		// password
		WebElement passwordLabel = driver.findElement(By.xpath("//label[normalize-space()='Password']"));
		String passwordLabelContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').content;", passwordLabel);
		System.out.println(passwordLabelContent);

		String passwordLabelColor = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').color;", passwordLabel);
		System.out.println(passwordLabelColor);

		Assert.assertEquals(passwordLabelContent, expectedContent, "Password Name does not have *");
		Assert.assertEquals(passwordLabelColor, expectedColor, "Password Name does not have red color symbol ");

		// confirm password

		WebElement confirmPasswordLabel = driver.findElement(By.xpath("//label[normalize-space()='Password Confirm']"));
		String confirmPasswordLabelContent = (String) jse.executeScript(
				"return window.getComputedStyle(arguments[0],'::before').content;", confirmPasswordLabel);
		System.out.println(confirmPasswordLabelContent);

		String confirmPasswordLabelColor = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').color;", confirmPasswordLabel);
		System.out.println(confirmPasswordLabelColor);

		Assert.assertEquals(confirmPasswordLabelContent, expectedContent, "Confirm Password Name does not have *");
		Assert.assertEquals(confirmPasswordLabelColor, expectedColor,
				"Confirm Password Name does not have red color symbol ");

		// Privacy Policy Check box

		WebElement privacyPolicyLabel = driver.findElement(By.xpath("//input[@name='agree']"));
		String privacyPolicyLabelContent = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').content;", privacyPolicyLabel);
		System.out.println(privacyPolicyLabelContent);

		String privacyPolicyLabelColor = (String) jse
				.executeScript("return window.getComputedStyle(arguments[0],'::before').color;", privacyPolicyLabel);
		System.out.println(privacyPolicyLabelColor);

		Assert.assertEquals(privacyPolicyLabelContent, expectedContent, "Privacy Policy Name does not have *");
		Assert.assertEquals(privacyPolicyLabelColor, expectedColor,"Privacy Policy Name does not have red color symbol ");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
