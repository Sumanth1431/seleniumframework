package POM.SelniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import POM.SelniumFramework.pageobjects.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement submit;

	@FindBy(xpath = "//body//app-root//button[2]")
	WebElement selectcountry;

	By results = By.cssSelector(".ta-results");

	public void selectcountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitforElementtoAppear(By.cssSelector(".ta-results"));
		selectcountry.click();

	}

	public ConfirmationPage submitorder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
}
