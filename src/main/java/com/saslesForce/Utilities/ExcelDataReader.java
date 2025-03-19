package com.saslesForce.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReader {
	static String sheetName;
	static String actualsheetName;
	static Workbook wbook;
	static DataFormatter dataformat;
	static Sheet wsheet;
	static Object finaldata[][];
	 
	public static Object[][] readDataFromExcel(String givenSheetName) throws Exception {
		System.out.println("Sheet Name*****: "+ givenSheetName);
		//1.Data Formatter
		    DataFormatter dataformat = new DataFormatter();
		
		//2. Read excel data:
		    FileInputStream fis = new FileInputStream("C:\\Workspace\\com.testNGFrameWork.SalesForce\\src\\main\\java\\com\\SalesForce\\Data\\TestData.xlsx");
		    Workbook wbook= WorkbookFactory.create(fis);
		    
		//3.Count the no.of sheets and select the sheet to fetch data
		    int sheetCount = wbook.getNumberOfSheets();
		    for(int i=0; i<sheetCount; i++) {
		    sheetName = wbook.getSheetName(i);
		    if (sheetName.equalsIgnoreCase(givenSheetName)) {
		    	System.out.println("Sheet Name:"+ sheetName);
		    	Sheet wsheet= wbook.getSheetAt(i);
		    	
		  //4. Get the row and column
		    	int rowCount = wsheet.getPhysicalNumberOfRows();
		    	Row firstRow = wsheet.getRow(1);
		    	System.out.println("Row Count: "+ rowCount);
		    	int colCount = firstRow.getPhysicalNumberOfCells();
		    	System.out.println("Column Count: "+ colCount);
		    	Object data[][] = new Object[rowCount-1][colCount];
		    	System.out.println("Row Count: "+ rowCount);
		    	
		    	for (int m=0; m<rowCount-1; m++) {
		    	Row row = wsheet.getRow(m+1);
		    	 for (int n=0; n<colCount; n++) {
		    		  Cell cellValue = row.getCell(n);
		    		  data[m][n] = dataformat.formatCellValue(cellValue);
		    		 System.out.println( "Data from excel["+m+"]["+n+"] : "+ data[m][n]); 
		    	   }
		    	}
		    	 finaldata = data;
		    	
		    }
		    }
		 
		    return finaldata;	
	}
	
	/*public static void getData(String shName) {
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExcelDataReader ex = new ExcelDataReader();
		Object[][] values = ex.readDataFromExcel();
		System.out.println("values:"+ values.length);
		
	}*/

}
