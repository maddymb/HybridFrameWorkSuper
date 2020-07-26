package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RemoveRows {
	
	static int currentRow=0;

	public static void main(String[] args) throws Exception {
		File file =    new File("./src/main/java/com/data/SampleExcel2.xlsx");

		FileInputStream inputStream = new FileInputStream(file);

	    Workbook wb = new XSSFWorkbook(inputStream);
		
	    Sheet sheet = wb.getSheet("TestData");
	   
	    Row row = sheet.getRow(0);
	  
	    //sheet.removeRow(row);
	    
	    sheet.shiftRows(0, 1, 1);
	   
	    FileOutputStream fos = new FileOutputStream(file,true);
	    wb.write(fos);
	    
	    System.out.println("Done");
		
		
		}	
					
	}
	
	

