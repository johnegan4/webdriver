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


public class UserSettingsAppList extends LoadDriver {
	 
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public UserSettingsAppList(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[5]/a")
	private static WebElement application_list_Link;	
		
	@FindBy(how = How.XPATH, using = "//*[@id='application_table_filter']")
	private static WebElement application_table_filter;
	
//	@FindBy(how = How.XPATH, using = "//input[@name='app_name']")
//	private static WebElement app_name;
	
	@FindBy(how = How.XPATH, using = "//*[@id='app_name']")
	private static WebElement app_name;
		
	
	// Test User Settings App List form
		public static void UserSettingsAppList_validation(String excelFilePath, String sheetName) throws Exception {
			System.out.println("***************** User Settings App List Test_Validation- in validation *****************");
			Thread.sleep(200);
			
			PageFactory.initElements(driver, commonpageActions.class);
			
				//this will wait for page to load
				commonpageActions.waitForPageToLoad();
			   				
	   				//this method is for to click any link- in this case it is clicking on User Settings App List link
					  commonpageActions.click(driver, application_list_Link , 360);
					
						 //this method is for to click any button in this case it is clicking on Find Application Search Box
							commonpageActions.click(driver, application_table_filter , 360);
							
								//this method is for to read the data from excel sheet and enter data in a User Settings App List form 
								commonpageActions.UserSettingsAppList(excelFilePath, sheetName, app_name );
							
 				
  TakeScreenShots.TakesScreenshot(app_name);
							  
//										Assert.assertEquals("VLER Direct API",VLER Direct API);
								
											System.out.println ("~~~~~~~~~~~~~~~~  User Settings App List_test is complete~~~~~~~~~~~~~~~~~");			
				
	 }
  }
