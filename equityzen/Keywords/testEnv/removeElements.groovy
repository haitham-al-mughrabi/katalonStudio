package testEnv

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import haitham.TestObjectStuff as TOS
public class removeElements {
	@Keyword
	def removeIntercomElement(){
		try {
			def tosInstence = new TOS()
			WebUI.waitForElementPresent(tosInstence.createTestObject('intercomIframeObject', "//iframe/following-sibling::div[contains(@class,'intercom')]"), 5) 
			boolean executionResponse = WebUI.executeJavaScript("""
				let intercomWrapper = document.evaluate("//iframe/following-sibling::div[contains(@class,'intercom')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
				if(intercomWrapper!=null){
					intercomWrapper.parentNode.removeChild(intercomWrapper)
					return true
				}
				else if(intercomWrapper==null)
					return false
				""", [])
			if(executionResponse ==true)
				KeywordUtil.logInfo('Intercom wrapper has been successfully removed from the DOM')
			else if(executionResponse ==false)
				KeywordUtil.logInfo('Intercom wrapper can not be found on the DOM')
		}
		catch(Exception e) {
			KeywordUtil.markError(e.toString())
		}
	}
}
