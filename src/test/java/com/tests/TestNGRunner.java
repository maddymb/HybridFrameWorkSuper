package com.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


public class TestNGRunner {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		
		XmlSuite xmlsuite = new XmlSuite();
		xmlsuite.setName("Test");
		xmlsuite.setParallel("false");
		xmlsuite.setVerbose(1);
		
		XmlTest xmlTest = new XmlTest(xmlsuite);
		xmlTest.setName("Test_1");
		xmlTest.setPreserveOrder("true");
		
		XmlClass xmlClass = new XmlClass(LoginPageTest.class);
		
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
