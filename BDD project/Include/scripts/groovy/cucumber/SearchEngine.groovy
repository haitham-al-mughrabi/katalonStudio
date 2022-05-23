package cucumber
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUIdef
import haitham.BDDStuff
import java.time.*

class SearchEngine {
	def userDataList, userAge
	@Given("user data table")
	def readDataTable(DataTable dataTable) {
		def classWrapper =new BDDStuff()
		userDataList =classWrapper.castDataTableIntoMap(dataTable)
		println userDataList
	}
	@When("user calcualte his age")
	def calcualteAge() {
		def userDate = userDataList['birthdate'].toString().split('/')
		LocalDate today    = LocalDate.now()
		LocalDate birthday =LocalDate.of(userDate[2] as Integer,userDate[1] as Integer, userDate[0] as Integer)
		Period period = Period.between( birthday, today )
		userAge=period.years.toInteger()
	}
	@Then("his age should equial (.*)")
	def assertAge(def age) {
		println ("""$userAge,${userAge.getClass()}""")
		println ("""$age,${age.getClass()}""")
		assert(age.toInteger()==userAge)
	}
}
