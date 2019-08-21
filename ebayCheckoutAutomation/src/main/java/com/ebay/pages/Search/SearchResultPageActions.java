package com.ebay.pages.Search;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.ebay.pages.LandingPage.LandingPageLocator;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchResultPageActions extends EbayBasePage {

	private static final Logger logger = LogManager.getLogger(SearchResultPageLocators.class);
	
	public SearchResultPageActions(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	private SearchResultPageLocators searchResultPage = new SearchResultPageLocators (driver);
	
	public void navigateToProductDetailsPage() {
		searchResultPage.selectProductFromList();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
	
	public void verifySearchResultPageLoad() {
		Assert.assertTrue(searchResultPage.isSearchPageLoaded(), "Search Page is Loaded Successfully");
	logger.info("Search Result Page is loaded");
	}
}
