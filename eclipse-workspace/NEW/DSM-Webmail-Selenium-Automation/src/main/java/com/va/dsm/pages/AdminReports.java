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

public class AdminReports extends LoadDriver {

	public AdminReports(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	static List<BufferedImage> captureMultipleImagesList = new ArrayList();
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[6]/a")
	private static WebElement DSM_Email_Admin_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"menu_container\"]/div[1]/a")
	private static WebElement DSM_Email_Reports_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-0\"]/a")
	private static WebElement DSM_Email_Sent_Messages_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-1\"]/a")
	private static WebElement DSM_Email_Message_Success_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-2\"]/a")
	private static WebElement DSM_Email_Average_Size_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-3\"]/a")
	private static WebElement DSM_Email_Unique_Logins_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-4\"]/a")
	private static WebElement DSM_Email_Login_Success_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-5\"]/a")
	private static WebElement DSM_Email_Login_Errors_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tab-container-6\"]/a")
	private static WebElement DSM_Email_Attachment_Types_Tab;
	
	
	public static void Test_DSM_Email_Admin_Reports(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Test_DSM_Email_Admin_Reports *****************");

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());
			Thread.sleep(500);	
			if (driver.getTitle().startsWith("VA Direct Project")) {
				System.out.println("Inside loop");
				CommonUtil.click(driver, DSM_Email_Admin_Tab, 360);						
				
				CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);
				// Read all data rows from excel file for DSM email Admin Reports
				Map<String, Map<String, String>> adminReports = ReadExcelData.readExcelFile(excelFilePath,sheetName);
				
				// Loop through the map object
				if (adminReports != null) {
					for (int k = 1; k < adminReports.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (adminReports.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);
								Thread.sleep(500);
							}
										
							Thread.sleep(500);
							if (adminReports.get(String.valueOf(k)).get("Sent Messages") != null && adminReports.get(String.valueOf(k)).get("Sent Messages").equals("Yes")) {
								DSM_Email_Sent_Messages_Tab.click();								
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Message Success") != null && adminReports.get(String.valueOf(k)).get("Message Success").equals("Yes")) {
								DSM_Email_Message_Success_Tab.click();								
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Average Size") != null && adminReports.get(String.valueOf(k)).get("Average Size").equals("Yes")) {
								DSM_Email_Average_Size_Tab.click();							
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Unique Logins") != null && adminReports.get(String.valueOf(k)).get("Unique Logins").equals("Yes")) {
								DSM_Email_Unique_Logins_Tab.click();								
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Login Success") != null && adminReports.get(String.valueOf(k)).get("Login Success").equals("Yes")) {
								DSM_Email_Login_Success_Tab.click();								
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Login Errors") != null && adminReports.get(String.valueOf(k)).get("Login Errors").equals("Yes")) {
								DSM_Email_Login_Errors_Tab.click();								
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Attachment Types") != null && adminReports.get(String.valueOf(k)).get("Attachment Types").equals("Yes")) {
								DSM_Email_Attachment_Types_Tab.click();								
							}
							// Capture screenshot and click send button
							BufferedImage bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							
							//Capture multiple screenshot and save in the same word document
							CaptureScreenShots.captureMultipleScreenShotInSamePage(captureMultipleImagesList);
							Thread.sleep(500);
							
						}
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
}
