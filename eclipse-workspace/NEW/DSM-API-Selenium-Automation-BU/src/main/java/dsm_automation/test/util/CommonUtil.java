package dsm_automation.test.util;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CommonUtil {

	//Check if element is present or not in webpage
	public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	//Compare values between excel and form
	public static boolean compareExcelAndForm(String excelValues, String formValues) {
		Boolean compare = false;
        try {
        	System.out.println("excel is -Util->"+excelValues);
        	System.out.println("form is -Util->"+formValues);
        	
            List<String> l1 = Arrays.asList(excelValues.trim().split(","));
            List<String> l2 = Arrays.asList(formValues.trim().split("\n"));
            System.out.println("l1 is -->"+l1);
            System.out.println("l2 is -->"+l2);

            
            if ((l1 != null && l1.size() > 0 ) && (l2 != null && l2.size() > 0 )) {
	            for(String excel : l1)
	            {
	            	System.out.println("l3 is -->"+excel);
	            	 int i = 0;
	               for(String form : l2)
	               {	            	  	            	   
	            	   System.out.println("l4 is -->"+form);
	            	   if(form.trim().contains(excel.trim())) {
	            		   System.out.println("EQUAL");	            		   
	            		   compare = true; // Return true is string token matches
	            		   i = 1; break;
	            	   } else {
	            		   System.out.println("NOT EQUAL");
	            		   compare = false; // Return false is string token does not matches	            		  
	            	   }
	               }  if(i == 0) break;
	            }
            }
        	
            return compare;
        } catch (Exception e) {
            return false;
        }
    }
}
