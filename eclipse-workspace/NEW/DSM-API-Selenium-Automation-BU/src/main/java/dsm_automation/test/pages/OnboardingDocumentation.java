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


public class OnboardingDocumentation extends LoadDriver {
	//Click link please use this 
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public OnboardingDocumentation(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Onboarding')]")
	private static WebElement Onboarding_Link;
	
	@FindBy(how = How.XPATH, using = "/html/body/main/div/div[1]/div[1]/p[3]/a[1]")
	private static WebElement ViewOnlineDocumentation_link;	
	
	
	// Test OnboardingDocumentation form
	public static void OnboardingDocumentation_validation(String excelFilePath, String sheetName) throws Exception {
		System.out.println("***************** OnboardingDocumentation Test_Validation- in validation *****************");
		Thread.sleep(200);
		
		PageFactory.initElements(driver, commonpageActions.class);
		
		//this will wait for page to load
		commonpageActions.waitForPageToLoad();		
		
			//this method is for to click any link- in this case it is clicking on Onboarding link
			commonpageActions.click(driver, Onboarding_Link , 360);
			 	
				//this method is for to click any link- in this case it is clicking on View Online Documentation link
				commonpageActions.click(driver, ViewOnlineDocumentation_link , 360);
				
					TakeScreenShots.TakesScreenshot(ViewOnlineDocumentation_link);	
                              
				System.out.println ("~~~~~~~~~~~~~~~~OnboardingDocumentation_test is complete~~~~~~~~~~~~~~~~~");			
			
				}
		}
