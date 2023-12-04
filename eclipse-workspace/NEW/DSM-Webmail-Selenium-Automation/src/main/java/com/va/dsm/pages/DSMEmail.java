package com.va.dsm.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.va.dsm.util.CommonUtil;
import com.va.dsm.util.LoadDriver;
import com.va.dsm.util.ReadExcelData;
import com.va.dsm.util.CaptureScreenShots;

public class DSMEmail extends LoadDriver {

	public DSMEmail(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	static List<BufferedImage> captureMultipleImagesList = new ArrayList();
	
	private static WebElement webElement= null;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/button")
	private static WebElement DSM_Email_Compose_Button;

	@FindBy(how = How.XPATH, using = "//*[@id=\"token-input-message_to\"]")
	private static WebElement DSM_Email_Compose_To;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"show-cc\"]")
	private static WebElement DSM_Email_Compose_CC_Link;

	@FindBy(how = How.XPATH, using = "//*[@id=\"token-input-message_cc\"]")
	private static WebElement DSM_Email_Compose_CC;

	@FindBy(how = How.XPATH, using = "//*[@id=\"priority\"]")
	private static WebElement DSM_Email_Compose_Importance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"message_subject\"]")
	private static WebElement DSM_Email_Compose_Subject;

	//@FindBy(how = How.XPATH, using = "//*[@id=\"compose_form\"]/tbody/tr[9]/td/div/div[1]/a")
	@FindBy(how = How.XPATH, using = "//*[@id=\"compose_body\"]/div[8]/div/div[2]/div[1]/div/div")
	private static WebElement DSM_Email_Compose_Body_Link;
	
	//@FindBy(how = How.XPATH, using = "//*[@id=\"message_body\"]")
	@FindBy(how = How.XPATH, using = "//*[@id=\"editor\"]")
	private static WebElement DSM_Email_Compose_Body;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"send_btn\"]")
	private static WebElement DSM_Email_Compose_Send_Button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/div/button[1]")
	private static WebElement DSM_Email_Compose_Send_Button_Popup;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox_list\"]/li[1]/a")
	private static WebElement DSM_Email_Inbox_Link;

	//@FindBy(how = How.XPATH, using = "//*[@id=\"attach_row\"]/td[2]/a[1]")
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/form[1]/div[2]/div/div[6]/a[1]")
	private static WebElement DSM_Email_Attachment_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"attach-patient-document\"]")
	private static WebElement DSM_Email_VA_CCD_Attachment_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"given-name-field\"]")
	private static WebElement DSM_Email_VA_CCD_Given_Name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"family-name-field\"]")
	private static WebElement DSM_Email_VA_CCD_Family_Name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"area_number\"]")
	private static WebElement DSM_Email_VA_CCD_SSN_Area_Number;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"group_number\"]")
	private static WebElement DSM_Email_VA_CCD_SSN_Group_Number;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"serial_number\"]")
	private static WebElement DSM_Email_VA_CCD_SSN_Serial_Number;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"patient_lookup_form_button_find_matching\"]")
	private static WebElement DSM_Email_VA_CCD_Find_Matching_Patients_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"form-dialog-container\"]/div/form/div/ul/li/label/input")
	private static WebElement DSM_Email_VA_CCD_Select_Patient;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[8]/div[3]/div/button[1]")
	private static WebElement DSM_Email_VA_CCD_Attach_Document_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"compose_form\"]/tbody/tr[9]/td/div/div[1]/a")
	private static WebElement DSM_Email_VA_CCD_Attach_Document_Visible;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox_list\"]/li[7]/a")
	private static WebElement DSM_Email_Create_Folder_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div[3]/div/button[2]")
	private static WebElement DSM_Email_Create_Folder_Close_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"name-field\"]")
	private static WebElement DSM_Email_New_Folder_Name;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div[3]/div/button[1]")
	private static WebElement DSM_Email_Create_Folder_Create_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"parent-id-field\"]")
	private static WebElement DSM_Email_Parent_Folder_Drop_Down;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox_list\"]/li[3]/a")
	private static WebElement DSM_Email_Drafts_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"msg_pane\"]")
	private static WebElement DSM_Email_Drafts_Message_Pane;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"messages\"]/tbody/tr[2]/td[3]")
	private static WebElement DSM_Email_Drafts_Recipient;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"messages\"]/tbody/tr[2]/td[1]")
	private static WebElement DSM_Email_Drafts_Checkbox;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"archive_btn\"]")
	private static WebElement DSM_Email_Drafts_Archive_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"discard_btn\"]")
	private static WebElement DSM_Email_Drafts_Discard_Button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div[3]/div/button[1]")
	private static WebElement DSM_Email_Drafts_Discard_Yes_Confirm_Button;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div[3]/div/button[2]")
	private static WebElement DSM_Email_Drafts_Discard_No_Confirm_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox_list\"]/li[4]/a")
	private static WebElement DSM_Email_Archive_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"get_mail_btn\"]")
	private static WebElement DSM_Email_Get_Mail_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"filter_btn\"]")
	private static WebElement DSM_Email_All_Filter_Button;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dropdown-filter\"]/ul/li[1]/a")
	private static WebElement DSM_Email_All_Filter_link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dropdown-filter\"]/ul/li[2]/a")
	private static WebElement DSM_Email_Inbox_Filter_link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dropdown-filter\"]/ul/li[3]/a")
	private static WebElement DSM_Email_Sent_Filter_link;				
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/form/div[2]/table/tbody/tr[2]/td[1]/input")
	private static WebElement DSM_Email_Archive_Select_Row1;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/form/div[2]/table/tbody/tr[3]/td[1]/input")
	private static WebElement DSM_Email_Archive_Select_Row2;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/form/div[2]/table/tbody/tr[1]/th[1]/input")
	private static WebElement DSM_Email_Archive_Select_All;				
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dropdown-filter\"]/ul/li[4]/a")
	private static WebElement DSM_Email_Drafts_Filter_link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]/span/img")
	private static WebElement DSM_Email_Archive_Pagination_Next;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[2]/span/img")
	private static WebElement DSM_Email_Archive_Pagination_Previous;	

	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a/span/img")
	private static WebElement DSM_Email_Pagination;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"move_btn\"]")
	private static WebElement DSM_Email_Archive_Move_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"move_menu\"]/ul/li[3]/a")
	private static WebElement DSM_Email_Archive_Move_Drafts_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox_list\"]/li[5]/a")
	private static WebElement DSM_Email_Outbox_Link;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"msg_pane\"]")
	private static WebElement DSM_Email_Outbox_Message;		

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/form/div[2]/table/tbody/tr[2]/td[1]/input")
	private static WebElement DSM_Email_Inbox_Select_Row1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"more_button\"]")
	private static WebElement DSM_Email_Inbox_More_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dropdown-1\"]/ul/li[1]/a")
	private static WebElement DSM_Email_Inbox_Read;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"dropdown-1\"]/ul/li[2]/a")
	private static WebElement DSM_Email_Inbox_Unread;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"archive_btn\"]")
	private static WebElement DSM_Email_Inbox_Archive_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a/span/img")
	private static WebElement DSM_Email_Inbox_Pagination_Next;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]/span/img")
	private static WebElement DSM_Email_Inbox_Pagination_Previous;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox_list\"]/li[2]/a")
	private static WebElement DSM_Email_Sent_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/form/div[2]/table/tbody/tr[2]/td[1]/input")
	private static WebElement DSM_Email_Sent_Select_Row1;						

	@FindBy(how = How.XPATH, using = "//*[@id=\"archive_btn\"]")
	private static WebElement DSM_Email_Sent_Archive_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a/span/img")
	private static WebElement DSM_Email_Sent_Pagination_Next;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"pagination\"]/a[1]/span/img")
	private static WebElement DSM_Email_Sent_Pagination_Previous;	

	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[1]/a")
	private static WebElement DSM_Email_Mail_Box_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[5]/a")
	private static WebElement DSM_Email_Reports_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[2]/a")
	private static WebElement DSM_Email_Settings_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"accountsettings\"]")
	private static WebElement DSM_Email_Account_Settings_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"first-name-field\"]")
	private static WebElement DSM_Email_Account_Settings_FirstName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-name-field\"]")
	private static WebElement DSM_Email_Account_Settings_MiddleName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"last-name-field\"]")
	private static WebElement DSM_Email_Account_Settings_LastName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"default-mailbox-field\"]")
	private static WebElement DSM_Email_Account_Settings_Default_Mailbox;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"job-title-field\"]")
	private static WebElement DSM_Email_Account_Settings_Job_Title;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"department-field\"]")
	private static WebElement DSM_Email_Account_Settings_Department;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"organization-field\"]")
	private static WebElement DSM_Email_Account_Settings_Organization;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"telephone-field\"]")
	private static WebElement DSM_Email_Account_Settings_Telephone;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mobile-field\"]")
	private static WebElement DSM_Email_Account_Settings_Mobile;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"publish_in_dtd\"]")
	private static WebElement DSM_Email_Account_Settings_Direct_Trust;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"address_line1\"]")
	private static WebElement DSM_Email_Account_Settings_Addr1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"address_line2\"]")
	private static WebElement DSM_Email_Account_Settings_Addr2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"city-field\"]")
	private static WebElement DSM_Email_Account_Settings_City;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"state-field\"]")
	private static WebElement DSM_Email_Account_Settings_State;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip-field\"]")
	private static WebElement DSM_Email_Account_Settings_Zip;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"country-field\"]")
	private static WebElement DSM_Email_Account_Settings_Country;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"facility-id-field\"]")
	private static WebElement DSM_Email_Account_Settings_Facility;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"npi-field\"]")
	private static WebElement DSM_Email_Account_Settings_NPI;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"nucc-markup-container\"]/div/button")
	private static WebElement DSM_Email_Account_Settings_Speciality;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"set_default_nucc\"]")
	private static WebElement DSM_Email_Account_Settings_NonClinical_VA;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div/form/button")
	private static WebElement DSM_Email_Account_Settings_Update_Btn;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div[3]/div/button[1]")
	private static WebElement DSM_Email_Account_Settings_I_Agree_Btn;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"notificationsettings\"]")
	private static WebElement DSM_Email_Notification_Settings_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ext_mail\"]")
	private static WebElement DSM_Email_Notification_Settings_External_Email ;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"applicationsettings\"]")
	private static WebElement DSM_Email_Application_Settings_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	private static WebElement DSM_Email_Application_Settings_Country;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"timezone\"]")
	private static WebElement DSM_Email_Application_Settings_Timezone;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div/form/button")
	private static WebElement DSM_Email_Application_Settings_Update_Information_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"change_service_permission\"]")
	private static WebElement DSM_Email_Application_Settings_Change_Service_Permission_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"close_permissions\"]")
	private static WebElement DSM_Email_Application_Settings_Close_Btn;		
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"automaticreplies\"]")
	private static WebElement DSM_Email_Automatic_Replies_Tab;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"save\"]")
	private static WebElement DSM_Email_Automatic_Replies_Save_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"start-date\"]")
	private static WebElement DSM_Email_Automatic_Replies_Start_Date;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"end-date\"]")
	private static WebElement DSM_Email_Automatic_Replies_End_Date;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div[2]/button[1]")
	private static WebElement DSM_Email_Automatic_Replies_End_Date_Today;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"start-time\"]")
	private static WebElement DSM_Email_Automatic_Replies_Start_Time;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"end-time\"]")
	private static WebElement DSM_Email_Automatic_Replies_End_Time;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"editor\"]")
	private static WebElement DSM_Email_Automatic_Replies_Body;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"optionbar_menu\"]/span[4]/a")
	private static WebElement DSM_Email_Feedback_Tab;

	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div[3]/div/button[1]") 
	private static WebElement DSM_Email_Feedback_Submit_Btn;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[9]/div[3]/div/button[2]")
	private static WebElement DSM_Email_Feedback_Cancel_Btn;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin_menu\"]/div/div/a")
	private static WebElement DSM_Email_Reports_Mailbox_Activities_Tab;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cb-selected_user\"]")
	private static WebElement DSM_Email_Reports_Users;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"start_date\"]")
	private static WebElement DSM_Email_Reports_StartDate;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"end-date\"]")
	private static WebElement DSM_Email_Reports_EndDate;			
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div[2]/button[1]")
	private static WebElement DSM_Email_Reports_StartDate_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div[2]/button[1]")
	private static WebElement DSM_Email_Reports_EndDate_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"filter_button\"]")
	private static WebElement DSM_Email_Reports_Filter_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"clear_button\"]")
	private static WebElement DSM_Email_Reports_Clear_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div[3]/button[2]") 
	private static WebElement DSM_Email_Reports_Done_Btn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"reports_form\"]/div[3]/a[1]/img")
	private static WebElement DSM_Email_Reports_Export_To_Excel;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"reports_form\"]/div[3]/a[2]/img")
	private static WebElement DSM_Email_Reports_Export_To_PDF;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"reports_form\"]/div[3]/a[3]/img")
	private static WebElement DSM_Email_Reports_Send_To_Printer;
	
	// Test DSM Email Compose with No Attachment
	public static void Test_DSM_Email_Compose_No_Attachment(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** In DSM Email Compose with No Attachment *****************");
		Thread.sleep(200);

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());

			if (driver.getTitle().startsWith("VA Direct Project")) {

				CommonUtil.click(driver, DSM_Email_Compose_Button, 360);
				Thread.sleep(500);

				// Read all data rows from excel file for DSM email no attachment in map object
				Map<String, Map<String, String>> noAttachmentExcelData = ReadExcelData.readExcelFile(excelFilePath,
						sheetName);
				
				// Loop through the map object
				if (noAttachmentExcelData != null) {
					for (int k = 1; k < noAttachmentExcelData.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (noAttachmentExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Compose_Button, 360);
								Thread.sleep(500);
							}
							
										
							Thread.sleep(500);
							if (noAttachmentExcelData.get(String.valueOf(k)).get("To") != null) {
								DSM_Email_Compose_To.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("To"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							Thread.sleep(500);
							if (noAttachmentExcelData.get(String.valueOf(k)).get("To-1") != null) {
								DSM_Email_Compose_To.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("To-1"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							Thread.sleep(500);
							if (noAttachmentExcelData.get(String.valueOf(k)).get("To-2") != null) {
								DSM_Email_Compose_To.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("To-2"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							// Click Add CC link
							//CommonUtil.click(driver, DSM_Email_Compose_CC_Link, 360);
							Thread.sleep(1000);

							if (noAttachmentExcelData.get(String.valueOf(k)).get("Add CC") != null) {
								DSM_Email_Compose_CC.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Add CC"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							if (noAttachmentExcelData.get(String.valueOf(k)).get("Add CC-1") != null) {
								DSM_Email_Compose_CC.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Add CC-1"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							if (noAttachmentExcelData.get(String.valueOf(k)).get("Add CC-2") != null) {
								DSM_Email_Compose_CC.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Add CC-2"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							// Select Importance
							if (noAttachmentExcelData.get(String.valueOf(k)).get("Importance") != null) {
								DSM_Email_Compose_Importance.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Importance"));
								Thread.sleep(200);
								DSM_Email_Compose_Importance.sendKeys(Keys.ENTER);
							}

							// Enter Subject
							if (noAttachmentExcelData.get(String.valueOf(k)).get("Subject") != null) {
								DSM_Email_Compose_Subject.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Subject"));
								Thread.sleep(200);
							}
							
							Thread.sleep(30000);
							
							// Enter Body											
							if (noAttachmentExcelData.get(String.valueOf(k)).get("Body") != null) {
								CommonUtil.click(driver, DSM_Email_Compose_Body_Link, 360);	
								Thread.sleep(200);
								System.out.println("DSM Email - Body - "+noAttachmentExcelData.get(String.valueOf(k)).get("Body"));
								//DSM_Email_Compose_Body.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Body"));
								DSM_Email_Compose_Body_Link.sendKeys(noAttachmentExcelData.get(String.valueOf(k)).get("Body"));
								Thread.sleep(200);
							}
							
							// Capture screenshot and click send button
							BufferedImage bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(1000);
							CommonUtil.click(driver, DSM_Email_Compose_Send_Button, 360);
							Thread.sleep(1000);
							
							// Capture popup screenshot and click send button							
							bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							CommonUtil.click(driver, DSM_Email_Compose_Send_Button_Popup, 360);
							Thread.sleep(1000);		
							
							// Click Inbox link and capture screenshot 
							CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
							bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							
							//Capture multiple screenshot and save in the same word document
							CaptureScreenShots.captureMultipleScreenShotInSamePage(captureMultipleImagesList);
							Thread.sleep(500);
							
						}
					}
				}
			}
			CommonUtil.click(driver, DSM_Email_Sent_Link, 360);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	// Test DSM Email Compose with Attachment
	public static void Test_DSM_Email_Compose_With_Attachment(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** In DSM Email Compose with Attachment *****************");
		Thread.sleep(500);

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());

			if (driver.getTitle().startsWith("VA Direct Project")) {

				CommonUtil.click(driver, DSM_Email_Compose_Button, 360);
				Thread.sleep(500);

				// Read all data rows from excel file for DSM email with attachment in map object
				Map<String, Map<String, String>> attachmentExcelData = ReadExcelData.readExcelFile(excelFilePath,
						sheetName);
				
				// Loop through the map object
				if (attachmentExcelData != null) {
					for (int k = 1; k < attachmentExcelData.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (attachmentExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Compose_Button, 360);
								Thread.sleep(500);
							}
							
										
							Thread.sleep(500);
							if (attachmentExcelData.get(String.valueOf(k)).get("To") != null) {
								DSM_Email_Compose_To.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("To"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							Thread.sleep(500);
							if (attachmentExcelData.get(String.valueOf(k)).get("To-1") != null) {
								DSM_Email_Compose_To.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("To-1"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							Thread.sleep(500);
							if (attachmentExcelData.get(String.valueOf(k)).get("To-2") != null) {
								DSM_Email_Compose_To.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("To-2"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							// Click Add CC link
							//CommonUtil.click(driver, DSM_Email_Compose_CC_Link, 360);
							Thread.sleep(1000);

							if (attachmentExcelData.get(String.valueOf(k)).get("Add CC") != null) {
								DSM_Email_Compose_CC.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Add CC"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							if (attachmentExcelData.get(String.valueOf(k)).get("Add CC-1") != null) {
								DSM_Email_Compose_CC.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Add CC-1"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							if (attachmentExcelData.get(String.valueOf(k)).get("Add CC-2") != null) {
								DSM_Email_Compose_CC.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Add CC-2"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}


							// Enter Subject
							if (attachmentExcelData.get(String.valueOf(k)).get("Subject") != null) {
								DSM_Email_Compose_Subject.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Subject"));
								Thread.sleep(200);
							}
							
							// Select Importance
							if (attachmentExcelData.get(String.valueOf(k)).get("Importance") != null) {
								DSM_Email_Compose_Importance.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Importance"));
								Thread.sleep(200);
								DSM_Email_Compose_Importance.sendKeys(Keys.ENTER);
							}
							DSM_Email_Compose_Importance.sendKeys(Keys.TAB);
							Thread.sleep(20000);
							
							System.out.println("DSM Email - Before Attach");

							// Attach a file							
							if (attachmentExcelData.get(String.valueOf(k)).get("Attach File") != null) {		
								System.out.println("DSM Email - Before Attach Click -->"+DSM_Email_Attachment_Link);
								//CommonUtil.click(driver, DSM_Email_Attachment_Link, 360);
								DSM_Email_Attachment_Link.sendKeys(Keys.ENTER);
								System.out.println("DSM Email - After Attach Click");
								CommonUtil.setClipboardData(attachmentExcelData.get(String.valueOf(k)).get("Attach File"));
								Thread.sleep(500);
								//native key strokes for CTRL, V and ENTER keys
								Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_CONTROL);
								robot.keyPress(KeyEvent.VK_V);
								robot.keyRelease(KeyEvent.VK_V);
								robot.keyRelease(KeyEvent.VK_CONTROL);
								robot.keyPress(KeyEvent.VK_ENTER);
								robot.keyRelease(KeyEvent.VK_ENTER);

								Thread.sleep(1000);								
							}
							
							Thread.sleep(300);
							
							// Enter Body											
							if (attachmentExcelData.get(String.valueOf(k)).get("Body") != null) {
								CommonUtil.click(driver, DSM_Email_Compose_Body_Link, 360);	
								Thread.sleep(200);
								//DSM_Email_Compose_Body.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Body"));
								DSM_Email_Compose_Body_Link.sendKeys(attachmentExcelData.get(String.valueOf(k)).get("Body"));
								Thread.sleep(200);
							}
							
							// Capture screenshot and click send button
							BufferedImage bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(1000);
							CommonUtil.click(driver, DSM_Email_Compose_Send_Button, 360);
							Thread.sleep(1000);
							
							// Capture popup screenshot and click send button							
							bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							CommonUtil.click(driver, DSM_Email_Compose_Send_Button_Popup, 360);
							Thread.sleep(1000);		
							
							// Click Inbox link and capture screenshot 
							CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
							bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							
							//Capture multiple screenshot and save in the same word document
							CaptureScreenShots.captureMultipleScreenShotInSamePage(captureMultipleImagesList);
							Thread.sleep(500);
							
						}
					}
				}
				CommonUtil.click(driver, DSM_Email_Sent_Link, 360);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	
	// Test DSM Email Compose with VA CCD Attachment
	public static void Test_DSM_Email_Compose_With_CCD_Attachment(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** In DSM Email Compose with VA CCD Attachment *****************");
		Thread.sleep(200);

		try {
			System.out.println("DSM Email - Title ->" + driver.getTitle());

			if (driver.getTitle().startsWith("VA Direct Project")) {

				CommonUtil.click(driver, DSM_Email_Compose_Button, 360);
				Thread.sleep(500);

				// Read all data rows from excel file for DSM Email with CCD Attachment in map object
				Map<String, Map<String, String>> ccdAttachmentExcelData = ReadExcelData.readExcelFile(excelFilePath,
						sheetName);
				
				// Loop through the map object
				if (ccdAttachmentExcelData != null) {
					for (int k = 1; k < ccdAttachmentExcelData.size() + 1; k++) {
						
						// Execute the script only if Run Script is set to Yes
						if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
							
							// Refresh page after first test case execution
							if (k > 1) {
								CommonUtil.click(driver, DSM_Email_Compose_Button, 360);
								Thread.sleep(500);
							}
							
										
							Thread.sleep(500);
							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("To") != null) {
								DSM_Email_Compose_To.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("To"));
								Thread.sleep(200);
								System.out.println("DSM Email - CCD - Before Enter");
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
								System.out.println("DSM Email - CCD - After Enter");
							}

							Thread.sleep(500);
							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("To-1") != null) {
								DSM_Email_Compose_To.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("To-1"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							Thread.sleep(500);
							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("To-2") != null) {
								DSM_Email_Compose_To.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("To-2"));
								Thread.sleep(200);
								DSM_Email_Compose_To.sendKeys(Keys.ENTER);
							}

							// Click Add CC link
							//CommonUtil.click(driver, DSM_Email_Compose_CC_Link, 360);
							Thread.sleep(1000);

							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Add CC") != null) {
								DSM_Email_Compose_CC.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Add CC"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Add CC-1") != null) {
								DSM_Email_Compose_CC.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Add CC-1"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Add CC-2") != null) {
								DSM_Email_Compose_CC.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Add CC-2"));
								Thread.sleep(200);
								DSM_Email_Compose_CC.sendKeys(Keys.ENTER);
							}

							// Select Importance
							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Importance") != null) {
								DSM_Email_Compose_Importance.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Importance"));
								Thread.sleep(200);
								DSM_Email_Compose_Importance.sendKeys(Keys.ENTER);
							}

							// Enter Subject
							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Subject") != null) {
								DSM_Email_Compose_Subject.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Subject"));
								Thread.sleep(200);
							}
							
							Thread.sleep(6000);
							System.out.println("DSM Email - CCD - Before CCD Attachment");
							// Attach a VA CCD							
							if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Attach a VA CCD") != null) {								
								CommonUtil.click(driver, DSM_Email_VA_CCD_Attachment_Link, 360);								
								Thread.sleep(1000);								
								
								DSM_Email_VA_CCD_Given_Name.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Given Name"));
								Thread.sleep(1000);
								DSM_Email_VA_CCD_Family_Name.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Family Name"));
								Thread.sleep(500);
								DSM_Email_VA_CCD_SSN_Area_Number.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("SSN Area Number"));
								Thread.sleep(500);
								DSM_Email_VA_CCD_SSN_Group_Number.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("SSN Group Number"));
								Thread.sleep(500);
								DSM_Email_VA_CCD_SSN_Serial_Number.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("SSN Serial Number"));
								Thread.sleep(500);

								CommonUtil.click(driver, DSM_Email_VA_CCD_Find_Matching_Patients_Button, 360);
								Thread.sleep(1000);
								CommonUtil.waitforelementToBeVisible("ui-id-2");																
								
								DSM_Email_VA_CCD_Select_Patient.click();
								
								CommonUtil.click(driver, DSM_Email_VA_CCD_Attach_Document_Button, 360);
								System.out.println("Page Title ->"+driver.getTitle());									
								//CommonUtil.findElement(By.xpath("//*[@id=\"compose_form\"]/tbody/tr[9]/td/div/div[1]/a"));
								CommonUtil.waitForSometime();
								System.out.println("After waiting for Title");							
								Thread.sleep(100000);
							}
							System.out.println("Before entering body");
							// Enter Body											
						if (ccdAttachmentExcelData.get(String.valueOf(k)).get("Body") != null) {
								CommonUtil.click(driver, DSM_Email_Compose_Body_Link, 360);	
								Thread.sleep(200);
								//DSM_Email_Compose_Body.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Body"));
								DSM_Email_Compose_Body_Link.sendKeys(ccdAttachmentExcelData.get(String.valueOf(k)).get("Body"));
								Thread.sleep(200);
							}
							
							// Capture screenshot and click send button
							BufferedImage bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(1000);
							CommonUtil.click(driver, DSM_Email_Compose_Send_Button, 360);
							Thread.sleep(1000);
							
							// Capture popup screenshot and click send button							
							bufferedImage = CaptureScreenShots.captureImage();
							captureMultipleImagesList.add(bufferedImage);
							Thread.sleep(500);
							CommonUtil.click(driver, DSM_Email_Compose_Send_Button_Popup, 360);
							Thread.sleep(1000);		
							
							// Click Inbox link and capture screenshot 
							CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
							bufferedImage = CaptureScreenShots.captureImage();
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


	// Test DSM Email Create Folder
		public static void Test_DSM_Email_Create_Folder(String excelFilePath, String sheetName) throws Exception {
			System.out.println("***************** In DSM Email Create Folder *****************");
			Thread.sleep(200);

			try {
				System.out.println("DSM Email - Title ->" + driver.getTitle());

				if (driver.getTitle().startsWith("VA Direct Project")) {

					CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
					Thread.sleep(500);

					// Read all data rows from excel file for create folder in map object
					Map<String, Map<String, String>> createFolderExcelData = ReadExcelData.readExcelFile(excelFilePath,
							sheetName);
					
					// Loop through the map object
					if (createFolderExcelData != null) {
						for (int k = 1; k < createFolderExcelData.size() + 1; k++) {
							
							// Execute the script only if Run Script is set to Yes
							if (createFolderExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
								
								// Refresh page after first test case execution
								if (k > 1) {
									CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
									Thread.sleep(500);
								}
								
								
								Thread.sleep(1000);		
								if (createFolderExcelData.get(String.valueOf(k)).get("New Folder Name") != null) {
									CommonUtil.click(driver, DSM_Email_Create_Folder_Link, 360);
									Thread.sleep(15000);
								}	
								
								if (createFolderExcelData.get(String.valueOf(k)).get("Parent Folder") != null) {
									System.out.println("DSM_Email_Parent_Folder ->"+createFolderExcelData.get(String.valueOf(k)).get("Parent Folder"));
									DSM_Email_Parent_Folder_Drop_Down.sendKeys(createFolderExcelData.get(String.valueOf(k)).get("Parent Folder"));
									Thread.sleep(500);
								}
								
								Thread.sleep(500);
								if (createFolderExcelData.get(String.valueOf(k)).get("New Folder Name") != null) {
									DSM_Email_New_Folder_Name.sendKeys(createFolderExcelData.get(String.valueOf(k)).get("New Folder Name"));
									Thread.sleep(500);		
								}

								BufferedImage bufferedImage = CaptureScreenShots.captureImage();
								captureMultipleImagesList.add(bufferedImage);
								Thread.sleep(1000);
								
								if (createFolderExcelData.get(String.valueOf(k)).get("New Folder Name") != null) {
									CommonUtil.click(driver, DSM_Email_Create_Folder_Create_Button, 360);
									Thread.sleep(500);
								}
								
								Thread.sleep(500);
								if (createFolderExcelData.get(String.valueOf(k)).get("New Folder Name") == null) {
									CommonUtil.click(driver, DSM_Email_Create_Folder_Close_Button, 360);
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}

		}

		
		// Test DSM Email Drafts - Archive and Discard
				public static void Test_DSM_Email_Drafts_Archive_Discard(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Drafts - Archive and Discard *****************");
					Thread.sleep(200);

					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {

							CommonUtil.click(driver, DSM_Email_Drafts_Link, 360);
							Thread.sleep(500);

							// Read all data rows from excel file for Drafts-Archive and Discard in map object
							Map<String, Map<String, String>> draftsArchiveDiscardExcelData = ReadExcelData.readExcelFile(excelFilePath,
									sheetName);
							
							// Loop through the map object
							if (draftsArchiveDiscardExcelData != null) {								
								for (int k = 1; k < draftsArchiveDiscardExcelData.size() + 1; k++) {
									
									// Execute the script only if Run Script is set to Yes
									if (draftsArchiveDiscardExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										
										// Refresh page after first test case execution
										if (k > 1) {
											CommonUtil.click(driver, DSM_Email_Drafts_Link, 360);
											Thread.sleep(500);
										}										
										
										Thread.sleep(500);		
										if (draftsArchiveDiscardExcelData.get(String.valueOf(k)).get("Archive Message") != null) {
										     // getPageSource() to get page source
										      if ( driver.getPageSource().contains("There are no messages to display")){
										         System.out.println("Text: is present. ");
										      } else {
										         System.out.println("Text: is not present. ");
										         WebElement firstCheckbox = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/form/div[2]/table/tbody/tr[2]/td[1]/input"));
										         firstCheckbox.click();
										         System.out.println("selected checkbox");
										         if (draftsArchiveDiscardExcelData.get(String.valueOf(k)).get("Archive Message").equals("Yes")) {
										        	 System.out.println("In Archive");
										        	 CommonUtil.click(driver, DSM_Email_Drafts_Archive_Button, 360);
										         }else{
										        	 	System.out.println("In Discard");
										        	 	CommonUtil.click(driver, DSM_Email_Drafts_Discard_Button, 360);
										        	 	CommonUtil.click(driver, DSM_Email_Drafts_Discard_Yes_Confirm_Button, 360);										        	 	
										         }
										      }
											
										}								
							
										Thread.sleep(500);		
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);
										

									}
								}
							}
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}

				}		

				
				// Test DSM Email Archive functionalities
						public static void Test_DSM_Email_Archive_Functionalities(String excelFilePath, String sheetName) throws Exception {
							System.out.println("***************** In DSM Email Archive functionalities *****************");
							Thread.sleep(200);

							try {
								System.out.println("DSM Email - Title ->" + driver.getTitle());

								if (driver.getTitle().startsWith("VA Direct Project")) {

									CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
									Thread.sleep(500);

									// Read all data rows from excel file for Archive and store in map object
									Map<String, Map<String, String>> archiveExcelData = ReadExcelData.readExcelFile(excelFilePath,
											sheetName);
									
									// Loop through the map object
									if (archiveExcelData != null) {								
										for (int k = 1; k < archiveExcelData.size() + 1; k++) {
											
											// Execute the script only if Run Script is set to Yes
											if (archiveExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
												
												// Refresh page after first test case execution
												if (k > 1) {
													CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
													Thread.sleep(500);
												}										
												
												Thread.sleep(500);		
												Boolean isPaginationPresent = driver.findElements(By.ByXPath.xpath("//*[@id=\"pagination\"]/a/span/img")).size() > 0;

												if (archiveExcelData.get(String.valueOf(k)).get("Get Mail") != null) {
													CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
													if (archiveExcelData.get(String.valueOf(k)).get("Get Mail").equals("Yes")) {
														CommonUtil.click(driver, DSM_Email_Get_Mail_Button, 360);
														CommonUtil.click(driver, DSM_Email_Archive_Select_All, 360);
														System.out.println("isPresent -Pagination->"+isPaginationPresent.toString());
														if(isPaginationPresent) {
															CommonUtil.click(driver, DSM_Email_Archive_Pagination_Next, 360);
															CommonUtil.click(driver, DSM_Email_Archive_Pagination_Previous, 360);
														}
													}
												}		
												
												if (archiveExcelData.get(String.valueOf(k)).get("All") != null) {
													CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
													if (archiveExcelData.get(String.valueOf(k)).get("All").equals("Yes")) {
														CommonUtil.click(driver, DSM_Email_All_Filter_Button, 360);
														CommonUtil.click(driver, DSM_Email_All_Filter_link, 360);
													}
												}
												
												if (archiveExcelData.get(String.valueOf(k)).get("Inbox") != null) {
													CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
													if (archiveExcelData.get(String.valueOf(k)).get("Inbox").equals("Yes") && isPaginationPresent) {
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row1, 360);
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row2, 360);
														CommonUtil.click(driver, DSM_Email_All_Filter_Button, 360);
														CommonUtil.click(driver, DSM_Email_Inbox_Filter_link, 360);
													}
												}	
												
												if (archiveExcelData.get(String.valueOf(k)).get("Sent") != null) {
													CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
													if (archiveExcelData.get(String.valueOf(k)).get("Sent").equals("Yes") && isPaginationPresent) {
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row1, 360);
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row2, 360);													
														CommonUtil.click(driver, DSM_Email_All_Filter_Button, 360);
														CommonUtil.click(driver, DSM_Email_Sent_Filter_link, 360);
													}
												}	
												
												if (archiveExcelData.get(String.valueOf(k)).get("Drafts") != null) {
													CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
													if (archiveExcelData.get(String.valueOf(k)).get("Drafts").equals("Yes") && isPaginationPresent) {
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row1, 360);
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row2, 360);
														CommonUtil.click(driver, DSM_Email_All_Filter_Button, 360);
														CommonUtil.click(driver, DSM_Email_Drafts_Filter_link, 360);
													}
													if (archiveExcelData.get(String.valueOf(k)).get("Drafts").equals("Yes") && isPaginationPresent) {
														CommonUtil.click(driver, DSM_Email_Archive_Link, 360);
														CommonUtil.click(driver, DSM_Email_Archive_Select_Row1, 360);														
														CommonUtil.click(driver, DSM_Email_Archive_Move_Btn, 360);
														CommonUtil.click(driver, DSM_Email_Archive_Move_Drafts_Link, 360);
													}
												}	
											
																							
												Thread.sleep(500);		
												BufferedImage bufferedImage = CaptureScreenShots.captureImage();
												captureMultipleImagesList.add(bufferedImage);
												Thread.sleep(1000);												

											}
										}
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
								throw e;
							}

						}								

					
					// Test DSM Email Outbox functionalities
					public static void Test_DSM_Email_Outbox(String excelFilePath, String sheetName) throws Exception {
							System.out.println("***************** In DSM Email Oubox functionalities *****************");
							Thread.sleep(200);

							try {
								System.out.println("DSM Email - Title ->" + driver.getTitle());

								if (driver.getTitle().startsWith("VA Direct Project")) {

									CommonUtil.click(driver, DSM_Email_Outbox_Link, 360);
									Thread.sleep(500);

									// Read all data rows from excel file for Outbox and store in map object
									Map<String, Map<String, String>> archiveExcelData = ReadExcelData.readExcelFile(excelFilePath,
											sheetName);
									
									// Loop through the map object
									if (archiveExcelData != null) {								
										for (int k = 1; k < archiveExcelData.size() + 1; k++) {
											
											// Execute the script only if Run Script is set to Yes
											if (archiveExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
												
												// Refresh page after first test case execution
												if (k > 1) {
													CommonUtil.click(driver, DSM_Email_Outbox_Link, 360);
													Thread.sleep(500);
												}										
												
												Thread.sleep(500);		
												
												if (archiveExcelData.get(String.valueOf(k)).get("Outbox") != null) {													
													if (archiveExcelData.get(String.valueOf(k)).get("Outbox").equals("Yes")) {
														System.out.println("DSM_Email_Outbox_Message ->"+DSM_Email_Outbox_Message.getText());
														if(DSM_Email_Outbox_Message.getText().startsWith("There are no messages to display"))
														{
															System.out.println("Outbox - Test Pass");
														}else {
															System.out.println("Outbox - Test Fail");
														}														
												
													}
												}														
																							
												Thread.sleep(500);		
												BufferedImage bufferedImage = CaptureScreenShots.captureImage();
												captureMultipleImagesList.add(bufferedImage);
												Thread.sleep(1000);												

											}
										}
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
								throw e;
							}

						}								

						
						// Test DSM Email Inbox functionalities
						public static void Test_DSM_Email_Inbox(String excelFilePath, String sheetName) throws Exception {
								System.out.println("***************** In DSM Email Inbox functionalities *****************");
								Thread.sleep(200);

								try {
									System.out.println("DSM Email - Title ->" + driver.getTitle());

									if (driver.getTitle().startsWith("VA Direct Project")) {

										CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
										Thread.sleep(500);

										// Read all data rows from excel file for Inbox and store in map object
										Map<String, Map<String, String>> archiveExcelData = ReadExcelData.readExcelFile(excelFilePath,
												sheetName);
										
										// Loop through the map object
										if (archiveExcelData != null) {								
											for (int k = 1; k < archiveExcelData.size() + 1; k++) {
												
												// Execute the script only if Run Script is set to Yes
												if (archiveExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
													
													// Refresh page after first test case execution
													if (k > 1) {
														CommonUtil.click(driver, DSM_Email_Inbox_Link, 360);
														Thread.sleep(500);
													}										
													
													Thread.sleep(500);		
													Boolean isPaginationPresent = driver.findElements(By.ByXPath.xpath("//*[@id=\"pagination\"]/span")).size() > 0;
													
													if (archiveExcelData.get(String.valueOf(k)).get("Inbox") != null) {													
														if (archiveExcelData.get(String.valueOf(k)).get("Inbox").equals("Yes")) {
															
															// Read and Unread
															if(isPaginationPresent)
															{
																CommonUtil.click(driver, DSM_Email_Inbox_Select_Row1, 360);														
																CommonUtil.click(driver, DSM_Email_Inbox_More_Btn, 360);
																CommonUtil.click(driver, DSM_Email_Inbox_Unread, 360);
																CommonUtil.click(driver, DSM_Email_Inbox_Select_Row1, 360);														
																CommonUtil.click(driver, DSM_Email_Inbox_More_Btn, 360);
																CommonUtil.click(driver, DSM_Email_Inbox_Read, 360);
																CommonUtil.click(driver, DSM_Email_Inbox_Pagination_Next, 360);
																CommonUtil.click(driver, DSM_Email_Inbox_Pagination_Previous, 360);
															}
															//Archive message
															if(isPaginationPresent)
															{
																System.out.println("Inbox - Test Pass");
																CommonUtil.click(driver, DSM_Email_Inbox_Select_Row1, 360);														
																CommonUtil.click(driver, DSM_Email_Inbox_Archive_Btn, 360);																											
															}	
													
														}
													}														
																								
													Thread.sleep(500);		
													BufferedImage bufferedImage = CaptureScreenShots.captureImage();
													captureMultipleImagesList.add(bufferedImage);
													Thread.sleep(1000);												

												}
											}
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
									throw e;
								}

							}								

							
				// Test DSM Email Sent functionalities
				public static void Test_DSM_Email_Sent(String excelFilePath, String sheetName) throws Exception {
						System.out.println("***************** In DSM Email Sent functionalities *****************");
						Thread.sleep(200);

						try {
							System.out.println("DSM Email - Title ->" + driver.getTitle());

							if (driver.getTitle().startsWith("VA Direct Project")) {

							CommonUtil.click(driver, DSM_Email_Sent_Link, 360);
								Thread.sleep(500);

								// Read all data rows from excel file for Inbox and store in map object
								Map<String, Map<String, String>> archiveExcelData = ReadExcelData.readExcelFile(excelFilePath,
										sheetName);
								
								// Loop through the map object
								if (archiveExcelData != null) {								
									for (int k = 1; k < archiveExcelData.size() + 1; k++) {
										
										// Execute the script only if Run Script is set to Yes
										if (archiveExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
											
											// Refresh page after first test case execution
											if (k > 1) {
												CommonUtil.click(driver, DSM_Email_Sent_Link, 360);
												Thread.sleep(500);
											}										
											
											Thread.sleep(500);		
											Boolean isPaginationPresent = driver.findElements(By.ByXPath.xpath("//*[@id=\"pagination\"]/span")).size() > 0;
											System.out.println("Sent - isPaginationPresent ->"+isPaginationPresent);
											if (archiveExcelData.get(String.valueOf(k)).get("Sent") != null) {													
												if (archiveExcelData.get(String.valueOf(k)).get("Sent").equals("Yes")) {																

													//Archive message
													if(isPaginationPresent)
													{
														System.out.println("Sent - Test Pass");
														CommonUtil.click(driver, DSM_Email_Sent_Select_Row1, 360);														
														CommonUtil.click(driver, DSM_Email_Sent_Archive_Btn, 360);		
														CommonUtil.click(driver, DSM_Email_Sent_Pagination_Next, 360);
														CommonUtil.click(driver, DSM_Email_Sent_Pagination_Previous, 360);
													}	
											
												}
											}														
																						
											Thread.sleep(500);		
											BufferedImage bufferedImage = CaptureScreenShots.captureImage();
											captureMultipleImagesList.add(bufferedImage);
											Thread.sleep(1000);												

										}
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							throw e;
						}

					}		
	
				
			// Test DSM Email Account Settings functionalities
			public static void Test_DSM_Email_AccountSettings(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Account Settings functionalities *****************");
					Thread.sleep(200);
					CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);						
					Thread.sleep(500);	

					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {

							CommonUtil.click(driver, DSM_Email_Settings_Tab, 360);
							Thread.sleep(500);

							// Read all data rows from excel file for Account Settings and store in map object
							Map<String, Map<String, String>> accountSettingsExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
							
							// Loop through the map object
							if (accountSettingsExcelData != null) {								
								for (int k = 1; k < accountSettingsExcelData.size() + 1; k++) {
									System.out.println("Loop ->"+k);
									System.out.println("Run Script ->"+accountSettingsExcelData.get(String.valueOf(k)).get("Run Script"));
									// Execute the script only if Run Script is set to Yes
									if (accountSettingsExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										System.out.println("Inside 1");
									
										Thread.sleep(500);		
							        	CommonUtil.click(driver, DSM_Email_Account_Settings_Tab, 360);									        	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("First Name") != null) {
											DSM_Email_Account_Settings_FirstName.clear();
											DSM_Email_Account_Settings_FirstName.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("First Name"));
											Thread.sleep(200);										
										}
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Middle Name") != null) {
											DSM_Email_Account_Settings_MiddleName.clear();
											DSM_Email_Account_Settings_MiddleName.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Middle Name"));
											Thread.sleep(200);											
										}
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Last Name") != null) {
											DSM_Email_Account_Settings_LastName.clear();
											DSM_Email_Account_Settings_LastName.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Last Name"));
											Thread.sleep(200);											
										}
										
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Default Mailbox") != null) {
											DSM_Email_Account_Settings_Default_Mailbox.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Default Mailbox"));
											Thread.sleep(200);
											DSM_Email_Account_Settings_Default_Mailbox.sendKeys(Keys.ENTER);
										}			
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Job Title") != null) {
											DSM_Email_Account_Settings_Job_Title.clear();
											DSM_Email_Account_Settings_Job_Title.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Job Title"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Department") != null) {
											DSM_Email_Account_Settings_Department.clear();
											DSM_Email_Account_Settings_Department.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Department"));
											Thread.sleep(200);
																					}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Organization") != null) {
											DSM_Email_Account_Settings_Organization.clear();
											DSM_Email_Account_Settings_Organization.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Organization"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Telephone") != null) {
											DSM_Email_Account_Settings_Telephone.clear();
											DSM_Email_Account_Settings_Telephone.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Telephone"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Mobile Phone") != null) {
											DSM_Email_Account_Settings_Mobile.clear();
											DSM_Email_Account_Settings_Mobile.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Mobile Phone"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Published") != null) {
											 if (accountSettingsExcelData.get(String.valueOf(k)).get("Published").equals("Yes")) {
												 WebElement PublishedCheckbox = driver.findElement(By.xpath("//*[@name=\"publish_in_dtd\"]"));
												 if (!PublishedCheckbox.isSelected()) {
													 PublishedCheckbox.click();Thread.sleep(50);												
													 CommonUtil.click(driver, DSM_Email_Account_Settings_I_Agree_Btn, 360);
												 }												 
											 }
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Address Line 1") != null) {
											DSM_Email_Account_Settings_Addr1.clear();
											DSM_Email_Account_Settings_Addr1.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Address Line 1"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Address Line 2") != null) {
											DSM_Email_Account_Settings_Addr2.clear();
											DSM_Email_Account_Settings_Addr2.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Address Line 2"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("City") != null) {
											DSM_Email_Account_Settings_City.clear();
											DSM_Email_Account_Settings_City.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("City"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("State") != null) {
											DSM_Email_Account_Settings_State.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("State"));
											Thread.sleep(200);
											DSM_Email_Account_Settings_State.sendKeys(Keys.ENTER);
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Zip") != null) {
											DSM_Email_Account_Settings_Zip.clear();
											DSM_Email_Account_Settings_Zip.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Zip"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Country") != null) {
											DSM_Email_Account_Settings_Country.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Country"));
											Thread.sleep(200);
											DSM_Email_Account_Settings_Country.sendKeys(Keys.ENTER);
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Facility") != null) {
											DSM_Email_Account_Settings_Facility.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Facility"));
											Thread.sleep(200);
											DSM_Email_Account_Settings_Facility.sendKeys(Keys.ENTER);
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("NPI") != null) {
											DSM_Email_Account_Settings_NPI.clear();
											DSM_Email_Account_Settings_NPI.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("NPI"));
											Thread.sleep(200);											
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Speciality") != null) {
											DSM_Email_Account_Settings_Speciality.sendKeys(accountSettingsExcelData.get(String.valueOf(k)).get("Speciality"));
											Thread.sleep(200);
											DSM_Email_Account_Settings_Speciality.sendKeys(Keys.ENTER);
										}	
										
										Thread.sleep(500);
										if (accountSettingsExcelData.get(String.valueOf(k)).get("Non-Clinical") != null && accountSettingsExcelData.get(String.valueOf(k)).get("Non-Clinical").equals("Yes")) {
											WebElement nonClinicalCheckbox = driver.findElement(By.xpath("//*[@id=\"set_default_nucc\"]"));											
											if (!nonClinicalCheckbox.isSelected()) {
												nonClinicalCheckbox.click();Thread.sleep(50);
											 }	
										}	
										
										Thread.sleep(500);
										//CommonUtil.click(driver, DSM_Email_Account_Settings_Update_Btn, 360);	
										DSM_Email_Account_Settings_NPI.sendKeys(Keys.ENTER);
										
																					
										Thread.sleep(500);		
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);												

									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}

				}			
			

				
			// Test DSM Email Notification Settings functionalities
			public static void Test_DSM_Email_NotificationSettings(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Notification Settings functionalities *****************");
					Thread.sleep(200);
					CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);						
					Thread.sleep(500);	

					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {

							CommonUtil.click(driver, DSM_Email_Settings_Tab, 360);
							Thread.sleep(500);							

							// Read all data rows from excel file for Notification Settings and store in map object
							Map<String, Map<String, String>> notificationSettingsExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
							
							// Loop through the map object
							if (notificationSettingsExcelData != null) {								
								for (int k = 1; k < notificationSettingsExcelData.size() + 1; k++) {
									System.out.println("Loop ->"+k);
									System.out.println("Run Script ->"+notificationSettingsExcelData.get(String.valueOf(k)).get("Run Script"));
									// Execute the script only if Run Script is set to Yes
									if (notificationSettingsExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										System.out.println("Inside 1");
									
										Thread.sleep(500);		
										CommonUtil.click(driver, DSM_Email_Notification_Settings_Tab, 360);								        	
										
										Thread.sleep(500);
										if (notificationSettingsExcelData.get(String.valueOf(k)).get("External Email") != null) {
											DSM_Email_Notification_Settings_External_Email.clear();
											DSM_Email_Notification_Settings_External_Email.sendKeys(notificationSettingsExcelData.get(String.valueOf(k)).get("External Email"));
											Thread.sleep(200);										
										}
										
										Thread.sleep(500);
										if (notificationSettingsExcelData.get(String.valueOf(k)).get("Receive Notifications") != null && notificationSettingsExcelData.get(String.valueOf(k)).get("Receive Notifications").equals("Yes")) {
											 
												 WebElement PublishedCheckbox = driver.findElement(By.xpath("//*[@id=\"notify\"]"));
												 if (!PublishedCheckbox.isSelected()) {
													 PublishedCheckbox.click();Thread.sleep(50);	
												 }												 
											 
										}											
										
										Thread.sleep(500);
										if (notificationSettingsExcelData.get(String.valueOf(k)).get("Receive Group Notifications") != null && notificationSettingsExcelData.get(String.valueOf(k)).get("Receive Group Notifications").equals("Yes")) {
											WebElement nonClinicalCheckbox = driver.findElement(By.xpath("//*[@id=\"group_notify\"]"));											
											if (!nonClinicalCheckbox.isSelected()) {
												nonClinicalCheckbox.click();Thread.sleep(50);
											 }	
										}	
										
										Thread.sleep(500);										
										DSM_Email_Notification_Settings_External_Email.sendKeys(Keys.ENTER);
																															
										Thread.sleep(500);		
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);												

									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}

				}	
			
				
			// Test DSM Email Application Settings functionalities
			public static void Test_DSM_Email_ApplicationSettings(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Application Settings functionalities *****************");
					Thread.sleep(200);
					CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);						
					Thread.sleep(500);	
					
					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {

							CommonUtil.click(driver, DSM_Email_Settings_Tab, 360);
							Thread.sleep(500);	
							
							// Read all data rows from excel file for Application Settings and store in map object
							Map<String, Map<String, String>> applicationSettingsExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
							
							// Loop through the map object
							if (applicationSettingsExcelData != null) {								
								for (int k = 1; k < applicationSettingsExcelData.size() + 1; k++) {
									System.out.println("Loop ->"+k);
									System.out.println("Run Script ->"+applicationSettingsExcelData.get(String.valueOf(k)).get("Run Script"));
									// Execute the script only if Run Script is set to Yes
									if (applicationSettingsExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										System.out.println("Inside 1");
									
										Thread.sleep(500);		
										CommonUtil.click(driver, DSM_Email_Application_Settings_Tab, 360);	
										Thread.sleep(500);
										
										if (applicationSettingsExcelData.get(String.valueOf(k)).get("Country") != null) {
											DSM_Email_Application_Settings_Country.sendKeys(applicationSettingsExcelData.get(String.valueOf(k)).get("Country"));
											Thread.sleep(200);
											DSM_Email_Application_Settings_Country.sendKeys(Keys.ENTER);
										}	
										
										Thread.sleep(500);
										if (applicationSettingsExcelData.get(String.valueOf(k)).get("Timezone") != null) {
											DSM_Email_Application_Settings_Timezone.sendKeys(applicationSettingsExcelData.get(String.valueOf(k)).get("Timezone"));
											Thread.sleep(200);
											DSM_Email_Application_Settings_Timezone.sendKeys(Keys.ENTER);
										}		
										
										Thread.sleep(500);										
										DSM_Email_Application_Settings_Update_Information_Btn.click();
										
										Thread.sleep(500);										
										/*DSM_Email_Application_Settings_Change_Service_Permission_Btn.click();
										
										Thread.sleep(500);
										if (applicationSettingsExcelData.get(String.valueOf(k)).get("Change Service Permissions") != null && applicationSettingsExcelData.get(String.valueOf(k)).get("Change Service Permissions").equals("Yes")) {
											WebElement nonClinicalCheckbox = driver.findElement(By.xpath("//*[@id=\"send\"]"));											
											if (!nonClinicalCheckbox.isSelected()) {
												nonClinicalCheckbox.click();Thread.sleep(50);
											 }												
											Thread.sleep(500);										
											DSM_Email_Application_Settings_Close_Btn.click();
										}	*/
																															
										Thread.sleep(500);		
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);												

									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}

				}			
			

				
			// Test DSM Email Automatic functionalities
			public static void Test_DSM_Email_AutomaticReplies(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Automatic Replies functionalities *****************");
					Thread.sleep(200);
					CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);						
					Thread.sleep(500);	
					
					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {

							CommonUtil.click(driver, DSM_Email_Settings_Tab, 360);
							Thread.sleep(500);	
							
							// Read all data rows from excel file for Automatic Replies and store in map object
							Map<String, Map<String, String>> automaticRepliesExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
							
							// Loop through the map object
							if (automaticRepliesExcelData != null) {								
								for (int k = 1; k < automaticRepliesExcelData.size() + 1; k++) {
									System.out.println("Loop ->"+k);
									System.out.println("Run Script ->"+automaticRepliesExcelData.get(String.valueOf(k)).get("Run Script"));
									// Execute the script only if Run Script is set to Yes
									if (automaticRepliesExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										System.out.println("Inside 1");
									
										Thread.sleep(500);		
										CommonUtil.click(driver, DSM_Email_Automatic_Replies_Tab, 360);	
										Thread.sleep(500);

										if (automaticRepliesExcelData.get(String.valueOf(k)).get("Do not send automatic replies") != null && automaticRepliesExcelData.get(String.valueOf(k)).get("Do not send automatic replies").equals("Yes")) {
											WebElement DSM_Email_Automatic_Replies_DoNot_Send_Radio_Btn = driver.findElement(By.xpath("//*[@id=\"send_automatic_replies_no\"]"));											
											if (!DSM_Email_Automatic_Replies_DoNot_Send_Radio_Btn.isSelected()) {
												DSM_Email_Automatic_Replies_DoNot_Send_Radio_Btn.click();Thread.sleep(50);
											 }												
											Thread.sleep(500);
										}	else {											
											WebElement DSM_Email_Automatic_Replies_Send_Radio_Btn = driver.findElement(By.xpath("//*[@id=\"send_automatic_replies_yes\"]"));											
											if (!DSM_Email_Automatic_Replies_Send_Radio_Btn.isSelected()) {
												DSM_Email_Automatic_Replies_Send_Radio_Btn.click();Thread.sleep(100);
											 }					
											WebElement DSM_Email_Automatic_Replies_Checkbox = driver.findElement(By.xpath("//*[@id=\"send_within_time_period\"]"));
											DSM_Email_Automatic_Replies_Checkbox.click();
											Thread.sleep(100);		
											DSM_Email_Automatic_Replies_End_Date.clear();
											Thread.sleep(100);		
											
											DSM_Email_Automatic_Replies_End_Date_Today.click();
											Thread.sleep(100);
																	
										}
										
										DSM_Email_Automatic_Replies_Save_Btn.click();
										Thread.sleep(500);		
										
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);												

									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}

				}	
			

				
			// Test DSM Email Automatic functionalities
			public static void Test_DSM_Email_Feedback(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Feedback functionalities *****************");
					Thread.sleep(200);
					CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);						
					Thread.sleep(500);	
					
					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {
							
							// Read all data rows from excel file for Automatic Replies and store in map object
							Map<String, Map<String, String>> feedbackExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
							
							// Loop through the map object
							if (feedbackExcelData != null) {								
								for (int k = 1; k < feedbackExcelData.size() + 1; k++) {
									System.out.println("Loop ->"+k);
									System.out.println("Run Script ->"+feedbackExcelData.get(String.valueOf(k)).get("Run Script"));
									// Execute the script only if Run Script is set to Yes
									if (feedbackExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										System.out.println("Inside 1");
									
										Thread.sleep(500);		
										CommonUtil.click(driver, DSM_Email_Feedback_Tab, 360);	
										Thread.sleep(500);

										WebElement DSM_Email_Report_Issue_Radio_Btn = driver.findElement(By.xpath("//*[@id=\"feedback-type-field-issue-report\"]"));
										if (feedbackExcelData.get(String.valueOf(k)).get("Report Issue") != null && feedbackExcelData.get(String.valueOf(k)).get("Report Issue").equals("Yes")) {										
																					
											if (!DSM_Email_Report_Issue_Radio_Btn.isSelected()) {
												DSM_Email_Report_Issue_Radio_Btn.click();Thread.sleep(100);
											 }		
											DSM_Email_Report_Issue_Radio_Btn.sendKeys(Keys.TAB);
										
										} else {
											WebElement DSM_Email_General_Feedback_Radio_Btn = driver.findElement(By.id("feedback-type-field-general-feedback"));								

											DSM_Email_General_Feedback_Radio_Btn.sendKeys(Keys.TAB);
											
										}
										
										System.out.println("After Tab");
										if (feedbackExcelData.get(String.valueOf(k)).get("Feedback") != null) {
											WebElement DSM_Email_Feedback_Text = driver.findElement(By.id("feedback-comments-field"));
											DSM_Email_Feedback_Text.sendKeys(feedbackExcelData.get(String.valueOf(k)).get("Feedback"));
											Thread.sleep(100);
										}	
										
										DSM_Email_Feedback_Submit_Btn.click();
										Thread.sleep(500);	
										DSM_Email_Feedback_Cancel_Btn.click();
										Thread.sleep(500);
										
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);												

									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}

				}		


				
			// Test DSM Email Reports functionalities
			public static void Test_DSM_Email_Reports(String excelFilePath, String sheetName) throws Exception {
					System.out.println("***************** In DSM Email Report functionalities *****************");
					//Thread.sleep(200);
					CommonUtil.click(driver, DSM_Email_Reports_Tab, 360);						
					//Thread.sleep(500);	
					
					try {
						System.out.println("DSM Email - Title ->" + driver.getTitle());

						if (driver.getTitle().startsWith("VA Direct Project")) {
							
							// Read all data rows from excel file for Reports and store in map object
							Map<String, Map<String, String>> reportsExcelData = ReadExcelData.readExcelFile(excelFilePath,sheetName);
							
							// Loop through the map object
							if (reportsExcelData != null) {								
								for (int k = 1; k < reportsExcelData.size() + 1; k++) {
									System.out.println("Loop ->"+k);
									System.out.println("Run Script ->"+reportsExcelData.get(String.valueOf(k)).get("Run Script"));
									// Execute the script only if Run Script is set to Yes
									if (reportsExcelData.get(String.valueOf(k)).get("Run Script").equals("Yes")) {
										System.out.println("Inside 1");
									
										Thread.sleep(500);		
										//CommonUtil.click(driver, DSM_Email_Reports_Mailbox_Activities_Tab, 360);	
										//Thread.sleep(500);

										if (reportsExcelData.get(String.valueOf(k)).get("Users") != null) {
											Select s = new Select(driver.findElement(By.xpath("//*[@id=\"selected_user\"]")));
											s.selectByVisibleText(reportsExcelData.get(String.valueOf(k)).get("Users"));
											DSM_Email_Reports_Users.sendKeys(Keys.ENTER);
											Thread.sleep(200);
											DSM_Email_Reports_Users.sendKeys(Keys.TAB);
										}	
										
										if (reportsExcelData.get(String.valueOf(k)).get("Start Date") != null && reportsExcelData.get(String.valueOf(k)).get("Start Date").contentEquals("Yes")) {
											//DSM_Email_Reports_StartDate.click();
											
											Thread.sleep(200);			
											
											DSM_Email_Reports_StartDate_Btn.click();											
											Thread.sleep(200);											

										}		
										System.out.println("After Start Date 1");
										if (reportsExcelData.get(String.valueOf(k)).get("End Date") != null && reportsExcelData.get(String.valueOf(k)).get("End Date").contentEquals("Yes")) {
											System.out.println("After Start Date 2");
											Thread.sleep(200);	
											System.out.println("After Start Date 3");
											DSM_Email_Reports_EndDate.click();
											Thread.sleep(200);	
											DSM_Email_Reports_EndDate_Btn.click();
											System.out.println("After Start Date 4");
											Thread.sleep(200);											
																			
										}	
										
									
										DSM_Email_Reports_Filter_Btn.click();
										Thread.sleep(500);	
									
										/*
										if (reportsExcelData.get(String.valueOf(k)).get("Export To Excel") != null  && reportsExcelData.get(String.valueOf(k)).get("Export To Excel").equals("Yes")) {
											DSM_Email_Reports_Export_To_Excel.click();
											Thread.sleep(200);
											//DSM_Email_Reports_Export_To_Excel.sendKeys(Keys.ENTER);
											//native key strokes for CTRL, V and ENTER keys
											System.out.println("Press Enter - BEFORE");
							
											Thread.sleep(500);
											Robot robot = new Robot();
											robot.keyPress(KeyEvent.VK_CONTROL);
											robot.keyPress(KeyEvent.VK_V);
											robot.keyRelease(KeyEvent.VK_V);
											robot.keyRelease(KeyEvent.VK_CONTROL);
											robot.keyPress(KeyEvent.VK_ENTER);
											robot.keyRelease(KeyEvent.VK_ENTER);
											System.out.println("Press Enter - AFTER");
											
											System.out.println("Press Enter - BEFORE 1");
											//new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
										//	new WebDriverWait(driver, 20);
											//driver.switchTo().alert().accept();
											// WebDriverWait wait = new WebDriverWait(driver, 10);
											//    wait.until(ExpectedConditions.alertIsPresent());
											//    Alert alert = driver.switchTo().alert();
											//    alert.accept();
											
											 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
										      // store all window handles
										      Set<String> a = driver.getWindowHandles();
										      // iterate through handles
										      Iterator<String> it = a.iterator();
										      String chlwnd = it.next();
										      System.out.println("chlwnd "+ chlwnd);
										      //String pwnd = it.next();
										      //System.out.println("pwnd "+ pwnd);
										      // switch to child window
										      driver.switchTo().window(chlwnd);
										      System.out.println("Page title 1"+ driver.getTitle());
										      // switch to parent window
										      //driver.switchTo().window(pwnd);
										      System.out.println("Page title 2"+ driver.getTitle());
											
											//Alert myAlert = driver.switchTo().alert();
											//myAlert.accept();
											
											System.out.println("Press Enter - AFTER 1");											
										
											
											Thread.sleep(200);
										}*/
										
										
										BufferedImage bufferedImage = CaptureScreenShots.captureImage();
										captureMultipleImagesList.add(bufferedImage);
										Thread.sleep(1000);												

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
