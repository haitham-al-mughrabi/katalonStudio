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

public class handyMethods {
	/*
	 * Filter list
	 * - switching findall to true will find all words that match the pattern and will return the items as a list
	 * - keeping findall false will return first matched pattern and will return it as it's type.
	 * @param array list 
	 * @param findall boolean optional
	 * @param pattern string
	 * @param condition string
	 * @return object
	 */
	//	@Keyword
	//	def filter(def array=null, def pattern=null, def condition=null, def findall = false) {
	//	  if (array == null || array.size == 0 || pattern == null || condition == null)
	//	    return null
	//	  GroovyShell intilizedShell = new GroovyShell()
	//	  if (findall)
	//	    return array.findAll {
	//	      if (it.getClass().toString().contains('String'))
	//	        it = """'${it}'"""
	//	      if (pattern.getClass().toString().contains('String'))
	//	        pattern = """'${pattern}'""".replace('\'\'', '\'')
	//	      intilizedShell.evaluate("""${it} ${condition} ${pattern}""")
	//	    }
	//	  else if (findall == false)
	//	    return array.find {
	//	      if (it.getClass().toString().contains('String'))
	//	        it = """'${it}'"""
	//	      if (pattern.getClass().toString().contains('String'))
	//	        pattern = """'${pattern}'""".replace('\'\'', '\'')
	//	      intilizedShell.evaluate("""${it} ${condition} ${pattern}""")
	//	    }
	//	}
	@Keyword
	def filter(def array=null, def condition=null, def findall=false) {
		if(array==null ||array.size==0||condition==null)
			return null
		if(findall)
			return array.findAll {
				GroovyShell intilizedShell = new GroovyShell()
				intilizedShell.evaluate("""${it} ${condition} """)}
		else if(findall==false)
			return array.find {
				GroovyShell intilizedShell = new GroovyShell()
				intilizedShell.evaluate("""${it} ${condition} """)}
	}
}
