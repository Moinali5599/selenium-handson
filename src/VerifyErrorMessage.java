import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class VerifyErrorMessage {
	private static WebDriver driver = null;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?hl=en&continue=https%3A%2F%2Fmail.google.com%2Fmail&service=mail&ec=GAlAFw&flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void verifyErrorMessageTest() {
		driver.findElement(By.name("identifier")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
		String errorMessage = driver.findElement(By.xpath(
				"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div"))
				.getText();
		if (errorMessage.equalsIgnoreCase("Couldn’t find your Google Account")) {
			System.out.println("Verified");
		}
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
