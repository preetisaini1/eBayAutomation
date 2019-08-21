package com.ebay.pages.SignIn;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.pages.MainMenu.MainMenuLocators;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SignInPageLocators extends EbayBasePage {

	public SignInPageLocators(AndroidDriver<MobileElement> driver) {
		super(driver);
		
	}

	private static final Logger logger = LogManager.getLogger(SignInPageLocators.class);

	By username = By.id(elementName("username"));
	By password = By.id(elementName("password"));
	By signIn = By.id(elementName("signInButton"));
	

	
	
	public void typeUsername(String email) {
		driver.findElement(username).sendKeys(email);
		logger.info("SignINPage-> email entered " + email);
		}
	
	public void typePassword(String Password) {
		driver.findElement(password).sendKeys(Password);
		logger.info("SignINPage-> password entered " + password);
		}
	
	public void clickOnSinInButton() {
		driver.findElement(signIn).click();
		logger.info("SignINPage-> Clicked on SignIn Button ");
		}
	
	
		
	}

