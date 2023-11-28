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


public class ReportLogins extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportLogins(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logins')]")
	private static WebElement Logins_Link;
	
	@FindBy(how = How.XPATH, using = "//select[@id='successful']")
	private static WebElement successful;
	
	@FindBy(how = How.XPATH, using = "//*[@id='id']")
	private static WebElement id;

	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	private static WebElement username;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='session_id']")
	private static WebElement session_id;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ip_address']")
	private static WebElement ip_address;
	
	@FindBy(how = How.XPATH, using = "//input[@id='message']")
	private static WebElement message;

	@FindBy(how = How.XPATH, using = "//input[@id='org_id']")
	private static WebElement org_id;

	@FindBy(how = How.XPATH, using = "//input[@name='start_date']")
	private static WebElement start_date;
	
	@FindBy(how = How.XPATH, using = "//input[@name='end_date']")
	private static WebElement end_date;	
	
	@FindBy(how = How.XPATH, using = "//*[@id='filter_button']")
	private static WebElement filter_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id='details-link']")
	private static WebElement details_link;
	
	@FindBy(how = How.XPATH, using = "//*[@id='clear_button']")
	private static WebElement clear_button;
	

	// Test Report Logins form
	public static void ReportLogins_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("****************** Logins Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
			//this will wait for page to load
			commonpageActions.waitForPageToLoad();
		
				//this method is for to click any link- in this case it is clicking on Reports link 
				commonpageActions.click(driver, Reports_Link , 360);
   		
					//this method is for to click any link- in this case it is clicking on Logins link
					// NOTE---> LOGINS LINK TAKES 3 MINUTES TO LOAD PAGE
					commonpageActions.click(driver, Logins_Link , 360);
								
						//this method is for to read the data from excel sheet and enter data in a Logins form 
						commonpageActions.ReportLogins(excelFilePath, sheetName, successful, id, username, session_id, ip_address, 
							message, org_id, start_date, end_date );
					
							//this method is for to click any button in this case it is clicking on Filter button
							commonpageActions.click(driver, filter_button , 360);
							
								//this method is for to click any button in this case it is clicking on Save Report button
//								commonpageActions.click(driver, details_link , 360);
								
//									//this method is for to click any button in this case it is clicking on Clear button
//									commonpageActions.click(driver, clear_button , 360);									
									
  TakeScreenShots.TakesScreenshot(filter_button);
		  
//												Assert.assertEquals("106220",event_ID);
					
				
				System.out.println ("~~~~~~~~~~~~~~~~Reports Logins_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
		}
