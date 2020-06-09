pipeline {
    agent any
	customWorkspace 'F:/JenkinsWorkSpace'
    stages {
        stage('Git-Checkout') {
            steps {
		   
			     
		    
		    git changelog: false, poll: false, url: 'https://github.com/Arun19021987/JenkinsAutomation.git'
		   
            }
        }
		stage('Build') {
		      steps{
			     bat 'Build.bat'
			  }
		}
		stage('config'){
		    steps{
		        bat 'Config.bat'
			    
		    }
		  }
		 stage('Deploy') {
		     steps{
		         
			     script{
					def rootDir=pwd() 
				     String jsonPath=rootDir + "/Jenkins.json"
				     def pipeline = load 'GroovyFile.groovy'
				     def flag = pipeline.JsonFile(jsonPath)
				     if(flag == "Y")
				     bat 'Stage.bat'
				     else
					  bat 'Deploy.bat'
				     
			     }
			     
		     }
		 }
		}
}
