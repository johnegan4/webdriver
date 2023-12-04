package com.va.dsm.pages;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.va.dsm.util.CaptureScreenShots;
import com.va.dsm.util.CommonUtil;
import com.va.dsm.util.LoadDriver;
import com.va.dsm.util.ReadExcelData;

public class DirectorySearchInternalVA extends LoadDriver {

	public DirectorySearchInternalVA(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	static List<BufferedImage> captureMultipleImagesList = new ArrayList();
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[3]/a")
	private static WebElement DSM_Email_Directory_Search_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"basic-search-first-name\"]")
	private static WebElement DSM_Email_Search_Criteria_fname;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"basic-search-last-name\"]")
	private static WebElement DSM_Email_Search_Criteria_lname;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"basicSearch\"]")
	private static WebElement DSM_Email_Search_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"toggleToInternalSearch\"]")
	private static WebElement DSM_Email_Internal_VA_Address_Btn;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"toggleAdvancedSearch\"]/span")
	private static WebElement DSM_Email_Advanced_Search_Filter_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"internal-search-firstname\"]")
	private static WebElement DSM_Email_First_Name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"internal-search-lastname\"]")
	private static WebElement DSM_Email_Last_Name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"extAdvancedSearch\"]")
	private static WebElement DSM_Email_Advanced_Search_Filter_Search_btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"toggleToExternalSearch\"]")
	private static WebElement DSM_Email_Non_VA_Address_Link;	

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchResultsNextButton\"]")
	private static WebElement DSM_Email_Next_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchResultsPrevButton\"]")
	private static WebElement DSM_Email_Previous_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"intAdvancedSearch\"]")
	private static WebElement DSM_Email_Adv_Search_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cancel_button\"]")
	private static WebElement DSM_Email_Cancel_Btn;	

	public static void Test_DSM_Email_Directory_Search_InternalVA_Addresses(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Test_DSM_Email_Directory_Search_InternalVA_Addresses *****************");

		CommonUtil.click(driver, DSM_Email_Directory_Search_Tab, 360);						
		Thread.sleep(500);	

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());

			if (driver.getTitle().startsWith("VA Direct Project")) {

				CommonUtil.click(driver, DSM_Email_Internal_VA_Address_Btn, 360);
				// Read all data rows from excel file for DSM email Directory Search Internal VA Address
				Map<String, Map<String, String>> nonVAaddressExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
				
				// Loop through the map object
				if (nonVAaddressExcelData != null) {
					for (int k = 1; k < nonVAaddressExcelData.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (nonVAaddressExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Internal_VA_Address_Btn, 360);
								Thread.sleep(500);
							}
							
										
							Thread.sleep(500);
							if (nonVAaddressExcelData.get(String.valueOf(k)).get("Search") != null) {
								DSM_Email_Search_Criteria_fname.sendKeys(nonVAaddressExcelData.get(String.valueOf(k)).get("First Name"));
								Thread.sleep(200);
								DSM_Email_Search_Criteria_fname.sendKeys(Keys.ENTER);
								Thread.sleep(200);
								DSM_Email_Search_Criteria_lname.sendKeys(nonVAaddressExcelData.get(String.valueOf(k)).get("Last Name"));
								Thread.sleep(200);
								DSM_Email_Search_Criteria_lname.sendKeys(Keys.ENTER);
								Thread.sleep(200);
								DSM_Email_Search_Btn.click();
								Thread.sleep(500);
							}
							
						/*	if(driver.getPageSource().contains("Next")){
								CommonUtil.click(driver, DSM_Email_Next_Link, 360);
								Thread.sleep(500);
							}
							
							if(driver.getPageSource().contains("Previous")){								
								CommonUtil.click(driver, DSM_Email_Previous_Link, 360);
								Thread.sleep(500);
							}*/
							
							System.out.println("DSM_Email_Advanced_Search_Filter_Btn BEFORE->" + DSM_Email_Advanced_Search_Filter_Btn);
							//DSM_Email_Advanced_Search_Filter_Btn.click();
							CommonUtil.click(driver, DSM_Email_Advanced_Search_Filter_Btn, 360);	
							System.out.println("DSM_Email_Advanced_Search_Filter_Btn AFTER->" + DSM_Email_Advanced_Search_Filter_Btn);
							
							Thread.sleep(500);
							if (nonVAaddressExcelData.get(String.valueOf(k)).get("First Name") != null) {
								DSM_Email_First_Name.sendKeys(nonVAaddressExcelData.get(String.valueOf(k)).get("First Name"));
								Thread.sleep(200);
							}
							if (nonVAaddressExcelData.get(String.valueOf(k)).get("Last Name") != null) {
								DSM_Email_Last_Name.sendKeys(nonVAaddressExcelData.get(String.valueOf(k)).get("Last Name"));
								Thread.sleep(200);
							}
							Thread.sleep(500);
							DSM_Email_Adv_Search_Btn.click();
							
							// Capture screenshot and click send button
							BufferedImage bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							
							//Capture multiple screenshot and save in the same word document
							CaptureScreenShots.captureMultipleScreenShotInSamePage(captureMultipleImagesList);
							Thread.sleep(500);
							
						}
					}
					DSM_Email_Cancel_Btn.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
