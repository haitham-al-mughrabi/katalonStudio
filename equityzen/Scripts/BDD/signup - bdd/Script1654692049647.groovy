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


def rootpath = CustomKeywords.'haitham.pathStuff.getPath'()
CustomKeywords."haitham.Profile.profileChanger"("equityzen-test")
CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('rootpath', rootpath)
CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('currentPage', 'home')
def fakerInstence = CustomKeywords.'haitham.Faker.initFaker'()
def userCredintails=[
	"fullName":fakerInstence.name().fullName(),
	"username":fakerInstence.name().username(),
	"email":fakerInstence.internet().emailAddress(),
	"capitalCity":fakerInstence.nation().capitalCity(),
	"nationality":fakerInstence.nation().nationality(),
	"age":fakerInstence.number().digit()+18,
	"phoneNumber":fakerInstence.phoneNumber().phoneNumber(),
	"title":fakerInstence.job().title(),
	"password":"${CustomKeywords.'haitham.textEncodeAndDecode.encodeText'(CustomKeywords.'haitham.Generators.generateStrongPassword'())}"
	]

CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('userCredintails', userCredintails)	
WebUI.openBrowser(GlobalVariable['home'])
CucumberKW.runFeatureFile('Include/features/LoginAndSignUp/Signup.feature')
WebUI.closeBrowser()
