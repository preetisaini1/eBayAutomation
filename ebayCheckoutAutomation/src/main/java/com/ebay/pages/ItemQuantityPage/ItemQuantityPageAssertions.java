package com.ebay.pages.ItemQuantityPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.ebay.pages.common.EbayBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ItemQuantityPageAssertions extends EbayBasePage{

	private static final Logger logger = LogManager.getLogger(ItemQuantityPageAssertions.class);
	
	public ItemQuantityPageAssertions(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	private ItemQuantityPageLocator itemQuantityPage = new ItemQuantityPageLocator(driver);
	
	public void verifyItemQuantityPage() {
		Assert.assertTrue(itemQuantityPage.isItemQuantityPageLoaded(), "Enter Quantity page is loaded with some error" );
		logger.info("Enter Quantity page is loaded successgully ");
	}
	
	public void navigateToCheckoutPage() {
		itemQuantityPage.clickOnReviewButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
