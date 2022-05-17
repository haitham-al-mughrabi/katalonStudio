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
import com.sun.org.apache.xpath.internal.compiler.Keywords
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
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/signupButton'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/protonmail/Spans/accountTypeSpan'), 60)
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/Spans/accountTypeSpan'), 'Select Your ProtonMail Account Type')
	
	WebUI.click(findTestObject('Object Repository/protonmail/Wrappers/freePlanDiv'))
	
	WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/protonmail/Wrappers/freePlanWrapperDiv'), 'collapsed', 10)
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/selectFreePlanButton'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/Spans/signupPageTitle'),'Create your Proton Account')
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/nextButtonSignupPage'))
	
	WebUI.switchToFrame(findTestObject('Object Repository/protonmail/Wrappers/userNameIframeWrapper'), 15)
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/VerifyText/usernameEmptyInputFieldErrorMessage'),'This field is required')
	
	def generatedUserName=CustomKeywords.'haitham.Generators.generateComplexRandomText'(15)
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/userNameInputForm'), generatedUserName)
	
	WebUI.switchToDefaultContent()
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/VerifyText/passwordMustContainErrorMessage'),'Password must contain at least 8 characters')
	
	def generatedPassword = CustomKeywords.'haitham.Generators.generateStrongPassword'()
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/passwordInputForm'), generatedPassword)
	
	WebUI.verifyElementText(findTestObject('Object Repository/protonmail/VerifyText/repeatPassswordMustContainErrorMessage'),'Password must contain at least 8 characters')
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/repeatPasswordInputForm'), generatedPassword)
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/nextButtonSignupPage'))
	
	WebUI.delay(10)
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/skipRecoveryMethodButton'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/confirmSkippingRecoveryMethodButton'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/selectFreePlanButtonOnPlanSelection'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/Wrappers/emailTabVerificationPopup'))
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/emailVerficationInputForm'), tempEmail)
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/getVerificationCodeButton'))
	
	WebUI.delay(10)
	
	CustomKeywords.'haitham.TabControl.switchTab'(yopmailPageIndex)
	
	WebUI.click(findTestObject('Object Repository/yopmail/checkBoxButton'))
	
	WebUI.switchToFrame(findTestObject('Object Repository/yopmail/emailsIframe'), 10)
	
	WebUI.click(findTestObject('Object Repository/yopmail/messageFromProtonMailWrapper'))
	
	WebUI.switchToDefaultContent()
	
	WebUI.switchToFrame(findTestObject('Object Repository/yopmail/messageBodyIframe'), 10)
	
	def verificationCode = WebUI.getText(findTestObject('Object Repository/yopmail/verificationCodeWrapper'))
	
	CustomKeywords.'haitham.TabControl.switchTab'(protonmailPageIndex)
	
	WebUI.setText(findTestObject('Object Repository/protonmail/Inputs/verificationCodeInputForm'), verificationCode)
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/verifyEmailButton'))
	
	WebUI.click(findTestObject('Object Repository/protonmail/Buttons/getStartedButton'))
	
	for (i in 1..3)
		WebUI.click(findTestObject('Object Repository/protonmail/Buttons/getStartedNextButton'))
	
	WebUI.delay(5)
	
	def userinfo=['username':generatedUserName,'password':generatedPassword]
	
	def rootPath=CustomKeywords.'haitham.pathStuff.getPath'()
	
	def outputfilepath= CustomKeywords.'haitham.pathStuff.setPath'(rootPath.toString(),'InputFiles/users.txt')	
	
	CustomKeywords.'haitham.io.writeOnFile'(outputfilepath,userinfo,'w','json')
	
	WebUI.closeBrowser()
	
}
catch(Exception e) {
	println 'something went wrong'
	WebUI.closeBrowser()
}
