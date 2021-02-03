package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.java.pages.CheckoutPage;
import test.java.pages.LinkinBioPage;

public class linkinBioTests extends BaseTest {

	@Test
	public void canCheckoutItemFromCartSidebar() {
		LinkinBioPage linkinBioPage = openPage();
		linkinBioPage.addItemtoCart();
		CheckoutPage checkoutPage = linkinBioPage.checkoutCart();
		Assert.assertTrue(checkoutPage.isItemAddedToCheckoutPage());
	}
	
	
}
