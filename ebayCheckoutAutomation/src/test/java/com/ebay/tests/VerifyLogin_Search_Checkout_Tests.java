package com.ebay.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebay.common.modal.Item;
import com.ebay.pages.Checkout.CheckoutPageAssertions;
import com.ebay.pages.ItemQuantityPage.ItemQuantityPageAssertions;
import com.ebay.pages.LandingPage.LandingPageAssertions;
import com.ebay.pages.Search.SearchPageLocators;
import com.ebay.pages.Search.SearchResultPageActions;
import com.ebay.pages.SignIn.SignInPageActions;
import com.ebay.pages.itemDetailPage.ItemDetailsPageAssertions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class VerifyLogin_Search_Checkout_Tests extends BaseTest {
	private static final Logger logger = LogManager.getLogger(VerifyLogin_Search_Checkout_Tests.class);
	
	private SignInPageActions signInPageActions;
	private LandingPageAssertions landingPage;
	private SearchPageLocators searchPage;
	private SearchResultPageActions searchResultPage;
	private ItemDetailsPageAssertions itemDetailsPage; 
	private ItemQuantityPageAssertions itemQuantityPage;
	private CheckoutPageAssertions checkoutPage;

	
	@Test (testName = "VerifyLogin")
	public AndroidDriver<MobileElement> VerifyLogin(String email, String password, String userID)  {
		signInPageActions = new SignInPageActions(driver, email, password, userID);
		signInPageActions.verifySignIn(driver);
		return driver;
			
	}
	
	@Test (testName = "VerifySearch")
	public AndroidDriver<MobileElement> VerifySearch(String searchText) {
		landingPage = new LandingPageAssertions(driver);
		searchPage = new SearchPageLocators(driver);
		searchResultPage = new SearchResultPageActions(driver);
		landingPage.navigateToSearchPage();
		searchPage.enterSearchText(searchText);
		searchResultPage.verifySearchResultPageLoad();
		return driver;
	}
	
	@Test (testName = "VerifyCheckout", dataProvider = "TestData")
	public void verifyCheckout(String email, String password, String userID, String searchText) {
		driver = VerifyLogin(email, password, userID);
		driver = VerifySearch(searchText);
		itemDetailsPage = new ItemDetailsPageAssertions(driver);
		itemQuantityPage = new ItemQuantityPageAssertions(driver);
		checkoutPage = new CheckoutPageAssertions(driver);	
		searchResultPage.navigateToProductDetailsPage();
		itemDetailsPage.verifyItemDetailsPageLoad();
		Item itemProduct = itemDetailsPage.getProductDetailsFromItemDetailsPage();
		itemDetailsPage.navigateToItemQuantityEnterPage();
		itemQuantityPage.verifyItemQuantityPage();
		itemQuantityPage.navigateToCheckoutPage();
		checkoutPage.verifyCheckoutPageLoad();
		Item checkoutProduct = checkoutPage.getProductDetailsFromCheckoutPage();
		
		Assert.assertTrue(itemProduct.getItemName().contains(checkoutProduct.getItemName()), "Product Name in Checkout not matching with Product Name in Item Details page");
		Assert.assertTrue(itemProduct.getitemPrice().substring(4).contains(checkoutProduct.getitemPrice().substring(4)), "Product Price in Checkout not matching with Product price in Item Details page");
		
		logger.info("Product details in Checkout Page is same as available in Item-Detail-Page ");
		
	}
}
