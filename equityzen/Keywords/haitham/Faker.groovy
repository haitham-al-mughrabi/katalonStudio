package haitham

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.github.javafaker.Faker as FakerProvider
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
public class Faker {
	/* Faker
	 * In order to use faker, please keep in mind that you need
	 * to add faker to the project's dependency under build.gradle
	 * If you did not declarate build.gradle file while building the project
	 * kindly add the file and add {implementation 'com.github.javafaker:javafaker:1.0.2'}.
	 * Also you need to download the jar files in order to use the library
	 * you can find it here: https://jar-download.com/artifacts/com.github.javafaker
	 */
	@Keyword
	def initFaker() {
		FakerProvider faker = new FakerProvider();
		return faker
	}
	@Keyword
	def makeFakerObject(Map<String,String> prob) {
		Map<String,String> resutls=[:]
		def fakerInstence = initFaker()
		GroovyShell intilizedShell = new GroovyShell()
		prob.forEach { key, value -> 
			resutls[key]=intilizedShell.evaluate("${fakerInstence}.${value} ")
		}
	}
}
