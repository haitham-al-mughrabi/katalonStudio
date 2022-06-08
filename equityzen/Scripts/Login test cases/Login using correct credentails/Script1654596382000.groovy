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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.navigateToUrl('https://test-quality.nyc.equityzen.com/')

WebUI.click(findTestObject('Visiter view/Home Page/button_Login'))

KeywordUtil.logInfo('Waiting 3 seconds for the page content to be loaded.')

WebUI.delay(3)

CustomKeywords.'equityzen.removeElements.removeIntercomElement'()

if (WebUI.getUrl() == GlobalVariable.login) {
    KeywordUtil.logInfo('You are on login page')
} else if (WebUI.getUrl() != GlobalVariable.login) {
    KeywordUtil.markFailed('You are not on login page')
}

WebUI.setText(findTestObject('Visiter view/Login Page/input_Log in to your account_email'), 'quality+global@equityzen.com')

WebUI.setMaskedText(findTestObject('Visiter view/Login Page/input_Log in to your account_password'), CustomKeywords.'haitham.textEncodeAndDecode.decodeText'(
        'W+b/J7R9rwqd5mSb6/XXRA=='))

WebUI.click(findTestObject('Visiter view/Login Page/button_Submit'))

KeywordUtil.logInfo('Waiting 3 seconds for the page content to be loaded.')

WebUI.delay(3)

CustomKeywords.'equityzen.removeElements.removeIntercomElement'()

if (WebUI.getUrl() == GlobalVariable.listings) {
    KeywordUtil.logInfo('You are on listings page')
} else if (WebUI.getUrl() != GlobalVariable.listings) {
    KeywordUtil.markFailed('You are not on listings page')
}

WebUI.focus(findTestObject('User view/Shared srcs/settingsNavBarIcon'))

WebUI.click(findTestObject('User view/Shared srcs/logoutNavBarElement'))

KeywordUtil.logInfo('Waiting 3 seconds for the page content to be loaded.')

WebUI.delay(3)

if (WebUI.getUrl() == GlobalVariable.home) {
	KeywordUtil.logInfo('You are on home page')
} else if (WebUI.getUrl() != GlobalVariable.home) {
	KeywordUtil.markFailed('You are not on home page')
}