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

try {
	WebUI.openBrowser(testURL)
	def rootPath=CustomKeywords.'haitham.pathStuff.getPath'()
	def outputfilepath= CustomKeywords.'haitham.pathStuff.setPath'(rootPath.toString(),'InputFiles/users.txt')
	def userData= CustomKeywords.'haitham.io.readFromJsonFile'(outputfilepath)
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/emailOrUserInputForm'), userData.get('username'))
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/passwordInputForm'), userData.get('password'))
	WebUI.check(findTestObject('Object Repository/protonmail/Inputs/keepMeSignedInCheckBoxInputField'))
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/signInButton'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/protonmail/Buttons/inboxButton'), 60)
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/newMessageButton'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/protonmail/Wrappers/newMessageWrapper'), 60)
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/sentToInputField'), defaultEmailAddress)
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/subjectInputField'), defaultEmailSubject)
	WebUI.switchToFrame(findTestObject('Object Repository/protonmail/Wrappers/emailSlagIframe'), 30)
	WebUI.sendKeys(findTestObject('Object Repository/protonmail/Wrappers/emailWrapper'), defaultEmailSlag)
	WebUI.switchToDefaultContent()
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/insertFileButton'))
	WebUI.delay(5)
	WebUI.uploadFile(findTestObject('Object Repository/protonmail/Inputs/uploadFileField'), fileToUploadPath)
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/sendEmailButton'))
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/profileButton'))
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/signoutButton'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/protonmail/Buttons/signInButton'),60)
	WebUI.verifyMatch(WebUI.getUrl(),testURL , false)
	WebUI.closeBrowser()
}
catch(Exception e) {
	println 'An error occoured'
	WebUI.closeBrowser()
}