import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class DropDown {
	private WebDriver driver = null;
	By dayMenu = By.name("birthday_day");
	By monthMenu = By.name("birthday_month");
	By yearMenu = By.name("birthday_year");

	/*** Opening the Browser ***/
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	/*** Date Drop Down Test ***/
	@Test
	public void dropDownTest() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
		Thread.sleep(1000);
		// Selecting day
		Select day = new Select(driver.findElement(dayMenu));
		day.selectByVisibleText("12");
		// Selecting month
		Select month = new Select(driver.findElement(monthMenu));
		month.selectByVisibleText("Dec");
		// Selecting year
		Select year = new Select(driver.findElement(yearMenu));
		year.selectByVisibleText("2012");
		System.out.println("Options of days:");
		getOptions(dayMenu);
		System.out.println("Options of month:");
		getOptions(monthMenu);
		System.out.println("Options of years:");
		getOptions(yearMenu);
	}

	/*** Closing the browser ***/
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	/*** Function to get all the available options in the drop down list ***/
	private void getOptions(By by) {
		// Getting all options of dropdown 'by' as a list
		List<WebElement> menuOptions = new Select(driver.findElement(by)).getOptions();
		for (WebElement option : menuOptions) {
			System.out.print(option.getText()+", ");
		}
		System.out.println();
	}

}
