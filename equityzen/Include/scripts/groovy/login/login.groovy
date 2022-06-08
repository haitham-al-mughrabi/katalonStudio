package login

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

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory

import io.cucumber.datatable.DataTable
import cucumber.api.PendingException
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java.en.Given
import cucumber.api.java.en.And
import internal.GlobalVariable as GlobalVariable

public class login {
	@When("The user enter (.*) credentials")
	def performLogin(String credentialsType, DataTable dataTableObject){
		def BDDObject = GlobalVariable.bbdInstence
		def loginData= BDDObject.castMultipleListsIntoListOfMaps(BDDObject.castListOfListsIntoListOfKeysAndListOfValueLists(BDDObject.castDataTableIntoListOfLists(dataTableObject)))
		def srcControllerObject = GlobalVariable.srcControllerInstence
		def loginObject = srcControllerObject.srcController(loginData['targetPage'])
		WebUI.setText(loginObject.getter('multiUseInputField',true,'email'), loginData[0]['email'])
		WebUI.setEncryptedText(loginObject.getter('multiUseInputField',true,'password'), loginData[0]['password'])
	}
	@And("Clicks on (.*) button")
	def clickOnButton(String buttonType, DataTable dataTableObject){
		def BDDObject = GlobalVariable.bbdInstence
		def loginData = BDDObject.castMultipleListsIntoListOfMaps(BDDObject.castListOfListsIntoListOfKeysAndListOfValueLists(BDDObject.castDataTableIntoListOfLists(dataTableObject)))
		loginData.forEach{
			def srcControllerObject = GlobalVariable.srcControllerInstence
			def loginObject = srcControllerObject.srcController(it['targetPage'])
			element =
					WebUI.click(element)
			//			if(it['mutifunction'] as boolean == true) {
			//				WebUI.click(loginObject.getter(it['srcHolder'],true,it['buttonName']))
			//			}else if(it['mutifunction'] as boolean == false) {
			//				WebUI.click(loginObject.getter(it['buttonName']))
			//			}else {
			//				KeywordUtil.markFailed('Something went wrong on clickOnButton step')
			//			}
		}
	}
	@Then ("The user should be in (.*) page")
	def checkPageURL(String pageIdentifier){
		WebUI.delay(5)
		String pageURL = WebUI.executeJavaScript('return window.location.href', [])
		if(pageURL == GlobalVariable[pageIdentifier]) {
			KeywordUtil.logInfo("The user is on ${GlobalVariable[pageIdentifier]} page")
		}
		else {
			KeywordUtil.markFailed("The user is not on ${GlobalVariable[pageIdentifier]} page. current page is: $pageURL.")
		}
	}
}
