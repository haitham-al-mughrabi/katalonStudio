import haitham.TestObjectStuff as TOS
public class Login {
  def mutliUseButton, multiUseInputField, submitButton
  Login() {
    this.mutliUseButton = { "//button[.//*[text()='${it }']]" }
    this.multiUseInputField = { "//input[@id='${it }']" }
  }
  def getter(String probName,Boolean isClouser=false, String cluserValue=null) {
    TOS tosInstence = new TOS()
    if(isClouser ==true){
        return tosInstence.createTestObject('testObject',this[probName](cluserValue)) 
    }
    return tosInstence.createTestObject('testObject',this[probName]) 
  }
}
