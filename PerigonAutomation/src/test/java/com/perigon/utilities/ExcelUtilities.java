package com.perigon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtilities {

	protected static FileInputStream inputstream;
	protected static XSSFWorkbook workbook;
	protected static XSSFSheet sheet;

	@Test
	public List readExcel() {

		List<String> customerList = new ArrayList();

		File file = new File(
				"C:\\Users\\sagar.sonawane\\PerigonWorkspace\\PerigonAutomation\\TestDdata\\testdata.xlsx");
		try {
			inputstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(inputstream);
		} catch (IOException e) {

			e.printStackTrace();
		}

		sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();

		for (int i = 1; i <= lastRow; i++) {
			double customerDataAsDouble = sheet.getRow(i).getCell(0).getNumericCellValue();
			String customerID = String.format("%.0f", customerDataAsDouble);
			customerList.add(customerID);

		}

		return customerList;

	}
}
