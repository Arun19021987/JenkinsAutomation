pipeline {
    agent any
    stages {
        stage('Git-Checkout') {
            steps {
		    
		    
		    git changelog: false, poll: false, url: 'https://github.com/Arun19021987/JenkinsAutomation.git'
            }
        }
		stage('Build') {
		      steps{
			     bat Build.bat
			  }
		}
		stage('config'){
		    steps{
		        bat Config.bat
			    
		    }
		  }
		 stage('Deploy') {
		     steps{
		         
			     script{
					     
				     def pipeline = load 'GroovyFile.groovy'
				     def flag = pipeline.JsonFile()
				     if(flag == "Y")
				     bat Stage.bat
				     else
					  bat Deploy.bat
				     
			     }
			     
		     }
		 }
		}
}
