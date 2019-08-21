package com.ebay.pages.itemDetailPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ebay.common.modal.Item;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ItemDetailPageLocators extends EbayBasePage {

	private static final Logger logger = LogManager.getLogger(ItemDetailPageLocators.class);
	
	public ItemDetailPageLocators(AndroidDriver<MobileElement> driver) {
		super(driver);
		
		}
	
	By itemName = By.id(elementName("itemName"));
	By itemPrice = By.id(elementName("itemPrice"));
	By buyNowButton = By.id(elementName("buyNowButton"));
	By addToCartButton = By.id(elementName("addToCartButton"));
	private Item item = new Item();
	private boolean isBuyNowButtonPresent;
	
	public String getItemName() {
		String productName = driver.findElement(itemName).getText();
		item.setItemName(productName);
		logger.info("ItemName is set to  " +  productName);
		return item.getItemName();
		}
	
	public String getItemPrice() {
		String productPrice = driver.findElement(itemPrice).getText();
		item.setitemPrice(productPrice);
		logger.info("ItemPrice is set to  " +  productPrice);
		return item.getitemPrice();
		}
	
	public void getItemDetails() {
		
	}
	
	public boolean isBuyNowButtonPresent() {
		isBuyNowButtonPresent=isElementPresent(buyNowButton);
		logger.info("Buy Now Button is present " + isBuyNowButtonPresent);
		return isBuyNowButtonPresent;
		
	}
	
	public void clickOnBuyNowButton() {
		driver.findElement(buyNowButton).click();
		logger.info("Clicked on Buy Now Button " + isBuyNowButtonPresent);
	}
}
