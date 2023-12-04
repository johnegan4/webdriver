package com.va.dsm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.va.dsm.util.LoadDriver;

public class DSMEmailOthers extends LoadDriver {

	public DSMEmailOthers(WebDriver driver) {
		LoadDriver.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
