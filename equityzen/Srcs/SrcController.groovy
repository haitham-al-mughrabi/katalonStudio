import internal.GlobalVariable as GlobalVariable

public class SrcController{
    private Map<String,String> srcKeys =[
        'login':'Login.groovy'
        ]
    private Map<String,String> pagesKeys =[
        'login':GlobalVariable.login
        ]
    def srcController(String srcKey){
        if(srcKey!=null){
            Class BDDClass = new GroovyScriptEngine( "Srcs" ).loadScriptByName(srcKeys[srcKey])
            Object modelInstance = BDDClass.newInstance()
            return modelInstance
        }
    }
    def pageController(String pageKey){
        return pagesKeys[pageKey]
    } 
}