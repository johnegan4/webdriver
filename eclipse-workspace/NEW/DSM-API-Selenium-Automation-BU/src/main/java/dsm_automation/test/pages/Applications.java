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


public class Applications extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public Applications(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Application')]")
	private static WebElement Application_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Active')]")
	private static WebElement active_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pending Approval')]")
	private static WebElement pending_link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Denied')]")
	private static WebElement denied_link;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Search']")
	private static WebElement active_application_table_filter;
	
	
	// Test Applications form
	public static void Applications_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Applications Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();		
		
			//this method is for to click any link- in this case it is clicking on Applications link
			commonpageActions.click(driver, Application_Link , 360);
			 	
				//this method is for to click any link- in this case it is clicking on Denied link
//					commonpageActions.click(driver, denied_link, 360);
		
						//this method is for to click any link- in this case it is clicking on Pending Approval link
//						commonpageActions.click(driver, pending_link , 360);
		
							//this method is for to click any link- in this case it is clicking on Active link
							commonpageActions.click(driver, active_link , 360);
							
							
							//this method is for to read the data from excel sheet and enter data in a Applications form 
							commonpageActions.Applications(excelFilePath, sheetName, 
									active_application_table_filter );
							
							
							
							
			 			
							TakeScreenShots.TakesScreenshot(active_link);		
	
				
				
                              
				System.out.println ("~~~~~~~~~~~~~~~~Applications_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
	
	}

