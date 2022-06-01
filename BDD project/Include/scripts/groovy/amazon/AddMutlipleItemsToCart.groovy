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
import haitham.globalVariablesStuff
import haitham.globalVariablesStuff as gvs

class AddMutlipleItemsToCart {
	@When('navigate to (.*)')
	def naviagteToWebsite(String URL) {
		WebUI.navigateToUrl(URL)
	}

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
		def objectXpath='//div[@data-component-type and @data-index]'
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
		WebDriver myDriver = DriverFactory.getWebDriver()
		def objectXpath="//div[@data-component-type and @data-index]"
		for (element in myDriver.findElements(By.xpath(objectXpath))){
			def priceTagValue,itemName
			try {
				priceTagValue= element.findElement(By.xpath('.//span[@class="a-price"]/span[1]')).getAttribute('innerHTML').replace('$', '')
				itemName = element.findElement(By.xpath('.//h2/a/span')).getAttribute('innerHTML')
				def globalVariablesStuffObject = new gvs()
				globalVariablesStuffObject.addGlobalVariable('itemName',itemName)
				globalVariablesStuffObject.addGlobalVariable('priceTagValue',priceTagValue)
			}
			catch(Exception e) {
				KeywordUtil.logInfo('Unable to find price tag on $itemName item.')
				priceTagValue=null
			}
			if (priceTagValue!=null) {
				KeywordUtil.logInfo("Verifying $itemName price tag range")
				GroovyShell intilizedShell = new GroovyShell()
				String condition
				if(priceRange.contains('Up') || priceRange.contains('Under')) {
					condition="${priceTagValue} <= "
					priceRange.split('').each{
						if (it.isInteger()==true){
							condition+=it
						}
					}
				}
				else if (priceRange.contains('to')) {
					def priceRangeList = priceRange.split('to')
					condition = "${priceTagValue} >= ${priceRangeList[0].replace('$','').toFloat().toInteger()} && ${priceTagValue} <= ${priceRangeList[1].replace('$','').toFloat().toInteger()}"
				}
				else if(priceRange.contains('Above')) {
					condition="${priceTagValue} >= "
					priceRange.split('').each{
						if (it.isInteger()==true){
							condition+=it
						}
					}
				}
				def assertionResult = intilizedShell.evaluate("""${condition}""")
				if (assertionResult == false)
					KeywordUtil.markWarning("Price tag value does not match the price range for ${itemName} item. Price range: ${priceRange}. Price tag: ${priceTagValue}")
				else if(assertionResult == true)
					KeywordUtil.logInfo("Price tag value match the price range for ${itemName} item. Price range: ${priceRange}. Price tag: ${priceTagValue}")
			}
		}
	}
	@When ("I click on (.*) to select the item")
	def selectItem(def selectedItemToBuy) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//h2/a/span[contains(text(),'${selectedItemToBuy}')]"
		def newTestObject=testObjectClassInstance.createTestObject(selectedItemToBuy,'xpath',objectXpath,ConditionType.EQUALS)
		WebUI.click(newTestObject as TestObject)
	}

	@Then ("I should see (.*) item page")
	def checkSelectedItemPage(def itemName) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//span[@id='productTitle']"
		def newTestObject=testObjectClassInstance.createTestObject(itemName,'xpath',objectXpath,ConditionType.EQUALS)
		String itemGottenName=WebUI.getText(newTestObject)
		if (itemGottenName.contains(itemName)==false) {
			KeywordUtil.markError("Expected to get item name as $itemName but got $itemGottenName")
		}
		def globalVariablesStuffObject = new gvs()
		globalVariablesStuffObject.addGlobalVariable('itemGottenName',itemGottenName)
	}
	@And ("(.*)'s price should match (.*)")
	def checkPriceTag(def itemName, def priceTagValue) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//div[contains(@id,'title')]/following-sibling::div//tbody//tr//td//span/preceding-sibling::span[contains(text(),'${(char)36}')]"
		WebDriver myDriver = DriverFactory.getWebDriver()
		def itemPriceTagValue = myDriver.findElement(By.xpath(objectXpath)).getAttribute('innerHTML')
		if (itemPriceTagValue!= priceTagValue) {
			KeywordUtil.markError("Expected to get item name as $priceTagValue but got $itemPriceTagValue")
		}
	}
	@When ("Adding (.*) to the cart")
	def addingItemToTheCart(def selectedItemToBuy) {
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//input[@type='submit' and contains(@id,'cart')]"
		def newTestObject=testObjectClassInstance.createTestObject(selectedItemToBuy,'xpath',objectXpath,ConditionType.EQUALS)
		WebUI.click(newTestObject as TestObject)
	}
	@Then ("Item should be added to the cart")
	def verifyAddingToCart() {
		//Click on cart
		def testObjectClassInstance = new TestObjectStuff()
		def objectXpath="//div[@id='nav-tools']/a[last()]"
		def newTestObject=testObjectClassInstance.createTestObject('selectedItem','xpath',objectXpath,ConditionType.EQUALS)
		WebUI.click(newTestObject as TestObject)
		//Verify cart items
		WebDriver myDriver = DriverFactory.getWebDriver()
		objectXpath="//div[@data-name= 'Active Items']/div[@data-asin]"
		Boolean isItemAddedToCart=false
		def cartItems =myDriver.findElements(By.xpath(objectXpath))
		def globalVariablesStuffObject = new gvs()
		globalVariablesStuffObject.addGlobalVariable('cartItems',cartItems)
		for (element in cartItems){
			def itemName = element.findElement(By.xpath('.//span/span/span[1]')).getAttribute('innerHTML')
			if(itemName == GlobalVariable.itemGottenName || itemName.contains(GlobalVariable.itemGottenName)) {
				isItemAddedToCart=true
				break
			}
		}
		if(isItemAddedToCart==false)
			KeywordUtil.markFailed("Item did not get added to cart. Item name: ${GlobalVariable.itemGottenName}")
		else {
			KeywordUtil.logInfo("Item has been successfully added to cart. Item name: ${GlobalVariable.itemGottenName}")
			GlobalVariable.cartValue=GlobalVariable.cartValue+1
		}
	}
	@And ("Item count of the cart should be increased by 1")
	def verifyCartItemCount() {
		if (GlobalVariable.cartValue == GlobalVariable.cartItems.size()) {
			KeywordUtil.logInfo("Items count are verified. Items count: ${GlobalVariable.cartValue}")
		}
		else {
			KeywordUtil.markFailed("Items count on cart don't match the expected count cart. Item count in cart: ${GlobalVariable.cartItems.size()}. Item counter: ${GlobalVariable.cartValue}")

		}
	}

	@When('I close the browser')
	def closeTheBrowser() {
		WebUI.closeBrowser()
	}
}