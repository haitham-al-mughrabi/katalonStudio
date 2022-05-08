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
    WebUI.openBrowser('https://www.amazon.com')

    //	WebUI.delay(60)
    WebUI.click(findTestObject('Object Repository/Home page/loginAndSignUpButton'))

    WebUI.waitForElementVisible(findTestObject('Login page/loginH1Text'), 60 * 5)

    WebUI.click(findTestObject('Object Repository/Login page/signupButton'))

    WebUI.waitForElementVisible(findTestObject('Object Repository/Registration page/signupH1Text'), 60 * 5)

    WebUI.click(findTestObject('Object Repository/Registration page/registerButton'))

    WebUI.verifyElementText(findTestObject('Object Repository/Registration page/nameInputFieldErrorMessage'), 'Enter your name')

    WebUI.verifyElementText(findTestObject('Object Repository/Registration page/emailInputFieldErrorMessage'), 'Enter your email or mobile phone number')

    WebUI.verifyElementText(findTestObject('Object Repository/Registration page/minimumCharactersPasswordErrorMessage'), 
        'Minimum 6 characters required')

    WebUI.setText(findTestObject('Object Repository/Registration page/emailOrPasswordInputField'), 'bla bla bla')

    WebUI.click(findTestObject('Object Repository/Registration page/registerButton'))

    WebUI.verifyElementText(findTestObject('Registration page/wrongEmailOrPhoneNumberErrorMessage'), 'Wrong or Invalid email address or mobile phone number. Please correct and try again.')

    WebUI.setText(findTestObject('Object Repository/Registration page/customerNameInputField'), 'Automation user')

    WebUI.setText(findTestObject('Object Repository/Registration page/emailOrPasswordInputField'), CustomKeywords.'customScripts.Generators.generateEmail'())

    def password = CustomKeywords.'customScripts.Generators.generateStrongPassword'()
	
    WebUI.setText(findTestObject('Object Repository/Registration page/passwordInputField'), password)

    WebUI.setText(findTestObject('Object Repository/Registration page/renterPasswordInputField'), password)

    WebUI.click(findTestObject('Object Repository/Registration page/registerButton'))
	
    WebUI.closeBrowser()
}
catch (Exception ex) {
    println('Exception occured')

    WebUI.closeBrowser()
}