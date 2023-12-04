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


public class AdminManageFacilities extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public AdminManageFacilities(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[5]/a")
	private static WebElement Administration_Link;
		
//	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Facilities')]")
//	private static WebElement Facilities_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/ul/li[4]/ul/li[5]/a")
	private static WebElement Facilities_Link;
		
	@FindBy(how = How.XPATH, using = "//*[@id='create_link']")
	private static WebElement create_link;
	
	@FindBy(how = How.XPATH, using = "//input[@name='fac_name']")
	private static WebElement fac_name;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"createFacilityForm\"]/div[2]/input")
	private static WebElement CreateFacility;	
	
	//*[@id="create_link"]
	 
	
	// Test AdminManageFacilities form
	public static void AdminManageFacilities_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** AdminManageFacilities Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();
		
		//this method is for to click any link- in this case it is clicking on Administration link
		  commonpageActions.dropDownSelect(driver, Administration_Link , 360);
				
		   		  //this method is for to click any link- in this case it is clicking on Facilities link
//				commonpageActions.click(driver, Facilities_Link , 360);
			 	
					//this method is for to click any link- in this case it is clicking on Accounts link
			  		commonpageActions.click(driver, create_link , 360);			  		
			    			  						
                               //this method will read the data from excel sheet and enter data in a AdminManageFacilities form 
								commonpageActions.AdminManageFacilities(excelFilePath, sheetName, fac_name );
								
								//this method is for to click any link- in this case it is clicking on Submit link
					  			commonpageActions.click(driver, CreateFacility , 360);
					 
									
						  			
						  				TakeScreenShots.TakesScreenshot(CreateFacility);
//					
				
						  					System.out.println ("~~~~~~~~~~~~~~~~AdminManageFacilities_test is complete~~~~~~~~~~~~~~~~~");			
			
		}
	
	}
