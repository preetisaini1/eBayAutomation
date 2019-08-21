package com.ebay.pages.MainMenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ebay.pages.LandingPage.LandingPageLocator;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainMenuLocators extends EbayBasePage {

	public MainMenuLocators(AndroidDriver<MobileElement> driver) {
		super(driver);
	
	}

	private static final Logger logger = LogManager.getLogger(MainMenuLocators.class);

	By sign_in = By.id(elementName("sign_in"));
	By userid = By.id(elementName("userid"));
	By home = By.id(elementName("home"));
	
	public void clickOnSignIn() {
		driver.findElement(sign_in).click();
		logger.info("Main Menu ->Clicked on Sign IN");
	}
	
	public String getSignedInUSerId() {
		String signedInUserId = driver.findElement(userid).getText();
		logger.info("Main Menu -> Signed In USer ---- " + signedInUserId );
		return signedInUserId;
	}
	
	public void clickOnHome() {
		driver.findElement(home).click();
		logger.info("Main Menu -> Home -> Clicked on Home");
		
	}
}
