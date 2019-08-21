package com.ebay.pages.Search;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.ebay.pages.LandingPage.LandingPageLocator;
import com.ebay.pages.common.EbayBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchResultPageLocators extends EbayBasePage {

	private static final Logger logger = LogManager.getLogger(SearchResultPageLocators.class);
	
	public SearchResultPageLocators(AndroidDriver<MobileElement> driver) {
		super(driver);
		
	}

	private boolean isResultCountPresent;
	private boolean isSavepopUpPresent;
	
	By resultCount = By.id(elementName("resultCount"));
	By productContainerId = By.id(elementName("productContainerId"));
	By savePopUpId = By.id(elementName("savePopUpId"));
	
	
	
	public boolean isResultCountPresent() {
		isResultCountPresent=isElementPresent(resultCount);
		return isResultCountPresent;
	}
	
	public boolean isSavepopUpPresent() {
		isSavepopUpPresent=isElementPresent(savePopUpId);
		return isSavepopUpPresent;
	}
	
	public boolean isSearchPageLoaded(){
			if (isSavepopUpPresent()==true) {
				clickOnSavePopUp();
		}
		boolean isResultCountPresent = isElementPresent(resultCount); 
		logger.info(" Search page is Loaded with Result count" + driver.findElement(resultCount).getText() );
		return isResultCountPresent ;
	}
	
	public void clickOnSavePopUp() {
		driver.findElement(savePopUpId).click();
	}
	
	
	public void selectProductFromList() {
		List<MobileElement> productList = driver.findElements(productContainerId);
		productList.get(1).click();
		logger.info("Second product from the list is Selected ");
		
	}

}
