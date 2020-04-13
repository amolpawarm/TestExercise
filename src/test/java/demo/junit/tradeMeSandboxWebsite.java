package demo.junit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class tradeMeSandboxWebsite {

	private static WebDriver driver;
	private static List<WebElement> MakesTableCells;

	@BeforeClass
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.get("https://www.tmsandbox.co.nz/motors/used-cars");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("makes")));		
		WebElement Webtable = driver.findElement(By.id("makes"));
		//All the cells from makes tables
		MakesTableCells = Webtable.findElements(By.xpath("//*[@id='makes']/tbody/tr/td"));
	}

	@Test
	public void getTotalNumberOfNamedBrands() {
		//Makes table contains extra cell with more which need to be removed from the count
		System.out.println("Total Number of named brands of used cars available in the "
				+ "TradeMe UsedCars category are - "+ (MakesTableCells.size()-1));
	}

	@Test
	public void kiaBrandExist() {
		boolean kiaBrandExist = false;
		WebElement span = null;
		for(WebElement cell : MakesTableCells) {
			if (cell.getText().contains("Kia")) {
				span = cell.findElement(By.className("count"));
				kiaBrandExist = true;
			}
		}
		assertThat(kiaBrandExist, is(true));
		System.out.println("Number of Kia cars listed - "+span.getText().substring(1, 2));
	}
	
	@Test
	public void hispanoSuizaBrandDoesNotExist() {
		boolean hispanoSuizaBrandDoesNotExist = true;
		for(WebElement cell : MakesTableCells) {
			if (cell.getText().contains("Hispano Suiza")) {
				hispanoSuizaBrandDoesNotExist = false;
			}
		}
		assertThat(hispanoSuizaBrandDoesNotExist, is(true));		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}
}
