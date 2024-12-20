package POM.SelniumFramework.pageobjects.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.SelniumFramework.pageobjects.CartPage;
import POM.SelniumFramework.pageobjects.OrdersPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartheader;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement allcartorders;
	
	

	public CartPage gotocartpage() {
		cartheader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;

	}

	public void waitforElementtoAppear(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	}
	
	public void waitforwebElementtoAppear(WebElement FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}

	public void waitforelementtodissaper(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	public OrdersPage gotorderpage() {
		allcartorders.click();
		OrdersPage orderspage = new OrdersPage(driver);
		return orderspage;

	}
}
