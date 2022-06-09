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
	/**
	 * Convert Datatable type into Map
	 * @Param dataTable Datatable
	 * @Returns Map<String, String>
	 */
	def castDataTableIntoMap(def dataTable) {
		Map dataTableAsMap=dataTable.asMap()
		return dataTableAsMap
	}
	@Keyword
	/**
	 * Convert Datatable type into list
	 * @Param dataTable Datatable
	 * @Returns List<String>
	 */
	def castDataTableIntoList(def dataTable) {
		List dataTableAsTable=dataTable.asList()
		return dataTableAsTable
	}
	@Keyword
	/**
	 * Convert Datatable type into list of lists
	 * @Param dataTable Datatable
	 * @Returns List<List<String>>
	 */
	def castDataTableIntoListOfLists(def dataTable) {
		List<List<String>> dataTableAsListOfLists=dataTable.asLists()
		return dataTableAsListOfLists
	}
	@Keyword
	/**
	 * Combine two lists into map by using the first list
	 * items as a key for the map and the second list items
	 * as a value for the keys
	 * @Param listOfKeys List
	 * @Param listOfValues List
	 * @Returns Map
	 */
	def castTwoListsIntoMap(def listOfKeys, def listOfValues) {
		return [listOfKeys, listOfValues].transpose().collectEntries{[it[0], it[1]]}
	}
	@Keyword
	/**
	 * Combine a list of keys and lists of lists into list of maps by using the first list
	 * items as a key for the map and the second list items
	 * as a value for the keys by iterating on each list and convert them into maps
	 * then finally store all of the maps as list
	 * @Param listOfKeys List
	 * @Param listOfLists List<List>
	 * @Returns List<Map>
	 */
	def castMultipleListsIntoListOfMaps(def listOfKeys,def listOfLists) {
		def listOfMaps=[]
		listOfLists.each{list->
			listOfMaps.add([listOfKeys, list].transpose().collectEntries{[it[0], it[1]]})
		}
		return listOfMaps
	}
	@Keyword
	/**
	 * Divide list of lists into list of keys and lists of list that contains values
	 * @param listOfLists List<List>
	 * @return List<List>
	 */
	def castListOfListsIntoListOfKeysAndListOfValueLists(def listOfLists) {
		def listOfKeys = listOfLists[0]
		def listOfValueLists = listOfLists[1..listOfLists.size()-1]
		return [listOfKeys, listOfValueLists]
	}
	@Keyword
	/**
	 * Convert data table into list of multiple maps by calling castDataTableIntoListOfLists
	 * which convert the datatable into list then calls castListOfListsIntoListOfKeysAndListOfValueLists
	 * to divide the list into list of keys and list of lists of values then calls castMultipleListsIntoListOfMaps
	 * that combine the lists into list of maps
	 * @Param dataTable DataTable
	 * @Returns List<Maps>
	 */
	def castDataTableIntoListOfMultipleMaps(def dataTable) {
		def dataTableToList = castDataTableIntoListOfLists(dataTable)
		return castMultipleListsIntoListOfMaps(castListOfListsIntoListOfKeysAndListOfValueLists(dataTableToList))
	}
}
