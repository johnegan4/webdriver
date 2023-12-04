package com.va.dsm.util;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CaptureScreenShots extends LoadDriver {

	public static void CaptureScreenshot(WebElement element) throws IOException {
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

			// Capture Screenshot
			captureScreenShot(run, out, dirPath);
			Thread.sleep(1000);
			
			// Capture screenshot if the page is scrollable
			if(element != null && CommonUtil.isDisplayed(element)) {	
				JavascriptExecutor jse = ((JavascriptExecutor) driver);						
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
				captureScreenShot(run, out, dirPath);
				TimeUnit.SECONDS.sleep(2);
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
	
	
	public static BufferedImage captureImage() throws HeadlessException, AWTException {
		BufferedImage bufferedImage = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		return bufferedImage;
	}
	
    public static void captureMultipleScreenShotInSamePage(List<BufferedImage> images) throws Exception {
    	
    	String dirPath = ".//screenshots//";
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		XWPFDocument docx = new XWPFDocument();
		XWPFRun run = docx.createParagraph().createRun();
		FileOutputStream out = new FileOutputStream(dirPath + "Screenshots_" + sdf.format(d) + ".docx");
		
        int heightCurr = 0;
        int heightTotal = 4000;
        BufferedImage result = new BufferedImage(2000, heightTotal, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = result.createGraphics();
        for(BufferedImage bi : images){
            g2d.drawImage(bi, 0, heightCurr, null);
            heightCurr += 1100;
        }              
       
        String screenshot_name = System.currentTimeMillis() + ".png";
		File file = new File(dirPath + screenshot_name);
		ImageIO.write(result, "png", file);
		InputStream pic = new FileInputStream(dirPath + screenshot_name);
		run.addBreak();
		run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(500), Units.toEMU(500));
		pic.close();
		file.delete();
		g2d.dispose();
		
		docx.write(out);
		out.flush();
		out.close();
		docx.close();

	}
}
