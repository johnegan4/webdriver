package dsm_automation.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 

import dsm_automation.test.methods.commonpageActions;
import dsm_automation.test.util.LoadDriver;
import dsm_automation.test.util.TakeScreenShots;

public class ReportEvents extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportEvents(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Events')]")
	private static WebElement Events_Link;
	
	@FindBy(how = How.XPATH, using = "//select[@id='successful']")
	private static WebElement successful;
	
	@FindBy(how = How.XPATH, using = "//*[@id='event_id']")
	private static WebElement event_ID;

	@FindBy(how = How.XPATH, using = "//input[@name='action']")
	private static WebElement action_ID;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='target_user']")
	private static WebElement target;
	
	@FindBy(how = How.XPATH, using = "//select[@name='target_type']")
	private static WebElement target_type;
	
	@FindBy(how = How.XPATH, using = "//input[@id='acting_user']")
	private static WebElement acting_user;

	@FindBy(how = How.XPATH, using = "//select[@name='acting_type']")
	private static WebElement acting_type;

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
	
	@FindBy(how = How.XPATH, using = "//*[@id='event_id_type']")
	private static WebElement event_id_type;
	
	
	 	
	// Test Report Event form
	public static void ReportEvents_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Event Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		//this method is for to click any link- in this case it is clicking on reports link 
   		commonpageActions.click(driver, Reports_Link , 360);
   		
   				//this method is for to click any link- in this case it is clicking on Events link
				commonpageActions.click(driver, Events_Link , 360);
								
					//this method is for to read the data from excel sheet and enter data in a event form 
					commonpageActions.ReportEvents(excelFilePath, sheetName, 
							successful, event_ID, action_ID, target, target_type, acting_user, acting_type, start_date, end_date );
					
//					
				
					
						//this method is for to click any button in this case it is clicking on Filter button
						commonpageActions.click(driver, filter_button , 360);
					    //this method is for to click any button in this case it is clicking on Save Report button
//						commonpageActions.click(driver, details_link , 360);
						//this method is for to click any button in this case it is clicking on Clear button
//						commonpageActions.click(driver, clear_button , 360);
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@						
 TakeScreenShots.TakesScreenshot(filter_button);
						
//						Assert.assertEquals("106220",event_ID);									
//						SoftAssertion.assertAll();
						
				 
				
				System.out.println ("~~~~~~~~~~~~~~~~Reports Events_test is complete~~~~~~~~~~~~~~~~~"); 
				
				} } 
      