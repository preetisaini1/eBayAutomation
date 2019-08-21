package com.ebay.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebay.common.modal.Item;
import com.ebay.pages.Checkout.CheckoutPageAssertions;
import com.ebay.pages.ItemQuantityPage.ItemQuantityPageAssertions;
import com.ebay.pages.Search.SearchPageLocators;
import com.ebay.pages.Search.SearchResultPageActions;
import com.ebay.pages.SignIn.SignInPageActions;
import com.ebay.pages.itemDetailPage.ItemDetailsPageAssertions;
import com.ebay.pages.LandingPage.LandingPageAssertions;

public class verifyLoginAddtoCartCheckoutFlow extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(verifyLoginAddtoCartCheckoutFlow.class);
	
	
	
	@Test (dataProvider = "TestData")
	public void verifyLogin_CheckoutFlow(String email, String password, String userId, String searchText )  {
		
		SignInPageActions signInPageActions = new SignInPageActions(driver,email,password,userId);
		
		ItemDetailsPageAssertions itemDetailsPage = new ItemDetailsPageAssertions(driver);
		ItemQuantityPageAssertions itemQuantityPage = new ItemQuantityPageAssertions(driver);
		CheckoutPageAssertions checkoutPage = new CheckoutPageAssertions(driver);
		LandingPageAssertions landingPage = new LandingPageAssertions(driver);
		SearchPageLocators searchPage = new SearchPageLocators(driver);
		SearchResultPageActions searchResultPage = new SearchResultPageActions(driver);
				
		signInPageActions.verifySignIn(driver);
		landingPage.navigateToSearchPage();
		searchPage.enterSearchText(searchText);
		searchResultPage.verifySearchResultPageLoad();
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
	
	