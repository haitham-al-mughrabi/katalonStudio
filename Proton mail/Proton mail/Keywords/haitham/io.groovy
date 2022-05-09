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
import java.io.File

public class io {
	@Keyword
	def readFromFile(def filePath) {
		def lines=[],userindex=0
		new File(filePath).eachLine{ line->
			def splittedLine=line.split(','),userInfo=[:]
			userInfo.put('id',userindex)
			userInfo.put('username',splittedLine[0])
			userInfo.put('password',splittedLine[1])
			lines.add(userInfo)
			userindex+=1
		}
		println (lines)
	}
	@Keyword
	def writeOnFile(def filePath,def outputs,def writingStatus='append') {
		if(writingStatus =='append') {
			for(line in outputs) {
				File output = new File(filePath)
						output.withWriterAppend { out-> out.println(line) }		
			}				
			}
	}
}
