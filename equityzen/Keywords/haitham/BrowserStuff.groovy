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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.events.AbstractWebDriverEventListener
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import equityzen.removeElements
import haitham.globalVariablesStuff as GVS
import haitham.handyMethods as HM

protected class BrowserListnersOverrider extends AbstractWebDriverEventListener {
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		KeywordUtil.logInfo('afterNavigateTo listeners has been called.')
		WebUI.waitForPageLoad(30)
		def removeElementsInstence =  new removeElements()
		removeElementsInstence.removeIntercomElement()
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString()
				+ " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		KeywordUtil.logInfo('beforeClickOn listeners has been called.')
		def gvsInstence = new GVS()
		gvsInstence.addGlobalVariable('currentURL', WebUI.getUrl())
		KeywordUtil.logInfo("currentURL globalvariable value: ${GlobalVariable['currentURL']}")
		WebUI.waitForPageLoad(30)
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		KeywordUtil.logInfo('afterClickOn listeners has been called.')
		WebUI.delay(3)
		if(WebUI.getUrl()!=GlobalVariable['currentURL']) {
			KeywordUtil.logInfo('URL got changed. A delay will be occured for 5 seconds.')
			WebUI.waitForPageLoad(30)
			def removeElementsInstence =  new removeElements()
			removeElementsInstence.removeIntercomElement()
		}
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		KeywordUtil.logInfo('beforeFindBy listeners has been called.')
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}
}

public class BrowserListeners {
	@Keyword
	def enableBrowserListeners() {
		WebDriver webdriver = DriverFactory.getWebDriver()

		EventFiringWebDriver eventFiring = ((webdriver) as EventFiringWebDriver)

		eventFiring.register(new BrowserListnersOverrider())

		DriverFactory.changeWebDriver(eventFiring)
	}
	@Keyword
	def swapBrowsers(String browserName,Boolean returnable=false,Boolean execute=true) {
		def storedDrivers = RunConfiguration.getStoredDrivers().toList()

		def targetBrowser= storedDrivers.find{
			it.toString().toLowerCase().contains(browserName)
		}
		if (execute == true)
			DriverFactory.changeWebDriver(targetBrowser)
		if (returnable==true)
			return targetBrowser
	}
	@Keyword
	def switchToSeleniumWebDriver() {
		WebDriver seleniumDriver = DriverFactory.getWebDriver()
		return seleniumDriver
	}
	@Keyword
	def browsersInformation(String prob=null) {
		Map m = RunConfiguration.getExecutionProperties()
		def driverProb = m.get("drivers").get("system").get("WebUI")
		if (prob!=null)
			return driverProb[prob]
		return m
	}
	@Keyword
	def getCurrentBrowser() {
		WebDriver driver = DriverFactory.getWebDriver();
		String currentDriver = driver.toString();
		//		String[] browser = currentDriver.split("\\:")
		//		currentDriver = browser[0]
		return currentDriver;
	}
}