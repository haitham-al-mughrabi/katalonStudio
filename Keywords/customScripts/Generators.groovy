package customScripts

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

public class Generators {
	@Keyword
	def generateEmail(def emailDomain='automation',def emailLength=9) {
		try{
			String email= new Random().with {(1..emailLength).collect {(('a'..'z')).join()[ nextInt((('a'..'z')).join().length())]}.join()}
			return email+'@'+emailDomain+'.com'
		}
		catch(Exception e) {
			println('An error occured on generateEmail method from Generator')
			return 'info@automation.com'
		}
	}
	@Keyword
	def generateStrongPassword(def passwordLength=12,def startWithCapital=true,def includeSpecialChar=true,def includeNumbers=true) {
		try {
			def password='',alpha='A'..'Z',minValue=0, maxValue=alpha.size()
			if(startWithCapital==true)
				password+=alpha.get((Math.floor(Math.random()*(maxValue-minValue+1)+minValue)) as int)
			if(includeNumbers==true)
				password+=new Random().with {(1..passwordLength).collect {(('a'..'z')+('A'..'Z')+(0..9)).join()[ nextInt((('a'..'z')+('A'..'Z')+(0..9)).join().length())]}.join()}
			else if (includeNumbers==false)
				password+=new Random().with {(1..passwordLength).collect {(('a'..'z')).join()[ nextInt((('a'..'z')).join().length())]}.join()}
			if(includeSpecialChar==true)
				password+='$'
			return password
		}
		catch(Exception e) {
			println('An error occured on generateStrongPassword method from Generator')
			return null
		}
	}
}
