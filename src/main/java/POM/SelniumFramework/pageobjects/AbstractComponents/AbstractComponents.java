package POM.SelniumFramework.pageobjects.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver=driver;
	}

	public void waitforElementtoAppear(By FindBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	}
	
	public void waitforelementtodissaper(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
}
