package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import test.java.pages.LinkinBioPage;

public class BaseTestChromeOnly {

	public static final String SITE_URL    = "https://brave-goldberg-04dea0.netlify.app/latergear";	
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","c:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
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
