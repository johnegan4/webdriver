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


public class OnboardingRequest extends LoadDriver {
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public OnboardingRequest(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Onboarding')]")
	private static WebElement Onboarding_Link;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Request Application Access')]")
	private static WebElement RequestApplicationAccess_Link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_name']")
	private static WebElement app_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_url']")
	private static WebElement app_url;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_desc']")
	private static WebElement app_desc;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_just']")
	private static WebElement app_just;		
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_poc_name']")
	private static WebElement app_poc_name;	
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_poc_email']")
	private static WebElement app_poc_email;	
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_poc_phone']")
	private static WebElement app_poc_phone;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private static WebElement Save;
	
//	@FindBy(how = How.XPATH, using = "//*[@id='dpii_api_token']")
//	private static WebElement dpii_api_token_button;
	
	
	
	
	// Test Onboarding Request form
	public static void OnboardingRequest_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** Onboarding Request Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		//this method is for to click any link- in this case it is clicking on Onboarding link 
   		commonpageActions.click(driver, Onboarding_Link , 360);
   		
   				//this method is for to click any link- in this case it is clicking on Request Application Access link
				commonpageActions.click(driver, RequestApplicationAccess_Link , 360);
								
					//this method is for to read the data from excel sheet and enter data in a Onboarding Request form 
					commonpageActions.OnboardingRequest(excelFilePath, sheetName, app_name, app_url, app_desc, app_just, app_poc_name, app_poc_email, app_poc_phone );
									
						//this method is for to click any button in this case it is clicking on Save button
						commonpageActions.click(driver, Save , 360);
						
							TakeScreenShots.TakesScreenshot(Save);				
			  
	//						Assert.assertEquals("106220",event_ID1);
			
								System.out.println ("~~~~~~~~~~~~~~~~Onboarding Request_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
		}
