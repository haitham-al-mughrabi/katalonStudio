package loginAndSignup

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
import com.sun.jna.platform.KeyboardUtils

import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import haitham.BDDStuff as BDD
import haitham.textEncodeAndDecode as ED

public class generalSteps {
	@When("The user clicks on (.*)")
	def perofrmClickAction(def elementToClick) {
		WebUI.click(findTestObject("Object Repository/${GlobalVariable['currentPage']}/${elementToClick}"))
	}
	@Then("The user should be navigated to (.*) page")
	def verifyPage(def pageName) {
		WebUI.delay(5)
		String pageURL = WebUI.getUrl()
		if(pageURL == GlobalVariable[pageName]) {
			KeywordUtil.logInfo("You are on $pageName page!")
			GlobalVariable['currentPage']= pageName
		}
		else if(pageURL == GlobalVariable[pageName]){
			KeywordUtil.markFailedAndStop("Failed to navigate to $pageName. Current page url : $pageURL. Expected URL: $GlobalVariable[pageName]")
		}
	}
	@When ("The user fills (.*)")
	def fillInputFields(def placeholder,DataTable dataTable) {
		def bddInstence = new BDD()
		def edInstence = new ED()
		def rowsList =bddInstence.castDataTableIntoListOfMultipleMaps(dataTable)
		rowsList.forEach{
			def source = it['Source'], data=it['Data'], field=it['Field'],isEncrypted=it['isEncrypted'].toBoolean(),isMasked=it['isMasked'].toBoolean()
			def dataSource = GlobalVariable[source][data],text
			if(isEncrypted==true)
				text=edInstence.decodeText(dataSource)
			else if(isEncrypted.toBoolean() ==false)
				text= dataSource
			def testObject=findTestObject("Object Repository/${GlobalVariable['currentPage']}/${field}")
			if(isMasked == true)
				WebUI.setMaskedText(testObject, text)
			else if(isMasked == false)
				WebUI.setText(testObject,text )
			else {
				KeywordUtil.markFailed('Something went wrong on fillInputFields method')
			}
		}
	}
	@When ("The user check (.*)")
	def checkCheckBox(def checkBoxElement) {
		WebUI.check(findTestObject("Object Repository/${GlobalVariable['currentPage']}/${checkBoxElement}"))
	}
}
