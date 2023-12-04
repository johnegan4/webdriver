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

public class AdminManageUsers extends LoadDriver {

	public AdminManageUsers(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	static List<BufferedImage> captureMultipleImagesList = new ArrayList();
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[6]/a")
	private static WebElement DSM_Email_Admin_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"menu_container\"]/div[3]/a/img")
	private static WebElement DSM_Email_Manage_Users_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page_list\"]/li[2]/a")
	private static WebElement DSM_Email_Manage_Users_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page_list\"]/li[1]/a")
	private static WebElement DSM_Email_Manage_Users_Previous;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"manage_users\"]/table/tbody/tr[2]/td[6]/a[2]/img")
	private static WebElement DSM_Email_Manage_Users_Remove_user;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"manage_users\"]/table/tbody/tr[2]/td[6]/a[1]/img")
	private static WebElement DSM_Email_Manage_Users_Edit_user;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[4]/div/div/div/div/form/div[2]/div/input")
	private static WebElement DSM_Email_Manage_Users_Middle_Name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"manage_users\"]/div/div/form/button")
	private static WebElement DSM_Email_Manage_Users_Update_Btn;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div[2]/a")
	private static WebElement DSM_Email_Manage_Removed_Users_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page_list\"]/li[2]/a")
	private static WebElement DSM_Email_Manage_Removed_Users_Next;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page_list\"]/li[1]/a")
	private static WebElement DSM_Email_Manage_Removed_Users_Previous;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/div[3]/a")
	private static WebElement DSM_Email_Manual_Account_Creation_Tab;
	
	
	
	public static void Test_DSM_Email_Admin_Manage_Users(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Test_DSM_Email_Admin_Manage_Users *****************");

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());
			Thread.sleep(500);	
			if (driver.getTitle().startsWith("VA Direct Project")) {
				System.out.println("Inside loop");
				CommonUtil.click(driver, DSM_Email_Admin_Tab, 360);						
				
				CommonUtil.click(driver, DSM_Email_Manage_Users_Tab, 360);
				// Read all data rows from excel file for DSM email Admin Manage Users
				Map<String, Map<String, String>> adminManageUsers= ReadExcelData.readExcelFile(excelFilePath,sheetName);
				
				// Loop through the map object
				if (adminManageUsers != null) {
					for (int k = 1; k < adminManageUsers.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (adminManageUsers.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Manage_Users_Tab, 360);
								Thread.sleep(500);
							}
										
							Thread.sleep(500);
							if (adminManageUsers.get(String.valueOf(k)).get("Manage Users") != null && adminManageUsers.get(String.valueOf(k)).get("Manage Users").equals("Yes")) {
								DSM_Email_Manage_Users_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Manage_Users_Next.click();
								Thread.sleep(500);
								DSM_Email_Manage_Users_Previous.click();
							}
							Thread.sleep(1000);
							if (adminManageUsers.get(String.valueOf(k)).get("Manage Users - Delete") != null && adminManageUsers.get(String.valueOf(k)).get("Manage Users - Delete").equals("Yes")) {
								DSM_Email_Manage_Users_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Manage_Users_Remove_user.click();	
								Thread.sleep(500);
								driver.switchTo().alert().accept();
								Thread.sleep(500);
							}
							if (adminManageUsers.get(String.valueOf(k)).get("Manage Users - Edit") != null && adminManageUsers.get(String.valueOf(k)).get("Manage Users - Edit").equals("Yes")) {
								DSM_Email_Manage_Users_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Manage_Users_Edit_user.click();	
								Thread.sleep(500);
								DSM_Email_Manage_Users_Middle_Name.sendKeys(adminManageUsers.get(String.valueOf(k)).get("Manage Users - Edit - Middle Name"));
								Thread.sleep(200);
								DSM_Email_Manage_Users_Update_Btn.click();
								Thread.sleep(500);
							}
							if (adminManageUsers.get(String.valueOf(k)).get("Manage Removed Users") != null && adminManageUsers.get(String.valueOf(k)).get("Manage Removed Users").equals("Yes")) {
								DSM_Email_Manage_Removed_Users_Tab.click();	
								Thread.sleep(500);
								DSM_Email_Manage_Removed_Users_Next.click();
								Thread.sleep(500);
								DSM_Email_Manage_Removed_Users_Previous.click();
								Thread.sleep(500);
							}
							if (adminManageUsers.get(String.valueOf(k)).get("Manual Account Creation") != null && adminManageUsers.get(String.valueOf(k)).get("Manual Account Creation").equals("Yes")) {
								DSM_Email_Manual_Account_Creation_Tab.click();	
								Thread.sleep(500);
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
