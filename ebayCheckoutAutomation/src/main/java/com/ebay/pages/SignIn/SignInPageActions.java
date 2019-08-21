package com.ebay.pages.SignIn;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.ebay.pages.LandingPage.LandingPageAssertions;
import com.ebay.pages.LandingPage.LandingPageLocator;
import com.ebay.pages.MainMenu.MainMenuLocators;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SignInPageActions extends EbayBasePage{
	
	private static final Logger logger = LogManager.getLogger(SignInPageActions.class);
	
		private	SignInPageLocators signInPageLocators = new SignInPageLocators (driver) ;
		private	String email;
		private	String password;
		private	String userID;
		private String actualuserID;
		private	LandingPageLocator landingPage = new LandingPageLocator(driver) ;
		private	MainMenuLocators mainMenuLocators = new MainMenuLocators(driver);
		private boolean ebayLogoPresent=false;
		
	
		public SignInPageActions(AndroidDriver<MobileElement> driver, String email, String password, String userID) {
			super(driver);
			this.email=email;
			this.password=password;
			this.userID=userID;
		}
	
	public void verifySignIn(AndroidDriver<MobileElement> driver) {
	
	landingPage.clickOnMainMenu();
	mainMenuLocators.clickOnSignIn();
	signInPageLocators.typeUsername(email);
	signInPageLocators.typePassword(password);
	signInPageLocators.clickOnSinInButton();
	
	logger.info("Sign In button Clicked");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	ebayLogoPresent=landingPage.isEbayLogoPresent();
	
	Assert.assertEquals(ebayLogoPresent, true, "User is navigated to Ebay Landing Page");
	
	landingPage.clickOnMainMenu();
	
	actualuserID=mainMenuLocators.getSignedInUSerId();
	Assert.assertEquals(actualuserID, userID, "GIven User is successgully SignediN");
	
	mainMenuLocators.clickOnHome();
	logger.info("User is Directed to Home");
	
	}
	
	
}
