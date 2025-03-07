package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

//	public ExcelUtility(String path) {
//		
//		this.path = path;
//	}
//	
//	public int getRowCount(String sheetName) {
//		fi = new FileInputStream(path);
//		workbook = new XSSFWorkbook(fi);
//		sheet = workbook.getSheet(sheetName);
//	    int rowCount = sheet.getLastRowNum();
//	    workbook.close();
//	    fi.close();
//	    return rowCount;
//	}    

	// Constructor to initialize the Excel file path
	public ExcelUtility(String path) {
		this.path = path;
	}

	// Get the total number of rows in the sheet
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}

	// Get the total number of columns in a row
	public int getColumnCount(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int colCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return colCount;
	}

	// Get cell data as a string
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter(); // Use DataFormatter to get the cell value as a string
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}

		workbook.close();
		fi.close();
		return data;
	}

	// Set data in a specific cell
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}

		cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
		}

		cell.setCellValue(data);

		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	// Add a new row with data
	public void addRow(String sheetName, String[] data) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);

		int rowNum = sheet.getLastRowNum() + 1; // Get the next available row number
		row = sheet.createRow(rowNum);

		for (int i = 0; i < data.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(data[i]);
		}

		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	// Apply a style to a specific cell
	public void applyCellStyle(String sheetName, int rowNum, int colNum, CellStyle style) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}

		cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
		}

		cell.setCellStyle(style);

		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	// Save workbook changes
	private void saveWorkbook() throws IOException {
		fo = new FileOutputStream(path);
		workbook.write(fo);
		fo.close();
	}

}
