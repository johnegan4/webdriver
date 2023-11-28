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


public class ReportUserSummary extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportUserSummary(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/ul/ul/li[5]/a")
	private static WebElement user_activity_summary_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id='whichfacility']")
	private static WebElement whichfacility;	
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtGivenname']")
	private static WebElement txtGivenname;

	@FindBy(how = How.XPATH, using = "//input[@name='txtSN']")
	private static WebElement txtSN;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtVAEmailAddress']")
	private static WebElement txtVAEmailAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtDirectAddress']")
	private static WebElement txtDirectAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtUserName']")
	private static WebElement txtUserName;

	@FindBy(how = How.XPATH, using = "//select[@name='user_status_type']")
	private static WebElement user_status_type;

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

	// Test Report User Summary form
	public static void ReportUserSummary_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** UserSummary Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
				//this will wait for page to load
				commonpageActions.waitForPageToLoad();
		
					//this method is for to click any link- in this case it is clicking on reports link 
					commonpageActions.click(driver, Reports_Link , 360);
   		
						//this method is for to click any link- in this case it is clicking on User Summary link
						commonpageActions.click(driver, user_activity_summary_Link , 360);
								
							//this method is for to read the data from excel sheet and enter data in a User Summary form 
							commonpageActions.ReportUserSummary(excelFilePath, sheetName, whichfacility, txtGivenname, txtSN, 
							txtVAEmailAddress, txtDirectAddress, txtUserName, user_status_type, start_date, end_date );
					
								//this method is for to click any button in this case it is clicking on Filter button
								commonpageActions.click(driver, filter_button , 360);
								
									//this method is for to click any button in this case it is clicking on Save Report button
//									commonpageActions.click(driver, details_link , 360);
									
										//this method is for to click any button in this case it is clicking on Clear button
//										commonpageActions.click(driver, clear_button , 360);
			
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
  TakeScreenShots.TakesScreenshot(filter_button);
		  
//												Assert.assertEquals("106220",event_ID);
					
													System.out.println ("~~~~~~~~~~~~~~~~Reports UserSummary_test is complete~~~~~~~~~~~~~~~~~");			
				}
	 } 