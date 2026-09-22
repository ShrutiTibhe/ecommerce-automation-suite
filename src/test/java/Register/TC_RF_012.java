package Register;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_012 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://tutorialsninja.com/demo");

	}

	@Test
	public void registeringAccountUsingKeyboard() throws InterruptedException {

		Actions action = new Actions(driver);
		for (int i = 1; i <= 3; i++) {
			action.sendKeys(Keys.TAB).perform();
		}

		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);

		for (int i = 1; i <= 23; i++) {
			action.sendKeys(Keys.TAB).perform();

		}

		Thread.sleep(5000);
		action.sendKeys("Shruti").sendKeys(Keys.TAB).sendKeys("Tibhe").sendKeys(Keys.TAB).perform();
		String email = "shrutitibhe" + System.currentTimeMillis() + "@gmail.com";
		Thread.sleep(3000);
		action.sendKeys(email).pause(Duration.ofSeconds(2)).sendKeys(Keys.TAB).sendKeys("8280828585").sendKeys(Keys.TAB).sendKeys("Pass@12345")
				.sendKeys(Keys.TAB).sendKeys("Pass@12345").sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT)
				.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
				.perform();

		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
