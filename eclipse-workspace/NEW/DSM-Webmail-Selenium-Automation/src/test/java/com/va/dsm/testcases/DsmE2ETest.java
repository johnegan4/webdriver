package com.va.dsm.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.va.dsm.pages.AdminLogs;
import com.va.dsm.pages.AdminManageUsers;
import com.va.dsm.pages.AdminReports;
import com.va.dsm.pages.DSMEmail;
import com.va.dsm.pages.DirectorySearchInternalVA;
import com.va.dsm.pages.DirectorySearchNonVA;
import com.va.dsm.pages.DirectorySearchPersonalContacts;
import com.va.dsm.util.CommonUtil;
import com.va.dsm.util.LoadDriver;
import com.va.dsm.util.ReadExcelData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // To run methods in certain order
public class DsmE2ETest {
	private static WebDriver driver = null;
	private static String excelFilePath = null;
	private static String browserName = null;
	private static String applicationURL = null;

	@BeforeClass
	public static void beforeTest() throws Exception {
		System.out.println("DSME2ETest");
		try {
			excelFilePath = ReadExcelData.readFilePathFromConfig(); // Read file path from config file

			ReadExcelData excelUtil = new ReadExcelData(excelFilePath);
			browserName = excelUtil.getCellData("Main", "Browser", 2); // get the browser name to run the application
			applicationURL = excelUtil.getCellData("Main", "URL", 2); // get DSM application URL
			
			System.out.println("browserName ->"+browserName);
			System.out.println("applicationURL->"+applicationURL);

			driver = LoadDriver.createDriver(browserName);	
			System.out.println("After driver 1");
			
		
			//driver.switchTo().alert().accept();
			System.out.println("After driver 1a");
			//Alert alert = driver.switchTo().alert();
			System.out.println("After driver 1b");
			//alert.accept();				
			
		/*	WebDriverWait wait = new WebDriverWait(driver, 10); 
			System.out.println("After driver 1c");
			Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
			System.out.println("After driver 1d");
			alert.accept();	
			*/
			//waitForAlert(driver);
			//new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			//driver.switchTo().alert().accept();
			System.out.println("After driver 1e");
			CommonUtil.waitForPageToLoad();
			System.out.println("After driver 1f");
			//driver.switchTo().alert().accept();
			//Scanner keyboard = new Scanner(System.in);
		    //keyboard.nextLine();
			System.out.println("driver.getTitle() ->"+driver.getTitle());
			/*Actions builder = new Actions(driver);        
			builder.sendKeys(Keys.ENTER);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);*/
			
			
		/*	Robot robot = new Robot();
			   Thread mthread = new Thread(mlauncher);
			   mthread.start();

			  robot.keyPress(KeyEvent.VK_ENTER);
			  robot.keyRelease(KeyEvent.VK_ENTER);*/
			
			System.out.println("After driver 1g");
			driver.get(applicationURL);
			
			System.out.println("After driver 2");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


    static Runnable mlauncher = () -> {
    try {

      driver.get("https://test1.direct.va.gov/inbox");
     } catch (Exception e) {
          e.printStackTrace();
       }
    };
	
	@AfterClass
	public static void afterTest() throws Exception {
		System.out.println("Run this after class");
	}

	
	@Test
	public void Test001_DSM_Email_Compose_No_Attachment() throws Exception {
		System.out.println("Test001");
		String sheetName = "DSM Login";
		
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email Compose with No Attachment
			DSMEmail.Test_DSM_Email_Compose_No_Attachment(excelFilePath, "DSM Email No Attachment");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}

	
	@Test
	public void Test002_DSM_Email_Compose_With_Attachment() throws Exception {
		System.out.println("Test002");
		
		
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email Compose with Attachment
			DSMEmail.Test_DSM_Email_Compose_With_Attachment(excelFilePath, "DSM Email With Attachment");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	

	}

	@Test
	public void Test003_DSM_Email_Compose_With_CCD_Attachment() throws Exception {
		System.out.println("Test003");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email Compose with CCD Attachment
			DSMEmail.Test_DSM_Email_Compose_With_CCD_Attachment(excelFilePath, "DSM Email With CCD Attachment");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}

	
	@Test
	public void Test004_DSM_Email_Create_Folder() throws Exception {
		System.out.println("Test004");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Remaining functionalities like Archive, Folder creation, Move To, Mark as Read and Unread 
			DSMEmail.Test_DSM_Email_Create_Folder(excelFilePath, "Create Folder");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	
	@Test
	public void Test005_DSM_Email_Drafts_Archive_Discard() throws Exception {
		System.out.println("Test005");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Remaining functionalities like Draft - Archive and Discard 
			DSMEmail.Test_DSM_Email_Drafts_Archive_Discard(excelFilePath, "Drafts-Archive and Discard");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	
	@Test
	public void Test006_DSM_Email_Archive_Functionalities() throws Exception {
		System.out.println("Test006");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Archive option functionalities 
			DSMEmail.Test_DSM_Email_Archive_Functionalities(excelFilePath, "Archive");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	@Test
	public void Test007_DSM_Email_Outbox() throws Exception {
		System.out.println("Test007");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Outbox functionalities 
			DSMEmail.Test_DSM_Email_Outbox(excelFilePath, "Outbox");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	@Test
	public void Test008_DSM_Email_Inbox() throws Exception {
		System.out.println("Test008");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Inbox functionalities 
			DSMEmail.Test_DSM_Email_Inbox(excelFilePath, "Inbox");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	@Test
	public void Test009_DSM_Email_Sent() throws Exception {
		System.out.println("Test009");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Sent functionalities 
			DSMEmail.Test_DSM_Email_Sent(excelFilePath, "Sent");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}	
	
	
	
	@Test
	public void Test010_DSM_Email_AccountSettings() throws Exception {
		System.out.println("Test010");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Account Settings functionalities 
			DSMEmail.Test_DSM_Email_AccountSettings(excelFilePath, "Account Settings");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}	
	
	
	
	@Test
	public void Test011_DSM_Email_NotificationSettings() throws Exception {
		System.out.println("Test011");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Notification Settings functionalities 
			DSMEmail.Test_DSM_Email_NotificationSettings(excelFilePath, "Notification Settings");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	@Test
	public void Test012_DSM_Email_ApplicationSettings() throws Exception {
		System.out.println("Test012");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Application Settings functionalities 
			DSMEmail.Test_DSM_Email_ApplicationSettings(excelFilePath, "Application Settings");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	@Test
	public void Test013_DSM_Email_AutomaticReplies() throws Exception {
		System.out.println("Test013");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Automatic Replies functionalities 
			DSMEmail.Test_DSM_Email_AutomaticReplies(excelFilePath, "Application Settings");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}	
	
	
	@Test
	public void Test014_DSM_Email_Feedback() throws Exception {
		System.out.println("Test014");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Feedback functionalities 
			DSMEmail.Test_DSM_Email_Feedback(excelFilePath, "Feedback");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}	

	
	@Test
	public void Test015_DSM_Email_Reports() throws Exception {
		System.out.println("Test015");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DSMEmail.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Reports functionalities 
			DSMEmail.Test_DSM_Email_Reports(excelFilePath, "Reports");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}	

	

	@Test
	public void Test016_DSM_Email_Directory_Search_NonVA_Addresses() throws Exception {
		System.out.println("Test016");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DirectorySearchNonVA.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Non VA Address functionalities 
			DirectorySearchNonVA.Test_DSM_Email_Directory_Search_NonVA_Addresses(excelFilePath, "Directory Search - Non VA Addr");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}


	@Test
	public void Test016_DSM_Email_Directory_Search_InternalVA_Addresses() throws Exception {
		System.out.println("Test016");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DirectorySearchInternalVA.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Internal VA Address functionalities 
			DirectorySearchInternalVA.Test_DSM_Email_Directory_Search_InternalVA_Addresses(excelFilePath, "Directory Search - Int VA Addr");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}



	@Test
	public void Test016_DSM_Email_Directory_Search_Personal_Contacts() throws Exception {
		System.out.println("Test016");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, DirectorySearchPersonalContacts.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Personal Contacts functionalities 
			DirectorySearchPersonalContacts.Test_DSM_Email_Directory_Search_Personal_Contacts(excelFilePath, "Directory Search - Per Contacts");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	
	@Test
	public void Test017_DSM_Email_Admin_Reports() throws Exception {
		System.out.println("Test017");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, AdminReports.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Admin Reports functionalities 
			AdminReports.Test_DSM_Email_Admin_Reports(excelFilePath, "Admin - Reports");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	
	@Test
	public void Test017_DSM_Email_Admin_Logs() throws Exception {
		System.out.println("Test018");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, AdminLogs.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Admin Logs functionalities 
			AdminLogs.Test_DSM_Email_Admin_Logs(excelFilePath, "Admin - Logs");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}


	
	@Test
	public void Test018_DSM_Email_Admin_Manage_Users() throws Exception {
		System.out.println("Test019");

				
		try {
			Thread.sleep(200);

			PageFactory.initElements(driver, AdminManageUsers.class);
			CommonUtil.waitForPageToLoad();
			
			// Test DSM Email - Admin Manage Users functionalities 
			AdminManageUsers.Test_DSM_Email_Admin_Manage_Users(excelFilePath, "Admin - Manage Users");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	
}
