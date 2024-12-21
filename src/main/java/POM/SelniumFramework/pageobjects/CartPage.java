package POM.SelniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM.SelniumFramework.pageobjects.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail =
	// driver.findElement(By.xpath("//input[@id='userEmail']"));
//List<WebElement> cartproducts = driver.findElements(By.xpath("//h3[normalize-space()='ZARA COAT 3']"));
	// driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
	@FindBy(xpath = "//h3[normalize-space()='ZARA COAT 3']")
	List<WebElement> cartproducts;
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement elementclick;

	// Boolean match = cartproducts.stream().anyMatch(cartproduct
	// ->cartproduct.getText().equalsIgnoreCase(productName));

	public Boolean verifyproductdisplay(String productName) {
		Boolean match = cartproducts.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		return match;

	}

	public CheckoutPage goToCheckout() {
		elementclick.click();
		return new CheckoutPage(driver);

	}
}
