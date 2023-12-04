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

public class AdminLogs extends LoadDriver {

	public AdminLogs(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	static List<BufferedImage> captureMultipleImagesList = new ArrayList();
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[6]/a")
	private static WebElement DSM_Email_Admin_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"menu_container\"]/div[2]/a")
	private static WebElement DSM_Email_Logs_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[1]/a")
	private static WebElement DSM_Email_Login_logs_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/span")
	private static WebElement DSM_Email_Login_logs_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]")
	private static WebElement DSM_Email_Login_logs_Previous;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[2]/a")
	private static WebElement DSM_Email_Sent_Mail_Logs_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[10]/img")
	private static WebElement DSM_Email_Sent_Mail_logs_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]")
	private static WebElement DSM_Email_Sent_Mail_logs_Previous;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[3]/a")
	private static WebElement DSM_Email_Received_Mail_Logs_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[10]/img")
	private static WebElement DSM_Email_Received_Mail_logs_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]")
	private static WebElement DSM_Email_Received_Mail_logs_Previous;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[4]/a")
	private static WebElement DSM_Email_Edit_Logs_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[10]/img")
	private static WebElement DSM_Email_Edit_Mail_logs_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]")
	private static WebElement DSM_Email_Edit_Mail_logs_Previous;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[5]/a")
	private static WebElement DSM_Email_Feedback_Logs_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[2]")
	private static WebElement DSM_Email_Feedback_Mail_logs_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]")
	private static WebElement DSM_Email_Feedback_Mail_logs_Previous;	
	
	
	public static void Test_DSM_Email_Admin_Logs(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Test_DSM_Email_Admin_Logs *****************");

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());
			Thread.sleep(500);	
			if (driver.getTitle().startsWith("VA Direct Project")) {
				System.out.println("Inside loop");
				CommonUtil.click(driver, DSM_Email_Admin_Tab, 360);						
				
				CommonUtil.click(driver, DSM_Email_Logs_Tab, 360);
				// Read all data rows from excel file for DSM email Admin Logs
				Map<String, Map<String, String>> adminReports = ReadExcelData.readExcelFile(excelFilePath,sheetName);
				
				// Loop through the map object
				if (adminReports != null) {
					for (int k = 1; k < adminReports.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (adminReports.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Logs_Tab, 360);
								Thread.sleep(500);
							}
										
							Thread.sleep(500);
							if (adminReports.get(String.valueOf(k)).get("Login Logs") != null && adminReports.get(String.valueOf(k)).get("Login Logs").equals("Yes")) {
								DSM_Email_Login_logs_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Login_logs_Next.click();
								Thread.sleep(500);
								DSM_Email_Login_logs_Previous.click();
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Sent Mail Logs") != null && adminReports.get(String.valueOf(k)).get("Sent Mail Logs").equals("Yes")) {
								DSM_Email_Sent_Mail_Logs_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Sent_Mail_logs_Next.click();
								Thread.sleep(500);
								DSM_Email_Sent_Mail_logs_Previous.click();
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Received Mail Logs") != null && adminReports.get(String.valueOf(k)).get("Received Mail Logs").equals("Yes")) {
								DSM_Email_Received_Mail_Logs_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Received_Mail_logs_Next.click();
								Thread.sleep(500);
								DSM_Email_Received_Mail_logs_Previous.click();
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Edit Logs") != null && adminReports.get(String.valueOf(k)).get("Edit Logs").equals("Yes")) {
								DSM_Email_Edit_Logs_Tab.click();		
								Thread.sleep(500);
								DSM_Email_Edit_Mail_logs_Next.click();
								Thread.sleep(500);
								DSM_Email_Edit_Mail_logs_Previous.click();
							}
							Thread.sleep(1000);
							if (adminReports.get(String.valueOf(k)).get("Feedback Logs") != null && adminReports.get(String.valueOf(k)).get("Feedback Logs").equals("Yes")) {
								DSM_Email_Feedback_Logs_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Feedback_Mail_logs_Next.click();
								Thread.sleep(500);
								DSM_Email_Feedback_Mail_logs_Previous.click();
							}
							Thread.sleep(1000);

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
