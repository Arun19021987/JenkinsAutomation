pipeline {
    agent any
    stages {
        stage('Git-Checkout') {
            steps {
		    script{
			    checkout([$class: 'GitSCM', 
			    branches: [[name: '*/master']], 
			    doGenerateSubmoduleConfigurations: false, 
			    extensions: [[$class: 'CleanCheckout']], 
			    submoduleCfg: [], 
			    userRemoteConfigs: [[credentialsId: 'git-credentials', url: 'https://github.com/Arun19021987/JenkinsAutomation.git']]
			])
		    }
		    
		    //git changelog: false, poll: false, url: 'https://github.com/Arun19021987/JenkinsAutomation.git'
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
		         bat Deploy.bat
		     }
		 }
		}
}
