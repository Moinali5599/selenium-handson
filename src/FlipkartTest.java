import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class FlipkartTest {
	private WebDriver driver = null;
	By add_name = By.name("name");
	By add_mobile = By.name("phone");
	By add_pincode = By.name("pincode");
	By add_locality= By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div/div[1]/div/div/form/div/div[3]/div[2]/input");
	By add_address = By.name("addressLine1");
	By add_city = By.name("city");
	By add_state = By.name("state");
	By add_type = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div/div[1]/div/div/form/div/div[7]/div/div/label[1]/div[1]");
	By add_save = By.xpath("//button[text()='Save']");
	By searchBox = By.name("q");
	/*** Opening the Browser ***/
	@BeforeTest
	public void openURL() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("8072795680");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("MoinAli@1999");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		Thread.sleep(3000);
	}
	/*** Adding address 
	 * @throws InterruptedException 
	@Test
	public void addressTest() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.className("exehdJ"))).perform();
		driver.findElement(By.partialLinkText("My Profile")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/a[2]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/div/div/div[1]/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(add_name).sendKeys("TestUser");
		driver.findElement(add_mobile).sendKeys("9874563210");
		driver.findElement(add_pincode).sendKeys("522001");
		driver.findElement(add_locality).sendKeys("ABC street");
		driver.findElement(add_address).sendKeys("DoorNo:123456,ABC street");
		Select state = new Select(driver.findElement(add_state));
		state.selectByVisibleText("Andhra Pradesh");
		driver.findElement(add_type).click();
		driver.findElement(add_save).click();
	}***/
	
	@Test
	public void wishlistTest() throws InterruptedException {
		Actions act = new Actions(driver);
		driver.findElement(searchBox).sendKeys("iphone 11");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[3]")).click();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.className("exehdJ"))).perform();
		driver.findElement(By.partialLinkText("My Profile")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[2]/div[5]/div[1]/div[2]/a[4]/div")).click();
		Thread.sleep(1000);
		 List<WebElement> l= driver.findElements(By.xpath("//*[contains(text(),'APPLE iPhone 11 (Black, 64 GB)')]"));
	      if ( l.size() > 0){
	         System.out.println("Product is present in wishlist");
	      } else {
	         System.out.println("Product is not present in wishlist");
	      }
		
		
	}


}
