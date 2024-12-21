package POM.SelniumFramework;

import static org.testng.AssertJUnit.assertTrue;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.SelniumFramework.pageobjects.LandingPage;
import dev.failsafe.internal.util.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingpage = new LandingPage(driver);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("uniquesumanth143@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Suman@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartproducts = driver.findElements(By.xpath("//h3[normalize-space()='ZARA COAT 3']"));

		Boolean match = cartproducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		assertTrue(match);

		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		// driver.findElement(By.xpath("//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));

		driver.close();
//
	}

}
