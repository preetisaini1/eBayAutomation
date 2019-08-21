package com.ebay.pages.Search;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ebay.pages.common.EbayBasePage;
import com.ebay.pages.itemDetailPage.ItemDetailPageLocators;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SearchPageLocators extends EbayBasePage {

	private static final Logger logger = LogManager.getLogger(ItemDetailPageLocators.class);
	
	public SearchPageLocators(AndroidDriver<MobileElement> driver) {
		super(driver);
		}

	By searchTextBox = By.id(elementName("searchTextBox"));
	
	public void enterSearchText(String searchText) {
		driver.findElement(searchTextBox).sendKeys(searchText);
		logger.info("Search Page-> Entered Search text is " + searchText);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
}
