package com.ebay.common.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverUtil {
	static final Logger logger = LogManager.getLogger(AndroidDriverUtil.class);
	
	private AndroidDriver<MobileElement> driver;
	private Environment environment = new Environment();
	private DesiredCapabilities capabilities = null;
	
	public AndroidDriverUtil() {
		initializeApp();
				
	}
	
	
	//private static AndroidDriverUtil androidDriverUtil = new AndroidDriverUtil();
	
	//public static AndroidDriverUtil getAndroidDriverUtil() {
		//	return androidDriverUtil;
	//}
	
	public DesiredCapabilities initializeApp(){
	capabilities = new DesiredCapabilities();
	//cap.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
	capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, environment.getPlatform_version());
	capabilities.setCapability(MobileCapabilityType.UDID, environment.getUdid());
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, environment.getDevice_name());
	capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,environment.getApp_package());
	capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, environment.getApp_activity());
	logger.info("Android Environment is initialised with DesiredCapabilities ");
	logger.info(environment);
	return capabilities;
	}
	
	public AndroidDriver<MobileElement> startApp(){
		try
		{driver = new AndroidDriver<MobileElement>( new URL(environment.getAppium_url()), capabilities);
		logger.info("EBAY Application Started ");
		
	} catch (Exception exp) {
		// TODO Auto-generated catch block
		logger.error("Error while loading Ebay Application: ", exp);
	}
		return driver;
	}

	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}

}

