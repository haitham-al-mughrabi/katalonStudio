import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.By as By
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import haitham.BrowserListeners as BrowserListeners
import haitham.TestObjectStuff as TOS
import investInformation.InvestInformation as II

def browserListenersInstence = new BrowserListeners()

def tosInstence = new TOS()

CustomKeywords.'haitham.Profile.profileChanger'('equityzen-test')

WebUI.openBrowser(GlobalVariable['home'])

WebUI.setViewPortSize(1370, 768)

browserListenersInstence.enableBrowserListeners()

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('Visiter view/Home Page/button_Login'))

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

if (WebUI.getUrl() == GlobalVariable.listings) {
    KeywordUtil.logInfo('You are on listings page')
} else if (WebUI.getUrl() != GlobalVariable.listings) {
    KeywordUtil.markFailed('You are not on listings page')
}

def seleniumBrowser = browserListenersInstence.switchToSeleniumWebDriver()

def liveInvestments = seleniumBrowser.findElements(By.xpath(tosInstence.getTestObjectXpaths('Object Repository/listings/incestCardAnchor')[
        0]))

def r = new Random()

liveInvestments.get(r.nextInt(liveInvestments.size())).click()

def invistmentAmmount = seleniumBrowser.findElements(By.xpath(tosInstence.getTestObjectXpaths('Object Repository/listings/investmentAmmountButton')[
        0]))

invistmentAmmount.get(r.nextInt(invistmentAmmount.size())).click()

WebUI.click(findTestObject('Object Repository/listings/continueInvistmentButton'))

List toVerify = [[('xpath') : '//input[@id=\'firstName\']', ('type') : 'inputField'], [('xpath') : '//input[@id=\'lastName\']'
        , ('type') : 'inputField'], [('xpath') : '//input[@id=\'phoneNumber\']', ('type') : 'inputField'], [('xpath') : '//input[@id=\'addressStreet1\']'
        , ('type') : 'inputField'], [('xpath') : '//input[@id=\'addressCity\']', ('type') : 'inputField'], [('xpath') : '//input[@id=\'addressZipCode\']'
        , ('type') : 'inputField'], [('xpath') : '//div[text()=\'Country\']/following-sibling::div[1]', ('type') : 'other']
    , [('xpath') : '//div[text()=\'Entity Type\']/following-sibling::div[1]', ('type') : 'div'], [('xpath') : '//div[@id=\'addressState\']//div[contains(@class,\'selected-value\')]'
        , ('type') : 'div']]
def iiInstence = new II()
iiInstence.investInformationVerification(toVerify)

WebUI.click(findTestObject('Object Repository/listings/continueInvistmentButton'))

WebUI.click(findTestObject('Object Repository/investments/modifyAmountButton'))

WebUI.click(findTestObject('Object Repository/investments/cancelInvestmentButton'))

WebUI.click(findTestObject('Object Repository/investments/confirmCancelInvestmentButton'))

WebUI.click(findTestObject('Object Repository/investments/viewMyInvestmentsButton'))

if (WebUI.getText(findTestObject('Object Repository/investments/noInvestmentH2text')) == "Nothing in here yet") {
	KeywordUtil.logInfo("Success! Nothing in here yet.")
}
else if (WebUI.getText(findTestObject('Object Repository/investments/noInvestmentH2text')) != "Nothing in here yet") {
	KeywordUtil.markFailed("Failed! there is an investment.")
}

browserListenersInstence.swapBrowsers('chrome')

WebUI.closeBrowser()