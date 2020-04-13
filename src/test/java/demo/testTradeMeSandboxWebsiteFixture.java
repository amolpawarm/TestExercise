package demo;

import java.util.List;

import org.concordion.api.AfterSpecification;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(ConcordionRunner.class)
public class testTradeMeSandboxWebsiteFixture {
	WebDriver driver;
	List<WebElement> MakesTableCells;
	WebElement kiaBrandSpan = null;
	
	public void launchBrowserAndNavigateToUsedCars(String url) {
		driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.get(url.trim());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("makes")));
		WebElement Webtable = driver.findElement(By.id("makes"));
		//All the cells from makes tables
		MakesTableCells = Webtable.findElements(By.xpath("//*[@id='makes']/tbody/tr/td"));		
	}
	
	public int getTotalNumberOfNamedBrandAvailable() {
		return (MakesTableCells.size()-1);		
	}
	
	public boolean verifyKiaBrandExists() {
		boolean kiaBrandExist = false;		
		for(WebElement cell : MakesTableCells) {
			if (cell.getText().contains("Kia")) {
				kiaBrandSpan = cell.findElement(By.className("count"));
				kiaBrandExist = true;
			}
		}
		return kiaBrandExist;
	}
	
	public String getKiaCurrentListing() {
		return kiaBrandSpan.getText().substring(1, 2);
	}
	
	public boolean verifyHispanoSuizaBrandDoesNotExists() {
		boolean hispanoSuizaBrandDoesNotExist = true;
		for(WebElement cell : MakesTableCells) {
			if (cell.getText().contains("Hispano Suiza")) {
				hispanoSuizaBrandDoesNotExist = false;
			}
		}
		return hispanoSuizaBrandDoesNotExist;
	}
	
	@AfterSpecification
	public void teadDown() {
		driver.close();
	}
	
}
