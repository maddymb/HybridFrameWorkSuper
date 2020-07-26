package com.utility;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utility.ExcelUtility;

public class RunnerTest {
	
	static int currentRow=0;
	static List<String> executableTestCases= new ArrayList<String>(); 
	static ExcelUtility reader = new ExcelUtility("./src/main/java/com/data/SampleExcel.xlsx");
	static String sheetName = "Config";
	static String testCaseName="";
	static String fileName="";
	static int rowCount = reader.getRowCount(sheetName);
	public static String id="";

	public static void main(String[] args) throws Exception {
		//System.out.println(isTestCaseRunnable("HomePageTest"));
		//System.out.println(almFlag("HomePageTest"));
		//getData();
		//runTest(executableTestCases);
		
		System.out.println(id);
					
	}
	
	public RunnerTest(String id) {
		this.id=id;	
	}
	
	public static boolean isTestCaseRunnable(String TCID) {
		//TCID=id;
		System.out.println(id);
		boolean isExecutable=false;
		for(int i=2; i<=rowCount;i++) {
			String testCaseName= reader.getCellData(sheetName, "TestCaseName", i);	
			if(testCaseName.equalsIgnoreCase(TCID)) {				
				//System.out.println("Test Case ID Found");
				String runFlag= reader.getCellData(sheetName, "Execution", i);
				//System.out.println("Run Flag For TCID "+runFlag);
				if(runFlag.equalsIgnoreCase("Yes")) {
					//System.out.println("Test Case is Running");
					isExecutable=true;
					break;
				}
				else
					//System.out.println("Please make sure 'AUT_To_Start' flag to 'Y' in your datasheet, if you want to start the application");
					isExecutable=false;
					break;
			}
			else
				//System.out.println("The Test Case id is either invalid or Runmode of it is not 'Y' ");
				isExecutable=false;
		}
		return isExecutable;
	}
	
	
	public static boolean almFlag() {
		String TCID=id;
		boolean isExecutable=false;
		for(int i=2; i<=rowCount;i++) {
			String testCaseName= reader.getCellData(sheetName, "TestCaseName", i);	
			if(testCaseName.equalsIgnoreCase(TCID)) {				
				//System.out.println("Test Case ID Found");
				String almFlag= reader.getCellData(sheetName, "ALMUpdate", i);
				//System.out.println("Run Flag For TCID "+runFlag);
				if(almFlag.equalsIgnoreCase("Yes")) {
					//System.out.println("Test Case is Running");
					isExecutable=true;
					break;
				}
				else
					//System.out.println("Please make sure 'AUT_To_Start' flag to 'Y' in your datasheet, if you want to start the application");
					isExecutable=false;
					break;
			}
			else
				//System.out.println("The Test Case id is either invalid or Runmode of it is not 'Y' ");
				isExecutable=false;
		}
		return isExecutable;
	}
	
	
	
}
