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


public class ReportMail extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportMail(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Mail')]")
	private static WebElement Mail_Link;
	
	@FindBy(how = How.XPATH, using = "//select[@id='successful']")
	private static WebElement successful;
	
	@FindBy(how = How.XPATH, using = "//input[@name='id']")
	private static WebElement id;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mdn']")
	private static WebElement mdn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bound']")
	private static WebElement bound;

	@FindBy(how = How.XPATH, using = "//input[@name='sender']")
	private static WebElement sender;
	
	@FindBy(how = How.XPATH, using = "//input[@name='recipient']")
	private static WebElement recipient;
	
	@FindBy(how = How.XPATH, using = "//input[@name='file_size']")
	private static WebElement file_size;
	
	@FindBy(how = How.XPATH, using = "//input[@id='attachment_type']")
	private static WebElement attachment_type;

	@FindBy(how = How.XPATH, using = "//select[@name='protected_data']")
	private static WebElement protected_data;

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
	

	// Test Report Mail form
	public static void ReportMail_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Mail Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
			//this will wait for page to load
			commonpageActions.waitForPageToLoad();
		
				//this method is for to click any link- in this case it is clicking on reports link 
				commonpageActions.click(driver, Reports_Link , 360);
   		
					//this method is for to click any link- in this case it is clicking on Mail link
					commonpageActions.click(driver, Mail_Link , 360);
								
						//this method is for to read the data from excel sheet and enter data in a event form 
						commonpageActions.ReportMail(excelFilePath, sheetName, successful, id, mdn, bound, 
							sender, recipient, file_size, attachment_type, protected_data, start_date, end_date );
					
							//this method is for to click any button in this case it is clicking on Filter button
							commonpageActions.click(driver, filter_button , 360);
							
								//this method is for to click any button in this case it is clicking on Save Report button
//								commonpageActions.click(driver, details_link , 360);
								
									//this method is for to click any button in this case it is clicking on Clear button
//									commonpageActions.click(driver, clear_button , 360);
			
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
  TakeScreenShots.TakesScreenshot(filter_button);
		  
//											Assert.assertEquals("106220",event_ID);
					
					
				
												System.out.println ("~~~~~~~~~~~~~~~~Reports Mail_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
		}
