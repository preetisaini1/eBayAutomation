package com.ebay.common.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.hpe.b2c.common.model.User;

public class ExcelReader {
	private static final Logger logger = LogManager.getLogger(ExcelReader.class);
	//private Environment environment;
	private static ExcelReader excelReader;
	private XSSFWorkbook xssfWorkbook;
	private Environment environment = Environment.getEnvironment();
	private String dataFile;

	public ExcelReader() {
		this.dataFile =  environment.getDataFile();
		initialize();
	}

	public static ExcelReader getExcelReader() {
		if (excelReader == null) {
			excelReader = new ExcelReader();
		}
		return excelReader;
	}

	public void initialize() {
		logger.info(" Reading File: " + "src\\test\\resources\\"+dataFile);
		try {
			FileInputStream fis = new FileInputStream("src\\test\\resources\\"+dataFile);
			xssfWorkbook = new XSSFWorkbook(fis);
		logger.info("Reading dataFile completed ");
		} catch (Exception e) {
			logger.error("Error while reading excel data file: ", e);
		}
	}

	public ArrayList<Object[]> getTestData()  {
		ArrayList<Object[]> testData = new ArrayList<Object[]>();
		XSSFSheet spreadsheet = xssfWorkbook.getSheet("Test Data");
		// get row count from the sheet
		int rownumbers = spreadsheet.getLastRowNum();
		logger.info(rownumbers);
		int firstRowNumber = spreadsheet.getFirstRowNum();
		logger.info(firstRowNumber);
		for (int row = firstRowNumber+1; row < rownumbers; row++) {
			XSSFRow currentrow = spreadsheet.getRow(row);
			// columns available
			String Email = currentrow.getCell(0).getStringCellValue();
			String Pwd = currentrow.getCell(1).getStringCellValue();
			String UserId = currentrow.getCell(2).getStringCellValue();
			String SearchText = currentrow.getCell(3).getStringCellValue();
			
			logger.info(String.format("[Email]: %s [Password] %s [UserId] %s [SearchText] %s ",Email,Pwd,UserId,SearchText));
					
			Object Ob[] = { Email, Pwd, UserId, SearchText };
			testData.add(Ob);
			}
		return testData;
	}


	

	
	

	
		
	

}
