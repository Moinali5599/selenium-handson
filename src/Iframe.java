import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class Iframe {
	private static WebDriver driver = null;

	/*** Open Browser ***/
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uitestpractice.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	@Test
	public void iframeTest() throws Exception {
		Actions act = new Actions(driver);
		WebElement iframe = driver.findElement(By.xpath("//div[4]"));
		act.moveToElement(iframe).perform();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='iframe_a']")));
		driver.findElement(By.id("name")).sendKeys("Test User");
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[text()='uitestpractice.com']")).click();
		Thread.sleep(2000);
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}


}
