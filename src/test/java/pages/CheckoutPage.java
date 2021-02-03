package test.java.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {


	private static final String URL_PATH          = "https://later-gear.myshopify.com/3108798510/checkouts/";
	private static final By PRODUCT_LIST_ITEM     = By.xpath("//tr[@class = 'product']");
	

	WebDriver driver;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 10);
	}
	
	public boolean isItemAddedToCheckoutPage() {
		try {
			wait.until(ExpectedConditions.urlContains(URL_PATH));
		} catch (TimeoutException e) {
			throw new TimeoutException("[[Checkout page was not reached!]]");
		}
		List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT_LIST_ITEM));
		return (productList.size() > 0);
	}

	
	
}
