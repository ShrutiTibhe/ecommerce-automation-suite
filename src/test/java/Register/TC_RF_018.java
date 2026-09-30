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

public class TC_RF_018 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");

	}

	@Test
	public void mandatoryFieldsSymbolValidation() {
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		// First name
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		int firstNameHeight = firstName.getSize().getHeight();
		int firstNameWidth = firstName.getSize().getWidth();
		System.out.println(firstNameHeight);
		System.out.println(firstNameWidth);

		Assert.assertEquals(firstNameHeight, 34, "First Name Height Is Not 34");
		Assert.assertEquals(firstNameWidth, 701, "First Name Height Is Not 701");

		// Last Name

		WebElement lastName = driver.findElement(By.id("input-lastname"));
		int lastNameHeight = lastName.getSize().getHeight();
		int lastNameWidth = lastName.getSize().getWidth();
		System.out.println(lastNameHeight);
		System.out.println(lastNameWidth);
		Assert.assertEquals(lastNameHeight, 34, "Last Name Height Is Not 34");
		Assert.assertEquals(lastNameWidth, 701, "Last Name Height Is Not 701");

		// Email

		WebElement email = driver.findElement(By.id("input-email"));
		int emailHeight = email.getSize().getHeight();
		int emailWidth = email.getSize().getWidth();
		System.out.println(emailHeight);
		System.out.println(emailWidth);
		Assert.assertEquals(emailHeight, 34, "Last Name Height Is Not 34");
		Assert.assertEquals(emailWidth, 701, "Last Name Height Is Not 701");

		// Telephone

		WebElement telephone = driver.findElement(By.id("input-telephone"));
		int telephoneHeight = telephone.getSize().getHeight();
		int telephoneWidth = telephone.getSize().getWidth();
		System.out.println(telephoneHeight);
		System.out.println(telephoneWidth);
		Assert.assertEquals(telephoneHeight, 34, "Telephone Name Height Is Not 34");
		Assert.assertEquals(telephoneWidth, 701, "Telephone Name Height Is Not 701");

		// Password

		WebElement password = driver.findElement(By.id("input-password"));
		int passwordHeight = password.getSize().getHeight();
		int passwordWidth = password.getSize().getWidth();
		System.out.println(passwordHeight);
		System.out.println(passwordWidth);
		Assert.assertEquals(passwordHeight, 34, "Password Name Height Is Not 34");
		Assert.assertEquals(passwordWidth, 701, "Password Name Height Is Not 701");

		// Confirm-Password
		WebElement ConfirmPassword = driver.findElement(By.id("input-confirm"));
		int ConfirmPasswordHeight = ConfirmPassword.getSize().getHeight();
		int ConfirmPasswordWidth = ConfirmPassword.getSize().getWidth();
		System.out.println(ConfirmPasswordHeight);
		System.out.println(ConfirmPasswordWidth);
		Assert.assertEquals(ConfirmPasswordHeight, 34, "Confirm-Password Name Height Is Not 34");
		Assert.assertEquals(ConfirmPasswordWidth, 701, "Confirm-Password Name Height Is Not 701");

		boolean subscribeNo = driver.findElement(By.xpath("//label[normalize-space()='No']")).isDisplayed();
		boolean subscribeYes = driver.findElement(By.xpath("//label[normalize-space()='Yes']")).isDisplayed();
		
		WebElement button = driver.findElement(By.xpath("//input[@value='Continue']"));
		String buttonColor = button.getCssValue("background-color");
		Assert.assertNotNull(buttonColor);
		Assert.assertTrue(subscribeYes);
		Assert.assertTrue(subscribeYes, "Susbscribe Yes Is Not Displayed");
		Assert.assertTrue(subscribeNo, "Susbscribe Not Is Not Displayed");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
