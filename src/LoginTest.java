import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	private static WebDriver driver = null;
	// Web Elements
	By admin_Link = By.id("menu_admin_viewAdminModule");
	By job_Link = By.id("menu_admin_Job");
	By jobTilesLink = By.id("menu_admin_viewJobTitleList");
	By jobAddButton = By.name("btnAdd");
	By jobTitle = By.id("jobTitle_jobTitle");
	By jobDesc = By.id("jobTitle_jobDescription");
	By jobSaveButton = By.id("btnSave");
	By profile = By.id("welcome");
	By logoutButton = By.xpath("//a[text()='Logout']");
	/*** Open Browser ***/
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	/*** Job Add Test ***/
	@Test
	public void jobAddTest() {
		Actions act = new Actions(driver);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
			System.out.println("URL matched");
		} else {
			System.out.println("URL not matched");
		}
		act.moveToElement(driver.findElement(admin_Link)).perform();
		act.moveToElement(driver.findElement(job_Link)).perform();
		driver.findElement(jobTilesLink).click();
		driver.findElement(jobAddButton).click();
		driver.findElement(jobTitle).sendKeys("Business analyst");
		driver.findElement(jobDesc).sendKeys(
				"Business Analysts conduct market analyses, analysing both product lines and the overall profitability of the business");
		driver.findElement(jobSaveButton).click();
		driver.findElement(profile).click();
		driver.findElement(logoutButton).click();
	}

	/*** Quit Driver Instance ***/
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}

}
