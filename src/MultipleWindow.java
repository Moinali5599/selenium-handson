import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class MultipleWindow {
	private static WebDriver driver = null;
	String homePageTab, homePageTitle, newTabTitle;
	Set<String> allTabs;

	/*** Open Browser & Get URL ***/
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void multipleWindowTest() {
		Actions act = new Actions(driver);
		homePageTitle = driver.getTitle();
		// Getting id of homepage tab
		homePageTab = driver.getWindowHandle();
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul[1]/li[2]/a"))).perform();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul[1]/li[2]/div/ul/li[1]/a")).click();
		// Getting id's of all tabs
		allTabs = driver.getWindowHandles();
		for (String tab : allTabs) {
			// Getting id of tab other than homepage
			if (!tab.equalsIgnoreCase(homePageTab)) {
				driver.switchTo().window(tab);
				newTabTitle = driver.getTitle();
				// Getting list of all links that are present on current tab
				List<WebElement> allLinks = driver.findElements(By.tagName("a"));
				for (WebElement e : allLinks) {
					System.out.println("Link Text is: " + e.getText() + " , " + e.getAttribute("href"));
				}
			}
		}
		Assert.assertEquals(homePageTitle, newTabTitle);
	}

	/*** Quit Driver Instance ***/
	@AfterTest
	public void quitDriver() {
		driver.quit();}
}
