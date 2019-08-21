package com.ebay.pages.itemDetailPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.ebay.common.modal.Item;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ItemDetailsPageAssertions extends EbayBasePage {

	private static final Logger logger = LogManager.getLogger(ItemDetailsPageAssertions.class);
	
	public ItemDetailsPageAssertions(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	private ItemDetailPageLocators itemDetailPage = new ItemDetailPageLocators(driver);
	private Item item;
	
	public void verifyItemDetailsPageLoad() {
		Assert.assertTrue(itemDetailPage.isBuyNowButtonPresent(), "Item Details page is loaded with some error" + itemDetailPage.isBuyNowButtonPresent());
		logger.info("ItemDetailsPage is loaded Successfully");
	}
	
	public void navigateToItemQuantityEnterPage() {
		itemDetailPage.clickOnBuyNowButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public Item getProductDetailsFromItemDetailsPage() {
		String itemName = itemDetailPage.getItemName();
		String itemPrice = itemDetailPage.getItemPrice();
		item = new Item();
		item.setItemName(itemName);
		item.setitemPrice(itemPrice);
		logger.info("Selected Product Details are " + item);
		logger.info("Selected Product Name are " + itemName);
		logger.info("Selected Product Price are " + itemPrice);
		return item;
	}
}
