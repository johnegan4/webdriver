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


public class GlobalSearch extends LoadDriver {
	 
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public GlobalSearch(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Global Search')]")
	private static WebElement GlobalSearch_Link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='message_sender']")
	private static WebElement Message_Sender;
	
	@FindBy(how = How.XPATH, using = "//input[@name='message_recipients']")
	private static WebElement Message_Recipients;

	@FindBy(how = How.XPATH, using = "//input[@name='message_subject']")
	private static WebElement Message_Subject;

	@FindBy(how = How.XPATH, using = "//input[@name='message_plain']")
	private static WebElement Message_Plain;

	@FindBy(how = How.XPATH, using = "//input[@name='message_attachments']")
	private static WebElement Message_Attachments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mailbox\"]")
	private static WebElement Mailbox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"folder\"]")
	private static WebElement Folder;
	
	@FindBy(how = How.XPATH, using = "//input[@name='start_date']")
	private static WebElement start_date;
	
	@FindBy(how = How.XPATH, using = "//input[@name='end_date']")
	private static WebElement end_date;	

	@FindBy(how = How.XPATH, using = "//*[@id='filter_button']")
	private static WebElement filter_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id='clear_button']")
	private static WebElement clear_button;
	
	

	// Test Global Search form
		public static void ReportGlobalSearch_validation(String excelFilePath, String sheetName) throws Exception {
			System.out.println("***************** Global Search Test_Validation- in validation *****************");
			Thread.sleep(200);
			
			PageFactory.initElements(driver, commonpageActions.class);
			
			//this will wait for page to load
			commonpageActions.waitForPageToLoad();			
				   		
				//this method is for to click any link- in this case it is clicking on Reports link 
	   			commonpageActions.click(driver, Reports_Link , 360);
	   		
	   				//this method is for to click any link- in this case it is clicking on Global Search link
					commonpageActions.click(driver, GlobalSearch_Link , 360);
					
						//this method is for to read the data from excel sheet and enter data in a Global Search form 
						commonpageActions.ReportGlobalSearch(excelFilePath, sheetName, Message_Sender, Message_Recipients, Message_Subject, 
							Message_Plain, Message_Attachments, Mailbox, Folder, start_date, end_date );
				
											 					
							//this method is for to click any button in this case it is clicking on Filter button
							commonpageActions.click(driver, filter_button , 360);
				
//							//this method is for to click any button in this case it is clicking on Clear button
//							commonpageActions.click(driver, clear_button , 360);
							
								TakeScreenShots.TakesScreenshot(filter_button);						
						
//						  			Assert.assertEquals("106220",event_ID);						
					
					System.out.println ("~~~~~~~~~~~~~~~~Reports Global Search_test is complete~~~~~~~~~~~~~~~~~");			
				
					}
				}
		