import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AlertHandling {
	private static WebDriver driver = null;

	/*** Open Application ***/
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	/*** Accepting Alert ***/
	@Test(priority = 1)
	public void alertAccept() throws InterruptedException {
		// Accepting first alert box
		driver.findElement(By.xpath("//*[@id='OKTab']/button")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
	}

	/*** Dismissing Alert ***/
	@Test(priority = 2)
	public void alertDismiss() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
	}

	/*** Handling alert with textbox ***/
	@Test(priority = 3)
	public void alertWithTextBox() throws Exception {
		String input = "User";
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='Textbox']/button")).click();
		Thread.sleep(2000);
		Alert textBox = driver.switchTo().alert();
		textBox.sendKeys(input);
		textBox.accept();
		String message = driver.findElement(By.id("demo1")).getText();
		if (message.contains(input)) {
			System.out.println("Alert message contains input");
		}
		Thread.sleep(1000);
	}

	/*** Closing Browser ***/
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
