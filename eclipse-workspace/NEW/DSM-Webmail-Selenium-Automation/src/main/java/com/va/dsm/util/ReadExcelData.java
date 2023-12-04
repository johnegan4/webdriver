package com.va.dsm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ReadExcelData(String xlFilePath) throws Exception {
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int col_Num = -1;
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}

			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(col_Num);

			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				// String cellValue = String.valueOf(cell.getNumericCellValue());
				String cellValue = String.valueOf(cell.getRawValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist  in Excel";
		}
	}

	public static String readFilePathFromConfig() {
		File file = new File("resources/config.properties");
		FileInputStream fileInput = null;
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

		String filePath = prop.getProperty("exceldatafilepath");

		return filePath;
	}

	// Read all contents of excel sheet
	public static Map<String, Map<String, String>> readExcelFile(String excelFilePath, String sheetName)
			throws IOException {
		Map<String, Map<String, String>> completeSheetData = new HashMap<String, Map<String, String>>();
		try {
			List<String> columnHeader = new ArrayList<String>();

			File file = new File(excelFilePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook excelDataWorkBook = new XSSFWorkbook(inputStream);
			Sheet excelDataSheet = excelDataWorkBook.getSheet(sheetName);

			Row row = excelDataSheet.getRow(0);
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				columnHeader.add(cellIterator.next().getStringCellValue());
			}

			int rowCount = excelDataSheet.getLastRowNum() - excelDataSheet.getFirstRowNum();

			for (int i = 1; i <= rowCount; i++) {
				Map<String, String> singleRowData = new HashMap<String, String>();
				row = excelDataSheet.getRow(i);
				// Create a loop to print cell values in a row
				for (int j = 0; j < row.getLastCellNum(); j++) {
					row.getCell(j).setCellType(CellType.STRING);

					singleRowData.put(columnHeader.get(j), row.getCell(j).getStringCellValue());
				}

				completeSheetData.put(String.valueOf(i), singleRowData);

			}
			inputStream.close();
			excelDataWorkBook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return completeSheetData;

	}

}
