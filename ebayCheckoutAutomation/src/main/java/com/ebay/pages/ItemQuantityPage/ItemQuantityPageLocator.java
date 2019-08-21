package com.ebay.pages.ItemQuantityPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ebay.pages.common.EbayBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ItemQuantityPageLocator extends EbayBasePage {
	
	private static final Logger logger = LogManager.getLogger(ItemQuantityPageLocator.class);
	
	public ItemQuantityPageLocator(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	By reviewButton = By.id(elementName("reviewButton"));
	By enterQuantitypageTitle = By.id(elementName("enterQuantitypageTitle"));
	
	
	public boolean isItemQuantityPageLoaded() {
		boolean isItemQuantityPageLoaded=isElementPresent(enterQuantitypageTitle);
		String pageTitle = driver.findElement(enterQuantitypageTitle).getText();
		logger.info("item Enter Quantity page is Loaded and Page Titile is" + pageTitle);
		return isItemQuantityPageLoaded;
		}
	
	public void clickOnReviewButton() {
		driver.findElement(reviewButton).click();
		logger.info("Clicked on Review Button ");
	}

}
