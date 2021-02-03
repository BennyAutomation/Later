package test.java.tests;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import test.java.pages.LinkinBioPage;

public class BaseTest {

	public static final String SITE_URL    = "https://brave-goldberg-04dea0.netlify.app/latergear";	
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {
		switch(browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver","c:\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver","c:\\Selenium\\geckodriver.exe");
		        driver = new FirefoxDriver();
		        break;
			case "Edge":
				System.setProperty("webdriver.edge.driver","c:\\Selenium\\edgedriver.exe");
		        driver = new EdgeDriver();
		        break;
		    default:
		    	throw new InvalidSelectorException("[[Not an available browser choice!]]");
		}
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public LinkinBioPage openPage() {
		driver.get(SITE_URL);
		return new LinkinBioPage(driver);
	}
	
}
