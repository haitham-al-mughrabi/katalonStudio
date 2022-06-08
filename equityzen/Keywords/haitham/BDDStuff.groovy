package haitham
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class BDDStuff {
	@Keyword
	def castDataTableIntoMap(def dataTable) {
		Map dataTableAsMap=dataTable.asMap(String.class, String.class)
		return dataTableAsMap
	}
	@Keyword
	def castDataTableIntoList(def dataTable) {
		List dataTableAsTable=dataTable.asList(String.class)
		return dataTableAsTable
	}
	@Keyword
	def castDataTableIntoListOfLists(def dataTable) {
		List<List<String>> dataTableAsListOfLists=dataTable.asLists(String.class)
		return dataTableAsListOfLists
	}
	@Keyword
	def castTwoListsIntoMap(def listOfKeys, def listOfValues) {
		return [listOfKeys, listOfValues].transpose().collectEntries{[it[0], it[1]]}
	}
	@Keyword
	def castMultipleListsIntoListOfMaps(def listOfKeys,def listOfLists) {
		def listOfMaps=[]
		listOfLists.each{list->
			listOfMaps.add([listOfKeys, list].transpose().collectEntries{[it[0], it[1]]})
		}
		return listOfMaps
	}
	@Keyword
	def castListOfListsIntoListOfKeysAndListOfValueLists(def listOfLists) {
		def listOfKeys = listOfLists[0]
		def listOfValueLists = listOfLists[1..listOfLists.size()-1]
		return [listOfKeys, listOfValueLists]
	}
}
