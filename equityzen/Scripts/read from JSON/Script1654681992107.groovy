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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords."haitham.Profile.profileChanger"("equityzen-test")
def rootPath = CustomKeywords.'haitham.pathStuff.getPath'()
def jsonFile = CustomKeywords.'haitham.io.readFromJsonFile'("$rootPath/Fixtures/Login/loginCridentails.json")
jsonFile.forEach{
	CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('email', it['email'])
	
	CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('password', it['password'])
	
	WebUI.openBrowser('https://test-quality.nyc.equityzen.com/')
	
	WebUI.click(findTestObject('Visiter view/Home Page/button_Login'))
	
	String pageURL = WebUI.getUrl()
	
	if (pageURL == GlobalVariable.login) {
		KeywordUtil.logInfo('You are on login page')
	} else if (pageURL != GlobalVariable.login) {
		KeywordUtil.markFailed('You are not on login page')
	}
	
	WebUI.delay(5)
	
	CustomKeywords."equityzen.removeElements.removeIntercomElement"()
	
	
	WebUI.setText(findTestObject('Visiter view/Login Page/input_Log in to your account_email'),
		GlobalVariable.email)
	
	WebUI.setMaskedText(
		findTestObject('Visiter view/Login Page/input_Log in to your account_password'),
		CustomKeywords.'haitham.textEncodeAndDecode.decodeText'(GlobalVariable.password)
		)
	
	WebUI.click(findTestObject('Visiter view/Login Page/button_Submit'))
	
	WebUI.delay(5)
	
	pageURL = WebUI.getUrl()
	
	if (pageURL == GlobalVariable.listings) {
		KeywordUtil.logInfo('You are on listings page')
	} else if (pageURL != GlobalVariable.listings) {
		KeywordUtil.markFailed('You are not on listings page')
	}
}
