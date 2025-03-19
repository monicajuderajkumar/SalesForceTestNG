package com.saslesForce.Utilities;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class ExcelReader {
	
	static String sheetName;
	static String actualsheetName;
	static Workbook wbook;
	static DataFormatter dataformat;
	static Sheet wsheet;
	static Object obj[][];
	static Object finaldata[][];
	 static int colcount;
	 static ArrayList<String> arr;
	 static int rowCount;
	 
	public static ArrayList<String> readDataFromExcel(String givenSheetName) throws Exception {
		
		ArrayList<String> arr = new ArrayList<String>();
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
		    	rowCount = wsheet.getPhysicalNumberOfRows();
		    	
		    	//5. Get first row to find the cell with testcases
		    	Row firstRow = wsheet.getRow(0);
		    	int firstRowColCount = firstRow.getPhysicalNumberOfCells();
		    	
		    	for (int a=0; a<firstRowColCount; a++) {
		    		System.out.println(firstRow.getCell(a).getStringCellValue());
		    		if((firstRow.getCell(a).getStringCellValue()).equalsIgnoreCase("TestCases")) {
		    			Cell cell = firstRow.getCell(a);
		    			System.out.println("Cell Value:"+ cell);
		    			//Object data[][] = new Object[rowCount-1][100];
		    //6. To get the test case name
		    			for(int x=0; x<rowCount-1; x++) {
		    				System.out.println("TestCase Name: "+ wsheet.getRow(x+1).getCell(a));
		    				if (wsheet.getRow(x+1).getCell(a).getStringCellValue().equalsIgnoreCase("invalidLogin")) {
		    	//7. To get the row - col values 
		    					int newrowCount=1;
		    					
		    					
		    					colcount = wsheet.getRow(x+1).getPhysicalNumberOfCells();
		    					Object data[][] = new Object[x+1][colcount];
		    					System.out.println("Targeted Column Count:" + colcount);
		    					for(int y=0; y<colcount-1; y++) {
		    						System.out.println(wsheet.getRow(x+1).getCell(y+1));
		    						Cell cellValue = wsheet.getRow(x+1).getCell(y+1);
		    						data[x][y] = dataformat.formatCellValue(cellValue);
		    						//arr.add(dataformat.formatCellValue(cellValue));
		    						System.out.println("["+x+"] ["+y+"]" + data[x][y]);
		    						System.out.println("****" + data.length);
		    						finaldata = data;
		    					}
		    				}
		    				
		    				
		    			}
		    		}
		    	}
		    	
		    	
		    }
		    }
		  //System.out.println("****" + finaldata.length);
		  System.out.println("****" + arr.size());
		  System.out.println("****" + arr.get(0));
		  System.out.println("****" + arr.get(1));
		  System.out.println("*RowCount*" + rowCount);
		  System.out.println("*ColCount*" + colcount);
		  Object obj[][] = new Object[rowCount-1][colcount];	
		 
		    return arr;	
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 readDataFromExcel("SalesForceData");
		
	}
		
}
