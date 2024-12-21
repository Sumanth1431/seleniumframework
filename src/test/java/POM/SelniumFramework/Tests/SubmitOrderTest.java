package POM.SelniumFramework.Tests;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.SelniumFramework.pageobjects.OrdersPage;
import POM.SelniumFramework.TestComponents.BaseTest;
import POM.SelniumFramework.pageobjects.CartPage;
import POM.SelniumFramework.pageobjects.CheckoutPage;
import POM.SelniumFramework.pageobjects.ConfirmationPage;
import POM.SelniumFramework.pageobjects.LandingPage;
import POM.SelniumFramework.pageobjects.ProductCatalogue;
import dev.failsafe.internal.util.Assert;

public class SubmitOrderTest extends BaseTest{
	
	String productName = "ZARA COAT 3";

	@Test
	
	public void submitorder( ) throws IOException{
		// TODO Auto-generated method stub
	
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		// driver.get("https://rahulshettyacademy.com/client");
//		LandingPage landingpage = launchapplication();
//		landingpage.goTo();
//		landingpage.LoginApplication("uniquesumanth143@gmail.com", "Suman@123");
//		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("uniquesumanth143@gmail.com");
//		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Suman@123");
//		driver.findElement(By.xpath("//input[@id='login']")).click();
		ProductCatalogue productCatalogue = landingpage.LoginApplication("uniquesumanth143@gmail.com", "Suman@123");
		productCatalogue.getProductsList();
		productCatalogue.AddproducttoCart(productName);
		CartPage cartpage = productCatalogue.gotocartpage();

		Boolean match = cartpage.verifyproductdisplay(productName);
		assertTrue(match);
		CheckoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectcountry("india");
		ConfirmationPage confirmationpage = checkoutpage.submitorder();

//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));	
//		WebElement prod = products.stream().filter(product-> 
//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);				
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

//		CartPage cartpage = new CartPage(driver);

//		List<WebElement> cartproducts = driver.findElements(By.xpath("//h3[normalize-space()='ZARA COAT 3']"));
//		
//		Boolean match = cartproducts.stream().anyMatch(cartproduct ->cartproduct.getText().equalsIgnoreCase(productName));

//		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

////////		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		// driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		String confirmmessage = confirmationpage.getconfirmation();

		assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));

		//driver.close();
//
	}

	
	@Test(dependsOnMethods= {"submitorder"}) 
	
	public void orderhistorytest() {
		
		
		ProductCatalogue productCatalogue = landingpage.LoginApplication("uniquesumanth143@gmail.com", "Suman@123");
		OrdersPage orderspage = productCatalogue.gotorderpage();
		assertTrue(orderspage.verifyproductdisplay(productName));
		
	}
	
	@DataProvider
	public Object[][] getdata() {
		return new Object [] [] {{"uniquesumanth143@gmail.com","Suman@123","ZARA COAT 3"},{"uniquesumanth143@gmail.com","Suman@123","ADIDAS ORIGINAL"}};
	}
}
