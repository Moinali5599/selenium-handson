import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigationTest {
	private static WebDriver driver = null;

	/*** Open Browser ***/
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	/*** Search Test 
	 * @throws InterruptedException ***/
	@Test
	public void navigationTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@title = 'Search']")).sendKeys("Selenium Automation");
		driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
		Thread.sleep(1000);
		// Clicking the back button
		driver.navigate().back();
		Thread.sleep(1000);
		// Clicking the forward button
		driver.navigate().forward();
		Thread.sleep(1000);
	}

	/*** Quit Driver Instance ***/
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
}
