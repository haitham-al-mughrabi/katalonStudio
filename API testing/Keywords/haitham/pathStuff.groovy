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

import groovy.transform.SourceURI
import java.nio.file.Path
import java.nio.file.Paths
import java.io.File

public class pathStuff {
	@Keyword
	def getPath() {
		@SourceURI
				URI sourceUri
		Path scriptLocation = Paths.get(sourceUri).getParent().getParent().getParent()
		return scriptLocation.toString()
	}
	@Keyword
	def setPath(def rootPath, def filePath) {
		try {
			if(rootPath!=null && filePath!=null) {
				return new File(rootPath, filePath).toString()
				return Paths.get(rootPath,filePath)
			}
			else
				return null
		}
		catch(Exception e) {
			println e
			return null
		}
	}
}
