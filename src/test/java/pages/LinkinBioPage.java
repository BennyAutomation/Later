package test.java.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkinBioPage {

	private static final By CARD_LINK                   = By.xpath("//a[@class = 'o--card']");
	private static final By ITEM_DROPDOWN               = By.xpath("//select[@class = 'o--form__select']");
	private static final By ADD_TO_CART_BUTTON          = By.xpath("//div[@class = 'cDT--post__btn']/a");
	private static final By CART_ITEM                   = By.className("cSC--li");
	
	private static final String CLICK_CHECKOUT_BUTTON   = "document.querySelector('footer a').click()";

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	
	public LinkinBioPage(WebDriver drv) {
		driver = drv;
		wait = new WebDriverWait(driver, 10);
	}

	public void addItemtoCart() {
		WebElement cardLink = wait.until(ExpectedConditions.elementToBeClickable(CARD_LINK));
		cardLink.click();
		setDropdownFilters();
		WebElement addTOCartButton = wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON));
		addTOCartButton.click();
	}
	
	private void setDropdownFilters() {
		List<WebElement> dropdowns = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ITEM_DROPDOWN));
		for(WebElement dropdown : dropdowns) {
			Select filter = new Select(dropdown);
			filter.selectByIndex(1);
		}
	}

	public CheckoutPage checkoutCart() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(CART_ITEM));
		} catch (TimeoutException e) {
			throw new NoSuchElementException("[[Item was not added to the cart!]]");
		}
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(CLICK_CHECKOUT_BUTTON);
		return new CheckoutPage(driver);
	}
	
	
}
