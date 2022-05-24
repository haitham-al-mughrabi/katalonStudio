package amazon
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.junit.After
import org.junit.Before
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import com.kms.katalon.core.configuration.RunConfiguration


class Cart {
	@When("user open browser")
	def launchBrowser() {
		if(RunConfiguration.getExecutionProfile()=='default') {
			WebUI.openBrowser('')
		}
		else {
			WebUI.openBrowser(GlobalVariable.website)
			KeywordUtil.logInfo("$GlobalVariable.website has been used from defined website link on ${RunConfiguration.getExecutionProfile()} profile")
		}
	}
	@When("user navigates to (.*)")
	def navigateToWebsite(String website) {
		println RunConfiguration.getExecutionProfile()
		if(RunConfiguration.getExecutionProfile()=='default') {
			WebUI.navigateToUrl(website)
		}
		else {
			KeywordUtil.logInfo('Website has been already set by using webiste global variable that is defined inside profile file.')
		}
	}
	@When("user clicks on (.*) on (.*) categorie")
	def selectCategorie(String item, String categorie) {
		TestObject myNewObject = new TestObject(item)
		def objectXpath="//img[@alt='${item}']"
		myNewObject.addProperty('xpath',ConditionType.EQUALS, objectXpath)
		WebUI.click(myNewObject as TestObject)
		WebUI.delay(10)
	}
	@Then("user see results of (.*) item")
	def checkSelectedItem(def item) {
		TestObject myNewObject = new TestObject(item)
		def firstElementTitle="//div[@data-cel-widget='search_result_1']//h2//span"
		myNewObject.addProperty('xpath',ConditionType.EQUALS, firstElementTitle)
		def elementTitle = WebUI.getText(myNewObject)
		assert(elementTitle.toLowerCase().contains(item)==true)
	}
	@When('close browser')
	def closeBrowser() {
		WebUI.closeBrowser()
	}
}