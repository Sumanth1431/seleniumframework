package POM.SelniumFramework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import POM.SelniumFramework.pageobjects.LandingPage;

public class BaseTest {
public WebDriver driver;
public LandingPage landingpage;
	public WebDriver initalizedriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Sumant\\SelniumFramework\\src\\main\\java\\POM\\SelniumFramework\\resources\\GlobalData.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
		 driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;

}
	@BeforeMethod
	public LandingPage launchapplication() throws IOException {
		
		driver = initalizedriver();
	 landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
//	@AfterMethod
//	public void teardown() {
//		driver.close();
//	}
}

