package POM.SelniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM.SelniumFramework.pageobjects.AbstractComponents.AbstractComponents;
//import POM.SelniumFramework.pageobjects.AbstractComponents.tr;

public class OrdersPage extends AbstractComponents {

	WebDriver driver;
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productnames;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail =
	// driver.findElement(By.xpath("//input[@id='userEmail']"));
//List<WebElement> cartproducts = driver.findElements(By.xpath("//h3[normalize-space()='ZARA COAT 3']"));
	// driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
	
	

	// Boolean match = cartproducts.stream().anyMatch(cartproduct
	// ->cartproduct.getText().equalsIgnoreCase(productName));

	public Boolean verifyproductdisplay(String productName) {
		Boolean match = productnames.stream()
				.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
		return match;

	}

	
}
