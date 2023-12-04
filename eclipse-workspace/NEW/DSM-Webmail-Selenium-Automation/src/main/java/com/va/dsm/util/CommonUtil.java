package com.va.dsm.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil extends LoadDriver {
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public CommonUtil(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Check if element is present or not in webpage
	public static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Compare values between excel and form
	public static boolean compareExcelAndForm(String excelValues, String formValues) {
		Boolean compare = false;
		try {
			System.out.println("excel is -Util->" + excelValues);
			System.out.println("form is -Util->" + formValues);

			List<String> l1 = Arrays.asList(excelValues.trim().split(","));
			List<String> l2 = Arrays.asList(formValues.trim().split("\n"));
			System.out.println("l1 is -->" + l1);
			System.out.println("l2 is -->" + l2);

			if ((l1 != null && l1.size() > 0) && (l2 != null && l2.size() > 0)) {
				for (String excel : l1) {
					System.out.println("l3 is -->" + excel);
					int i = 0;
					for (String form : l2) {
						System.out.println("l4 is -->" + form);
						if (form.trim().contains(excel.trim())) {
							System.out.println("EQUAL");
							compare = true; // Return true is string token matches
							i = 1;
							break;
						} else {
							System.out.println("NOT EQUAL");
							compare = false; // Return false is string token does not matches
						}
					}
					if (i == 0)
						break;
				}
			}

			return compare;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * private void clickWaitForPopoUp(WebDriver driver, By by,int waitTime) { final
	 * int currentWindows = driver.getWindowHandles().size();
	 * driver.findElement(by).click(); WebDriverWait wait = new
	 * WebDriverWait(driver, waitTime); wait.until(new ExpectedCondition<Boolean>()
	 * { public Boolean apply(WebDriver d) { return (d.getWindowHandles().size() !=
	 * currentWindows); } }); }
	 */
	 public static WebElement waitForElement(By locator,int timeout)
	 {
	     WebElement element=new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	     return element;
	 }
	@SuppressWarnings("deprecation")
	public static void waitforelementToBeVisible(String element) throws Exception {
		/*FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(2000, TimeUnit.SECONDS).pollingEvery(10000, TimeUnit.MILLISECONDS);*/
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}
	
	@SuppressWarnings("deprecation")
	public static void waitforelementToBeClickable(WebElement element) throws Exception {
		//FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(200000, TimeUnit.SECONDS).pollingEvery(100000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@SuppressWarnings("deprecation")
	public static void waitToVerifyPageTitle(String element) throws Exception {
		//FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(1000, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(element));
	}

	public static void zoomInZoomOut() throws Exception {
		String zoomLevelReduced = "50%";
		js.executeScript("document.body.style.zoom='" + zoomLevelReduced + "'");
	}

	public static void waitForPageToLoad() throws InterruptedException {
		int i = 0;
		while (i != 10) {
			String state = (String) js.executeScript("return document.readyState;");
			System.out.println(state);
			if (state.equals("complete"))
				break;
			else
				Thread.sleep(5000);
			i++;
		}
	}

	public static void click(WebDriver driver, WebElement link, int Timeouts) throws Exception {
		waitForPageToLoad();

		new WebDriverWait(driver, Timeouts).until(ExpectedConditions.elementToBeClickable(link));
		js.executeScript("arguments[0].click()", link);
		Thread.sleep(1000);
	}
	
	// Read location of attachment file path
	public static String getAttachmentFilePath() {

		File file = new File("resources/config.properties");
		FileInputStream fileInput = null;
		String attachmentFilePath = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		attachmentFilePath = prop.getProperty("attachmentfilepath");

		return attachmentFilePath;
	}
	
	public static void setClipboardData(String string) {			
		   StringSelection stringSelection = new StringSelection(string);		   
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void waitForSometime() {
		   int i=0;
		    while(i<15)
		    {
		        try{
		            driver.switchTo().alert();
		            Thread.sleep(20000);
		        }catch(NoAlertPresentException a){
		            break;
		        }
		        catch (Exception e) {
		        }
		        i++;
		    }
	}
	
	public static void findElement(By by) throws InterruptedException {
		  int attempts = 0;
		  while (attempts > 300)
		    try {
		      driver.findElement(by);
		    } catch (Exception e) {
		      Thread.sleep(500);
		      attempts++;
		    }
		  }		

}
