package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dsm_automation.test.pages.AdminAccountRequests;
import dsm_automation.test.pages.AdminApplicationRequests;
import dsm_automation.test.pages.AdminManageFacilities;
import dsm_automation.test.pages.AdminManageGroups;
import dsm_automation.test.pages.AdministrationManageAccounts;
import dsm_automation.test.pages.Applications;
import dsm_automation.test.pages.GlobalSearch;
import dsm_automation.test.pages.OnboardingDocumentation;
import dsm_automation.test.pages.OnboardingPDF;
import dsm_automation.test.pages.OnboardingRequest;
import dsm_automation.test.pages.ReportEvents;
import dsm_automation.test.pages.ReportFacility;
import dsm_automation.test.pages.ReportGroupSummary;
import dsm_automation.test.pages.ReportLogins;
import dsm_automation.test.pages.ReportMail;
import dsm_automation.test.pages.ReportPointsofOrigin;
import dsm_automation.test.pages.ReportRequests;
import dsm_automation.test.pages.ReportUserSummary;
import dsm_automation.test.pages.UserSettings;
import dsm_automation.test.pages.UserSettingsAppList;
import dsm_automation.test.util.LoadDriver;
import dsm_automation.test.util.ReadExcelData;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // To run methods in certain order
public class APIDSMTest {
	private static WebDriver driver = null;
	private static String excelFilePath = null;
	private static String browserName = null;
	private static String applicationURL = null;


