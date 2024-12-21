package POM.SelniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import POM.SelniumFramework.pageobjects.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	WebElement submit;
	
//	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
//	WebElement errormessage;
//	
	@FindBy(css = "flyInOut")
	WebElement errormessage;
	
//	body:nth-child(2) div.overlay-container:nth-child(6) div.toast-bottom-right.toast-container div.ng-tns-c4-12.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error > div.ng-tns-c4-12.toast-message.ng-star-inserted
	public ProductCatalogue LoginApplication(String email, String pwd) {

		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}


public String geterrormessage() {
	waitforwebElementtoAppear(errormessage);
	return errormessage.getText();
	
}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

	

}}
