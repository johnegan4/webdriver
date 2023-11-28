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


public class ReportGroupSummary extends LoadDriver {
		//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportGroupSummary(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
		
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Group Summary')]")
	private static WebElement group_activity_summary_link;		
	
	@FindBy(how = How.XPATH, using = "//*[@id='whichfacility']")
	private static WebElement whichfacility;
	
	@FindBy(how = How.XPATH, using = "//*[@id='group_status_type']")
	private static WebElement group_status_type;
	
	@FindBy(how = How.XPATH, using = "//input[@name='text_group_name']")
	private static WebElement text_group_name;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='txtDirectAddress']")
	private static WebElement txtDirectAddress;

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
								
		
										

	// Test Report GroupSummary form
		public static void ReportGroupSummary_validation(String excelFilePath, String sheetName) throws Exception {
			System.out.println("***************** Reports GroupSummary Test_Validation- in validation *****************");
			Thread.sleep(200);
			
		PageFactory.initElements(driver, commonpageActions.class);
			
			//this will wait for page to load
				commonpageActions.waitForPageToLoad();
			
					//this method is for to click any link- in this case it is clicking on reports link 
						commonpageActions.click(driver, Reports_Link , 360);
	   		
						//this method is for to click any link- in this case it is clicking on GroupSummary link
							commonpageActions.click(driver, group_activity_summary_link , 360);
					
								//this method is for to read the data from excel sheet and enter data in a group summary form 
								commonpageActions.ReportGroupSummary(excelFilePath, sheetName, whichfacility, group_status_type, text_group_name, txtDirectAddress, 
										start_date, end_date );
						
									//this method is for to click any button in this case it is clicking on Filter button
										commonpageActions.click(driver, filter_button , 360);
										
											//this method is for to click any button in this case it is clicking on Save Report button
//												commonpageActions.click(driver, details_link , 360);
												
													//this method is for to click any button in this case it is clicking on Clear button
//														commonpageActions.click(driver, clear_button , 360);
														
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
  TakeScreenShots.TakesScreenshot(filter_button);
						
//                                   							Assert.assertEquals("106220",event_ID);
										
					System.out.println ("~~~~~~~~~~~~~~~~Reports Group Summary_test is complete~~~~~~~~~~~~~~~~~");			
				
					}
				}
