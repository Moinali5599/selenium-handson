import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class MenuTest {

	public static WebDriver driver = null;

	/*** Opening Browser ***/
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}
	/***
	 * Testing Accounts Menu
	 * 
	 * @throws InterruptedException
	 ***/
	@Test
	public void mouseHoverTest() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
		action.moveToElement(menu).perform();
		driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span")).click();
		WebElement mobiles = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
		action.contextClick(mobiles).perform();
		Thread.sleep(3000);
	}
	/*** Closing the browser 
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}***/

}
