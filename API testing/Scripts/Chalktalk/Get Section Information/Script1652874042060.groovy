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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

try {
	if(RunConfiguration.getExecutionProfile()!='default') {
		def section = GlobalVariable.courseSections.find{
			it['name']==GlobalVariable.sectionName
		}
		GlobalVariable.sectionID = section['id']
		if(GlobalVariable.sectionID!=null) {
			def response = WS.sendRequest(findTestObject('Object Repository/Chalktalk/Gain section information'))
			if(response.statusCode==200) {
				def mapObject= CustomKeywords.'haitham.jsonStuff.parseJsonToMap'(response.responseBodyContent)
				println mapObject
			}
			else {
				throw new Exception("""Status code is not 200. status code: ${response.statusCode}""")
			}
		}
		else {
			throw new Exception('Provided course name does not match any course.')
		}
	}
	else {
		throw new Exception('Profile is not selected')
	}
}
catch(Exception e) {
		KeywordUtil.markError("""An exception has been raised. Error message: ${e.getMessage()}""")
}
