package POM.SelniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']")); 
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement submit;
	
	
	public void LoginApplication(String email, String pwd) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}

	
	
}


