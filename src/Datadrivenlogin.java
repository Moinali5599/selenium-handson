import java.io.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Datadrivenlogin {
	private static WebDriver driver = null;

	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void datadrivenLoginTest() throws Exception {
		File file = new File(
				System.getProperty("user.dir") + "\\logindata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet loginDataSheet = workbook.getSheetAt(0);
		for (int i = 0; i < 2; i++) {
			System.out.println("***Login Test Started***");
			String username = loginDataSheet.getRow(i).getCell(0).getStringCellValue();
			XSSFCell passwordCell = loginDataSheet.getRow(i).getCell(1);
			//Coverting numeric cell data
			DataFormatter df = new DataFormatter();
			String password = df.formatCellValue(passwordCell);
			driver.findElement(By.name("userName")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("submit")).click();
			Thread.sleep(1000);
			if (driver.getCurrentUrl().equalsIgnoreCase("http://demo.guru99.com/test/newtours/index.php")) {
				System.out.println("Error message: " + driver.findElement(By.xpath("//span")).getText());
			} else {
				if (driver.getTitle().equalsIgnoreCase("Login: Mercury Tours"))
					System.out.println("Title Verifed");
				else
					System.out.println("Title does not match");

			}
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
