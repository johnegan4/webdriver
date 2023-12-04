package dsm_automation.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dsm_automation.test.methods.commonpageActions;
import dsm_automation.test.util.LoadDriver;
import dsm_automation.test.util.TakeScreenShots;

//
public class AdminAccountRequests extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public AdminAccountRequests(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using ="//*[contains(text(),'Administration')]")
	private static WebElement Administration_Link;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Account Requests')]")
	private static WebElement requests_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Approved')]")
	private static WebElement approved_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pending Approval')]")
	private static WebElement pending_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Denied')]")
	private static WebElement denied_link;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Search']")
	private static WebElement active_account_table_filter;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[3]/a")
	private static WebElement manageAccounts;
	
 	// Test AdminApplicationRequests form
	public static void AdminAccountRequests_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** AdminAccountRequests Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		
		//this method is for to click any link- in this case it is clicking on Administration link
		commonpageActions.mouseOverElement(Administration_Link);
		commonpageActions.click(driver, Administration_Link, 300);
			 	
	
	
						//this method is for to click any link- in this case it is clicking on Approved link
						commonpageActions.click(driver, approved_link, 300);
					
						
						
						//this method is for to click any link- in this case it is clicking on Denied link
	//					  commonpageActions.click(driver, denied_link, 360);
						
						//this method is for to click any link- in this case it is clicking on Pending link
//                        commonpageActions.click(driver, pending_link , 360);	
						
						//this method is for to click any link- in this case it is clicking on Requests link
//			              commonpageActions.click(driver, requests_link , 360);
						
									
				
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
// TakeScreenShots.TakesScreenshot(approved_link);
                              
				System.out.println ("~~~~~~~~~~~~~~~~AdminAccountRequests_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
	
	}


