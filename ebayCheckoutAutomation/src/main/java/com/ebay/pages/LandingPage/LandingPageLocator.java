package com.ebay.pages.LandingPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ebay.pages.common.EbayBasePage;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPageLocator extends EbayBasePage {
	
	public LandingPageLocator(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	private static final Logger logger = LogManager.getLogger(LandingPageLocator.class);

	By mainMenu = By.id(elementName("mainMenu"));
	By ebayLogo = By.id(elementName("ebayLogo"));
	By searchButton = By.id(elementName("searchButton"));
	//By searchTextBox = By.id(elementName("searchTextBox"));
	
	private boolean isEbayLogoPresent;
	//private int timeLimitInSeconds = 30;
	//private WebDriverWait wait;
	
	public void clickOnMainMenu() {
		driver.findElement(mainMenu).click();
		logger.info("landing Page->Clicked on main menu");
	}
	
	
	public boolean isEbayLogoPresent() {
		isEbayLogoPresent=isElementPresent(ebayLogo);
		return isEbayLogoPresent;
		
	}
	
	/*public MobileElement enterSearchText(AndroidDriver<MobileElement> driver,String searchText) {
		driver.findElement(searchButton).click();
		driver.findElement(searchTextBox).sendKeys(searchText);
		logger.info("landing Page-> Entered Search text is " + searchText);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}*/
	public void clickOnSerachTextBox() {
		driver.findElement(searchButton).click();
		logger.info("Search Text Box Clicked");
	}
		
	/*public boolean isEbayLogoPresent() {
		try{
			wait = new WebDriverWait(driver, 60);
			logger.info("wait initiated");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(ebayLogo)));
			logger.info(ebayLogo + "Is Displayed");
			isEbayLogoPresent = driver.findElement(ebayLogo).isDisplayed();
			logger.info(isEbayLogoPresent);
			return isEbayLogoPresent;
			
		}catch(Exception e){
			isEbayLogoPresent = false;
			System.out.println(e.getMessage());
			return isEbayLogoPresent;
		} }
		*/
}
