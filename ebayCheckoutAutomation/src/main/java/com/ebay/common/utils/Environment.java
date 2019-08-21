package com.ebay.common.utils;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class Environment {
	
	static final Logger logger = LogManager.getLogger(Environment.class);
	private String platform_name;
	private String device_name;
	private String udid;
	private String platform_version;
	private String app_package;
	private String app_activity;
	private String appium_url;
	private String dataFile;
	private String explicitWaitTimeInSeconds;
	private String implicitWaitTimeInSeconds;
	private static final String NOT_FOUND = "Not Found";
	private static Environment environment = null;
	static java.util.Properties property = new Properties();
	static FileInputStream fileInputStream = null;
	

    final static void loadProperty() {
    	try {
    	fileInputStream = new FileInputStream("src\\main\\resources\\android.properties");
        property.load(fileInputStream);
        logger.info(" Reading android.property File completed " );
    	            	}
    	catch (Exception exp) {
    		logger.error("Error while reading excel data file: ", exp);
    		
    	}
		    }
	public Environment() {
		loadProperty();
		setPlatform_name();
		setDevice_name();
		setUdid();
		setPlatform_version();
		setApp_package();
		setApp_activity();
		setAppium_url();
		setExplicitWaitTime();
		setImplicitWaitTime();
		setDataFile();
	}
	
	public static Environment getEnvironment() {
		if (environment == null) {
			environment = new Environment();
		}
		return environment;
	}
	
	public String getPlatform_name() {
		return platform_name;
	}

	private final void setPlatform_name() {
		this.platform_name = property.getProperty("platform_name");
		//this.platform_name = property.getProperty(platform_name, "ANDROID");
	}

	public String getDevice_name() {
		return device_name;
	}

	private final void setDevice_name() {
		this.device_name = property.getProperty("device_name");
		//this.device_name = property.getProperty(device_name, "My MI");
	}

	private final void setUdid() {
		this.udid = property.getProperty("udid");
	}

	public String getUdid() {
		return udid;
	}

	private final void setPlatform_version() {
		this.platform_version = property.getProperty("platform_version");
	}

	public String getPlatform_version() {
		return platform_version;
	}

	private final void setApp_package() {
		this.app_package = property.getProperty("app_package");
	}

	public String getApp_package() {
		return app_package;
	}
	
	private final void setApp_activity() {
		this.app_activity = property.getProperty("app_activity");
	}

	public String getApp_activity() {
		return app_activity;
	}
	
	private final void setAppium_url() {
		this.appium_url = property.getProperty("appium_url");
	}

	public String getAppium_url() {
		return appium_url;
	}
	
	private final void setDataFile() {
		this.dataFile = property.getProperty("dataFile");
	}

	public String getDataFile() {
		return dataFile;
	}

	//setExpicitiWaitTime	
	private final void setExplicitWaitTime() {
		this.explicitWaitTimeInSeconds= property.getProperty("explicitWaitTimeInSeconds");
	}
	
	public String getExplicitWaitTime() {
		return explicitWaitTimeInSeconds;
	}
	
	private final void setImplicitWaitTime() {
		this.implicitWaitTimeInSeconds= property.getProperty("implicitWaitTimeInSeconds");
		}
	
	public String getImplicitWaitTime() {
		return implicitWaitTimeInSeconds;
	}
	
	public String getElementName(String key) {
		String value = property.getProperty(key, NOT_FOUND);
		if (NOT_FOUND.equals(value)) {
			logger.error(" No Mapping found for key %s. Check config.properties ", key);
		}
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("[Platform_Name]: %s [Platform_Version]: %s [Device_name]: %s [UDID]: %s [App_Package]: %s [App_Activity]: %s [Appium_URL]: %s [DATA FILE]: %s ",platform_name,platform_version,device_name,udid,app_package,app_activity,appium_url,dataFile );
	}
}
