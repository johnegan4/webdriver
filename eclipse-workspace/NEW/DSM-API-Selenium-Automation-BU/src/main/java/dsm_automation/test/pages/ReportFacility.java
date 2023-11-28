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


public class ReportFacility extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public ReportFacility(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reports')]")
	private static WebElement Reports_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Facility')]")
	private static WebElement Facility_link;	
	
	@FindBy(how = How.XPATH, using = "//*[@id='whichfacility']")
	private static WebElement whichfacility;	
	
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

	// Test Report Facility form
	public static void ReportFacility_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Facility Test_Validation- in validation *****************");
		Thread.sleep(200);
		
	PageFactory.initElements(driver, commonpageActions.class);
		
	//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		//this method is for to click any link- in this case it is clicking on reports link 
   			commonpageActions.click(driver, Reports_Link , 360);
   		
   			//this method is for to click any link- in this case it is clicking on Facility link
   				commonpageActions.click(driver, Facility_link , 360);
				
		System.out.println("excelFilePath ->"+excelFilePath);	
		System.out.println("sheetName ->"+sheetName);	
		System.out.println("whichfacility ->"+whichfacility);	
		System.out.println("start_date ->"+start_date);	
		System.out.println("end_date ->"+end_date);	
				
				   //this method is for to read the data from excel sheet and enter data in a facility form 
				       commonpageActions.ReportFacility(excelFilePath, sheetName, whichfacility, start_date, end_date );					

					   //this method is for to click any button in this case it is clicking on Filter button
					        commonpageActions.click(driver, filter_button , 360);
					        
					        //this method is for to click any button in this case it is clicking on Save Report button
//					             commonpageActions.click(driver, details_link , 360);
//					        
//					        	//this method is for to click any button in this case it is clicking on Clear button
//									 commonpageActions.click(driver, clear_button , 360);
					        
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
  TakeScreenShots.TakesScreenshot(filter_button);		
		  
//										Assert.assertEquals("106220",event_ID);
				
				System.out.println ("~~~~~~~~~~~~~~~~Reports Facility_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
		}
