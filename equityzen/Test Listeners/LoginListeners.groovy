import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import haitham.globalVariablesStuff as GVS
import haitham.BDDStuff as BBD
class LoginListeners {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
//		String testCaseName = testCaseContext.getTestCaseId().split('/')[-1]
//		if(testCaseName == "Login") {
//			if(RunConfiguration.getExecutionProfile()!='default'){
//				WebUI.openBrowser(GlobalVariable['home'])
//				GVS gvsInstence = new GVS()
//				BBD bbdInstence = new BBD()
//				Class SrcCOntrollerClass = new GroovyScriptEngine( "Srcs" ).loadScriptByName('SrcController.groovy')
//				gvsInstence.addGlobalVariable('srcControllerInstence',SrcCOntrollerClass.newInstance())
//				gvsInstence.addGlobalVariable('bbdInstence',bbdInstence)
//			}
//			else if(RunConfiguration.getExecutionProfile()=='default'){
//				KeywordUtil.markFailedAndStop('Please change the defualt profile in order to run the test correctly.')
//				System.exit(0)
//			}
//		}	
	}
	
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
//		WebUI.closeBrowser()
	}
}