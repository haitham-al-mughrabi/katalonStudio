import haitham.globalVariablesStuff as GVS
import com.kms.katalon.core.testobject.ConditionType

public class BDD{
	def categoriesSeeMoreAnchor(String categorie, String anchorText){
		return "//div[.//h2[text()='${categorie}'] and @data-a-card-type='basic']//div[contains(@class,'footer')]//a[text()='${anchorText}']"
	}
	
	
	
	def objectInitilizer(def objectSelector, def objectName='createdObject', def srcType='xpath', def condition=ConditionType.EQUALS){
		GVS testObjectClassInstance = new GVS()
		return testObjectClassInstance.createTestObject(objectName,srcType,objectSelector,condition)
	}
}