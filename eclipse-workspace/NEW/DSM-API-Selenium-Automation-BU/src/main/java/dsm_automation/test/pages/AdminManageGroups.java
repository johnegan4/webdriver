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


public class AdminManageGroups extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public AdminManageGroups(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*[@id="deactivated_link"]

//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Administration')]")
//	private static WebElement Administration_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[4]/a")
	private static WebElement Administration_Link;
	
//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Groups')]")
//	private static WebElement Manage_Link;
	
//	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[4]/a")
//	private static WebElement Manage_Link;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-1\"]")
	private static WebElement Group_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-2\"]")
	private static WebElement DisableGroup_Link;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-3\"]")
	private static WebElement CreateGroup_Link;
	
//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Accounts')]")
//	private static WebElement Accounts_link;
	
//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Create')]")
//	private static WebElement Create_link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='group_name']")
	private static WebElement Group_Name;
	
	@FindBy(how = How.XPATH, using = "//select[@id='domain-field']")
	private static WebElement Domain;
	
	@FindBy(how = How.XPATH, using = "//input[@name='display_name']")
	private static WebElement Display_Name;
	
//	@FindBy(how = How.XPATH, using = "//input[@name='description']")
//	private static WebElement Description;
	
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private static WebElement Description;
	
	@FindBy(how = How.XPATH, using = "//select[@id='facility-field']")
	private static WebElement Facility;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"create\"]/form/div[2]/input")
	private static WebElement Submit;
	
	 	
	// Test AdminManageGroups form
	public static void AdminManageGroups_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** AdminManageGroups_Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		
  		//this method is for to click any link- in this case it is clicking on Administration link
   		  commonpageActions.click(driver, Administration_Link , 360);
   		  
   		//this method is for to click any link- in this case it is dropdown on Administration link
 		//commonpageActions.dropDownSelect(driver, Administration_Link , 360);
 		  
 		//this method is for to click any link- in this case it is mouseover on Administration link
 		//commonpageActions.mouseOverElement(driver, Administration_Link , 360);
			 	
		//this method is for to click any link- in this case it is clicking on Manage link
		//commonpageActions.click(driver, Manage_Link , 360);
			 	
		//this method is for to click any link- in this case it is clicking on Create Group link
		//commonpageActions.click(driver, Create_link , 360);
   		  
   	    //this method is for to click any link- in this case it is clicking on Submit link
	     commonpageActions.click(driver, Submit , 360);
				
                               //this method will read the data from excel sheet and enter data in a AdminManageGroups form 
								commonpageActions.AdminManageGroups(excelFilePath, sheetName, Group_Name, Domain, Display_Name, Description, Facility );
					 
								
								
								TakeScreenShots.TakesScreenshot(Submit);
//					
				
				System.out.println ("~~~~~~~~~~~~~~~~AdminManageGroups_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
	
	}
