package com.tests;

import com.utility.ExcelUtility;

public class ExcelTest {
	
	static int currentRow=0;

	public static void main(String[] args) throws Exception {

		ExcelUtility reader = new ExcelUtility("./src/main/java/com/data/SampleExcel.xlsx");
		String sheetName = "TestData";
		String userName="";
		String passWord="";
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("Total Rows: "+ rowCount);
		
		
		for(int i=2; i<=rowCount;i++) {
		
			String testCaseName= reader.getCellData(sheetName, "TestCaseName", i);			
			System.out.println("Test Case Name :" +testCaseName);
				if(testCaseName.equalsIgnoreCase("LoginPageTest")) {
					currentRow=i;
					System.out.println("Current Row "+i);
					userName = reader.getCellData(sheetName, "UserName", i);
					System.out.println("UserName : "+userName);
					
					passWord = reader.getCellData(sheetName, "Password", i);
					System.out.println("Password : "+passWord);
					
					
					
					
				}
		}	
					
	}
	
	
}
