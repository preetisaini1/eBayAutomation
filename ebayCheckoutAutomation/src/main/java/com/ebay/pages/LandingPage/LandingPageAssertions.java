package com.ebay.pages.LandingPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LandingPageAssertions extends EbayBasePage{

	private static final Logger logger = LogManager.getLogger(LandingPageAssertions.class);

	public LandingPageAssertions(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	private LandingPageLocator landingPage = new LandingPageLocator(driver);
	
	public void navigateToSearchPage() {
		landingPage.clickOnSerachTextBox();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}




}