	@BeforeClass
	public static void beforeTest(ITestContext context) throws Exception {
		System.out.println("API DSM Test started");
		try {
			 
			excelFilePath = ReadExcelData.readFilePathFromConfig(); // Read file path from config file
			ReadExcelData excelUtil = new ReadExcelData(excelFilePath);
			browserName = excelUtil.getCellData("Main", "Browser", 2); // get the browser name to run the application
		    applicationURL = excelUtil.getCellData("Main", "URL", 2); // get DSM application URL
			driver = LoadDriver.createDriver(browserName);	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(applicationURL);
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@AfterClass
	public static void afterTest() throws Exception {
		System.out.println("Close all open browsers after the test is complete");
		driver.quit();
	    }
	
	
//======================================    START     ================================================================

/*	
	 
	@Test //Report_Events
	    public void TestCase01_ReportEvents() throws Exception {
	                    System.out.println("ReportEvents _Test_Validation");
	                                    PageFactory.initElements(driver, ReportEvents.class);
	                    	                                    
	                                    // Test Report_Events
	                                    ReportEvents.ReportEvents_validation(excelFilePath, "Report_Events");
	     }
	
 	  @Test //Report_Facility 
	 	public void TestCase02_ReportFacility() throws Exception {
                        System.out.println("ReportFacility _Test_Validation");
                                        PageFactory.initElements(driver, ReportFacility.class);
                  
                                        // Test Report_Facility 
	                                    ReportFacility.ReportFacility_validation(excelFilePath, "Report_Facility");
         }
      @Test //Report_PointsofOrigin 
        public void TestCase03_ReportPointsofOrigin() throws Exception {
     				   System.out.println("ReportPointsofOrigin _Test_Validation");
                  			           PageFactory.initElements(driver, ReportPointsofOrigin.class);
                                      
              				            // Test Report_PointsofOrigin
                                        ReportPointsofOrigin.ReportPointsofOrigin_validation(excelFilePath, "Report_PointsofOrigin");
         }		 
      @Test //Report_GroupSummary 
         public void TestCase04_ReportGroupSummary() throws Exception {
                         System.out.println("ReportGroupSummary _Test_Validation");
                                         PageFactory.initElements(driver, ReportGroupSummary.class);
                                                 
                                         // Test Report_GroupSummary
                                         ReportGroupSummary.ReportGroupSummary_validation(excelFilePath, "Report_GroupSummary");
         }
	  @Test //Report_Requests
      	 public void TestCase05_ReportRequests() throws Exception {
	                     System.out.println("ReportRequests _Test_Validation");
	                                     PageFactory.initElements(driver, ReportRequests.class);
	                 
	                                 
	                                    // Test Report_Requests
	                                    ReportRequests.ReportRequests_validation(excelFilePath, "Report_Requests");
      	 }
      @Test //Report_Mail 
 		 public void TestCase06_ReportMail() throws Exception {
                         System.out.println("ReportMail _Test_Validation");
                                         PageFactory.initElements(driver, ReportMail.class);
                                                  
                                        // Test Report_Mail
                                        ReportMail.ReportMail_validation(excelFilePath, "Report_Mail");
         }
      @Test //Applications     
	     public void TestCase07_Applications() throws Exception {
                      System.out.println("Applications _Test_Validation");
                                      PageFactory.initElements(driver, Applications.class);          
                   
                                      // Test Applications
                                      Applications.Applications_validation(excelFilePath, "Applications"); 
		 }
      @Test //Global_Search
	     public void TestCase08_Global_Search() throws Exception {
		             System.out.println("Global Search_Test_Validation");
		                        	 PageFactory.initElements(driver, GlobalSearch.class);
			
		                         	// Test Global Search 
		                        	GlobalSearch.ReportGlobalSearch_validation(excelFilePath, "Global_Search");
	     }
	  @Test //User_Settings 
         public void TestCase09_UserSettings() throws Exception {
                         System.out.println("UserSettings _Test_Validation");
                                         PageFactory.initElements(driver, UserSettings.class);
                             
                                              
                                        // Test User_Settings
                                        UserSettings.UserSettings_validation(excelFilePath, "User_Settings");
         }         
 	  @Test //Report_Logins      
	 	 public void TestCase10_ReportLogins() throws Exception {
                           System.out.println("ReportLogins _Test_Validation");
                                           PageFactory.initElements(driver, ReportLogins.class);          
                           
                                          // Test Report_Logins
                                         ReportLogins.ReportLogins_validation(excelFilePath, "Report_Logins"); 
  		 }
 	  @Test //OnboardingDocumentation    
	  	 public void TestCase11_OnboardingDocumentation() throws Exception {
				         System.out.println("OnboardingDocumentation_Test_Validation");
                                     PageFactory.initElements(driver, Applications.class);          
             
                                     // Test OnboardingDocumentation
                                     OnboardingDocumentation.OnboardingDocumentation_validation(excelFilePath, "Onboarding_Documentation"); 
         } 
      @Test //OnboardingPDF    
		 public void TestCase12_OnboardingPDF() throws Exception {
                     System.out.println("OnboardingPDF_Test_Validation");
                                     PageFactory.initElements(driver, Applications.class);          
             
                                     // Test OnboardingPDF
                                     OnboardingPDF.OnboardingPDF_validation(excelFilePath, "Onboarding_PDF"); 
         }  
	  @Test //OnboardingRequest    
	     public void TestCase13_OnboardingRequest() throws Exception {
                     System.out.println("OnboardingRequest_Test_Validation");
                                     PageFactory.initElements(driver, OnboardingRequest.class);          
         
                                    // Test OnboardingRequest
                                    OnboardingRequest.OnboardingRequest_validation(excelFilePath, "Onboarding_Request"); 
         }
	  @Test //UserSettingsAppList    
	     public void TestCase14_UserSettingsAppList() throws Exception {
                      System.out.println("UserSettingsAppList_Test_Validation");
                                      PageFactory.initElements(driver, UserSettingsAppList.class);          
      
                                    // Test UserSettingsAppList
                                     UserSettingsAppList.UserSettingsAppList_validation(excelFilePath, "User_Settings_AppList"); 
	     }
   	  @Test //Report_UserSummary 
	 	public void TestCase15_ReportUserSummary() throws Exception {
          System.out.println("ReportUserSummary _Test_Validation");
                          PageFactory.initElements(driver, ReportUserSummary.class);

            
                         // Test Report_UserSummary 
                         ReportUserSummary.ReportUserSummary_validation(excelFilePath, "Report_UserSummary");
	     }
	     
	     
*/
	     
//	     
//	  @Test //AdminApplicationRequests     
//		 public void TestCase16_AdminApplicationRequests() throws Exception {
//                         System.out.println("AdminApplicationRequests _Test_Validation");
//                                         PageFactory.initElements(driver, AdminApplicationRequests.class);          
//                         
//                                        // Test AdminApplicationRequests
//                                        AdminApplicationRequests.AdminApplicationRequests_validation(excelFilePath, "Admin_Application_Requests"); 
//		 }
	  @Test //AdminAccountRequests     
		 public void TestCase17_AdminAccountRequests() throws Exception {
                         System.out.println("AdminAccountRequests _Test_Validation");
                                         PageFactory.initElements(driver, AdminAccountRequests.class);          
                         
                                        // Test AdminAccountRequests;
                                         AdminAccountRequests.AdminAccountRequests_validation(excelFilePath, "Admin_Account_Requests"); 
	     }
//	  @Test //AdministrationManageAccounts     
//		 public void TestCase18_AdministrationManageAccounts() throws Exception {
//	                     System.out.println("AdministrationManageAccounts _Test_Validation");
//	                                     PageFactory.initElements(driver, AdministrationManageAccounts.class);          
//	                     
//	                                    // Test Administration_Manage_Accounts
//	                                    AdministrationManageAccounts.AdministrationManageAccounts_validation(excelFilePath, "Admin_Manage_Accounts"); 
//		 } 
//	  @Test //AdminManageFacilities     
//		 public void TestCase19_AdminManageFacilities() throws Exception {
//	                     System.out.println("AdminManageFacilities _Test_Validation");
//	                                     PageFactory.initElements(driver, AdminManageFacilities.class);          
//	                     
//	                                    // Test AdminManageFacilities
//	                                    AdminManageFacilities.AdminManageFacilities_validation(excelFilePath, "Admin_Manage_Facilities");
//		 } 
//	  @Test //AdminManageGroups     
// 	     public void TestCase20_AdminManageGroups() throws Exception {
//                         System.out.println("AdminManageGroups _Test_Validation");
//                                         PageFactory.initElements(driver, AdminManageGroups.class);          
//                          
//                                         // Test AdminManageGroups
//                                         AdminManageGroups.AdminManageGroups_validation(excelFilePath, "Admin_Manage_Groups"); 
// 	     }
// 	  
// 
 	  }

//======================================    END    ================================================================
