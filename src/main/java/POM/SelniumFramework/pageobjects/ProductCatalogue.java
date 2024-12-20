package POM.SelniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM.SelniumFramework.pageobjects.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail =
	// driver.findElement(By.xpath("//input[@id='userEmail']"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;

	By products1 = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
    By toastconatainer = By.cssSelector("#toast-container");
	public List<WebElement> getProductsList() {

		waitforElementtoAppear(products1);
		

		return products;
	}

	public WebElement getProductbyname(String productName) {
		WebElement prod = getProductsList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void AddproducttoCart(String productName) {
		WebElement prod = getProductbyname(productName);
		prod.findElement(addtocart).click();
		waitforElementtoAppear(toastconatainer);
		waitforelementtodissaper(spinner);
	}
}
