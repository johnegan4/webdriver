package dsm_automation.test.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import dsm_automation.test.methods.commonpageActions;


public class TakeScreenShots extends LoadDriver {

	public static void TakesScreenshot(WebElement element) throws IOException {
		try {
			String dirPath = ".//screenshots//";
			Date d = new Date();
			System.out.println(d.toString());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

			// Create folder/directory if not exist.
			File file = new File("screenshots");
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}

			XWPFDocument docx = new XWPFDocument();
			XWPFRun run = docx.createParagraph().createRun();
			FileOutputStream out = new FileOutputStream(dirPath + "Screenshots_" + sdf.format(d) + ".docx");

			//Take Screenshot
			captureScreenShot(run, out, dirPath);
		    commonpageActions.waitForPageToLoad();
			
			// Capture screenshot if the page is scrollable
			if(CommonUtil.isDisplayed(element)) {	
				JavascriptExecutor jse = ((JavascriptExecutor) driver);						
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
				
//				captureScreenShot(run, out, dirPath);
			   commonpageActions.waitForPageToLoad();
				jse.executeScript("window.scrollBy(0,350)");
	
				captureScreenShot(run, out, dirPath);
				commonpageActions.waitForPageToLoad();
			}
	
			System.out.println("Write to doc file sucessfully...");

			docx.write(out);
			out.flush();
			out.close();
			docx.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void captureScreenShot(XWPFRun run, FileOutputStream out, String dirPath) throws Exception {

		String screenshot_name = System.currentTimeMillis() + ".png";
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		File file = new File(dirPath + screenshot_name);
		ImageIO.write(image, "png", file);
		InputStream pic = new FileInputStream(dirPath + screenshot_name);
		run.addBreak();
		run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(500), Units.toEMU(350));
		pic.close();
		file.delete();
	}
	

}
