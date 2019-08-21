package com.ebay.pages.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.common.utils.Environment;
import com.ebay.common.utils.ExcelReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EbayBasePage {
	
	private static final Logger logger = LogManager.getLogger(EbayBasePage.class);
	protected AndroidDriver<MobileElement> driver = null;
	private Environment environment;
	protected ExcelReader reader = null;
	protected long explicitWaitTimeInSeconds;
	protected long implicitWaitTimeInSeconds;
	protected boolean isElementPresent;
	private WebDriverWait wait;
	//protected long IMPLICIT_WAIT_IN_SECONDS = 9;
	//public static final String SELECT_BUTTON = "Select";
	//public static final String ADD_TO_CART_BUTTON = "Add To Cart";
	//public static final String GET_QUOTE_BUTTON = "Get Quote";
	//private static final int WINDOW_HEIGHT = 300;
	
	public EbayBasePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		environment = Environment.getEnvironment();
		//WAIT_IN_SECONDS = Integer.parseInt(environment.getWaitTime());
		logger.debug(this.getClass().getName() + " page initializing");
		
		}

	protected String elementName(String key) {
		return environment.getElementName(key);
	}
	
	public boolean isElementPresent(By by) {
		try{
			wait = new WebDriverWait(driver, explicitWaitTimeInSeconds);
			logger.info("wait initiated");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
			logger.info(" Element Is Displayed --");
			isElementPresent = driver.findElement(by).isDisplayed();
			logger.info(isElementPresent);
			return isElementPresent;
			
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		} }

}
