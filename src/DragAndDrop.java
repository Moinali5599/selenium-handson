import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class DragAndDrop {
	private static WebDriver driver = null;

	/*** Open Browser ***/
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	/*** Drag and Drop Test ***/
	@Test
	public void dragDropTest() {
		// Switching to the frame where draggable and droppable elements are present
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		// Element to be dragged
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));

		// Element where to drop
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act = new Actions(driver);

		act.dragAndDrop(drag, drop).build().perform();

	}

	/*** Close the Browser ***/
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
