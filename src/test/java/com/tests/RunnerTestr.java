package com.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utility.ExcelUtility;

public class RunnerTestr {
	
	static int currentRow=0;
	static List<String> executableTestCases= new ArrayList<String>(); 
	static ExcelUtility reader = new ExcelUtility("./src/main/java/com/data/SampleExcel.xlsx");
	static String sheetName = "Config";
	static String testCaseName="";
	static String fileName="";
	static int rowCount = reader.getRowCount(sheetName);

	public static void main(String[] args) throws Exception {
		System.out.println(isTestCaseRunnable("HomePageTest"));
		System.out.println(almFlag("HomePageTest"));
		//getData();
		//runTest(executableTestCases);
					
	}
	
	
	public static boolean isTestCaseRunnable(String TCID) {
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
	
	
	public static boolean almFlag(String TCID) {
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
	
	
	public static void getData() {	

		
		
		
		//System.out.println("Total Rows: "+ rowCount);
		
		
		for(int i=2; i<=rowCount;i++) {
		
			String isRunnable= reader.getCellData(sheetName, "Execution", i);			
		//	System.out.println("Execute Test Case :" +isRunnable);
				if(isRunnable.equalsIgnoreCase("Yes")) {
					currentRow=i;
		//			System.out.println("Current Row "+i);
					testCaseName = reader.getCellData(sheetName, "TestCaseName", i);
					System.out.println("Test Case Name : "+testCaseName);
					fileName = "com.tests."+testCaseName;
					executableTestCases.add(fileName);
					
					//System.err.println(fileName);					
					//runTest(fileName);
					String almFlag = reader.getCellData(sheetName, "ALMUpdate", i);
					if(almFlag.equalsIgnoreCase("Yes")) {
						
		//				System.out.println("ALM Updated");
						
					}
					
				}
				
			//	else 
			//		System.out.println("Test Case is Not Runnable");
		}	
		
		for(int i=0; i<executableTestCases.size(); i++) {
			
		//	System.out.println(executableTestCases.get(i));
			
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void runTest(List<String>listOfTestCase) throws ClassNotFoundException {
		
		XmlSuite xmlsuite = new XmlSuite();
		xmlsuite.setName("Test");
		xmlsuite.setParallel("false");
		xmlsuite.setVerbose(1);
	//	xmlsuite.addListener("com.retryanalyzer.RetryTranformer");
		
		XmlTest xmlTest = new XmlTest(xmlsuite);
		xmlTest.setName("Test_1");
		xmlTest.setPreserveOrder("true");
		
		
		
		//Class<?> clas = Class.forName("executableTestCases");
		
		
		
		List<XmlClass> list = new ArrayList<XmlClass>();
		
		
		for(int i=0; i<executableTestCases.size(); i++) {
			
			//	System.out.println(executableTestCases.get(i));
				XmlClass xmlClass = new XmlClass(Class.forName(executableTestCases.get(i)));
			//	Class.forName(executableTestCases.get(i));
				list.add(xmlClass);
				
				
		}
		
		for(int i=0; i<list.size(); i++) {
			
			System.out.println(list.get(i));
			
			
		}
		
		
		xmlTest.setXmlClasses(list);	
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlsuite);		
		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
	//	testng.
		System.out.println(testng.toString());
	//	testng.run();
				
		
	}

}
