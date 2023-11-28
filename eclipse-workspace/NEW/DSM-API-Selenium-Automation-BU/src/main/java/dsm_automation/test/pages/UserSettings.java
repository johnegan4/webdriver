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


public class UserSettings extends LoadDriver {
	 
	//Click link please use this
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public UserSettings(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'User Settings')]")
	private static WebElement UserSettings_Link;
	
//	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[5]/a")
//	private static WebElement application_list_Link;
	
 	@FindBy(how = How.XPATH, using = "//*[@id=\"tabs\"]/ul/li[2]/a")
	private static WebElement Account_edit_Link;
			
	@FindBy(how = How.XPATH, using = "//input[@name='first_name']")
	private static WebElement first_name;
	
	@FindBy(how = How.XPATH, using = "//input[@name='last_name']")
	private static WebElement last_name;

	@FindBy(how = How.XPATH, using = "//input[@name='middle_name']")
	private static WebElement middle_name;

	@FindBy(how = How.XPATH, using = "//input[@name='ext_mail']")
	private static WebElement ext_mail;

	@FindBy(how = How.XPATH, using = "//input[@name='title']")
	private static WebElement title;

	@FindBy(how = How.XPATH, using = "//input[@name='department']")
	private static WebElement department;

	@FindBy(how = How.XPATH, using = "//input[@name='organization']")
	private static WebElement organization;
	
	@FindBy(how = How.XPATH, using = "//input[@name='telephone']")
	private static WebElement telephone;
			
	@FindBy(how = How.XPATH, using = "//input[@name='mobile']")
	private static WebElement mobile;
					
	@FindBy(how = How.XPATH, using = "//input[@name='location']")
	private static WebElement location;
	
	@FindBy(how = How.XPATH, using = "//select[@id='facility_select']")
	private static WebElement facility_select;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"accountForm\"]/div[2]/input")
	private static WebElement Save;
	


	// Test User Settings form
		public static void UserSettings_validation(String excelFilePath, String sheetName) throws Exception {
			System.out.println("***************** User Settings Test_Validation- in validation *****************");
			Thread.sleep(200);
			
			PageFactory.initElements(driver, commonpageActions.class);
			
				//this will wait for page to load
				commonpageActions.waitForPageToLoad();
				
				//this method is for to click any link- in this case it is clicking on User Settings link 
		   		commonpageActions.click(driver, UserSettings_Link , 360);
			   				
	   				//this method is for to click any link- in this case it is clicking on User Settings link
//					  commonpageActions.click(driver, application_list_Link , 360);			  
					
						//this method is for to click any link- in this case it is clicking on User Account link
						commonpageActions.click(driver, Account_edit_Link , 360);					
					
							//this method is for to read the data from excel sheet and enter data in a User Settings form 
							commonpageActions.ReportUserSettings(excelFilePath, sheetName, first_name, middle_name, 
								last_name, ext_mail, title, department, organization, telephone, mobile, 
								location, facility_select );
						  
								//this method is for to click any button in this case it is clicking on Save button
								commonpageActions.click(driver, Save , 360);
																
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
  TakeScreenShots.TakesScreenshot(Save);
							
//										Assert.assertEquals("106220",event_ID);
					
											System.out.println ("~~~~~~~~~~~~~~~~  User Settings_test is complete~~~~~~~~~~~~~~~~~");			
			}
	}
	