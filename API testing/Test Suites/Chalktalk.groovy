import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * Some methods below are samples for using SetUp/TearDown in a test suite.
 */

/**
 * Setup test suite environment.
 */
@SetUp(skipped = false) // Please change skipped to be false to activate this method.
def setUp() {
	try {
		if(RunConfiguration.getExecutionProfile()!='default') {
	
	def response = WS.sendRequest( findTestObject('Object Repository/Chalktalk/Gain access token') )
	if(response.statusCode==200) {
		def mapObject= CustomKeywords.'haitham.jsonStuff.parseJsonToMap'(response.responseBodyContent)
		CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('teacherAccessToken',mapObject['tokens']['access'])
		CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('teacherID',mapObject['user']['id'])
	}
		}
		else {
			throw new Exception('Profile is not selected')
		}
	}
	catch(Exception e) {
		KeywordUtil.markError("""An exception has been raised. Error message: ${e.getMessage()}""")
	}
}

/**
 * Clean test suites environment.
 */
@TearDown(skipped = false) // Please change skipped to be false to activate this method.
def tearDown() {
	KeywordUtil.logInfo('Teardown has been occured')
}

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = false) // Please change skipped to be false to activate this method.
def setupTestCase() {
	try {
		if(GlobalVariable.teacherAccessToken==null) {
	
	def response = WS.sendRequest( findTestObject('Object Repository/Chalktalk/Gain access token') )
	if(response.statusCode==200) {
		def mapObject= CustomKeywords.'haitham.jsonStuff.parseJsonToMap'(response.responseBodyContent)
		CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('teacherAccessToken',mapObject['tokens']['access'])
		CustomKeywords.'haitham.globalVariablesStuff.addGlobalVariable'('teacherID',mapObject['user']['id'])
	}
		}
		else {
			KeywordUtil.logInfo('Teacher AccessToken is defined, skipping')
		}
	}
	catch(Exception e) {
		KeywordUtil.markError("""An exception has been raised. Error message: ${e.getMessage()}""")
	}
}

/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = false) // Please change skipped to be false to activate this method.
def tearDownTestCase() {
	// Put your code here.
}

/**
 * References:
 * Groovy tutorial page: http://docs.groovy-lang.org/next/html/documentation/
 */