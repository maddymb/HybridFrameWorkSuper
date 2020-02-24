package com.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.utility.ExcelUtility;

public class RunnerTest {
	
	static int currentRow=0;

	public static void main(String[] args) throws Exception {

		ExcelUtility reader = new ExcelUtility("./src/main/java/com/data/SampleExcel.xlsx");
		String sheetName = "Config";
		String testCaseName="";
		String fileName="";
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("Total Rows: "+ rowCount);
		
		
		for(int i=2; i<=rowCount;i++) {
		
			String isRunnable= reader.getCellData(sheetName, "Execution", i);			
			System.out.println("Execute Test Case :" +isRunnable);
				if(isRunnable.equalsIgnoreCase("Yes")) {
					currentRow=i;
					System.out.println("Current Row "+i);
					testCaseName = reader.getCellData(sheetName, "TestCaseName", i);
					System.out.println("Test Case Name : "+testCaseName);
					fileName = "com.tests."+testCaseName;
					System.err.println(fileName);	
					runTest(fileName);
					String almFlag = reader.getCellData(sheetName, "ALMUpdate", i);
					if(almFlag.equalsIgnoreCase("Yes")) {
						
						System.out.println("ALM Updated");
						
					}
					
				}
		}	
					
	}
	
	@SuppressWarnings("deprecation")
	public static void runTest(String fileName) throws ClassNotFoundException {
		
		XmlSuite xmlsuite = new XmlSuite();
		xmlsuite.setName("Test");
		xmlsuite.setParallel("false");
		xmlsuite.setVerbose(1);
		xmlsuite.addListener("com.retryanalyzer.RetryTranformer");
		
		XmlTest xmlTest = new XmlTest(xmlsuite);
		xmlTest.setName("Test_1");
		xmlTest.setPreserveOrder("true");
		
		XmlClass xmlClass = new XmlClass(Class.forName(fileName));
		
		List<XmlClass> list = new ArrayList<XmlClass>();
		list.add(xmlClass);
		
		
		xmlTest.setXmlClasses(list);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlsuite);
		
		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
		testng.run();
				
		
	}

}
