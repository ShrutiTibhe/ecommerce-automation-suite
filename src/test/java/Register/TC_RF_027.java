package Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

public class TC_RF_027 {

	WebDriver driver;

	@Test(priority = 1)
	public void registerWithChrome() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		boolean registerAccountTest = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']"))
				.isDisplayed();
		Assert.assertTrue(registerAccountTest);

	}

	@Test(priority = 2)
	public void registerWithEdge() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		boolean registerAccountTest = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']"))
				.isDisplayed();
		Assert.assertTrue(registerAccountTest);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
