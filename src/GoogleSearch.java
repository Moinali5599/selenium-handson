import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {
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

	/*** Search Test ***/
	@Test
	public void searchTest() {
		driver.findElement(By.xpath("//input[@title = 'Search']")).sendKeys("Automation Selenium");
		driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Automation Selenium - Google Search")) {
			System.out.println("Title matched");
		}else {
			System.out.println("Title not matched");
		}

	}

	/*** Quit Driver Instance ***/
	@AfterTest
	public void quitDriver() {
		driver.quit();
		
	}


}
