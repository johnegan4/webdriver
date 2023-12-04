package com.va.dsm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Common utility class to create different drivers
 * */
public class LoadDriver {
	public static WebDriver driver;
	/*
	 * public LoadDriver(String browserName) { createDriver(browserName); }
	 */

	public static WebDriver createDriver(String browserName) {
		if (browserName.toUpperCase().equals("EDGE"))
			return edgeDriver();

		if (browserName.toUpperCase().equals("CHROME")) {
			System.out.println("Return Chrome Driver");
			return chromeDriver();
		}
		
		if (browserName.toUpperCase().equals("IE")) {
			System.out.println("Return IE Driver");
			return ieDriver();
		}

		throw new RuntimeException("invalid browser name");
	}

	// Chrome Driver
	public static WebDriver chromeDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", getDriverPath("CHROME"));

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");// maximize window
			options.addArguments("disable-infobars"); // disable infobars
			options.addArguments("--disable-extensions"); // disable extensions
			options.addArguments("--disable-gpu");// applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--remote-debugging-port=9222");
			options.addArguments("ignore-certificate-errors");
			options.addArguments("test-type");
			options.setExperimentalOption("useAutomationExtension", false);

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			return driver;
			
			/*WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--ignore-certificate-errors");
			options.addArguments("test-type");
			options.addArguments("start-maximized");// maximize window
			options.addArguments("disable-infobars"); // disable infobars
			options.addArguments("--disable-extensions"); // disable extensions
			options.addArguments("--disable-gpu");// applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--remote-debugging-port=9222");
			//options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setAcceptInsecureCerts(true);
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.binary", getDriverPath("CHROME"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			
			return driver;*/
		}

		catch (Exception ex) {
			System.out.println("chromeDriver exception ->"+ex);
			throw new RuntimeException("could not create chrome driver");
		}
	}

	// Edge Driver
	public static WebDriver edgeDriver() {
		try {
			System.setProperty("webdriver.edge.driver", getDriverPath("EDGE"));
			return new EdgeDriver();
		} catch (Exception ex) {
			throw new RuntimeException("could not create the edge driver");
		}
	}
	
	// IE Driver
	public static WebDriver ieDriver() {
		try {
			
			System.setProperty("webdriver.ie.driver", getDriverPath("IE"));
			InternetExplorerOptions options = new InternetExplorerOptions();
			//options.destructivelyEnsureCleanSession();
			options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new InternetExplorerDriver(options);
			driver.manage().window().maximize();
			return driver;
		} catch (Exception ex) {
			throw new RuntimeException("could not create the IE driver");
		}
	}

	// Read location of driver path
	private static String getDriverPath(String browserName) {

		File file = new File("resources/config.properties");
		FileInputStream fileInput = null;
		String driverPath = null;
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

		if (browserName.toUpperCase().equals("EDGE"))
			driverPath = prop.getProperty("edgedriverpath");

		if (browserName.toUpperCase().equals("CHROME"))
			driverPath = prop.getProperty("chromedriverpath");
		
		if (browserName.toUpperCase().equals("IE"))
			driverPath = prop.getProperty("iedriverpath");		

		return driverPath;
	}

}
