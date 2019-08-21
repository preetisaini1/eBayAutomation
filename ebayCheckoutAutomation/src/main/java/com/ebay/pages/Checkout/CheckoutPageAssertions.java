package com.ebay.pages.Checkout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.ebay.common.modal.Item;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutPageAssertions extends EbayBasePage {

	private static final Logger logger = LogManager.getLogger(CheckoutPageAssertions.class);
	
	public CheckoutPageAssertions(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	private CheckoutPageLocators CheckoutPage = new CheckoutPageLocators(driver);
	private Item item;
	
	public void verifyCheckoutPageLoad() {
		Assert.assertTrue(CheckoutPage.isCheckoutPageLoaded(), "Checkout page is loaded with some error" + CheckoutPage.isCheckoutPageLoaded());
		logger.info("Checkout page is Loaded Successfully");
	}

	public Item getProductDetailsFromCheckoutPage() {
		String productName=CheckoutPage.getProductName();
		String productPrice=CheckoutPage.getProductPrice();
		item = new Item();
		item.setItemName(productName);
		item.setitemPrice(productPrice);
		logger.info("Selected Product Details are " + item);
		logger.info("Selected Product Name are " + productName);
		logger.info("Selected Product Price are " + productPrice);
		return item;
	}
}
