package com.ebay.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.ebay.common.utils.AndroidDriverUtil;
import com.ebay.common.utils.Environment;
import com.ebay.common.utils.ExcelReader;
import com.ebay.pages.common.EbayBasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;;


public class BaseTest {
	
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	static Environment environment = Environment.getEnvironment();
	private AndroidDriverUtil androidDriverUtil;
	protected AndroidDriver<MobileElement> driver;
	protected String testName;
	private ExcelReader excelReader = ExcelReader.getExcelReader();
	
	
	@BeforeSuite
	public void initializeSuite() throws Exception {
		logger.info("EBAY: [" + this.getClass().getName() + "] Initializing Suite");
		//environment = Environment.getEnvironment();
		//WAIT_IN_SECONDS = environment.getWaitTime();
		androidDriverUtil = new AndroidDriverUtil();
		driver = androidDriverUtil.startApp();
			
	}
	
	@BeforeTest
	public void beforeTest() {
		String testCaseName = this.getClass().getName();
		logger.info("EBAY: [" + testCaseName + "] Starting Test");
		new EbayBasePage(driver);
	}

	@BeforeMethod
	public void startTest(ITestResult result) {
		logger.info("EBAY: [" + result.getMethod().getMethodName() + "] Before running test method");
	}

	
	@AfterSuite
	public void completeTest() {
		logger.info("EBAY: [" + this.getClass().getName() + "] Completing Test");
		androidDriverUtil.closeDriver();
		//andriod.closeWebPage();
		if (driver != null) {
			androidDriverUtil.closeDriver();
		}
		logger.info("EBAY: [" + this.getClass().getName() + "] Ending Test");
	}
	
	@DataProvider(name="TestData")
	public Iterator<Object[]> TestDataFeed() {
		ArrayList<Object[]> testData = excelReader.getTestData();
	    return testData.iterator();
	}
		
}
