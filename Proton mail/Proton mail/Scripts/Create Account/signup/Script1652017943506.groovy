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
	WebUI.openBrowser('https://protonmail.com/')
	
	CustomKeywords.'haitham.TabControl.openTab'()
	
	protonmailPageIndex =  CustomKeywords.'haitham.TabControl.getCurrentTabIndex'()
	
	yopmailPageIndex=CustomKeywords.'haitham.TabControl.getCurrentTabIndex'()+1
	
	CustomKeywords.'haitham.TabControl.switchTab'(yopmailPageIndex)
	
	WebUI.navigateToUrl('https://yopmail.fr/en/')
	
	WebUI.click(findTestObject('Object Repository/yopmail/randomEmailAddressGeneratorButton'))
	
	def tempEmail = WebUI.getText(findTestObject('Object Repository/yopmail/emailWrapperSpan'))
	
	CustomKeywords.'haitham.TabControl.switchTab'(protonmailPageIndex)
	
	WebUI.click(findTestObject('Object Repository/protonmail/signupButton'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/accountTypeSpan'), 'Select Your ProtonMail Account Type')
	
	WebUI.click(findTestObject('Object Repository/protonmail/freePlanDiv'))
	
	WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/protonmail/freePlanWrapperDiv'), 'collapsed', 10)
	
	WebUI.click(findTestObject('Object Repository/protonmail/selectFreePlanButton'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/signupPageTitle'),'Create your Proton Account')
	
	WebUI.click(findTestObject('Object Repository/protonmail/nextButtonSignupPage'))
	
	WebUI.switchToFrame(findTestObject('Object Repository/protonmail/userNameIframeWrapper'), 15)
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/VerifyText/usernameEmptyInputFieldErrorMessage'),'This field is required')
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Forms/userNameInputForm'), 'test123493-2ir2')
	
	WebUI.switchToDefaultContent()
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/VerifyText/passwordMustContainErrorMessage'),'Password must contain at least 8 characters')
		
	WebUI.setText(findTestObject('Object Repository/protonmail/Forms/passwordInputForm'), 'password')
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/VerifyText/repeatPassswordMustContainErrorMessage'),'Password must contain at least 8 characters')
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Forms/repeatPasswordInputForm'), 'password')
	
	WebUI.click(findTestObject('Object Repository/protonmail/nextButtonSignupPage'))
	
	WebUI.delay(10)
	
	WebUI.click(findTestObject('Object Repository/protonmail/skipRecoveryMethodButton'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/confirmSkippingRecoveryMethodButton'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/selectFreePlanButtonOnPlanSelection'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/emailTabVerificationPopup'))
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Forms/emailVerficationInputForm'), tempEmail)
	
	WebUI.click(findTestObject('Object Repository/protonmail/getVerificationCodeButton'))
	
	CustomKeywords.'haitham.TabControl.switchTab'(yopmailPageIndex)
	
	WebUI.click(findTestObject('Object Repository/yopmail/checkBoxButton'))
	
	WebUI.switchToFrame(findTestObject('Object Repository/yopmail/emailsIframe'), 10)
	
	WebUI.click(findTestObject('Object Repository/yopmail/messageFromProtonMailWrapper'))
	
	WebUI.switchToDefaultContent()
	
	WebUI.switchToFrame(findTestObject('Object Repository/yopmail/messageBodyIframe'), 10)
	
	def verificationCode = WebUI.getText(findTestObject('Object Repository/yopmail/verificationCodeWrapper'))
	
	CustomKeywords.'haitham.TabControl.switchTab'(protonmailPageIndex)
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Forms/verificationCodeInputForm'), verificationCode)
	
	WebUI.click(findTestObject('Object Repository/protonmail/verifyEmailButton'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/getStartedButton'))
	
	for (i in 1..3)
		WebUI.click(findTestObject('Object Repository/protonmail/getStartedNextButton'))
	
	WebUI.delay(30)
	
	WebUI.closeBrowser()
	
}
catch(Exception e) {
	println 'something went wrong'
	WebUI.closeBrowser()
}
