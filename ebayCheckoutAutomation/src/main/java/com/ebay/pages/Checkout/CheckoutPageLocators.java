package com.ebay.pages.Checkout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ebay.common.modal.Item;
import com.ebay.pages.common.EbayBasePage;
import com.ebay.pages.itemDetailPage.ItemDetailPageLocators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutPageLocators extends EbayBasePage {

	
	private static final Logger logger = LogManager.getLogger(CheckoutPageLocators.class);
	
	public CheckoutPageLocators(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	By productName = By.id(elementName("productName"));
	By productPrice = By.id(elementName("productPrice"));
	By checkoutPageTitle = By.id(elementName("checkoutPageTitle"));
	private Item product = new Item();
	
	public String getProductName() {
		String ProductName = driver.findElement(productName).getText();
		product.setItemName(ProductName);
		logger.info("ItemName is set to  " +  ProductName);
		return product.getItemName();
		}
	
	public String getProductPrice() {
		String ProductPrice = driver.findElement(productPrice).getText();
		product.setitemPrice(ProductPrice);
		logger.info("ItemPrice is set to  " +  ProductPrice);
		return product.getitemPrice();
		}
	
	public boolean isCheckoutPageLoaded() {
		boolean isCheckoutPageLoaded=isElementPresent(checkoutPageTitle);
		logger.info("Checkout Page is Loaded " + isCheckoutPageLoaded);
		return isCheckoutPageLoaded;
	}
}
