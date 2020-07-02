@NonCPS
import groovy.json.*
//@Grab("org.codehaus.groovy:groovy-json")

String JsonFile(String FileName)
{
def filepath=FileName
def fileread = new File(filepath)
def json = new JsonSlurper()

def out = json.parse(fileread)
def deploy
out.each { 
	key,value->
	if(key == "Deploy" && value=="Y")
	{
	     deploy = 'Y'
	}
	
	
}
	return deploy
}
return this
