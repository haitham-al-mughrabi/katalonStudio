package amazon
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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

import org.jsoup.*
import haitham.TestObjectStuff

class AddMutlipleItemsToCart {

	/*
	 * Background
	 */
	@Given('open browser')
	def launchBrowser() {
		if(RunConfiguration.getExecutionProfile()=='default')
			WebUI.openBrowser('')
		else
			WebUI.openBrowser(GlobalVariable.website)
	}
	@And('navigate to (.*)')
	def naviagteToWebsite(String URL) {
		if(RunConfiguration.getExecutionProfile()=='default')
			WebUI.navigateToUrl(URL)
	}
	/*
	 * Scenario
	 */
	@When('clicking on -(.*)- in the bottom of (.*) card wrapper')
	def clickOnSeeMore(String anchorText,String categorie) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//div[.//h2[text()='${categorie}'] and @data-a-card-type='basic']//div[contains(@class,'footer')]//a[text()='${anchorText}']"
		def newTestObject=testObjectClassInstance.createTestObject(anchorText,'xpath',objectXpath,ConditionType.EQUALS)
		WebUI.click(newTestObject as TestObject)
	}
	@Then('I should see different item categories under selected (.*)')
	def assertSeeMoreClicked(String categorieName) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//div[contains(@class,'bxc-grid__row')]//div[contains(@class,'bxc-grid__column--1-of-5')]/div/div"
		def newTestObject=testObjectClassInstance.createTestObject(categorieName,'xpath',objectXpath,ConditionType.EQUALS)
		assert(WebUI.findWebElements(newTestObject,20).size >0)
	}
	@When('clicking on (.*) card')
	def selectingCategorie(String categorieName) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//div[contains(@class,'bxc-grid__row')]//div[contains(@class,'bxc-grid__column--1-of-5')]/div/div[.//img[@alt='${categorieName}']]"
		def newTestObject=testObjectClassInstance.createTestObject(categorieName,'xpath',objectXpath,ConditionType.EQUALS)
		WebUI.click(newTestObject)
	}
	@Then('I should see number of items under the selected (.*) categories collection')
	def verifyGettingCategorieitems(String categorieName){
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath='//div[contains(@data-cel-widget,"search_result") and not(@egaabirrd) and @data-component-type]'
		def newTestObject=testObjectClassInstance.createTestObject(categorieName,'xpath',objectXpath,ConditionType.EQUALS)
		assert(WebUI.findWebElements(newTestObject,20).size >0)
	}
	@And('(.*) keyword must be contained in the information text on the header')
	def verifyCategorieResults(String categorieName) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//span[@class='a-color-state a-text-bold']"
		def newTestObject=testObjectClassInstance.createTestObject(categorieName,'xpath',objectXpath,ConditionType.EQUALS)
		def elementText = WebUI.getText(newTestObject)
		if(elementText.contains(categorieName.toLowerCase())==false)
			KeywordUtil.markFailed('Categorie name does not match')
	}
	@When('selecting (.*) from Price list')
	def selectPriceRange(String priceRange){
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//li//a/span[contains(text(),'${priceRange}')]"
		def newTestObject=testObjectClassInstance.createTestObject('price'+priceRange,'xpath',objectXpath,ConditionType.EQUALS)
		WebUI.click(newTestObject)
	}
	@Then('I should see items between low and high of the (.*) price range')
	def verifyPriceRange(String priceRange) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//div[contains(@data-cel-widget,'search_result') and not(@egaabirrd) and @data-component-type]"
		def newTestObject=testObjectClassInstance.createTestObject('price'+priceRange,'xpath',objectXpath,ConditionType.EQUALS)
		WebDriver myDriver = DriverFactory.getWebDriver()
		myDriver.findElement(By.xpath(objectXpath)).each{element->
			def htmlParsedPage = Jsoup.parse(element)
			println htmlParsedPage
		}
		KeywordUtil.markFailedAndStop('exit(0)')
		GroovyShell intilizedShell = new GroovyShell()
		WebUI.findWebElements(newTestObject,20).each{item->


			String condition
			if(priceRange.contains('Up')) {
				condition=' > '
				priceRange.split('').each{
					if (it.isInteger()==true){
						condition+=it
					}
				}
			}
			else if (priceRange.contains('to')) {
			}
			else if(priceRange.contains('Above')) {
			}
			intilizedShell.evaluate("""${it} ${condition} """)
		}
	}
	@When('I close the browser')
	def closeTheBrowser() {
		WebUI.closeBrowser()
	}
}