import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory

import org.jsoup.Jsoup;
import us.codecraft.xsoup.Xsoup;
import haitham.TestObjectStuff

WebUI.openBrowser('https://www.amazon.com/s?k=oculus&i=electronics-intl-ship&bbn=16225009011&rh=p_36%3A1253506011&dc&pf_rd_i=23508887011&pf_rd_m=ATVPDKIKX0DER&pf_rd_p=434db2ed-6d53-4c59-b173-e8cd550a2e4f&pf_rd_r=4DPXCBHH7FTCYS8MN1Z6&pf_rd_s=merchandised-search-5&pf_rd_t=101&qid=1653478951&rnid=386442011&ref=sr_nr_p_36_4')
WebDriver myDriver = DriverFactory.getWebDriver()
def objectXpath="//div[contains(@data-cel-widget,'search_result') and not(@egaabirrd) and @data-component-type]"
myDriver.findElements(By.xpath(objectXpath)).each{element->
	def priceTag= element.findElement(By.xpath('//span[@class="a-price"]/span[1]'))
	println priceTag.getAttribute('innerHTML').replace('$', '')
}
WebUI.closeBrowser()